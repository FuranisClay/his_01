<template>
	<div class="login">
		<el-form label-width="80px">
			<el-form-item label="账号">
				<el-input v-model="ename"></el-input>
			</el-form-item>
			<el-form-item label="确认密码">
				<el-input type="password" v-model="pwd"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button  @click="submit">登录</el-button>
				<el-button @click="resetForm('ruleForm')">取消</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script>
	export default{
		data(){
			return{
				ename:'',
				pwd:'',
			}
		},
		methods:{
			submit(){
				let en=this.ename
				let pw=this.pwd	
				let that=this
				this.$axios.get("http://localhost:8080/User/validate?rn="+en+"&pw="+pw).then(function(res){
					console.log(res.data)
					if(res.data==null || res.data==''){
						that.$message.error('登录失败');
					}else{
						// 登录成功  将登录的员工信息储存到Vuex中
						console.log(res.data);
						that.$store.commit('user',res.data)
						that.$router.push("/registrationview")
					}
				})
			}
		}
	}
</script>

<style>
	.login{
		width: 300px;
		margin: 150px auto;
	}
</style>