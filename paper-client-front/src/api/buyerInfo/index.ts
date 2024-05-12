import showSimpleInformation from '@/api/buyerInfo/modules/showSimpleInformation.ts';
import changeInformation from '@/api/buyerInfo/modules/changeInformation.ts';
import { IPersonalInfoIn } from '@/interface/IPersonalInfo.ts';
import { postResourceImg } from '@/api/ImgResource';
import showInformation from '@/api/buyerInfo/modules/showInformation.ts';

/**
 * @description 展示用户信息
 */
export function getShowInfo () {
    return showInformation();
}

/**
 * @description 用户更改信息
 * @param personalInfoDataIn
 * @param personalInfoDataIn.buyerHobby 买家爱好
 * @param personalInfoDataIn.buyerAutograph 买家个签
 * @param personalInfoDataIn.picUrl 买家头像url
 */
export async function postChangeInfo (personalInfoDataIn: IPersonalInfoIn) {
    const { buyerHobby, buyerAutograph, picUrl } = personalInfoDataIn;
    const { resourcePath, resourceBase64 } = postResourceImg(picUrl);
    return changeInformation(buyerHobby, buyerAutograph, resourcePath);
}

/**
 * @description 展示用户简易信息(主页)
 */
export function getSimpleInfo () {
    return showSimpleInformation();
}
