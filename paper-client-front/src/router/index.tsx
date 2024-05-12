import Main from '../views/Main';
import HomeScreen from '../views/HomeScreen';
import ShoppingScreen from '../views/ShoppingScreen';
import CarScreen from '../views/CarScreen';
import MineScreen from '../views/MineScreen';

import PersonalInfo from '../views/PersonalInfo';
import ProjectDetail from '../views/ProjectDetail';
import SignUp from '../views/SignUp';
import SetUp from '../views/SetUp';
import Address from '@/views/Adress';
import Settle from '@/views/Settle';

/*
    只配置stack
 */
interface IBottomTab {
    name: string,
    component: any,
}

interface IRouter {
    name: string,       // 页面名字,供跳转使用
    title?: string,      // 头部标题
    component: any,
    bottomTab?: IBottomTab[]
}

const router: IRouter[] = [
    {
        name: 'Main',
        title: '首页',
        component: Main,
        bottomTab: [
            {
                name: '首页',
                component: HomeScreen,
            },
            {
                name: '商城',
                component: ShoppingScreen
            },
            {
                name: '购物车',
                component: CarScreen
            },
            {
                name: '我的',
                component: MineScreen
            }
        ]
    },
    {
        name: 'SignUp',
        title: '签到',
        component: SignUp
    },
    {
        name: 'ProjectDetail',
        title: '商品信息',
        component: ProjectDetail
    },
    {
        name: 'PersonalInfo',
        title: '个人信息',
        component: PersonalInfo
    },
    {
        name: 'SetUp',
        title: '设置',
        component: SetUp
    },
    {
        name: 'Address',
        title: '收货地址',
        component: Address
    },
    {
        name: 'Settle',
        title: '结算',
        component: Settle
    }
];

export default router;
