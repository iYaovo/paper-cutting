import { StyleSheet, Text, View } from 'react-native';
import React from 'react';
import { IShopItem } from '@/interface/IShopPage.ts';

interface IProps extends IShopItem {
}

const ShopItem = (props: IProps) => {
    const { goodCategoryName } = props;
    return (
        <View style={ styles.content }>
            <View style={ styles.image }>
                <Text style={ styles.imageText }>{ goodCategoryName }</Text>
            </View>
        </View>
    );
};
export default ShopItem;
const styles = StyleSheet.create({
    content: {
        width: 67.5,
        height: 100,
        display: 'flex',
        justifyContent: 'center',
    },
    image: {
        height: 60,
        width: 60,
        borderRadius: 120,
        backgroundColor: '#f1ece6',
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center'
    },
    imageText: {
        color: '#84321c',
        fontSize: 18
    }
});
