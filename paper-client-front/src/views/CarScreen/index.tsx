import { Dimensions, Pressable, ScrollView, StyleSheet, Text, View } from 'react-native';
import React, { useEffect, useState } from 'react';
import LinearGradient from 'react-native-linear-gradient';
import MyText from '@/components/MyText';
import BouncyCheckbox from 'react-native-bouncy-checkbox';
import { ICarItem } from '@/interface/ICarPage.ts';
import CarItem from '@/views/CarScreen/components/CarItem';
import AddBackgroundHOC from '@/components/HOC/AddBackgroundHOC.tsx';
import { getGoodsCar, getUpdateCar } from '@/api/Car';
import { useNavigation } from '@react-navigation/native';

/*
    BottomTab的购物车
 */
const CarScreen = () => {
    const navigation = useNavigation();
    const [isCheckedArr, setIsCheckedArr] = useState<boolean[]>([]);
    const [addNumsArr, setAddNumsArr] = useState<number[]>([]);
    let [totalAmount, setTotalAmount] = useState(0);
    let [totalSelected, setTotalSelected] = useState(false);
    const [carItemData, setCarItemData] = useState<ICarItem[]>([]);

    useEffect(() => {
        !(async function () {
            const res: any = await getGoodsCar();
            // 对数据进行处理,分为projectInfo和shopInfo
            setCarItemData(res.map((item: any) => {
                const { shopInfo, ...projectInfo } = item;
                return { shopInfo, projectInfo };
            }));
            setCarItemData(value => {
                setIsCheckedArr(new Array(value.length).fill(false));
                setAddNumsArr(new Array(value.length).fill(1));
                return value;
            });
        })();
    }, []);

    useEffect(() => {
        // 如果检测到勾选状态改变,就放进 已勾选数组里,并改变总金额
        isCheckedArr.includes(false) && setTotalSelected(false);
        computedTotalAmount(isCheckedArr);
    }, [isCheckedArr, addNumsArr]);

    // 是否选中本条
    function changeCheckedFunc (changeIndex: number) {
        return function (status: boolean) {
            const newIsCheckedArr = isCheckedArr.map((item, index) => {
                if (index === changeIndex) item = status;
                return item;
            });
            setIsCheckedArr(newIsCheckedArr);
        };
    }

    // 全选按钮
    function allSelected (isChecked: boolean) {
        const newIsCheckedArr = isCheckedArr.map(() => isChecked);
        setTotalSelected(isChecked);
        setIsCheckedArr(newIsCheckedArr);
        computedTotalAmount(newIsCheckedArr);
    }

    // 计算合计金额
    function computedTotalAmount (newIsCheckedArr: boolean[]) {
        let total = 0;
        for (let i = 0; i < newIsCheckedArr.length; i++) {
            if (newIsCheckedArr[i]) {
                total += carItemData[i].projectInfo.price * addNumsArr[i];
            }
        }
        setTotalAmount(total);
    }

    // 单个商品数量
    function changeNumsFunc (changeIndex: number, changeGoodsId: number) {
        return function (nums: number) {
            const newAddNumsArr = addNumsArr.map((item, index) => {
                if (index === changeIndex) item = nums;
                return item;
            });
            setAddNumsArr(newAddNumsArr);
            // TODO 调更新数量接口
            // getUpdateCar(changeGoodsId).then();
        };
    }

    // 结算按钮
    function settleFunc () {
        // @ts-ignore
        navigation.navigate('Settle');
        console.log('结算');
    }

    return (
        <AddBackgroundHOC>
            <View style={ styles.content }>
                <LinearGradient style={ styles.carTop } colors={ ['#84321c', '#bb614a'] }>
                    <View style={ styles.carTopTitle }>
                        <MyText text="购物车" styles={ { color: '#fff', fontWeight: 'bold', fontSize: 18 } }/>
                    </View>
                </LinearGradient>
                <ScrollView
                    style={ styles.main }
                    contentContainerStyle={ { alignItems: 'center', paddingBottom: Dimensions.get('window').height * 0.08 } }
                >
                    {
                        carItemData.map((item, index) => {
                            return (
                                <CarItem
                                    key={ index }
                                    shopInfo={ item.shopInfo }
                                    projectInfo={ item.projectInfo }
                                    changeCheckedFunc={ changeCheckedFunc(index) }
                                    isCheckedPar={ isCheckedArr[index] }
                                    changeNumsFunc={ changeNumsFunc(index, item.projectInfo.goodsId) }
                                />
                            );
                        })
                    }

                </ScrollView>
                <View style={ styles.carBottom }>
                    <View style={ styles.carBottomLeft }>
                        <BouncyCheckbox
                            size={ 15 }
                            fillColor="#bb614a"
                            unFillColor="#fff"
                            text="全选"
                            iconStyle={ { borderRadius: 0, marginRight: -10 } }
                            innerIconStyle={ { borderWidth: 2, borderRadius: 0 } }
                            textStyle={ { textDecorationLine: 'none', } }
                            isChecked={ totalSelected }
                            onPress={ (isChecked: boolean) => {
                                allSelected(isChecked);
                            } }
                        />
                        <Text style={ { fontSize: 15 } }>
                            合计:
                            <Text style={ { color: '#ff0000', fontWeight: 'bold' } }>
                                ￥ { totalAmount }
                            </Text>
                        </Text>
                    </View>
                    <LinearGradient
                        style={ styles.carBottomRight }
                        colors={ ['#b94621', '#e36723cc'] }
                        start={ { x: 0, y: 0 } }
                        end={ { x: 1, y: 0 } }
                    >
                        <Pressable onPress={ settleFunc }>
                            <Text style={ { color: '#fff' } }>结算</Text>
                            {/*({ isCheckedArr.length })*/ }
                        </Pressable>
                    </LinearGradient>
                </View>
            </View>
        </AddBackgroundHOC>
    );
};
export default CarScreen;
const styles = StyleSheet.create({
    content: {
        flex: 1,
        position: 'relative'
    },
    carTop: {
        width: Dimensions.get('window').width,
        height: 50,
    },
    carTopTitle: {
        height: '100%',
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center'
    },
    main: {
        flex: 1,
        display: 'flex',
        zIndex: 100
    },
    carBottom: {
        position: 'absolute',
        bottom: 10,
        width: '100%',
        height: Dimensions.get('window').height * 0.06,
        paddingLeft: 15,
        paddingRight: 10,
        borderRadius: 18,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        backgroundColor: '#fff',
        zIndex: 101
    },
    carBottomLeft: {
        // width: '60%',
        flex: 1,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
    },
    carBottomRight: {
        width: '25%',
        height: '80%',
        marginLeft: 20,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: 25,
        // backgroundColor: ''
    }
});
// ff8d00 ff5300
