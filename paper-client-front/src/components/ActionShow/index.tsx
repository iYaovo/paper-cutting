import { StyleSheet, View, ViewStyle } from 'react-native';
import React from 'react';
import AntDesignIcon from 'react-native-vector-icons/AntDesign';
import MyText from '@/components/MyText';
import IActionShow from '@/interface/IAction.ts';

interface IPros extends IActionShow {
    onPress?: () => void;
}

const ActionShow = (props: IPros) => {
    const { iconName, iconColor, count, style, onPress } = props;
    return (
        <View
            style={ { ...styles.content, ...(style as ViewStyle) } }
            onStartShouldSetResponder={ () => true }
            onResponderRelease={ onPress }>
            <AntDesignIcon
                name={ iconName }
                color={ iconColor }
                style={ { marginRight: 5 } }
                size={15}
            />
            <MyText text={ count }/>
        </View>
    );
};
export default ActionShow;
const styles = StyleSheet.create({
    content: {
        height: 20,
        display: 'flex',
        flexDirection: 'row',
        alignItems: 'center'
    }
});
