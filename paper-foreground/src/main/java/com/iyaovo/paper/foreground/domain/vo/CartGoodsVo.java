/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: CartGoodsVo
 * Author: 22932
 * Date: 2024/4/24 18:00:25
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.domain.vo;

import com.iyaovo.paper.foreground.domain.entity.ShopInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName: CartGoodsVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/24 18:00:25
 */
@Schema(defaultValue = "购物车中的商品Vo")
public class CartGoodsVo extends GoodsInfoVo{

   @Schema(defaultValue = "商品数量")
   private Integer goodsNumber;

   public CartGoodsVo() {
   }

   public CartGoodsVo(Integer goodsId, String goodsName, String goodsIntroduction, String picUrl, BigDecimal price, BigDecimal promotionPrice, Integer soldNumber, Integer totalNumber, Integer goodsNumber) {
      super(goodsId, goodsName, goodsIntroduction, picUrl, price, promotionPrice, soldNumber, totalNumber);
   }

   public CartGoodsVo toCartGoodsVo(GoodsInfoVo goodsInfoVo,Integer goodsNumber){
      return new CartGoodsVo(goodsInfoVo.getGoodsId(),goodsInfoVo.getGoodsName(), goodsInfoVo.getGoodsIntroduction(),
              goodsInfoVo.getPicUrl(),goodsInfoVo.getPrice(),goodsInfoVo.getPromotionPrice(),goodsInfoVo.getSoldNumber(),goodsInfoVo.getTotalNumber(),goodsNumber);
   }
}

