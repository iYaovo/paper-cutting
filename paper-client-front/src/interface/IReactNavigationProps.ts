import { RouteProp } from '@react-navigation/native';
import { IShopCategory } from '@/interface/IShopPage.ts';
import IProjectBlock from '@/interface/IProjectBlock.ts';

export enum Views {
    Shop = '商品',
    ProjectDetail = 'ProjectDetail'
}

export type RootStackParamList = {
    [Views.Shop]: {
        shopCategoryData: IShopCategory;
        callback: () => void;
    };
    [Views.ProjectDetail]: {
        projectBlockData: IProjectBlock;
    };
};

export type RootRouteType<RouteName extends keyof RootStackParamList> = RouteProp<RootStackParamList, RouteName>;
