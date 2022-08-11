<template>
  <div id="app">
    <nav>
     <!-- <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> | -->
	  <router-link to="/login" style="text-decoration: none;">云医院</router-link>
	  
	
    </nav>
	<router-view v-if="isRouterAlive"/>
  </div>
</template>

<script>
    export default {
        name: 'App',
        provide(){
            return{
                reload:this.reload
            }
        },
        data(){
            return{
                isRouterAlive:true
            }
        },
        methods: {
            reload() {
                this.isRouterAlive=false
                this.$nextTick(function(){
                    this.isRouterAlive=true
                })
            }
        }
    }
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
<style>
	.rightside{
		text-align:left;
		margin-left: 0.625rem;
	}
</style>
