import {createRouter, createWebHistory} from "vue-router";
import Layout from '@/views/layout/layout.vue'
const constantRouterMap = [
    {
        path: '',
        redirect: '/note/list'
    },
    {
        path: '/note',
        component: Layout,
        // redirect: '',
        name: 'note',
        meta: { title: '文章列表' },
        children: [
            {
                path: 'list',
                name: 'list',
                component: () => import('@/views/note/list.vue')
            }
        ]
    },
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
