import { Dimensions, Image, Pressable, ScrollView, StyleSheet, Text, View } from 'react-native';
import { useEffect, useState } from 'react';
import AddBackgroundHOC from '@/components/HOC/AddBackgroundHOC.tsx';
import LinearGradient from 'react-native-linear-gradient';
import IsRenderHOC from '@/components/HOC/IsRenderHOC.tsx';
import ProjectBlock from '@/components/ProjectBlock';
import MyText from '@/components/MyText';
import { useNavigation } from '@react-navigation/native';
import { IPersonalInfoOut } from '@/interface/IPersonalInfo.ts';
import { getRecommendGoods } from '@/api/ProjectInfo';
import IProjectBlock from '@/interface/IProjectBlock.ts';
import { getSimpleInfo } from '@/api/buyerInfo';

/*
    BottomTab我的
 */
const MineScreen = () => {
    const orderInner = [
        {
            img: require('@/assets/img/minePage/obligation.png'),
            title: '待付款'
        },
        {
            img: require('@/assets/img/minePage/deliver.png'),
            title: '待发货'
        },
        {
            img: require('@/assets/img/minePage/goods.png'),
            title: '待收货'
        },
        {
            img: require('@/assets/img/minePage/evaluate.png'),
            title: '待评价'
        },
        {
            img: require('@/assets/img/minePage/afterSale.png'),
            title: '售后'
        },

    ];
    // header的个人信息(out)
    const [personalInfoDataOut, setPersonalInfoDataOut] = useState<IPersonalInfoOut>({
        picUrl: require('@/assets/img/logo.png'),
        buyerId: '',
        buyerName: '',
        collectionNumber: 0,
        shopFollowNumber: 0,
        goodsViewNumber: 0
    });
    useEffect(() => {
        // TODO 调个人信息接口(外)
        !(async function () {
            const res: any = await getSimpleInfo();
            setPersonalInfoDataOut(res);
        })();
    }, []);
    // 静态信息 收藏、关注、浏览
    const headerBottom = [
        {
            title: '商品收藏',
            name: 'collectionNumber',
            nums: personalInfoDataOut.collectionNumber
        },
        {
            title: '店铺关注',
            name: 'shopFollowNumber',
            nums: personalInfoDataOut.shopFollowNumber
        },
        {
            title: '近期浏览',
            name: 'goodsViewNumber',
            nums: personalInfoDataOut.goodsViewNumber
        },
    ];
    // 推荐商品
    const [projectBlockData, setProjectBlockData] = useState<IProjectBlock[]>([]);
    useEffect(() => {
        // recommend接口
        !(async function () {
            const res: any = await getRecommendGoods(1, 4);
            setProjectBlockData(res.list);
        })();
    }, []);
    const navigation = useNavigation();
    return (
        <AddBackgroundHOC>
            <ScrollView style={ styles.content }>
                <View style={ styles.header }>
                    <LinearGradient
                        style={ styles.headerInfo }
                        colors={ ['#84321c', '#c86c53'] }
                        start={ { x: 0, y: 0 } }
                        end={ { x: 1, y: 0 } }
                    >
                        <View style={ styles.headerInfoBtn }>
                            <Pressable
                                // @ts-ignore
                                onPress={ () => navigation.navigate('SignUp') }
                            >
                                <Image
                                    source={ require('@/assets/img/minePage/sign.png') }
                                    style={ { width: 24, height: 24, objectFit: 'contain', marginRight: 20 } }
                                />
                            </Pressable>
                            <Pressable
                                // @ts-ignore
                                onPress={ () => navigation.navigate('PersonalInfo') }
                            >
                                <Image
                                    source={ require('@/assets/img/minePage/user.png') }
                                    style={ { width: 24, height: 24, objectFit: 'contain', marginRight: 20 } }
                                />
                            </Pressable>
                            <Pressable
                                // @ts-ignore
                                onPress={ () => navigation.navigate('SetUp') }
                            >
                                <Image
                                    source={ require('@/assets/img/minePage/set.png') }
                                    style={ { width: 24, height: 24, objectFit: 'contain', marginRight: 20 } }
                                />
                            </Pressable>
                        </View>
                        <View style={ styles.headerInfoUser }>
                            <View style={ styles.userImgView }>
                                <Image
                                    source={ require('@/assets/img/minePage/mine.png') }
                                    style={ { width: '80%', height: '80%', objectFit: 'contain' } }
                                />
                            </View>
                            <View style={ styles.userInfo }>
                                <Text style={ styles.userInfoText }>{ personalInfoDataOut.buyerName }</Text>
                                <Text style={ styles.userInfoText }>id : { personalInfoDataOut.buyerId }</Text>
                            </View>

                        </View>
                        <View style={ styles.headerBottom }>
                            {
                                headerBottom.map((item, index) => {
                                    return (
                                        <View key={ index } style={ styles.headerBottomBtn }>
                                            <View style={ styles.headerBottomBtnInner }>
                                                <Text style={ styles.headerBottomBtnText }>{ item.nums }</Text>
                                                <Text style={ styles.headerBottomBtnText }>{ item.title }</Text>
                                            </View>
                                            <IsRenderHOC isShow={ index !== headerBottom.length - 1 }>
                                                <View style={ styles.headerBottomBtnSolid }/>
                                            </IsRenderHOC>
                                        </View>
                                    );
                                })
                            }
                        </View>
                    </LinearGradient>
                </View>
                <View style={ styles.main }>
                    <View style={ styles.order }>
                        <View style={ styles.orderTop }>
                            <Text style={ { color: '#000', fontWeight: 'bold' } }>我的订单</Text>
                            <Text style={ { fontSize: 12 } }>查看全部 { '>' } </Text>
                        </View>
                        <View style={ styles.orderInner }>
                            {
                                orderInner.map((item, index) => {
                                    return (
                                        <View key={ index } style={ styles.orderInnerItem }>
                                            <Image source={ item.img } style={ { width: 30, height: 30, objectFit: 'contain' } }/>
                                            <Text style={ { color: '#000' } }>{ item.title }</Text>
                                        </View>
                                    );
                                })
                            }
                        </View>
                    </View>
                    <View style={ styles.recommend }>
                        <View style={ styles.recommendTop }>
                            <Text style={ { color: '#000', fontSize: 18, fontWeight: 'bold' } }>精品推荐</Text>
                            <Text>查看全部 { '>' }</Text>
                        </View>
                        <View style={ styles.recommendInner }>
                            {
                                projectBlockData.map((item, index) => {
                                    return (
                                        // <ProjectBlock
                                        //     key={ index }
                                        //     imgUrl={ item.imgUrl }
                                        //     title={ item.title }
                                        //     price={ item.price }
                                        //     hasSold={ item.hasSold }
                                        // />
                                        <ProjectBlock
                                            key={ index }
                                            projectBlockData={ item }
                                        />
                                    );
                                })
                            }
                        </View>
                    </View>
                </View>
                <View style={ styles.hasInBottom }>
                    <MyText text="~~~~~  已经到底啦  ~~~~~"/>
                </View>
            </ScrollView>
        </AddBackgroundHOC>
    );
};
export default MineScreen;
const styles = StyleSheet.create({
    content: {
        flex: 1,
    },
    header: {
        width: '100%',
        height: Dimensions.get('window').height * 0.25,
    },
    headerInfo: {
        width: '100%',
        height: '95%',
        borderBottomLeftRadius: 55,
        borderBottomRightRadius: 55,
    },
    headerInfoBtn: {
        width: '100%',
        marginTop: 15,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'flex-end',
    },
    headerInfoUser: {
        width: '100%',
        height: 50,
        marginBottom: 15,
        display: 'flex',
        flexDirection: 'row',
        alignItems: 'center'
    },
    userImgView: {
        width: 50,
        height: 50,
        marginLeft: 20,
        marginRight: 20,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#f2c88c',
        borderRadius: 100,
    },
    userInfo: {
        height: '100%',
    },
    userInfoText: {
        fontSize: 15,
        color: '#fff'
    },
    headerBottom: {
        flex: 1,
        borderTopWidth: 2,
        borderTopColor: '#f8f8f8',
        borderStyle: 'solid',
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-around',
        alignItems: 'center',
    },
    headerBottomBtn: {
        width: '100%',
        height: '100%',
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
    },
    headerBottomBtnInner: {
        width: '33%',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
    },
    headerBottomBtnText: {
        color: '#f8f8f8',
        fontSize: 15,
        marginTop: 5
    },
    headerBottomBtnSolid: {
        width: 2,
        height: '70%',
        backgroundColor: '#f8f8f8'
    },
    main: {
        width: '100%',
        // flex: 1,
        marginTop: 15,
        paddingLeft: 10,
        paddingRight: 10
    },
    order: {
        width: '100%',
        height: 100,
        paddingLeft: 5,
        paddingRight: 5,
        borderRadius: 15,
        backgroundColor: '#fff'
    },
    orderTop: {
        height: 20,
        marginTop: 10,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-between'
    },
    orderInner: {
        width: '100%',
        flex: 1,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center'
    },
    orderInnerItem: {
        width: '20%',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
    },
    recommend: {
        width: '100%',
        // height: '70%',
        marginTop: 15,
        borderRadius: 15,
        backgroundColor: '#ffffffc4'
    },
    recommendTop: {
        height: 40,
        marginLeft: 5,
        marginRight: 5,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center'
    },
    recommendInner: {
        flex: 1,
        display: 'flex',
        flexWrap: 'wrap',
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        marginLeft: 5,
        marginRight: 5,
        // backgroundColor: '#fff'
    },
    hasInBottom: {

        marginTop: 20,
        marginBottom: 30,
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
    }
});
