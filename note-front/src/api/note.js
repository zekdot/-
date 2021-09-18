// 引入封装的request
import { request, noteRequest } from '@/utils/request'

// 根据地址获取文章列表
export function getNoteList(address) {
  return request({
    url: 'node/getNodes',
    method: 'get',
    params : {'address' : address}
  })
}

// 根据address请求文章详情
export function getNoteDetail(address) {
  return noteRequest({
    url: address,
    method: 'get'
  })
}

export function updateContent(data) {
  return request({
    url: 'note/updateContent',
    method: 'post',
    data: data
  })
}