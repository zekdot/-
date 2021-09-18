import { request } from '@/utils/request';

// 登录
export function login(user) {
    return request({
        url: 'user/login',
        method: 'post',
        params: user
    })
}
// 是否登录
export function isLogin() {
    return request({
        url: 'user/isLogin',
        method: 'get'
    })
}