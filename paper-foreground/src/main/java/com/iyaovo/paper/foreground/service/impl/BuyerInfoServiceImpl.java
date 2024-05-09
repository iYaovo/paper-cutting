/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: BuyerInfoServiceImpl
 * Author: 22932
 * Date: 2024/4/12 22:07:55
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.constant.Constants;
import com.iyaovo.paper.common.exception.Asserts;
import com.iyaovo.paper.common.util.ImageToBase64Util;
import com.iyaovo.paper.foreground.bo.BuyerUserDetails;
import com.iyaovo.paper.foreground.domain.dto.BuyerChangeInformationDto;
import com.iyaovo.paper.foreground.domain.dto.BuyerParam;
import com.iyaovo.paper.foreground.domain.entity.*;
import com.iyaovo.paper.foreground.domain.vo.BuyerInfoSimpleVo;
import com.iyaovo.paper.foreground.domain.vo.BuyerInfoVo;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.foreground.domain.vo.ShopInfoVo;
import com.iyaovo.paper.foreground.mapper.*;
import com.iyaovo.paper.foreground.service.IBuyerInfoService;
import com.iyaovo.paper.security.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName: BuyerInfoServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 22:07:55
 */
@Service
@RequiredArgsConstructor
public class BuyerInfoServiceImpl extends ServiceImpl<BuyerInfoMapper,BuyerInfo> implements IBuyerInfoService {

    private final JwtTokenUtil jwtTokenUtil;

    private final PasswordEncoder passwordEncoder;

    private final BuyerInfoMapper buyerInfoMapper;

    private final ShopFollowMapper shopFollowMapper;

    private final GoodsViewsMapper goodsViewsMapper;

    private final GoodsCollectionMapper goodsCollectionMapper;

    private final GoodsInfoMapper goodsInfoMapper;

    private final ShopInfoMapper shopInfoMapper;

    private final DailySignMapper dailySignMapper;

    private final CartInfoMapper cartInfoMapper;

