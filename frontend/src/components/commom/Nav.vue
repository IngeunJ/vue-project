<template>
<div>

  <b-navbar v-if="$store.state.userInfo.loginflag"  variant="faded" type="light" id="navbar">
    <b-navbar-brand href="/">
      <h2>Ingeun Jeong</h2>
    </b-navbar-brand>
<b-nav id="nav1">
    <b-nav-item to="/product" >Board</b-nav-item>
</b-nav>

<b-nav small>
    <b-nav-item to="/login">{{$store.state.userInfo.userId}}</b-nav-item>
    <b-button @click="logout">로그아웃</b-button>
  
</b-nav>
  </b-navbar>
<b-navbar v-else="!$store.state.userInfo.loginflag" variant="faded" type="light" id="navbar">
    <b-navbar-brand href="/">
      <h2>Ingeun Jeong</h2>
    </b-navbar-brand>
<b-nav id="nav1">
    <b-nav-item @click="ready" >Board</b-nav-item>
</b-nav>
<b-nav small>
    <b-nav-item to="/login">login</b-nav-item>
    <b-nav-item to="/join">join</b-nav-item>
</b-nav>
  </b-navbar>


</div>
</template>

<script>

export default {
    methods:{
      ready(){
        alert("로그인해주세요.");
      },
      logout(){
       this.$store.state.userInfo.userId = '';
       this.$store.state.userInfo.userflag = false;
       
      }

    }
}
</script>


<style scoped>
div{
padding: 0 7% 0 5%;
background-color: #ccc1;
opacity: 0.9;  
}

.navbar-expand{
  justify-content:space-around;
}
a{
  text-align: right;
  color: black;
}
</style>
