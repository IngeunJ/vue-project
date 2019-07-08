<template>
<div>
<div class="container">
      <h1 align="center">게시판</h1>
      <b-button variant="primary" class="wr" to="/Write">글 쓰기</b-button>
<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">내용</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="(key,num) in list" @click="Articles(num+1)" >
      <th scope="row">{{num+1}}</th>
      <td>{{key.title}}</td>
      <td>{{key.content}}</td>
    </tr>
  </tbody>
</table>
</div>
</div>
</template>
<script>
import axios from 'axios'
import {store} from '../../store'
export default {
    data(){
        return{
          context: 'http://localhost:9000/board',
          list:[],
          a:'',
        }
    },
    methods:{
      Articles(num){
        this.$router.push('/Articles')
        this.$store.state.boardInfo.bon=num;
      },
    },
    created:function(){
       axios.get(`${this.context}`)
            .then(res=>{
                this.list=res.data;   
                  
            }).catch(e=>{
                alert('오류')
            })
    }
    
}
</script>
<style scoped>
.wr{
    margin: 1em 1em;
    float: right;
}

.container{
   margin-top: 5%;
   margin-bottom: 10%;
}
</style>