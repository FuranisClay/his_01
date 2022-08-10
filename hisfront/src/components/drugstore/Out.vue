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
				<el-table-column prop="genderName" label="性别"></el-table-column>
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
		<hr>
		<h4>总计费用:{{money}}</h4>
		<el-button  @click="giveDrugs()">退药</el-button>
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
				realName:'',
				Preid:[],
				state:5,
				record:1,
				checkApply:[],
				money:0
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
								for(let i=0;i<list.length;i++){
									that.$axios.get("http://localhost:8080/registerCq/selectAmount?registerId="+id+"&drugsId="+list[i].id).then(function(res){
										list[i].amount=res.data[0]
										that.getMoney()
									})
								}
								// console.log(that.getTime())
								that.drugslist=list
								
								// console.log(that.drugslist)
							})
							// that.setDrugs(id)
						})
					}
					
				})
				},
			giveDrugs(){
				let that=this
				let realName=this.realName
				let caseNumber=this.caseNumber
				this.$confirm('此操作将进行退药', {
				  confirmButtonText: '确定',
				  cancelButtonText: '取消',
				  type: 'warning'
				}).then(() => {
					that.$axios.get("http://localhost:8080/registerCq/selectRegister?realName="+realName+"&caseNumber="+caseNumber).then(function(res){
						that.register=res.data
						// console.log(res.data[0].id)
						let registId = that.register[0].id
						that.$axios.get("http://localhost:8080/registerCq/selectCheckApply?id="+registId).then(function(res){
							that.checkApply=res.data
							// console.log(that.checkApply)
							for(let i=0;i<that.checkApply.length;i++){
								// console.log(that.checkApply[i])
								that.checkApply[i].id=that.checkApply[i].id
								that.checkApply[i].state=that.state
								that.checkApply[i].resultTime=that.getTime()
								that.checkApply[i].checkTime=that.enderTime(that.checkApply[i].checkTime)
								that.checkApply[i].creationTime=that.enderTime(that.checkApply[i].creationTime)
								// console.log(that.checkApply[i].id)
								// console.log(that.checkApply[i].resultTime)
								
								let ue = that.$qs.stringify(that.checkApply[i])
								// console.log(ue)
								that.$axios.get("http://localhost:8080/registerCq/updateCheck?"+ue).then(function(res){
									console.log(that.checkApply[i].id)
									if(res.data!=1){
										that.record=0
									}
								})
							}
						})
						that.$axios.get("http://localhost:8080/registerCq/getPreId?id="+registId).then(function(res){
							that.Preid=res.data
							for(let i=0;i<that.Preid.length;i++){
								that.$axios.get("http://localhost:8080/registerCq/setState?id="+that.Preid[i]+"&state="+that.state).then(function(res){
									if(res.data!=1){
										that.record=0
									}
								})
							}
							// console.log(that.Preid)
						})
						
						
					})
					if(that.record==1){
						this.$message({
											type: 'success',
											message: '退药成功!'
						});
					}else{
						this.$message({
											type: 'success',
											message: '退药失败!'
						});
					}
				}).catch(() => {
				  this.$message({
					type: 'info',
					message: '已取消退药'
				  });          
				});
			},
			getTime() {
			      var dateee = new Date().toJSON();
			      // var y = date.getFullYear()
			      // var m = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1)
			      // var d = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate())
			      // return y + '-' + m + '-' + d+''
				  return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '') 
			    },
			enderTime(date) {
			  var dateee = new Date(date).toJSON();
			  return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '') 
			},
			getMoney(){
				this.money=0
				// console.log(this.drugslist)
				// console.log(this.drugslist[0].amount)
				for(let i=0;i<this.drugslist.length;i++){
					this.money+=this.drugslist[i].drugsPrice*this.drugslist[i].amount
				}
			}
		},
	}
</script>

<style>
	.out .el-form{
		text-align: left;
		/* position: relative; */
	}
	.out .el-input{
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