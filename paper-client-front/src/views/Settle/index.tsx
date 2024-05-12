import { StyleSheet, Text, View } from 'react-native';
import React, { FC } from 'react';
import AddBackgroundHOC from '@/components/HOC/AddBackgroundHOC.tsx';
import { ISettleList } from '@/interface/ISettleList.ts';

interface IProps extends ISettleList {
}

const Settle: FC<IProps> = (props) => {
    return (
        <AddBackgroundHOC>
            <View style={ styles.content }>
                <Text>Settle</Text>
            </View>
        </AddBackgroundHOC>
    );
};
export default Settle;
const styles = StyleSheet.create({
    content: {}
});
