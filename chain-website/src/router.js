import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const Login = ()=> import(`@/views/Login.vue`);
const Home = ()=> import(`@/views/Home.vue`);
const ManagerIndex = ()=> import(`@/components/Home/ManagerIndex.vue`);
const PlayerIndex = ()=> import(`@/components/Home/PlayerIndex.vue`);
const PlatformIndex = ()=> import(`@/components/Home/PlatformIndex.vue`);
const PlatformContest = ()=> import(`@/components/Home/PlatformContest.vue`);
const PlatformFinal = ()=> import(`@/components/Home/PlatformFinal.vue`);
const ManagerVerify = ()=> import(`@/components/Home/ManagerVerify.vue`);
const PlayerVerify = ()=> import(`@/components/Home/PlayerVerify.vue`);
const PlatformFinalVerify = ()=> import(`@/components/Home/PlatformFinalVerify.vue`);
const ManagerIndex1 = ()=> import(`@/components/Home/ManagerIndex1.vue`);
const PlayerIndex1 = ()=> import(`@/components/Home/PlayerIndex1.vue`);


const routesMap = [
    {
        path: "/",
        redirect: "/login"
    },
    {
        path: "/login",
        component: Login,
    },
    {
        path:"/home",
        component: Home,
        children:[
            {
                path:'playerIndex',
                component:PlayerIndex,
            },
            {   
                path:'managerIndex',
                component:ManagerIndex
            },
            {
                path:'platformIndex',
                component:PlatformIndex
            },
            {
                path:'platformContest',
                component:PlatformContest
            },
            {
                path:'platformFinal',
                component:PlatformFinal
            },
            {
                path:'managerVerify',
                component:ManagerVerify
            },
            {
                path:'playerVerify',
                component:PlayerVerify
            },
            {
                path:'platformFinalVerify',
                component:PlatformFinalVerify
            },
            {   
                path:'managerIndex1',
                component:ManagerIndex1
            },
            {
                path:'playerIndex1',
                component:PlayerIndex1,
            },
        ]
    }
]

const router = new VueRouter({
    mode: 'history',
    routes: routesMap
})

export default router
