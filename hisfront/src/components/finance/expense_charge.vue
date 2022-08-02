<template>
	<div>
		<el-container>
			<el-aside width="180px"></el-aside>

			<el-main style="text-align: left;">
				<el-row>
					<label id="label01" class="el-icon-goods">窗口收费</label>
				</el-row>
				<el-divider></el-divider>
				<el-row>
					<label id="label02">患者信息查询</label>
				</el-row>
				
				<el-form :inline="true" :model="infoQuery" class="demo-form-inline">
				  <i class="el-icon-tickets"></i>
				  <el-form-item  label="病历号" >
				    <el-input v-model="infoQuery.id" placeholder="请输入病历号"></el-input>
				  </el-form-item>
				  <i class="el-icon-user"></i>
				  <el-form-item label="患者名" >
				    <el-input v-model="infoQuery.name" placeholder="请输入患者名"></el-input>
				  </el-form-item>
				  <el-form-item>
				    <el-button type="primary" @click="query()">查询</el-button>
				  </el-form-item>
				</el-form>
				<el-divider></el-divider>
				<el-row>
					<label id="label02">患者信息确认</label>
				</el-row>
				
				<el-form :inline="true" :model="patientInfo" class="demo-form-inline">
				  <i class="el-icon-user"></i>
				  <el-form-item  label="患者名" >
				    <el-input v-model="patientInfo.name" :disabled="true"></el-input>
				  </el-form-item>
				  <i class="el-icon-postcard"></i>
				  <el-form-item  label="身份证号" >
				    <el-input v-model="patientInfo.id" :disabled="true"></el-input>
				  </el-form-item>
				  <i class="el-icon-date"></i>
				  <el-form-item  label="年龄" >
				    <el-input v-model="patientInfo.age" :disabled="true"></el-input>
				  </el-form-item>
				  <i class="el-icon-male"></i>
				  <el-form-item  label="性别" >
				    <el-input v-model="patientInfo.sex" :disabled="true"></el-input>
				  </el-form-item>
				</el-form>
				<el-row>
					<el-button type="primary" :disabled="true" class="el-icon-price-tag">项目金额： {{price}}元</el-button>
					<el-button type="primary" @click="charge()" class="el-icon-price-tag">收费结算</el-button>
				</el-row>
				<el-table
				    :data="tableData"
				    border
				    style="width: 100%">
				    <el-table-column
				      prop="name"
				      label="项目名称"
				      width="400">
				    </el-table-column>
				    <el-table-column
				      prop="price"
				      label="单价"
				      width="100">
				    </el-table-column>
				    <el-table-column
				      prop="type"
				      label="类型"
					  width="100">
				    </el-table-column>
					<el-table-column
					  prop="format"
					  label="规格"
					  width="100">
					</el-table-column>
					<el-table-column
					  prop="quantity"
					  label="数量"
					  width="200">
					</el-table-column>
					<el-table-column
					  prop="date"
					  label="开立时间"
					  width="200">
					</el-table-column>
				  </el-table>
			</el-main>
		</el-container>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				infoQuery:{
					id: '',
					name: '',
				},
				patientInfo:{
					name: '大壮',
					id: '1111111111111111',
					age: '28',
					sex: '男'
				},
				price: '0',    //如何计算？
				tableData: [{
					name: '1',
					price: '2',
					type: '3',
					format: '4',
					quantity: '5',
					date: '6',
					
				}],
				

				
			}
		},
		
		methods: {
			query(){
				
			},
			charge() {
				
			}
		}
	}
</script>
<style>
	.el-table {
		margin: 0px auto;
	}
	#label01{
		font-size: 25px;
		font-weight: lighter;
	}
	#label02{
		font-size: 20px;
		font-weight: bold;
	}
	
	
</style>
