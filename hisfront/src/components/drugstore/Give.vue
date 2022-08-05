<template>
	<div class="give">
		<hr>
		<h4><i class="el-icon-edit-outline"></i>发药</h4>
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
			<el-table :data="drugslist" class="drugsTable">
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
				that.$axios.get("http://localhost:8080/registerCq/selectRegister?realName="+realName+"&caseNumber="+caseNumber).then(function(res){
					that.register=res.data
					// console.log(res.data[0].id)
					for(let i=0;i<that.register.length;i++){
						let id = that.register[0].id
						that.$axios.get("http://localhost:8080/registerCq/selectDrugs?id="+id).then(function(res){
							let list = res.data
							that.$axios.get("http://localhost:8080/registerCq/selectAmount?id="+id).then(function(res){
								that.amount=res.data
								for(let j=0;j<list.length;j++){
									list[j].amount=that.amount[j]
								}
							})
							that.drugslist=list
						})
					}
				})
				}
		},
	}
</script>

<style>
	.give .el-form{
		text-align: left;
		/* position: relative; */
	}
	.give .el-input{
		width: 20%;
		margin-right: 20px;
	}
	#search{
		width: 60%;
		/* position: absolute; */
		/* margin-left: 100px; */
	}
	.give{
		text-align: left;
	}
</style>