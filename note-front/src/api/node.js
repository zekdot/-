// 引入封装的request
import { request } from '@/utils/request'

// 根据地址获取文章列表
export function submitNewNode(node) {
    return request({
        url: 'node/addNode',
        method: 'post',
        params : node
    })
}

export function delNode(data) {
    return request({
        url: 'node/delNode',
        method: 'post',
        params: data
    })
}

// 根据address请求文章详情
// export function getNoteDetail(address) {
//     return noteRequest({
//         url: address,
//         method: 'get'
//     })
// }