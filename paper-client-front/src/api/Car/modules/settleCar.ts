import request from '@/utils/request.ts';

export default function (receivingAddressId: number, cartIds: number[]) {
    return request({
        url: '/cart/settle',
        method: 'POST',
        data: {
            receivingAddressId,
            cartIds
        }
    })
}

