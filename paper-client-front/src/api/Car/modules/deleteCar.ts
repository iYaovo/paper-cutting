import request from '@/utils/request.ts';

export default function (ids: number[]) {
    return request({
        url: '/cart/delete',
        method: 'POST',
        data: {
            ids
        }
    });
}

