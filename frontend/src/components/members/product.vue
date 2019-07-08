<template>
<div>
  <Nav></Nav>
    <Article></Article>
  <Footer></Footer>
</div>
</template>

<style scoped>



</style>

<script>
import Nav from '@/components/commom/Nav.vue'
import Footer from'@/components/commom/Footer.vue'
import Article from'@/components/board/Article.vue'
import Articles from'@/components/board/Articles.vue'

export default {
    components: {
      Nav,Footer,Article,Articles
  }
    
}
</script>
