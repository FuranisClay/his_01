<template>
	<div class="give">
		<hr>
		<h4><i class="el-icon-edit-outline"></i>配药</h4>
		<hr>
		<el-form>
			<el-input v-model="caseNumber" placeholder="请输入病历号"></el-input>
			<el-input v-model="realName" placeholder="请输入患者姓名"></el-input>
			<el-button @click="submit" id="search" style="width: 15%;margin-right: 20px;">搜索</el-button>
			<el-table :data="register" class="register">
				<el-table-column prop="id" label="患者id"></el-table-column>
				<el-table-column prop="caseNumber" label="病历号"></el-table-column>
				<el-table-column prop="realName" label="姓名"></el-table-column>
				<el-table-column prop="genderName" label="性别"></el-table-column>
				<el-table-column prop="age" label="患者年龄"></el-table-column>
			</el-table>
		</el-form>
		<hr>
		<div class="drugs">
			<el-form>
				<el-input v-model="drugsId" placeholder="请输入药品id" style="width: 20%;margin-right: 20px;"></el-input>
				<el-input v-model="drugsName" placeholder="请输入药品名称" style="width: 20%;margin-right: 20px;"></el-input>
				<el-button @click="submit1" id="search" style="width: 15%;margin-right: 20px;">搜索</el-button>
			</el-form>
			<!-- <hr> -->
			<hr>
			<el-table :data="drugslist1" class="drugsTable" @selection-change="hsc">
				<el-table-column prop="id" label="药品id"></el-table-column>
				<el-table-column prop="drugsCode" label="药品编码"></el-table-column>
				<el-table-column prop="drugsName" label="药品名称"></el-table-column>
				<el-table-column prop="drugsFormat" label="药品规格"></el-table-column>
				<el-table-column prop="manufacturer" label="生产厂商"></el-table-column>
				<el-table-column prop="drugsPrice" label="药品单价"></el-table-column>
				<el-table-column>
					<template slot-scope="scope">
					        <el-button icon="el-icon-plus" @click="insertDru(scope.row)"></el-button>
					</template>
				</el-table-column>
			</el-table>
			<!-- 分页 -->
			<el-pagination
			  background
			  :page-size="pageSize"
			  layout="prev, pager, next"
			  :total="drugslist.length"
			  @current-change="dopaging"
			  >
			</el-pagination>
		</div>
		<hr>
		<h4><i class="el-icon-edit-outline"></i>已配药品：</h4>
			<el-form>
				<el-table :data="drugslist3" class="drugsTable">
					<el-table-column prop="drugsCode" label="药品编码"></el-table-column>
					<el-table-column prop="drugsName" label="药品名称"></el-table-column>
					<el-table-column prop="drugsFormat" label="药品规格"></el-table-column>
					<el-table-column prop="drugsUnit" label="包装规格"></el-table-column>
					<el-table-column prop="manufacturer" label="生产厂商"></el-table-column>
					<el-table-column prop="drugsPrice" label="药品单价"></el-table-column>
					<el-table-column prop="amount" label="药品数量"></el-table-column>	
				</el-table>
			</el-form>
		<hr>
		<!-- <el-button  @click="setDrugs()">配药</el-button> -->
		<el-dialog
		  title="加入药品"
		  :visible.sync="dialogVisible"
		    width="40%"
		    :before-close="handleClose">
		    <el-form label-width="100px">
		  	  <el-form-item label="id">
		  		  <el-input :disabled=true v-model="Pre.id" id="updateInput1"></el-input>
		  	  </el-form-item>
			  <el-form-item label="成药处方id">
			  		  		  <el-input :disabled=true v-model="Pre.prescriptionId" id="updateInput1"></el-input>
			  </el-form-item>
			  <el-form-item label="药品id">
			  		  		  <el-input :disabled=true v-model="Pre.drugsId" id="updateInput1"></el-input>
			  </el-form-item>
			  <el-form-item label="用法">
			  		  		  <el-input  v-model="Pre.drugsUsage" id="updateInput1"></el-input>
			  </el-form-item>
			  <el-form-item label="用量">
			  		  		  <el-input  v-model="Pre.dosage" id="updateInput1"></el-input>
			  </el-form-item>
			  <el-form-item label="频次">
			  		  		  <el-input  v-model="Pre.frequency" id="updateInput1"></el-input>
			  </el-form-item>
			  <el-form-item label="数量">
			  		  		  <el-input  v-model="Pre.amount" id="updateInput1"></el-input>
			  </el-form-item>
			  <el-form-item label="状态">
			  		  		  <el-input :disabled=true v-model="Pre.stateName" id="updateInput1"></el-input>
			  </el-form-item>
			  <el-form-item>
			  			  <el-button @click="submitDru">提交</el-button>
							<el-button @click="dialogVisible = false">取消</el-button>
			  </el-form-item>
		    </el-form>
		  </el-dialog>
	</div>