    @Override
    public BuyerInfo getBuyerInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return getAdminByUsername(username);
    }

    @Override
    public void registerBuyer(BuyerParam buyerParam) {
        BuyerInfo buyerInfo = new BuyerInfo(null,buyerParam.getBuyerAccount(),buyerParam.getBuyerPassword(),null,null,null);
        //查询是否有相同用户名的用户
        QueryWrapper<BuyerInfo> buyerInfoQueryWrapper = new QueryWrapper<BuyerInfo>();
        buyerInfoQueryWrapper.eq("buyer_name",buyerInfo.getBuyerName());
        if(buyerInfoMapper.selectCount(buyerInfoQueryWrapper) > 0){
            Asserts.fail("该用户名已存在");
        }
        //将密码进行加密操作
        buyerInfo.setBuyerPassword(passwordEncoder.encode(buyerInfo.getBuyerPassword()));
        buyerInfoMapper.insert(buyerInfo);
    }

    @Override
    public String loginBuyer(BuyerParam buyerParam) {
        String token = null;

        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(buyerParam.getBuyerAccount());

            if(!passwordEncoder.matches(buyerParam.getBuyerPassword(),userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            Asserts.fail("该账号不存在");
        }
        return token;
    }

    @Override
    public void updatePassword(String oldPassword, String newPassword) {
        BuyerInfo buyerInfo = getBuyerInfo();
        if(!passwordEncoder.matches(oldPassword,buyerInfo.getBuyerPassword())){
            Asserts.fail("密码不正确");
        }
        buyerInfo.setBuyerPassword(passwordEncoder.encode(newPassword));
        buyerInfoMapper.updateById(buyerInfo);
    }



    /**
     * id处理
     * @return
     */
    private String handleId(Long id){
        return String.valueOf(id).substring(7,19);
    }


    @Override
    public BuyerInfoSimpleVo showSimpleInformation() {
        BuyerInfo buyerInfo = getBuyerInfo();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("buyer_id",buyerInfo.getBuyerId());
        return new BuyerInfoSimpleVo(handleId(buyerInfo.getBuyerId()),buyerInfo.getBuyerName(),ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH+buyerInfo.getPicUrl()),
                goodsCollectionMapper.selectCount(queryWrapper),shopFollowMapper.selectCount(queryWrapper),goodsViewsMapper.selectCount(queryWrapper));
    }

    @Override
    public BuyerInfoVo showInformation() {
        BuyerInfo buyerInfo = getBuyerInfo();
        return new BuyerInfoVo(handleId(buyerInfo.getBuyerId()),buyerInfo.getBuyerName(),buyerInfo.getBuyerHobby(),buyerInfo.getBuyerAutograph(),ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH+buyerInfo.getPicUrl()));
    }

    @Override
    public void changeInformation(BuyerChangeInformationDto buyerChangeInformationDto) {
        BuyerInfo buyerInfo = getBuyerInfo();
        if (!buyerChangeInformationDto.getBuyerAutograph().isEmpty()){
            buyerInfo.setBuyerAutograph(buyerChangeInformationDto.getBuyerAutograph());
        }
        if (!buyerChangeInformationDto.getPicUrl().isEmpty()){
            buyerInfo.setPicUrl(buyerChangeInformationDto.getPicUrl());
        }
        if (!buyerChangeInformationDto.getBuyerHobby().isEmpty()){
            buyerInfo.setBuyerHobby(buyerChangeInformationDto.getBuyerHobby());
        }
        buyerInfoMapper.updateById(buyerInfo);
    }

    @Override
    public void dailySign() {
        dailySignMapper.insert(new DailySign(null,getBuyerInfo().getBuyerId(),LocalDateTime.now().toString().substring(0, 10)));
    }

    @Override
    public List<Integer> showSign(Long time) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
        //将时间转换指定格式的日期
        String date=f.format(time);
        QueryWrapper<DailySign> queryWrapper = new QueryWrapper();
        queryWrapper.eq("buyer_id",getBuyerInfo().getBuyerId());
        queryWrapper.like("sign_time",date);
        List<DailySign> dailySigns = dailySignMapper.selectList(queryWrapper);
        List<Integer> sign = new ArrayList<Integer>();
        dailySigns.forEach(dailySign -> sign.add(Integer.valueOf(dailySign.getSignTime().substring(8,10))));
        return sign;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        //获取用户信息
        BuyerInfo buyerInfo = getAdminByUsername(username);
        if (buyerInfo != null) {
            return new BuyerUserDetails(buyerInfo);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public BuyerInfo getAdminByUsername(String username) {
        QueryWrapper<BuyerInfo> buyerInfoQueryWrapper = new QueryWrapper<BuyerInfo>();
        buyerInfoQueryWrapper.eq("buyer_name",username);
        return buyerInfoMapper.selectOne(buyerInfoQueryWrapper);
    }

    @Override
    public CommonPage<GoodsInfoVo> showGoodsCollection(Integer pageNum, Integer pageSize) {
        QueryWrapper<GoodsCollection> goodsCollectionQueryWrapper = new QueryWrapper<GoodsCollection>();
        goodsCollectionQueryWrapper.eq("buyer_id",getBuyerInfo().getBuyerId());
        Page<GoodsCollection> goodsCollectionPage = goodsCollectionMapper.selectPage(new Page<>(pageNum,pageSize), goodsCollectionQueryWrapper);
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        goodsCollectionPage.getRecords().forEach(goodsCollection -> {
            goodsInfoList.add(goodsInfoMapper.selectById(goodsCollection.getGoodsId()));
        });
        List<GoodsInfoVo> goodsInfoVoList = goodsInfoToGoodsInfoVo(goodsInfoList);
        Page<GoodsInfoVo> goodsInfoVoPage = new Page<>(pageNum,pageSize,goodsCollectionPage.getTotal());
        goodsInfoVoPage.setPages(goodsCollectionPage.getPages());
        goodsInfoVoPage.setRecords(goodsInfoVoList);
        return CommonPage.restPage(goodsInfoVoPage);
    }

    @Override
    public CommonPage<ShopInfoVo> showShopFollow(Integer pageNum, Integer pageSize) {
        QueryWrapper<ShopFollow> shopFollowQueryWrapper = new QueryWrapper<ShopFollow>();
        shopFollowQueryWrapper.eq("buyer_id",getBuyerInfo().getBuyerId());
        Page<ShopFollow> shopFollowPage = shopFollowMapper.selectPage(new Page<>(pageNum,pageSize), shopFollowQueryWrapper);
        List<ShopInfoVo> shopInfoVoList = new ArrayList<>();
        shopFollowPage.getRecords().forEach(shopFollow -> {
            ShopInfo shopInfo = shopInfoMapper.selectById(shopFollow.getShopId());
            shopInfoVoList.add(new ShopInfoVo(shopInfo.getShopId(),shopInfo.getShopName(),ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH+shopInfo.getPicUrl())));
        });
        return CommonPage.restPage(shopInfoVoList);
    }

    @Override
    public CommonPage<GoodsInfoVo> showGoodsViews(Integer pageNum, Integer pageSize) {
        QueryWrapper<GoodsViews> goodsViewsQueryWrapper = new QueryWrapper<GoodsViews>();
        goodsViewsQueryWrapper.eq("buyer_id",getBuyerInfo().getBuyerId());
        goodsViewsQueryWrapper.orderByDesc("create_time");
        Page<GoodsViews> goodsViewsPage = goodsViewsMapper.selectPage(new Page<>(pageNum,pageSize), goodsViewsQueryWrapper);
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        goodsViewsPage.getRecords().forEach(goodsView -> {
            goodsInfoList.add(goodsInfoMapper.selectById(goodsView.getGoodsId()));
        });
        List<GoodsInfoVo> goodsInfoVoList = goodsInfoToGoodsInfoVo(goodsInfoList);
        Page<GoodsInfoVo> goodsInfoVoPage = new Page<>(pageNum,pageSize,goodsViewsPage.getTotal());
        goodsInfoVoPage.setPages(goodsViewsPage.getPages());
        goodsInfoVoPage.setRecords(goodsInfoVoList);
        return CommonPage.restPage(goodsInfoVoPage);
    }


    @Override
    public void favoriteGoods(Integer goodsId) {
        goodsCollectionMapper.insert(new GoodsCollection(null,goodsId, getBuyerInfo().getBuyerId(), null));
    }

    @Override
    public void cancelFavoriteGoods(Integer goodsId) {
        QueryWrapper<GoodsCollection> goodsCollectionQueryWrapper = new QueryWrapper<>();
        goodsCollectionQueryWrapper.eq("goods_id",goodsId)
                        .eq("buyer_id",getBuyerInfo().getBuyerId());
        goodsCollectionMapper.delete(goodsCollectionQueryWrapper);
    }

    @Override
    public void favoriteShop(Integer shopId) {
        shopFollowMapper.insert(new ShopFollow(null,shopId,getBuyerInfo().getBuyerId(),null));
    }

    @Override
    public void cancelFavoriteShop(Integer shopId) {
        QueryWrapper<ShopFollow> shopFollowQueryWrapper = new QueryWrapper<>();
        shopFollowQueryWrapper.eq("shop_id",shopId)
                .eq("buyer_id",getBuyerInfo().getBuyerId());
        shopFollowMapper.delete(shopFollowQueryWrapper);
    }

    private List<GoodsInfoVo> goodsInfoToGoodsInfoVo(List<GoodsInfo> goodsInfoList){
        List<GoodsInfoVo> goodsInfoVoList = new ArrayList<GoodsInfoVo>();
        goodsInfoList.forEach(goodsInfo ->{
            //entity转为vo
            GoodsInfoVo goodsInfoVo = new GoodsInfoVo(goodsInfo.getGoodsId(),goodsInfo.getGoodsName(),goodsInfo.getGoodsIntroduction(), ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH+goodsInfo.getPicUrl()), goodsInfo.getPrice(),
                    goodsInfo.getPromotionPrice(),goodsInfo.getSoldNumber(),goodsInfo.getTotalNumber());
            //判断商品是否被收藏
            QueryWrapper<GoodsCollection> goodsCollectionQueryWrapper = new QueryWrapper<>();
            goodsCollectionQueryWrapper.eq("goods_id",goodsInfo.getGoodsId())
                    .eq("buyer_id",getBuyerInfo().getBuyerId());
            GoodsCollection goodsCollection = goodsCollectionMapper.selectOne(goodsCollectionQueryWrapper);
            if(ObjectUtil.isEmpty(goodsCollection)){
                goodsInfoVo.setIsCollection(false);
            }else{
                goodsInfoVo.setIsCollection(true);
            }
            //判断商品是否被加入购物车
            QueryWrapper<CartInfo> cartInfoQueryWrapper = new QueryWrapper<>();
            cartInfoQueryWrapper.eq("goods_id",goodsInfo.getGoodsId())
                    .eq("buyer_id",getBuyerInfo().getBuyerId());
            CartInfo cartInfo = cartInfoMapper.selectOne(cartInfoQueryWrapper);
            if(ObjectUtil.isEmpty(cartInfo)){
                goodsInfoVo.setIsJoinCart(false);
            }else{
                goodsInfoVo.setIsJoinCart(true);
            }
            //把店铺信息封装到vo
            goodsInfoVo.setShopInfo(shopInfoMapper.selectById(goodsInfo.getShopId()));
            goodsInfoVoList.add(goodsInfoVo);
        });
        return goodsInfoVoList;
    }

}

