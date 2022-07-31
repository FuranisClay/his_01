<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
	  <router-link to="/drugstore">Drugstore</router-link>
	
	<!-- <div class="drugstore" style="margin-top: 20px;">
	<el-container style="height: 600px; border: 0px solid">
	  <el-aside width="200px" style="background-color: rgb(238, 241, 246);border: 1px solid #eee">
	    <el-menu>
	      <el-submenu index="1">
	        <template slot="title"><i class="el-icon-s-claim"></i>药房管理</template>
	        <el-menu-item-group>
	          <el-menu-item index="1"><router-link to="/drugstore/give">药房发药</router-link></el-menu-item>
	          <el-menu-item index="2"><router-link to="/drugstore/out">药房退药</router-link></el-menu-item>
			  <el-menu-item index="3"><router-link to="/drugstore/drugs">药库管理</router-link></el-menu-item>
			  <el-menu-item index="4"><router-link to="/drugstore/history">交易记录</router-link></el-menu-item>
	        </el-menu-item-group>
	      </el-submenu>
	    </el-menu>
	  </el-aside>
	  <div class="rightside" style="margin-left:;width: 100%;">
		  
	  </div>
	  </el-container>
	</el-container>
	</div> -->
    </nav>
	<router-view/>
  </div>
</template>

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
