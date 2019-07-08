<template>
   <!-- Swiper -->
   <swiper :options="swiperOption">
        <div class="parallax-bg" slot="parallax-bg" data-swiper-parallax="-23%"></div>
        <swiper-slide>
          <div class="title" data-swiper-parallax="-100"></div>
          <br>
          <div class="subtitle" data-swiper-parallax="-200">개발자 정인근입니다.</div>
          <div class="text" data-swiper-parallax="-300">
            <p>Web Development</p>
          </div>
        </swiper-slide>
        <swiper-slide>
          <div class="title" data-swiper-parallax="-100"></div>
          <div class="subtitle" data-swiper-parallax="-200"></div>
          <div class="text" data-swiper-parallax="-300">
            <p></p>
          </div>
        </swiper-slide>
        <swiper-slide>
          <div class="title" data-swiper-parallax="-100"></div>
          <div class="subtitle" data-swiper-parallax="-200"></div>
          <div class="text" data-swiper-parallax="-300">
            <p></p>
          </div>
        </swiper-slide>
        <div class="swiper-pagination swiper-pagination-white" slot="pagination"></div>
        <div class="swiper-button-prev swiper-button-white" slot="button-prev"></div>
        <div class="swiper-button-next swiper-button-white" slot="button-next"></div>
      </swiper>
</template>


<script>
import 'swiper/dist/css/swiper.css'
import { swiper, swiperSlide } from 'vue-awesome-swiper'
 export default {
    components: {
    swiper
    },
    name: 'carrousel',
    data() {
      return {
         swiperOption: {
          speed: 600,
          parallax: true,
          pagination: {
            el: '.swiper-pagination',
            clickable: true
          },
          navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev'
          }
        }
      }
    },
    computed: {
      swiper() {
        return this.$refs.mySwiper.swiper
      }
    },
    mounted() {
      // current swiper instance
      // 然后你就可以使用当前上下文内的swiper对象去做你想做的事了
      console.log('this is current swiper instance object', this.swiper)
      this.swiper.slideTo(0, 1000, false)
    }
  }
</script>


<style scoped>
    .swiper-container {
      font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
      font-size: 14px;
      color:#000;
      width: 100%;
      height: 100%;
      background: #ccc;
    }
    .swiper-slide {
      font-size: 18px;
      color:#fff;
      -webkit-box-sizing: border-box;
      box-sizing: border-box;
      height: 100%;
      padding: 18% 15%;
    }
    .parallax-bg {
      position: absolute;
      left: 0;
      top: 0;
      width: 130%;
      height: 100%;
      -webkit-background-size: cover;
      background-image: url("../../assets/bg_main01.jpg");
      background-size: cover;
      background-position: center;
    }
    .swiper-slide .title {
      font-weight: 300;
      margin: 0,10%;
    }
    .swiper-slide .subtitle {
      font-size: 2em;
      font-weight: bold;
      margin-bottom: 1%;
      text-align: right;
    }
    .swiper-slide .text {
      font-size: 1em;
      line-height: 1.3;
    }
    p{
      text-align: right;

    }
</style>
