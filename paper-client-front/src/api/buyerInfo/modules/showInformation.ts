import request from '@/utils/request.ts';

export default function () {
    return request({
        url: '/buyer/showInformation',
        method: 'GET',
    })
}
