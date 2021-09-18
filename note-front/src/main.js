import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router';
import store from './store/store';

const app = createApp(App);

router.beforeEach((to) => {

    if(to.meta.requireLogin && !store.state.user.username) {
        console.log('过滤' + to);
        return {
            path: '/note/list'
        }
    }
    // return true;
});

app.use(router);
app.use(store);
app.mount('#app');