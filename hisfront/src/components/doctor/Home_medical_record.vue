<template>
	<div class="give">
		
		
		<div style="font-size:20px;text-align:left">
			<i class="el-icon-document-checked">
				看诊记录
			</i>
		</div>
		<h2></h2>
		<hr>
		<el-form>
			<el-input v-model="caseNumber" placeholder="请输入病历号"></el-input>
			<el-button @click="submit" id="search" style="width: 15%;margin-right: 20px;">搜索</el-button>			
		</el-form>
		<hr>
		<el-form>
			<el-table :data="medicalrecord" class="medicalrecord">
				<el-table-column prop="caseNumber" label="病历号"></el-table-column>
				<el-table-column prop="registId" label="挂号序列"></el-table-column>
				<el-table-column prop="readme" label="主诉"></el-table-column>
				<el-table-column prop="present" label="现病史"></el-table-column>
				<el-table-column prop="presentTreat" label="现病治疗情况"></el-table-column>
				<el-table-column prop="history" label="既往史"></el-table-column>
				<el-table-column prop="allergy" label="过敏史"></el-table-column>
				<el-table-column prop="physique" label="体格检查"></el-table-column>
				<el-table-column prop="proposal" label="检查建议"></el-table-column>
			</el-table>
		</el-form>
	</div>
</template>

<script>
	export default{
		name:'medicalrecord',
		data(){
			return{
				medicalrecord:[],
				caseNumber:'',

			}
		},
		methods:{
			fun(){
				
			},
			submit(){
				let that = this
				let caseNumber=this.caseNumber
				that.$axios.get("http://localhost:8080/medicalrecord/list?casenum="+caseNumber).then(function(res){					 
					that.medicalrecord=res.data			
					console.log(res.data)					
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