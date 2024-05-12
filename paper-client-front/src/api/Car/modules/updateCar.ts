import request from '@/utils/request.ts';

export default function (cartId: number, goodsNumber: number) {
    return request({
        url: '/cart/update',
        method: 'GET',
        data: {
            cartId,
            goodsNumber
        }
    })
}
