<template>
<div>
<Nav></Nav>
<div class="container">   
     <form>
        <div class="form-group">
        <label for="title">제목</label>
        <p id="content">{{board.content}}</p>
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <p id="content">{{board.content}}</p>
        </div>
        <button class="btn btn-info" @click="modify()">수정하기</button>
        <button class="btn btn-danger" @click="delete1()">삭제하기</button>
    </form>
    <div>
        
    </div>
    </div>
<Footer></Footer>    
</div> 
</template>
<script>
import Nav from '@/components/commom/Nav.vue'
import Footer from '@/components/commom/Footer.vue'
import axios from 'axios'
import {store} from '../../store'
export default {
    data(){
        return{
            context:'http://localhost:9000/board',
            
            board:{
                id: '',
                title:'',
                content:''
            },
            
        }
    },
    components:{
        Nav,Footer
    },
   created:function(){
       axios.get(`${this.context}/${this.$store.state.boardInfo.bon}`)
            .then(res=>{
              let a= JSON.stringify(res.data);
                this.ida =res.data.bon;
                this.board.title=res.data.title;   
                this.board.content=res.data.content;  
                this.$store.state.boardInfo.title = res.data.title;
                this.$store.state.boardInfo.content = res.data.content;
                  
            }).catch(e=>{
                alert('오류')
            })
    },
     methods:{
         modify(){
             this.$router.push('/Modify')
         },
        delete1(){
              let con = confirm("정말 삭제하시겠습니까?")
              if(con == true){             
                axios.delete(`${this.context}/${this.id}`)
                        .then(res=>{
                            this.$router.push("/product")                    
                        })
                        .catch(e=>{
                            alert('에러')
                        })
              }
            }
     }
    
    
}
</script>
<style scoped>
p{
    clear: both;
    text-align: left;
}
label{
    float: left;
    font-weight: bold;
    font-size: 1.5em;
}
p{
    border: 1px solid #ccc;
    font-size: 1.2em;
}
.container{
   margin-top: 8%;
   margin-bottom: 10%;
}
</style>