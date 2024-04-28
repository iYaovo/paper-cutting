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

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.exception.Asserts;
import com.iyaovo.paper.foreground.bo.BuyerUserDetails;
import com.iyaovo.paper.foreground.domain.dto.BuyerChangeInformationDto;
import com.iyaovo.paper.foreground.domain.dto.BuyerParam;
import com.iyaovo.paper.foreground.domain.entity.*;
import com.iyaovo.paper.foreground.domain.vo.BuyerInfoSimpleVo;
import com.iyaovo.paper.foreground.domain.vo.BuyerInfoVo;
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

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
            Asserts.fail("登录异常");
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


    //TODO
    @Override
    public void changeAvatar() {
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
        return new BuyerInfoSimpleVo(handleId(buyerInfo.getBuyerId()),buyerInfo.getBuyerName(),buyerInfo.getPicUrl(),
                goodsCollectionMapper.selectCount(queryWrapper),shopFollowMapper.selectCount(queryWrapper),goodsViewsMapper.selectCount(queryWrapper));
    }

    @Override
    public BuyerInfoVo showInformation() {
        BuyerInfo buyerInfo = getBuyerInfo();
        return new BuyerInfoVo(handleId(buyerInfo.getBuyerId()),buyerInfo.getBuyerName(),buyerInfo.getBuyerHobby(),buyerInfo.getBuyerAutograph(),buyerInfo.getPicUrl());
    }

    @Override
    public void changeInformation(BuyerChangeInformationDto buyerChangeInformationDto) {
        BuyerInfo buyerInfo = getBuyerInfo();
        buyerInfo.setBuyerHobby(buyerChangeInformationDto.getBuyerHobby());
        buyerInfo.setBuyerAutograph(buyerChangeInformationDto.getBuyerAutograph());
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
    public CommonPage<GoodsInfo> showGoodsCollection(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<GoodsCollection> goodsCollectionQueryWrapper = new QueryWrapper<GoodsCollection>();
        goodsCollectionQueryWrapper.eq("buyer_id",getBuyerInfo().getBuyerId());
        List<GoodsCollection> goodsCollections = goodsCollectionMapper.selectList(goodsCollectionQueryWrapper);
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        goodsCollections.forEach(goodsCollection -> {
            goodsInfoList.add(goodsInfoMapper.selectById(goodsCollection.getGoodsId()));
        });
        return CommonPage.restPage(goodsInfoList);
    }

    @Override
    public CommonPage<ShopInfo> showShopFollow(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<ShopFollow> shopFollowQueryWrapper = new QueryWrapper<ShopFollow>();
        shopFollowQueryWrapper.eq("buyer_id",getBuyerInfo().getBuyerId());
        List<ShopFollow> shopFollows = shopFollowMapper.selectList(shopFollowQueryWrapper);
        List<ShopInfo> shopInfoList = new ArrayList<>();
        shopFollows.forEach(shopFollow -> {
            shopInfoList.add(shopInfoMapper.selectById(shopFollow.getShopId()));
        });
        return CommonPage.restPage(shopInfoList);
    }

    @Override
    public CommonPage<GoodsInfo> showGoodsViews(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<GoodsViews> goodsViewsQueryWrapper = new QueryWrapper<GoodsViews>();
        goodsViewsQueryWrapper.eq("buyer_id",getBuyerInfo().getBuyerId());
        List<GoodsViews> goodsViews = goodsViewsMapper.selectList(goodsViewsQueryWrapper);
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        goodsViews.forEach(goodsView -> {
            goodsInfoList.add(goodsInfoMapper.selectById(goodsView.getGoodsId()));
        });
        return CommonPage.restPage(goodsInfoList);
    }


}

