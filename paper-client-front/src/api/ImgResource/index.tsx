import request from '@/utils/request.ts';

export function postResourceImg (file: File): any {
    return request({
        url: '/resource/add',
        method: 'POST',
        data: {
            file
        },
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    });
}
