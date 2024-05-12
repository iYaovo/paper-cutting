import request from '@/utils/request.ts';

export default function (buyerHobby: string, buyerAutograph: string, picUrl: string) {
    return request({
        url: '/buyer/changeInformation',
        method: 'POST',
        data: {
            buyerHobby,
            buyerAutograph,
            picUrl
        }
    });
}
