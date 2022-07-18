<template>
	<div>
		<el-container>
		  <el-header>Header</el-header>
		  <el-container>
		    <el-aside width="200px">Aside</el-aside>
		    <el-main>
				<el-row>
				  <el-col :span="6">aa<div class="grid-content bg-purple"></div></el-col>
				  <el-col :span="6">bb<div class="grid-content bg-purple-light"></div></el-col>
				  <el-col :span="6">cc<div class="grid-content bg-purple"></div></el-col>
				  <el-col :span="6">dd<div class="grid-content bg-purple-light"></div></el-col>
				</el-row>
				<el-button type="primary" icon="el-icon-search">搜索</el-button>
				
				<br />
				 <el-date-picker
				      v-model="dt"
				      type="datetime"
				      placeholder="选择日期时间"
					  value-format="yyyy-MM-ddd HH:mm:ss">
				</el-date-picker>
				<hr />
				你选择的时间为{{dt}}
				
			</el-main>
		  </el-container>
		  <el-footer>footer</el-footer>
		</el-container>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				dt:''
			}
		}
	}
</script>

<style>
	.el-header{
		background-color: aqua;
		line-height: 100px;
	}
	.el-aside{
		height: 500px;
		background-color: lightsalmon;
	}
	.el-footer{
		background-color: yellow;
		line-height: 100px;
	}
</style>