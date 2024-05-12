import request from '@/utils/request.ts';

export default function () {
    return request({
        url: '/buyer/showSimpleInformation',
        method: 'GET',
    })
}
