<template>
	<div>
		<el-container>
			<el-aside width="180px"></el-aside>

			<el-main style="text-align: left;">
				<el-row>
					<label id="label01" class="el-icon-goods">窗口退费</label>
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
				
				<el-form :inline="true"  >
				  <i class="el-icon-user"></i>
				  <el-form-item  label="患者名" >
				    <el-input v-model="patientInfo.name" :disabled="true"></el-input>
				  </el-form-item>
				  <i class="el-icon-postcard"></i>
				  <el-form-item  label="身份证号" >
				    <el-input v-model="patientInfo.id" :disabled="true"></el-input>
				  </el-form-item>
				</el-form>
				<el-form :inline="true">
				  <i class="el-icon-date"></i>
				  <el-form-item  label="年龄" >
				    <el-input v-model="patientInfo.age" :disabled="true"></el-input>
				  </el-form-item>
				  <i class="el-icon-male"></i>
				  <el-form-item  label="性别" >
				    <el-input v-model="patientInfo.sex" :disabled="true"></el-input>
				  </el-form-item>
				  <el-form-item>
					  <el-button @click="queryCost()" type="primary">确认</el-button>
				  </el-form-item>
				</el-form>
				<el-row>
					<el-button type="primary" :disabled="true" class="el-icon-price-tag">项目金额： {{totalPrice}}元</el-button>
					<el-button type="primary" @click="open()" class="el-icon-price-tag">收费结算</el-button>
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
				      prop="itemType"
				      label="类型"
					  width="100">
				    </el-table-column>
					<el-table-column
					  prop="format"
					  label="规格"
					  width="100">
					</el-table-column>
					<el-table-column
					  prop="amount"
					  label="数量"
					  width="200">
					</el-table-column>
					<el-table-column
					  prop="createtime"
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
					name: '',
					id: '',
					age: '',
					sex: '',
					registerid: '',
				},
				price: '0',   
				tableData: [],
			}
		},
		
		computed:{
		            totalPrice(){
						// if(this.tableData==null){
						// 	return 0;
						// }
						return this.sum();
		            }
		        },
		
		methods: {
			query(){
				//this.patientInfo=[];
				let id = this.infoQuery.id;
				let name=this.infoQuery.name;
				let that=this;
				if(id!=null&&name!=null){
					var str="caseNumber="+id+"&"+"name="+name;
				}else if(id!=null){
					var str="id="+id;
				}else{
					var str="name="+name;
				}
				

				that.$axios.get("http://localhost:8080/charge/selectByCaseNumberAndName?caseNumber="+id).then(function(res){
					//console.log(res.data);
					that.patientInfo.name=res.data[0].realName;
					that.patientInfo.age=res.data[0].age;
					that.patientInfo.sex=res.data[0].gender;
					that.patientInfo.id=res.data[0].idnumber;
					that.patientInfo.registerid=res.data[0].registerId;
				});
			},
			queryCost(){
				let registerid=this.patientInfo.registerid;
				let that=this;
				that.$axios.get("http://localhost:8080/charge/selectByRegisterid?registerid="+registerid).then(function(res){
					that.tableData=res.data;
					for(var i in that.tableData){
						//console.log(that.tableData[i].itemType);
						if(that.tableData[i].itemType==1){
							that.tableData[i].itemType="非药品";
							console.log(that.tableData[i].itemType);
						}
						else{
							that.tableData[i].itemType="药品";
						}
					}
				});
			},
			sum(){
				let sum=0;
				for(var i in this.tableData){
					//console.log(this.tableData[i]);
					sum+=parseFloat(this.tableData[i].price)*parseInt(this.tableData[i].amount);
					//sum+=it.price*it.amount;
				}
				return sum;
			},
			open() {
					
					var str="本次退费金额为"+this.sum()+"元";
			        this.$confirm(str, '退费窗口', {
			          confirmButtonText: '确定',
			          cancelButtonText: '取消',
			          type: 'warning'
			        }).then(() => {
			          this.$message({
			            type: 'success',
			            message: '退费成功!'
			          });
			        }).catch(() => {
			          this.$message({
			            type: 'info',
			            message: '取消退费'
			          });          
			        });
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
