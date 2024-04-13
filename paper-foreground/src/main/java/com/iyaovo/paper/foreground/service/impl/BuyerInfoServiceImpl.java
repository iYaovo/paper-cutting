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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.BuyerChangeInformationDto;
import com.iyaovo.paper.foreground.domain.dto.BuyerLoginDto;
import com.iyaovo.paper.foreground.domain.dto.BuyerRegisterDto;
import com.iyaovo.paper.foreground.domain.entity.BuyerInfo;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.entity.ShopInfo;
import com.iyaovo.paper.foreground.mapper.BuyerInfoMapper;
import com.iyaovo.paper.foreground.service.IBuyerInfoService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BuyerInfoServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 22:07:55
 */
@Service
public class BuyerInfoServiceImpl extends ServiceImpl<BuyerInfoMapper,BuyerInfo> implements IBuyerInfoService {
    @Override
    public void registerBuyer(BuyerRegisterDto buyerRegisterDto) {

    }

    @Override
    public void loginBuyer(BuyerLoginDto buyerLoginDto) {
    }

    @Override
    public void logoutBuyer(Long buyerId) {
    }

    @Override
    public void changeAvatar() {
    }

    @Override
    public BuyerInfo showBuyerInfo() {
        return null;
    }

    @Override
    public void changeInformation(BuyerChangeInformationDto buyerChangeInformationDto) {
    }

    @Override
    public void dailySign() {

    }

    @Override
    public CommonPage<GoodsInfo> showGoodsCollection(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public CommonPage<ShopInfo> showShopFollow(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public CommonPage<GoodsInfo> showGoodsViews(Integer pageNum, Integer pageSize) {
        return null;
    }
}

