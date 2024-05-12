import { ImageSourcePropType } from 'react-native';

interface IPersonalInfo {
    // ----- 公共
    picUrl: ImageSourcePropType,
    buyerId: string,
    buyerName: string,

    /// ----- 以下为里面的
    buyerHobby: string,
    buyerAutograph: string, // 个性签名

    // ----- 以下为外面的
    shopFollowNumber: number, // 关注
    collectionNumber: number, // 收藏
    goodsViewNumber: number, // 浏览记录
    // fans: number,   // 粉丝
    // friend: number, // 好友
}

type publicType = {
    picUrl: ImageSourcePropType,
    buyerId: string,
    buyerName: string
}
export type IPersonalInfoIn = Omit<IPersonalInfo, 'shopFollowNumber' | 'collectionNumber' | 'goodsViewNumber'>
export type IPersonalInfoOut = publicType & Omit<IPersonalInfo, keyof IPersonalInfoIn>
