import { login }from "@/api/user";

export const actions = {
  // 用户登录
  async login({ commit }, user) {
   try {
       await login(user);
       commit('SET_USERNAME', user.username);
       // commit('SET_TOKEN_KEY', user.tokenKey);
       // commit('SET_TOKEN_VALUE', user.tokenValue);
   }catch (e) {
       return Promise.reject(e);
   }
  }
};