import { createStore } from 'vuex'
import Cookies from 'js-cookie';
import { note } from './modules/note';
import { user } from './modules/user';
import persistedState from 'vuex-persistedstate'

const store = {
    state: {
        version: '1.0.0'
    },
    modules: {
        note,
        user
    },
    plugins: [
      persistedState({
        storage: {
          getItem: key => Cookies.get(key),
          setItem: (key, value) => Cookies.set(key, value),
          removeItem: key => Cookies.remove(key)
        }
      })
    ]
};
export default new createStore(store);