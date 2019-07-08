<template>
<div>
<Nav></Nav>
<div class="container">
    <h1 class="heading mb-sm-5 mb-4" >글쓰기</h1>
    <form>
        <div class="form-group">
        <label for="title">제목</label>
        <input type="text" id="title" class="form-control" v-model="title">
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea class="form-control" id="content" rows="12" v-model="content"></textarea>
        </div>
        <div class="form-group">
        <button type="submit" class="btn btn-primary" @click="save">작성하기</button>
        </div>
    </form>
</div>
<Footer></Footer>
</div>
</template>
<script>
import Nav from '@/components/commom/Nav.vue'
import Footer from'@/components/commom/Footer.vue'
import axios from 'axios'
export default {
    data(){
        return{
            title:'',
            content:'',
            context: 'http://localhost:9000/board',
        }
    },
    components:{
        Nav,Footer
    },
    methods:{
       save(){
            let data={
                title:this.title,
                content:this.content
            }
             let header={
                'Content-Type':'application/json',
                'Authorization':'JWT fefege..'
             }
             axios.post(`${this.context}`, data,{headers:header})
             .then(res=>{
                 alert("작성완료")
                 this.$router.push("/product")
             })
             .catch(e=>{
                 alert('ERROR')
                 this.$router.link(-1);
             })
        }
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