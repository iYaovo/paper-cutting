import { Dimensions, ImageBackground, InputAccessoryView, Pressable, StyleSheet, Text, TextInput, View } from 'react-native';
import React, { useEffect, useState } from 'react';
import AntDesignIcon from 'react-native-vector-icons/AntDesign';
import MyText from '@/components/MyText';
import { useNavigation } from '@react-navigation/native';

interface IProps {
    page: number,   // 0 主页,1 社区
    onNavigator: (page: number) => void,
}

const HomeTop = (props: IProps) => {
    const Navigation = useNavigation();
    const onNavigator = props.onNavigator;
    const [curPage, setCurPage] = useState(props.page);
    const [searchValue, setSearchValue] = useState('');
    useEffect(() => {
        setCurPage(props.page);
    }, [props.page]);

    return (
        <View style={ styles.container }>
            {/* 签到,主页,社区 */ }
            <View style={ styles.topBtn }>
                <View style={ styles.btnSign }>
                    <AntDesignIcon name="calendar"/>
                    {/*<MyText text="签到" styles={ { fontSize: 10, fontWeight: 'bold' } } onNavigator={() => }/>*/ }
                    <Pressable
                        hitSlop={ 10 }
                        // @ts-ignore
                        onPress={ () => Navigation.navigate('SignUp') }
                    >
                        <Text style={ { fontSize: 10, fontWeight: 'bold' } }>签到</Text>
                    </Pressable>
                </View>
                <View style={ styles.btnPage }>
                    <MyText
                        text="主页"
                        styles={ curPage === 0 ? { ...styles.btnPageText, ...styles.btnPageTextActive } : styles.btnPageText }
                        onNavigator={ () => onNavigator(0) }
                    />
                    <MyText
                        text="社区"
                        styles={ curPage === 1 ? { ...styles.btnPageText, ...styles.btnPageTextActive } : styles.btnPageText }
                        onNavigator={ () => onNavigator(1) }
                    />
                </View>
            </View>
            {/* 搜索框,拍照,扫码*/ }
            <View style={ styles.topSearchBar }>
                <View style={ styles.searchBarInner }>
                    <AntDesignIcon
                        name={ 'camerao' }
                        color={ '#84321c' }
                        size={ 20 }
                        style={ { marginRight: 5 } }
                    />
                    <MyText
                        text={ '|' }
                        styles={ { fontWeight: 'bold', color: '#f1ece6' } }
                    />
                    <TextInput
                        style={ styles.searchBarInput }
                        placeholder={ '输入搜索内容' }
                        value={ searchValue }
                        onChangeText={ text => setSearchValue(text) }
                    />
                    <AntDesignIcon
                        name={ 'scan1' }
                        color={ '#84321c' }
                        size={ 20 }
                        style={ { marginLeft: 5 } }
                    />
                </View>
            </View>
        </View>
    );
};
export default HomeTop;

const vWidth = Dimensions.get('window').width;
const vHeight = Dimensions.get('window').height;

const styles = StyleSheet.create({
    container: {
        height: vHeight / 7,
        backgroundColor: '#84321c',
        borderBottomLeftRadius: 45,
        borderBottomRightRadius: 45,
    },
    topBtn: {
        position: 'relative',
        height: '40%',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
    },
    btnSign: {
        position: 'absolute',
        left: 15,
        width: 50,
        height: 25,
        backgroundColor: '#f2c88c',
        borderRadius: 25,
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
    },
    btnPage: {
        width: vWidth / 3,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-around',
    },
    btnPageText: {
        color: '#f2c88c',
        fontSize: 15
    },
    btnPageTextActive: {
        fontWeight: 'bold',
        fontSize: 16
    },
    topSearchBar: {
        height: '30%',
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'center',
    },
    searchBarInner: {
        width: '80%',
        paddingLeft: 10,
        paddingRight: 10,
        display: 'flex',
        flexDirection: 'row',
        alignItems: 'center',
        backgroundColor: '#fff',
        borderRadius: 18,
    },
    searchBarInput: {
        flex: 1,
        padding: 0,
    }
});
