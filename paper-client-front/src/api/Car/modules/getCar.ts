import request from '@/utils/request.ts';

export default function () {
    return request({
        url: '/goods/cart',
        method: 'GET'
    })
}
