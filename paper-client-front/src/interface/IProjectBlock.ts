import { ImageSourcePropType } from 'react-native';
import { IBusinessInfo } from '@/interface/IBusinessPage.ts';

// 商品信息
export default interface IProjectBlock {
    goodsId: number,    // 商品id
    goodsName: string,  // 商品名字
    goodsIntroduction: string, // 商品介绍
    picUrl: ImageSourcePropType,  // 商品图片
    price: number,  // 市场价
    promotionPrice: number, // 当前商品价格
    soldNumber: number,  // 卖了多少笔
    totalNumber: number,   // 库存
    shopInfo: IBusinessInfo, // 店铺信息
    isCollection: boolean,  // 商品是否已经被收藏
    isJoinCart: true    // 商品是否已经加入了购物车
}
