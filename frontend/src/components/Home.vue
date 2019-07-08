<template>
<div>
  <Nav></Nav>
  <Swiper></Swiper>
  <Footer></Footer>
</div>  
</template>

<script>
import Swiper from '@/components/members/Swiper.vue'
import Nav from '@/components/commom/Nav.vue'
import Footer from'@/components/commom/Footer.vue'
export default {
  name: 'Home',
    components:{
      Nav,Footer,Swiper
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
