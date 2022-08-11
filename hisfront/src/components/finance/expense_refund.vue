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
					  <el-button @click="queryCost();queryLev()" type="primary">确认</el-button>
				  </el-form-item>
				</el-form>
				<el-row>
					<el-button type="primary" :disabled="true" class="el-icon-price-tag">项目金额： {{totalPrice}}元</el-button>
					<el-button type="primary" @click="open()" class="el-icon-price-tag">退费结算</el-button>
				</el-row>
				<el-table
				    :data="newTableDate"
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
					  width="200"
					  >
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
					registerLeID: '',
				},
				registerLevel: [],
				registerFee: 0,
				price: '0',   
				tableData: [],
				newTableDate: [{
					amount:'',
					backId:'',
					createOperId:'',
					createtime:'',
					deptId:'',
					feeType:'',
					id:'',
					invoiceId:'',
					itemId:'',
					itemType:'',
					name:'',
					payTime:'',
					price:'',
					registId:'',
					registerId:'',
				}],
				
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
				// console.log(id);
				// console.log(name);
				if(id!=''&&name!=''){
					var str="caseNumber="+id+"&"+"realname="+name;
				}else if(id!=''){
					var str="caseNumber="+id;
				}else if(name!=''){
					var str="realname="+name;
				}
				// if(id!=''){
				// 	var str="caseNumber="+id;
				// }
				// console.log(str);
				that.$axios.get("http://localhost:8080/charge/selectByCaseNumberAndName?"+str).then(function(res){
					//console.log(res.data);
					that.patientInfo.name=res.data[0].realName;
					that.patientInfo.age=res.data[0].age;
					that.patientInfo.sex=res.data[0].gender;
					//console.log(res.data[0].gender);
					that.patientInfo.id=res.data[0].idnumber;
					that.patientInfo.registerid=res.data[0].id;
					that.patientInfo.registerLeID=res.data[0].registLeId;
				});
			},
			queryCost(){
				let id=this.patientInfo.registerid;
				let that=this;
				that.$axios.get("http://localhost:8080/charge/selectById?id="+id).then(function(res){
					that.tableData=res.data;
					for(var i in that.tableData){
						//console.log(that.tableData[i].itemType);
						if(that.tableData[i].itemType==1){
							that.tableData[i].itemType="非药品";
							//console.log(that.tableData[i].itemType);
						}
						else{
							that.tableData[i].itemType="药品";
						}
					}
					
					//将tableData的数据amount处理后放入newtable
					var oldTable=that.tableData;
					var newTable=that.newTableDate; 
					//var count=0;
					for(var i in oldTable){
						var name=oldTable[i].name;
						var amount=oldTable[i].amount;
						//搜索newTable是否有相同名称的数据项
						var j=0;
						var flag=false;//无相同名称数据项
						for( j in newTable){
							if(name===newTable[j].name){
								flag=true;//有相同姓名项
								newTable[j].amount+=amount;
								//停止搜索
								break;
							}
						}
						//如果无相同名称项，向newTable数组添加
						if(flag==false){
							//这里是将newTable指向oldTable原来的地址,导致oldTable 的数据将不可用
							//newTable[count]=oldTable[i];
							// newTable.length+=1;
							// newTable[count].amount=oldTable[i].amount;
							// newTable[count].backId=oldTable[i].backId;
							// newTable[count].createOperId=oldTable[i].createOperId;
							// newTable[count].createtime=oldTable[i].createtime;
							// newTable[count].deptId=oldTable[i].deptId;
							// newTable[count].feeType=oldTable[i].feeType;
							// newTable[count].id=oldTable[i].id;
							// newTable[count].invoiceId=oldTable[i].invoiceId;
							// newTable[count].itemType=oldTable[i].itemType;
							// newTable[count].name=oldTable[i].name;
							// newTable[count].payTime=oldTable[i].payTime;
							// newTable[count].price=oldTable[i].price;
							// newTable[count].registId=oldTable[i].registId;
							// newTable[count].registerId=oldTable[i].registerId;
							let target=Object.assign({},oldTable[i] );
							//console.log(target);
							newTable.push(target);
						}
					}
					for(var n in newTable){
						if(newTable[n].amount==0){
							delete newTable[n];
						}
					}
				});
			},
			queryLev(){
				//获取registerLevel表
				let that=this;
				that.$axios.get("http://localhost:8080/register/list").then(function(res){
					that.registerLevel=res.data;
				});
			},
			sum(){
				let sum=0;
				for(var i in this.tableData){
					//console.log(this.tableData[i]);
					sum+=parseFloat(this.tableData[i].price)*parseInt(this.tableData[i].amount);
					//sum+=it.price*it.amount;
				}
				let id=this.patientInfo.registerLeID;
				for( var it in this.registerLevel){
					if(id==this.registerLevel[it].id){
						this.registerFee=this.registerLevel[it].registFee;
						//sum+=this.registerFee;   //不再单独添加挂号费
						break;
					}
				}
				return sum;
			},
			open() {
					var str="本次收费金额为"+this.sum()+"元"+"(其中包含挂号费"+this.registerFee+"元)";
			        this.$confirm(str, '收费窗口', {
			          confirmButtonText: '确定',
			          cancelButtonText: '取消',
			          type: 'warning'
			        }).then(() => {
			          this.$message({
			            type: 'success',
			            message: '缴费成功!'
			          });
			        }).catch(() => {
			          this.$message({
			            type: 'info',
			            message: '取消收费'
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
