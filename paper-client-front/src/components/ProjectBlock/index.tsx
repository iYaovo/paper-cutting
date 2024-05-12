import {
    Dimensions,
    Pressable,
    StyleSheet,
    useWindowDimensions,
    View,
} from 'react-native';
import React, { FC, useEffect, useState } from 'react';
import ProjectBlockImg from '@/components/Img';
import MyText from '@/components/MyText';
import Ionicons from 'react-native-vector-icons/Ionicons';
import IsRenderHOC from '@/components/HOC/IsRenderHOC.tsx';
import { useNavigation } from '@react-navigation/native';
import IProjectBlock from '@/interface/IProjectBlock.ts';

interface IProps {
    addBtn?: (data: IProjectBlock) => void,
    projectBlockData: IProjectBlock
}

const ProjectBlock: FC<IProps> = ({ addBtn, projectBlockData }) => {
    const navigation = useNavigation();
    const [projectWidth, setProjectWidth] = useState(0);
    let [projectHeight, setProjectHeight] = useState(projectWidth * 1.2);
    const window = useWindowDimensions();
    useEffect(() => {
        setProjectWidth(window.width / 2.1); // 每个商品大块的宽度
        setProjectHeight(projectWidth * 1.2);
    }, [projectWidth, projectHeight, window.width]);

    return (
        <Pressable
            style={ {
                width: '49%',
                height: projectHeight,
                borderRadius: 18,
                marginBottom: 5,
            } }
            onPress={ () => {
                // @ts-ignore
                navigation.navigate('ProjectDetail', { projectBlockData });
            } }>
            <View style={ styles.projectInner }>
                <ProjectBlockImg imgUrl={ projectBlockData.picUrl }/>
                <View style={ styles.information }>
                    <View>
                        <MyText text={ projectBlockData.goodsName } styles={ { fontWeight: 'bold' } }/>
                    </View>
                    <View>
                        <MyText
                            text={ `￥${ projectBlockData.promotionPrice }` }
                            styles={ { color: '#cd2929', fontSize: 20 } }
                        />
                    </View>
                    <View>
                        <MyText
                            text={ `已售 ${ projectBlockData.soldNumber } 笔` }
                            styles={ { color: '#b1b1b1', fontSize: 10 } }
                        />
                    </View>
                    {/*<IsRenderHOC isShow={ typeof addBtn === 'function' }>*/ }
                    {/*    <Pressable*/ }
                    {/*        onPress={ () => addBtn?.(projectBlockData) }*/ }
                    {/*    >*/ }
                    {/*        <Ionicons name="add-circle" style={ styles.addBtn } size={ 20 }/>*/ }
                    {/*    </Pressable>*/ }
                    {/*</IsRenderHOC>*/ }
                </View>
            </View>
        </Pressable>
    );
};
export default ProjectBlock;
const styles = StyleSheet.create({
    projectInner: {
        width: '100%',
        height: '100%',
        borderRadius: 18,
        overflow: 'hidden',
    },
    information: {
        position: 'relative',
        paddingTop: 10,
        paddingBottom: 10,
        paddingLeft: 5,
        paddingRight: 5,
        backgroundColor: '#fcfcfc',
    },
    addBtn: {
        position: 'absolute',
        bottom: 5,
        right: 5,
        width: 20,
        height: 20,
        color: '#f00',
        // borderRadius: 40,
        backgroundColor: '#fff',
    },
});
