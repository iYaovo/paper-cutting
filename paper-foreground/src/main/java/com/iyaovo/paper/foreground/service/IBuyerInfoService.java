package com.iyaovo.paper.foreground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.BuyerChangeInformationDto;
import com.iyaovo.paper.foreground.domain.dto.BuyerLoginDto;
import com.iyaovo.paper.foreground.domain.dto.BuyerRegisterDto;
import com.iyaovo.paper.foreground.domain.entity.BuyerInfo;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.entity.ShopInfo;

public interface IBuyerInfoService extends IService<BuyerInfo> {

    /**
     * 注册
     */
    void registerBuyer(BuyerRegisterDto buyerRegisterDto);

    /**
     * 登录
     */
    void loginBuyer(BuyerLoginDto buyerLoginDto);

    /**
     * 登出
     */
    void logoutBuyer(Long buyerId);

    /**
     * 修改头像
     */
    void changeAvatar();

    /**
     * 查看个人资料
     */
    BuyerInfo showBuyerInfo();

    /**
     *修改资料
     */
    void changeInformation(BuyerChangeInformationDto buyerChangeInformationDto);

    /**
     * 每日签到
     */
    void dailySign();

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
}