</template>

<script>
	export default{
		name:'register',
		data(){
			return{
				register:[],
				caseNumber:'',
				realName:'',
				Preid:[],
				state:2,
				record:1,
				checkApply:[],
				drugslist:[],
				drugslist1:[],
				deletelist:[],
				drugslist2:[],
				drugslist3:[],
				drugslist4:[],
				drugsId:0,
				drugsName:'',
				insertRow:{},
				pageSize:4,
				currPage:1,
				num:1,
				Pre:{},
				dialogVisible:false,
				Preid:[],
				PatientCosts:{},
				// checkApply1:{}
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
							for(let i=0;i<list.length;i++){
								that.$axios.get("http://localhost:8080/registerCq/selectAmount?registerId="+id+"&drugsId="+list[i].id).then(function(res){
									list[i].amount=res.data[0]
								})
							}
							that.drugslist3=list
							that.$axios.get("http://localhost:8080/registerCq/getPreId?id="+id).then(function(res){
								that.Preid=res.data
								
							})
							
						})
					}
				})
				},
				handleClose(done) {
				        this.$confirm('确认关闭？')
				          .then(_ => {
				            done();
				          })
				          .catch(_ => {});
				},
				//查询药品
				submit1(){
					let drugsName=this.drugsName
					let drugsId=this.drugsId
					let that = this
					this.$axios.get("http://localhost:8080/drugsCq/list?drugsName="+drugsName+"&id="+drugsId).then(function(res){
						that.drugslist=res.data
						that.drugslist1=that.drugslist.slice(0,4)
					})
				},
				
				// 批量选择
				hsc(arr){
					this.drugslist4=arr
					// console.log(this.drugslist4)
				},
				addDrugs(){
					this.drugslist3=this.add(this.drugslist3,this.drugslist4)
					// console.log(this.drugslist3)
				},	
				add(arr1,arr2){
					for(let i=0;i<arr2.length;i++){
						if(arr1.indexOf(arr2[i])==-1){
							arr1.push(arr2[i])
						}
					}
					return arr1
				},
				//分页操作
				dopaging(currPage){
					this.currPage=currPage
					let start=(currPage-1)*this.pageSize
					let end=currPage*this.pageSize
					this.drugslist1=this.drugslist.slice(start,end)
					
				},
				changeVal() {
				      this.$forceUpdate();
				    },
				
			    handleChange(value) {
					console.log(value);
					console.log(this.num)
			    },
				setDrugs(){
					for(let i=0;i<this.drugslist3.length;i++){
						
					}
				},
				insertDru(row){
					// console.log(row)
					
					this.dialogVisible=true
					let that = this
					that.Pre.drugsId=row.id
					that.Pre.state=2
					that.Pre.stateName="已开立"
					let realName=this.realName
					let caseNumber=this.caseNumber
					that.$axios.get("http://localhost:8080/registerCq/selectRegister?realName="+realName+"&caseNumber="+caseNumber).then(function(res){
						that.register=res.data
						// console.log(res.data)
						that.$axios.get("http://localhost:8080/registerCq/selectAllP").then(function(res){
							that.Pre.id=res.data[res.data.length-1].id+1
							that.$axios.get("http://localhost:8080/registerCq/selectPByRId?id="+that.register[0].id).then(function(res){
								console.log(res.data)
								that.Pre.prescriptionId=res.data[res.data.length-1].id
								
								that.$axios.get("http://localhost:8080/registerCq/getPreId?id="+that.register[0].id).then(function(res){
									that.Preid=res.data
									for(let i=0;i<that.Preid.length;i++){
										that.$axios.get("http://localhost:8080/registerCq/setState?id="+that.Preid[i]+"&state="+that.state).then(function(res){
											if(res.data!=1){
												that.record=0
											}
											// console.log(res.data)
												that.PatientCosts.registId=that.register[0].id
												that.PatientCosts.invoiceId=56
												that.$axios.get("http://localhost:8080/drugsCq/list?id="+row.id).then(function(res){
													// console.log(res.data)
													that.PatientCosts.itemId=res.data[0].id
													that.PatientCosts.itemType=2
													that.PatientCosts.name=res.data[0].drugsName
													that.PatientCosts.price=res.data[0].drugsPrice
												})
										})
									}
									// console.log(that.Preid)
								})
								
							})
						})
					})
					
				},
				submitDru(){
					let that=this
					that.PatientCosts.amount=that.Pre.amount
					that.PatientCosts.deptId=1
					that.PatientCosts.createtime=that.getTime()
					that.PatientCosts.createOperId=that.$store.state.emp.id
					that.PatientCosts.payTime=that.getTime()
					that.PatientCosts.registerId=that.$store.state.emp.id
					that.PatientCosts.feeType=51
					
					// console.log(this.Pre)
					// console.log(this.checkApply1)
					// console.log(this.PatientCosts)
					let ue = this.$qs.stringify(this.Pre)
					
					let ue2 = this.$qs.stringify(this.PatientCosts)
					// console.log(">>>>>>>>>>>>>"+this.Pre.prescriptionId)
					if(this.Pre.prescriptionId==undefined){
						// console.log("不允许")
						this.open()
					}else{
						this.$axios.get("http://localhost:8080/registerCq/insertPre?"+ue).then(function(res){
							
								that.$axios.get("http://localhost:8080/registerCq/insertPatientcosts?"+ue2).then(function(res){
									
								})

						})
						this.dialogVisible=false
					}
				},
				getTime() {
				      var dateee = new Date().toJSON();
				      
					  return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '') 
				    },
				enderTime(date) {
				  var dateee = new Date(date).toJSON();
				  return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '') 
				},
				open() {
				        this.$alert('请先开处方或选择患者!', '系统提示', {
				          confirmButtonText: '确定',
				          // callback: action => {
				          //   this.$message({
				          //     type: 'info',
				          //     // message: `action: ${ action }`
				          //   });
				          // }
				        });
				      }
			},
		created() {
			let that=this;
			that.$axios.get("http://localhost:8080/drugsCq/list?id=0").then(function(res){
				console.log(res)
				that.drugslist=res.data
				that.drugslist1=that.drugslist.slice(0,4)
			})
			that.$axios.get("http://localhost:8080/drugsCq/getConstantItem").then(function(res){
				that.options1=res.data
				// console.log(that.options1)
			})
		}
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
<style>
	.drugs .el-form{
		text-align: left;
		/* height: 50px; */
		/* position: relative; */
	}
	.drugs .el-form-item{
		height: 50px;
	}
	.drugs .el-input{
		width: 100%;
	}
	#search{
		width: 60%;
		/* position: absolute; */
		/* margin-left: 100px; */
	}
	.el-input{
		width: 100%;
	}
	.drugs{
		text-align: left;
	}
	#updateInput1{
		width: 400%;
	}
</style>
