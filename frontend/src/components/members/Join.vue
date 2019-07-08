<template>
  <div>
      <Nav></Nav>
    <section class="contact py-5">
        <div class="container py-lg-5">
            <h1 class="heading mb-sm-5 mb-4" > Join Us</h1>
            <div class="row">
                <div class="col-lg-12 contact-form mt-md-0 mt-sm-5 mt-4">
                    <h4 class="mb-4 w3f_title"></h4>
                    <div name="contactform" id="contactform">
                        <b-card bg-variant="light" class="form-group">
                            <b-form-group label-cols-lg="3" label="Impomation"  label-size="lg" 
                            label-class="font-weight-bold pt-0" class="mb-0">
                            <b-form-group label-cols-sm="3" label="아이디" label-align-sm="right" label-for="nested-street">
                                <b-form-input v-model="id" ></b-form-input>
                            </b-form-group>

                            <b-form-group label-cols-sm="3" label="비밀번호" label-align-sm="right" label-for="nested-city">
                                <b-form-input type="password" v-model="pws"></b-form-input>
                            </b-form-group>

                            <b-form-group label-cols-sm="3" label="비밀번호 확인" label-align-sm="right" label-for="nested-state">
                                <b-form-input></b-form-input>
                            </b-form-group>
                            <b-form-group
                                label-cols-sm="3" label="이름" label-align-sm="right" label-for="nested-street">
                                <b-form-input v-model="name"></b-form-input>
                            </b-form-group>
                             <b-form-group
                                label-cols-sm="3" label="이메일" label-align-sm="right" label-for="nested-city">
                                <b-form-input id="nested-city"  v-model="email"></b-form-input>
                            </b-form-group>
                            <b-form-group label-cols-sm="3" label="핸드폰번호" label-align-sm="right" label-for="nested-state">
                                <b-form-input id="nested-state" v-model="phone"></b-form-input>
                            </b-form-group>
                            <!--<b-form-group label-cols-sm="3" label="성별" label-align-sm="right" label-for="nested-state">
                                    <b-button type="submit" variant="primary" v-model="sex" @click="man">남성</b-button>
                                    <b-button type="reset" variant="danger" v-model="sex" @click="women">여성</b-button>
                            </b-form-group>-->
                            </b-form-group>
                        </b-card>
                         <div class="form-group">
                        <b-card bg-variant="light">
                            <b-form-group label-cols-lg="3" label="Address"  label-size="lg" 
                            label-class="font-weight-bold pt-0" class="mb-0">
                            <b-form-group
                                label-cols-sm="3" label="주소:" label-align-sm="right" label-for="nested-street">
                                <b-form-input id="nested-street" v-model="address"></b-form-input>
                            </b-form-group>
                            <b-form-group label-cols-sm="3" label="우편번호:" label-align-sm="right" label-for="nested-state">
                                <b-form-input id="postalcal" v-model="postalcal"></b-form-input>
                            </b-form-group>
                            </b-form-group>
                        </b-card>
                        </div>
            
                        <div class="form-group"> 
                            <b-form-textarea id="textarea" v-model="text" placeholder="소개부탁드립니다." rows="3" max-rows="6">
                            </b-form-textarea>
                        </div>
                        <b-button id="sub" type="submit" variant="basic" @click="save" >Submit</b-button>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <Footer></Footer>
    </div>
</template>
<script>
import Nav from '@/components/commom/Nav.vue'
import Footer from'@/components/commom/Footer.vue'
import axios from 'axios'

export default {
  name: 'home',
  components:{
    Nav,Footer
  },
  data(){
      return{
          	context: 'http://localhost:9000/customers',
            sex: '',//아직
            id:'',
            pws:'',
            name:'',
            email:'',
            phone:'',
            city:'',
            address:'',
            postalcal:'',
            text:'',
      }
  },
  methods:{
      save(){
        let data = {
           customerId:this.id,
           password:this.pws,
           customerName:this.name,
           email:this.email,
           phone:this.phone,
           city:this.city,
           address:this.address,
           postalcode:this.postalcal,
           introduction:this.text
         }
         let headers = {
           'Content-Type': 'application/json',
           'Authorization': 'JWT fefege..'
         }
         axios.post(`${this.context}`, 
                    JSON.stringify(data),
                    {headers: headers})
         .then(res=>{
             alert('환영합니다.')
             this.$router.push("/Login");
         })
         .catch(e=>{
             alert('ERROR')
         })
      },
  }

}
</script>

<style scoped>


.form-row{
    margin-top: 2em;
}
h1{font-weight: bold}
#sub{color: black; background-color:#ccc }
label{
    font-size: 1em;
    float: left;
    margin-left: 1%;
}
.btn.btn-secondary{width: 3%}
</style>