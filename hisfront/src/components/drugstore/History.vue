<template>
	<div class="history">
		<hr>
		<h4><i class="el-icon-edit-outline"></i>交易记录</h4>
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
			<el-table :data="checkApply" class="checkApply">
				<el-table-column prop="fmeditems[0].itemName" label="项目名称"></el-table-column>
				<el-table-column prop="fmeditems[0].price" label="单价"></el-table-column>
				<el-table-column prop="fmeditems[0].recordType" label="类型"></el-table-column>
				<el-table-column prop="fmeditems[0].format" label="规格"></el-table-column>
				<el-table-column prop="num" label="数量"></el-table-column>
				<el-table-column prop="creationTime" label="开立时间"></el-table-column>
			</el-table>
		</el-form>
	</div>
</template>

<script>
	export default{
		name:'history',
		data(){
			return{
				caseNumber:'',
				realName:'',
				register:[],
				checkApply:[]
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
					let id = that.register[0].id
					that.$axios.get("http://localhost:8080/registerCq/selectCheckApply?id="+id).then(function(res){
						that.checkApply=res.data
						console.log(res.data)	
					})
					
				})
				}
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
	.history{
		text-align: left;
	}
</style>