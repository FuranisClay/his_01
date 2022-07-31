<template>
	<div>
		<el-container>
		  <el-header style="text-align: right;">
			  <el-row>
				  <el-col span="3">
					  {{$store.state.user.realName}},欢迎登录
				  </el-col>
				  <el-col span="21">
					  <i class="el-icon-setting" style="margin-right: 15px"></i>
					  <router-link to="/">退出登录</router-link> 
				  </el-col>
			  </el-row> 
			  <router-view></router-view>
		  </el-header>
		  <el-container>
		    <el-aside width="200px">
				<el-menu router="true"  default-active="2" class="el-menu-vertical-demo" 
					background-color=" #545c64" text-color="#fff" active-text-color="#ffd04b">
					<!-- 循环遍历 -->
					<el-submenu v-for="sysmenu in sysMenuList" index="1">
					        <template slot="title">
					          <i class="el-icon-location"></i>
					          <span>{{sysmenu.menuName}}</span>
					        </template>
					        <el-menu-item-group>
					          <el-menu-item v-for="childmenu,index in sysmenu.childMenu" :index="childmenu.url">
								  {{childmenu.menuName}}
							  </el-menu-item>
					        </el-menu-item-group>
					</el-submenu>
				</el-menu>
			</el-aside>
		    <el-main>
			</el-main>
		  </el-container>
		</el-container>

	</div>
</template>

<script>
	export default {
		name: 'RegistrationView',
		data(){
			return{
				sysMenuList:[]
			}
		},
		created(){
			//根据登录用户的角色，获取该角色对应的权限列表
			let rid=this.$store.state.user.roleId
			let that=this
			this.$axios.get("http://localhost:8080/sysmenu/list?rid="+rid).then(function(res){
				console.log(res.data);
				that.sysMenuList=res.data
			})
		}
	}
</script>

<style>
	.el-table {
		margin: 0px auto;
	}
	.el-col{
		color: #fff;
	}
	.el-header {
		height: 700px;
		background-color: #545c64;
		line-height: 60px;
	}
	.el-aside {
		height: 1000px;
		background-color: #545c64;
	}
	a{
		text-decoration: none;
		color: #fff;
	}
</style>
