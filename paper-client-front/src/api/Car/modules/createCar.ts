import request from '@/utils/request.ts';

export default function (goodsId: number, goodsNumber: number) {
    return request({
        url: '/cart/create',
        method: 'POST',
        data: {
            goodsId,
            goodsNumber
        }
    });
}
