<template>
<section id="login">
<Nav></Nav>
 <form>
  <h1>Login</h1>
  <div class="info" >
  </div>
  <input type="text" placeholder="Username"  v-model="id"/>
  <input type="password" placeholder="Password" v-model="pws"/>
  <button tag="button" @click="login()">로그인</button>
 </form>
 <Footer></Footer>
</section>
</template>

<script>
import Nav from '@/components/commom/Nav.vue'
import Footer from'@/components/commom/Footer.vue'
import axios from 'axios'
import {store} from '../../store'
export default {
  name: 'home',
  components:{
    Nav,Footer
  },
    data:()=>{
		return{
			context: 'http://localhost:9000/customers',
			id:'',
			pws:''
		}
	},
    methods:{
		login(){
		let headers = {
           'Content-Type': 'application/json',
           'Authorization': 'JWT fefege..'
         	}
          let data={
            customerId : this.id,
            password : this.pws
			}
			if(this.id =='' && this.pws==''){
				 alert("아이디와 비밀번호를 확인하세요.");
			 }
		
		 axios.post(`${this.context}/login`,data)
         .then(res=>{
             this.$router.push("/");
			 alert(`로그인 성공`)
			 this.$store.state.userInfo.userId=res.data.customerId;
			 this.$store.state.userInfo.loginflag=true;
			 
		 })
         .catch(e=>{
             alert('ERROR')
		 })
		  
		}, 
	
}
}
</script>


<style scoped>
html, body{
	width:100%;
	height:100%;
	margin:0px;
	font-family: 'Work Sans', sans-serif;
}
body{
	  background-size: cover;
		display: flex;
		flex-direction:column;
		justify-content:center;
	  align-items:center;
		color: #fff;
}
h1{
	font-weight: bold;
}

#login form{
		margin: 10%;
		
}
#login input{
	width: 65%;
	margin-left: 20%; 
}
#login button{
	width: 65%;
	margin-left: 20%; 
}
#section{
	background-color: rgba(0, 0, 0, 0.72);
	width:25%;
	min-height:25%;
	display:flex;
	flex-direction:column;
	/*margin-left:auto;
	margin-right:auto;*/
}
form{
	display:flex;
	flex-direction:column;
	padding: 15px; 
}
h2{
	font-family: 'Archivo Black', sans-serif;
	color:#e0dada;
	margin-left:auto;
	margin-right:auto;
}

.info{
	width:100%;
	padding :1em 5px;
	text-align:center;
	min-height:45px;
	display:flex;
	flex-direction:column;
	justify-content:center;
	align-items:center;
}

.info.error{
	border:1px solid #0990e1;
	background-color: #ff3c41;
	color:#0990e1;
}
.info p{
	margin:auto;
	padding:5px;
}
.info.good{
	border:1px solid #416d50;
	background-color: #47cf73;
	color:#416d50;
}

input{
	height:35px;
	padding: 5px 5px;
	margin: 10px 0px;
	background-color:#e0dada;
	border:none;
}

button{
	height:40px;
	padding: 5px 5px;
	margin: 10px 0px;
	font-weight:bold;
	background-color:#be5256;
	border:none;
	color:#e0dada;
	cursor:pointer;
	font-size:16px;
}
button:hover{
	background-color:#711f1b;
}

@-webkit-keyframes shake{
	from, to{
		-webkit-transform: translate3d(0, 0, 0);
		transform:translate3d(0,0,0);
	}
	10%,30%,50%,70%,90%{
		-webkit-transform: translate3d(-10px, 0, 0);
		transform:translate3d(-10px,0,0);
	}
	20%,40%,60%,80%{
		-webkit-transform: translate3d(10px, 0, 0);
		transform:translate(10px,0,0);
	}
}

.shake{
	animation-name: shake;
	animation-duration:1s;
	/*animation-fill-mode: both;*/
}

@media screen and (max-width: 780px) {
	section{
		width:90%;
	}
}
</style>
