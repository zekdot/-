import {createRouter, createWebHistory} from "vue-router";
const constantRouterMap = [
    {
        path: '',
        component: () => import('@/views/note/list.vue')
    },
    {
        path: '/list',
        name: 'list',
        component: () => import('@/views/note/list.vue')
    },
    // 这里在访问/detail/13的时候就会访问detail.vue，并且传入参数13
    {
        path: '/detail/:id',
        component: () => import('@/views/detail.vue')
    },
    // 404信息页面展示
    { 
        path: '/:pathMatch(.*)*', 
        name: 'NotFound', 
        component: () => import('@/views/notFound.vue')
    }
]
export default new createRouter({
    history: createWebHistory(),
    routes: constantRouterMap
});
//# sourceMappingURL=router.js.map
