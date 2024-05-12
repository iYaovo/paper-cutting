import { Image, Pressable, StyleSheet, Text, TextInput, View } from 'react-native';
import React, { useEffect, useState } from 'react';
import AddBackgroundHOC from '@/components/HOC/AddBackgroundHOC.tsx';
import TopPage from '@/components/TopPage';
import { IPersonalInfoIn } from '@/interface/IPersonalInfo.ts';
import { getShowInfo, postChangeInfo } from '@/api/buyerInfo';
import { AxiosResponse } from 'axios';

const PersonalInfo = () => {
    const [personalInfoDataIn, setPersonalInfoDataIn] = useState<IPersonalInfoIn>({
        picUrl: require('@/assets/img/logo.png'),
        buyerId: '',
        buyerName: '',
        buyerHobby: '',
        buyerAutograph: ''
    });
    useEffect(() => {
        !(async function () {
            const res: any = await getShowInfo();
            setPersonalInfoDataIn(res);
        })();
    }, []);
    // 切换修改/保存状态
    const [isEdit, setIsEdit] = useState(false);

    async function handleEditButtonPress () {
        // 当前是修改状态 -> 保存信息
        if (isEdit) {
            // TODO 调接口
            await postChangeInfo(personalInfoDataIn);
            setIsEdit(false);
            console.log('----保存成功!');
        } else {
            // 当前不是修改状态 -> 点一下变成修改状态
            setIsEdit(true);
        }
    }

    // 修改信息文本
    function changeInput (field: string, value: string) {
        console.log('value----', value);
        setPersonalInfoDataIn({
            ...personalInfoDataIn,
            [field]: value
        });
    }

    return (
        <AddBackgroundHOC>
            <TopPage title="个人信息"/>
            <View style={ styles.content }>
                <View style={ styles.info }>
                    <View style={ styles.editView }>
                        <Pressable
                            style={ styles.editBtn }
                            onPress={ handleEditButtonPress }
                        >
                            {
                                isEdit
                                    ? <Text style={ { color: '#fff', fontSize: 16 } }>保存</Text>
                                    : <Text style={ { color: '#fff', fontSize: 16 } }>修改</Text>
                            }
                        </Pressable>
                    </View>
                    <Image
                        style={ styles.picUrl }
                        source={ personalInfoDataIn.picUrl }
                        defaultSource={ require('@/assets/img/logo.png') }
                    />
                    <View style={ styles.buyerItem }>
                        <Text style={ styles.buyerText }>用户名称: </Text>
                        <TextInput
                            style={ styles.buyerTextInput }
                            value={ personalInfoDataIn.buyerName }
                            editable={ isEdit }
                            onChangeText={ (value) => changeInput('buyerName', value) }
                        />
                    </View>
                    <View style={ styles.buyerItem }>
                        <Text style={ styles.buyerText }>爱好: </Text>
                        <TextInput
                            style={ styles.buyerTextInput }
                            value={ personalInfoDataIn.buyerHobby }
                            editable={ isEdit }
                            onChangeText={ (value) => changeInput('buyerHobby', value) }
                        />
                    </View>
                    <View style={ styles.buyerItem }>
                        <Text style={ styles.buyerText }>个人签名: </Text>
                        <TextInput
                            style={ styles.buyerTextInput }
                            value={ personalInfoDataIn.buyerAutograph }
                            editable={ isEdit }
                            onChangeText={ (value) => changeInput('buyerAutograph', value) }
                        />
                    </View>
                </View>
            </View>
        </AddBackgroundHOC>
    );
};
export default PersonalInfo;
const styles = StyleSheet.create({
    content: {
        flex: 1
    },
    info: {
        width: '100%',
        display: 'flex',
        alignItems: 'center',
        paddingLeft: 10,
        paddingRight: 10
    },
    editView: {
        position: 'relative',
        width: '100%',
        height: 30,
    },
    editBtn: {
        width: 50,
        height: 30,
        position: 'absolute',
        right: 10,
        backgroundColor: '#deb880',
        borderRadius: 15,
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
    },
    picUrl: {},
    buyerItem: {
        width: '100%',
        height: 40,
        marginTop: 15,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
    },
    buyerText: {
        width: '20%',
        paddingLeft: 5
    },
    buyerTextInput: {
        flex: 1,
        backgroundColor: '#f5f5f5',
        borderRadius: 15
    }
});
