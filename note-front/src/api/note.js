// 引入封装的request
import request from '@/utils/request'

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
  return request({
    url: 'node/' + address,
    method: 'get'
  })
}