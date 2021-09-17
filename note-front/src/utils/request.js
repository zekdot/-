import axios from 'axios';
const request = axios.create({
    // 设置路径前缀，使用时所有路径请求时都会增加这个前缀
    baseURL: 'http://localhost:9003/api',
    // 设置请求超时时间
    timeout: 5000
});
// 请求回复前置处理
request.interceptors.response.use(response => {
    // 请求发送后的处理方式，如果code不为0,直接返回错误
    const res = response.data;
    if (res.code !== 0) {
        alert(res.message);
        return Promise.reject(res.message);
    }
    else {
        return res.object;
    }
}, error => {
    // 请求发送前就失败了的时候的处理方式
    alert(error.message);
    return Promise.reject(error);
});
export default request;
//# sourceMappingURL=request.js.map