import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Join from '@/components/members/Join'
import Login from '@/components/members/Login'
import Product from '@/components/members/product'
import Write from '@/components/board/Write'
import Article from '@/components/board/Article'
import Articles from '@/components/board/Articles'
import Modify from '@/components/board/Modify'

Vue.use(Router)
export default new Router({
  routes: [
    {path: '/',name: 'Home',component: Home},
    {path: '/join',name: 'Join',component: Join},
    {path: '/login',name: 'Login',component: Login},
    {path: '/product',name: 'Product',component: Product},
    {path: '/Write',name: 'Write',component: Write},
    {path: '/Article',name: 'Article',component: Article},
    {path: '/Articles',name: 'Articles',component: Articles},
    {path: '/Modify',name: 'Modify',component: Modify,},

  ]
})
