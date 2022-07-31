<template>
	<div class="out">
		<hr>
		<h4><i class="el-icon-edit-outline"></i>退药</h4>
		<hr>
		<el-form>
			<el-input v-model="caseNumber" placeholder="请输入病历号"></el-input>
			<el-input v-model="realName" placeholder="请输入患者姓名"></el-input>
			<el-button @click="submit" id="search" style="width: 15%;margin-right: 20px;">搜索</el-button>
			<el-table :data="register" class="register">
				<el-table-column prop="id" label="患者id"></el-table-column>
				<el-table-column prop="caseNumber" label="病历号"></el-table-column>
				<el-table-column prop="realName" label="姓名"></el-table-column>
				<el-table-column prop="gender" label="性别"></el-table-column>
				<el-table-column prop="age" label="患者年龄"></el-table-column>
			</el-table>
		</el-form>
		<hr>
		<el-form>
			<el-table :data="drugslist,amount" class="drugsTable">
				<el-table-column prop="drugsCode" label="药品编码"></el-table-column>
				<el-table-column prop="drugsName" label="药品名称"></el-table-column>
				<el-table-column prop="drugsFormat" label="药品规格"></el-table-column>
				<el-table-column prop="drugsUnit" label="包装规格"></el-table-column>
				<el-table-column prop="manufacturer" label="生产厂商"></el-table-column>
				<el-table-column prop="drugsPrice" label="药品单价"></el-table-column>
				<el-table-column prop="amount" label="药品数量"></el-table-column>
			</el-table>
		</el-form>
	</div>
</template>

<script>
	export default{
		name:'register',
		data(){
			return{
				drugslist:[],
				amount:[],
				register:[],
				caseNumber:'',
				realName:''
			}
		},
		methods:{
			fun(){
				
			},
			submit(){
				let that = this
				let realName=this.realName
				let caseNumber=this.caseNumber
				that.$axios.get("http://localhost:8080/register/selectRegister?realName="+realName+"&caseNumber="+caseNumber).then(function(res){
					that.register=res.data
					// console.log(res.data[0].id)
					for(let i=0;i<that.register.length;i++){
						let id = that.register[0].id
						that.$axios.get("http://localhost:8080/register/selectDrugs?id="+id).then(function(res){
							let list = res.data
							that.$axios.get("http://localhost:8080/register/selectAmount?id="+id).then(function(res){
								that.amount=res.data
								for(let j=0;j<list.length;j++){
									list[j].amount=that.amount[j]
								}
							})
							that.drugslist=list
						})
					}
				})
			},
		},
	}
</script>

<style>
	.el-form{
		text-align: left;
		/* position: relative; */
	}
	.el-input{
		width: 20%;
		margin-right: 20px;
	}
	#search{
		width: 60%;
		/* position: absolute; */
		/* margin-left: 100px; */
	}
	.out{
		text-align: left;
	}
</style>