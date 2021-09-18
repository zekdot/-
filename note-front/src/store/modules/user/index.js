import { getters } from './getters';
import { actions } from './actions';
import { mutations } from './mutations';
export const state = {
    username: null,
    // tokenKey: '',
    // tokenValue: ''
};
const namespaced = true;
export const user = {
    namespaced,
    state,
    getters,
    actions,
    mutations
};
//# sourceMappingURL=index.js.map