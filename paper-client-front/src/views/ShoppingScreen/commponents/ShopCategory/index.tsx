import { StyleSheet, View } from 'react-native';
import React, { FC } from 'react';
import { IShopCategory } from '@/interface/IShopPage.ts';
import ShopItem from '@/components/ShopItem';
import MyText from '@/components/MyText';
import { useRoute } from '@react-navigation/native';
import { RootRouteType, Views } from '@/interface/IReactNavigationProps.ts';
import AddBackgroundHOC from '@/components/HOC/AddBackgroundHOC.tsx';

const ShopCategory: FC = () => {
    const route = useRoute<RootRouteType<Views.Shop>>();
    // 路由参数获取
    const { shopCategoryData } = route.params;
    return (
        <AddBackgroundHOC>
            <View style={ styles.content }>
                <View style={ styles.title }>
                    <MyText text={ shopCategoryData?.goodCategoryName } styles={ { color: '#84321c', fontWeight: 'bold' } }/>
                </View>
                <View style={ styles.mainInner }>
                    {
                        shopCategoryData?.children.map((item, index) => {
                            return (
                                <ShopItem key={ index } goodCategoryName={ item.goodCategoryName }/>
                            );
                        })
                    }
                </View>
            </View>
        </AddBackgroundHOC>
    );
};
export default ShopCategory;
const styles = StyleSheet.create({
    content: {
        width: '100%',
        height: '100%',
        padding: 10,
    },
    title: {
        marginTop: 10,
    },
    mainInner: {
        display: 'flex',
        flexDirection: 'row',
        flexWrap: 'wrap',
        justifyContent: 'space-between'
    }
});
