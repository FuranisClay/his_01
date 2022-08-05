<template>
	<div>
		<div class="el-row">
			<div class="el-col el-col-3">
				<span class="el-tag el-tag--success el-tag--light">今日已看诊1人</span>
			</div>
			<div class="el-col el-col-3">
				<span class="el-tag el-tag--warning el-tag--light">当前有0人在排队</span>
			</div>
			<div class="el-col el-col-18"></div>
		 </div>
		 
		<div class="el-divider el-divider--horizontal"></div>
		
		<div style="font-size:20px;text-align:left">
			<i class="el-icon-document-checked">
				患者叫号
			</i>
		</div>
		
		
		
		
		
		<div class="el-divider el-divider--horizontal"></div>
		
		<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover"style="width:80%;">
			<div class="hidden-columns"></div>
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
			
			<div class="el-table__body-wrapper is-scrolling-left">
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width:1000px">
					<colgroup>
						<col name="el-table_1_column_1" width="80">
						<col name="el-table_1_column_2" width="180">
						<col name="el-table_1_column_3" width="370">
						<col name="el-table_1_column_4" width="370">
					</colgroup>
					<tbody>
					</tbody>
				</table>
				
				
			</div>
		</div>
		
		
		
		<div class="el-pagination" >
			<button type="button" disabled="disabled" class="btn-prev">
				<i class="el-icon el-icon-arrow-left">
				</i>
			</button>
			<ul class="el-pager">
				<li class="number active">1</li>
			</ul>
			<button type="button" disabled="disabled" class="btn-next">
				<i class="el-icon el-icon-arrow-right">
				</i>
			</button>
		</div>
		
	</div>

</template>

<script>
	export default{
		name:'register',
		data(){
			return{
				
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
					 console.log(res.data)					
				})
				}
		},
	}
</script>

<style>
</style>