import { ColorValue, StyleProp, ViewStyle } from 'react-native';

export default interface IActionShow {
    iconName: string;
    iconColor?: ColorValue | number;
    count: number;
    style?: StyleProp<ViewStyle>;
}
