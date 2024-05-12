import { IBusinessInfo } from '@/interface/IBusinessPage.ts';
import IProjectBlock from '@/interface/IProjectBlock.ts';

export interface ICarItem {
    shopInfo: IBusinessInfo;    // 商家店铺信息
    projectInfo: Omit<IProjectBlock, keyof IBusinessInfo>;      // 商品信息
}
