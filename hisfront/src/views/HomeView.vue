<template>
  <div class="home">
<!--    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> -->
	<!-- {{$store.state.num}} -->
	<!--store/index.js里声明的num1000-->
	<!-- <el-button @click="fun">修改vuex数据</el-button> -->
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  // components: {
  //   HelloWorld
  methods:{
	  fun(){
		  this.$store.commit('num',1)
	  }
  }
}
</script>
