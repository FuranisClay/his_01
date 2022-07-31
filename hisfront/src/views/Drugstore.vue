<template>
	<div class="drugstore">
	<el-container style="height: 600px; border: 1px solid #eee">
	  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
	    <el-menu>
	      <el-submenu index="1">
	        <template slot="title"><i class="el-icon-s-claim"></i>药房管理</template>
	        <el-menu-item-group>
	          <el-menu-item index="1"><router-link to="/drugstore/give" style="">药房发药</router-link></el-menu-item>
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
	</div>
</template>

<script>
</script>

<style>
	.rightside{
		text-align:left;
	}
	a{
	  text-decoration: none;
	  color: black;
	}
</style>

