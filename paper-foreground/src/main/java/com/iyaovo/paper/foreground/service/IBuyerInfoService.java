package com.iyaovo.paper.foreground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.BuyerChangeInformationDto;
import com.iyaovo.paper.foreground.domain.dto.BuyerParam;
import com.iyaovo.paper.foreground.domain.entity.BuyerInfo;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.entity.ShopInfo;
import com.iyaovo.paper.foreground.domain.vo.BuyerInfoSimpleVo;
import com.iyaovo.paper.foreground.domain.vo.BuyerInfoVo;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.List;

public interface IBuyerInfoService extends IService<BuyerInfo> {

    /**
     * 获取当前登录用户信息
     * @param
     * @return
     */
    BuyerInfo getBuyerInfo();

    /**
     * 注册
     */
    void registerBuyer(BuyerParam buyerParam);

    /**
     * 登录
     */
    String loginBuyer(BuyerParam buyerParam);

    /**
     * 更改密码
     */
    void updatePassword(String oldPassword,String newPassword);

    /**
     * 修改头像
     */
    void changeAvatar();

    /**
     * 展示简易资料(主页)
     */
    BuyerInfoSimpleVo showSimpleInformation();

    /**
     * 查看个人资料
     */
    BuyerInfoVo showInformation();

    /**
     *修改资料
     */
    void changeInformation(BuyerChangeInformationDto buyerChangeInformationDto);



    /**
     * 通过username获取用户
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 通过username获取用户
     * @param username
     * @return
     */
    BuyerInfo getAdminByUsername(String username);

    /**
     * 商品收藏
     */
    CommonPage<GoodsInfo> showGoodsCollection(Integer pageNum,
                                          Integer pageSize);

    /**
     * 店铺关注
     */
    CommonPage<ShopInfo> showShopFollow(Integer pageNum,
                                        Integer pageSize);

    /**
     * 近期浏览
     */
    CommonPage<GoodsInfo> showGoodsViews(Integer pageNum,
                                         Integer pageSize);

    /**
     * 每日签到
     */
    void dailySign();

    /**
     * 查看签到
     */
    List<Integer> showSign(Long time);

    /**
     * 收藏
     */

    /**
     * 取消收藏
     */

    /**
     * 店铺关注
     */

    /**
     * 取消关注
     */

    /**
     * 清理超过多少天的近期浏览
     */
}
