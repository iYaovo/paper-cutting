import createCar from '@/api/Car/modules/createCar.ts';
import getCar from '@/api/Car/modules/getCar.ts';
import deleteCar from '@/api/Car/modules/deleteCar.ts';
import settleCar from '@/api/Car/modules/settleCar.ts';
import updateCar from '@/api/Car/modules/updateCar.ts';

/**
 * @description 添加商品到购物车
 * @param goodsId 商品id
 * @param goodsNumber 商品数量
 */
export function postCreateCar (goodsId: number, goodsNumber: number) {
    return createCar(goodsId, goodsNumber);
}

/**
 * @description 获取购物车商品
 */
export function getGoodsCar () {
    return getCar();
}

/**
 * @description 删除购物车商品
 * @param ids 删除的goodsIds
 */
export function postDeleteCar (ids: number | number[]) {
    let newIds = [];
    if (typeof ids === 'number') {
        newIds[0] = ids;
    } else {
        newIds = ids;
    }
    return deleteCar(newIds);
}

/**
 * @description 结算购物车商品
 * @param receivingAddressId 收货地址id
 * @param cartIds 购物车的ids
 */
export function postSettleCar (receivingAddressId: number, cartIds: number[]) {
    return settleCar(receivingAddressId, cartIds);
}

/**
 * @description 通过购物车id更改商品数量
 * @param cartId 购物车id
 * @param goodsNumber 商品id
 */
export function getUpdateCar (cartId: number, goodsNumber: number) {
    return updateCar(cartId, goodsNumber);
}
