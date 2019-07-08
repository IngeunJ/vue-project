<template>
<div>
<Nav></Nav>
<div class="container">
    <!-- <form> -->
        <h1 class="heading mb-sm-5 mb-4" >수정하기</h1>
        <div class="form-group">
        </div>
        <div class="form-group">
        <label for="inputPrefilledEx">제목</label>
        <input type="text" id="inputPrefilledEx" class="form-control" v-model="title">
        </div>
        <div class="form-group">
        <label for="exampleFormControlTextarea3">내용</label>
        <textarea class="form-control" id="exampleFormControlTextarea3" rows="8" v-model="content"></textarea>
        </div>
        <div class="form-group">
        <button  class="btn btn-primary" @click="update">수정하기</button>
        </div>
    <!-- </form> -->
</div>
<Footer></Footer>
</div>
</template>
<script>
import Nav from '@/components/commom/Nav.vue'
import Footer from '@/components/commom/Footer.vue'
import {store} from '../../store'
import axios from 'axios'
export default {
    data(){
        return{
            id: this.$store.state.boardInfo.bon,
            context: 'http://localhost:9000/board',
            title:'dd',
            content:''
        
        }
    },
    components:{
        Nav,Footer
    },
    created: function(){
         axios.get(`${this.context}/${this.id}`)
         .then((res) =>{
                this.title =res.title
                this.content =res.content
        })
    },
    methods:{
        update(){
            let data={
                title:this.title,
                content:this.content
            }
             let header={
                'Content-Type':'application/json',
                'Authorization':'JWT fefege..'
             }
            axios.put(`${this.context}/${this.id}`,data,{headers:header})
            .then(res=>{
                alert("수정 완료")
                this.$router.push("/product")
            }).catch(e=>{
                aelrt("통신 오류")
            })
        },
    }
    
}
</script>
<style scoped>
label{
    float: left;
    margin-left: 1%;
}
.container{
   margin-top: 5%;
   
}
</style>