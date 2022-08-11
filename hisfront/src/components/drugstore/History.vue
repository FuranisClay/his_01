<template>
	<div class="give">
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
				<el-table-column prop="genderName" label="性别"></el-table-column>
				<el-table-column prop="age" label="患者年龄"></el-table-column>
			</el-table>
		</el-form>
		<hr>
		<el-form>
			<el-table :data="drugslist" class="drugsTable" >
				
				<el-table-column prop="drugsCode" label="药品编码"></el-table-column>
				<el-table-column prop="drugsName" label="药品名称"></el-table-column>
				<el-table-column prop="drugsFormat" label="药品规格"></el-table-column>
				<el-table-column prop="drugsUnit" label="包装规格"></el-table-column>
				<el-table-column prop="drugsPrice" label="药品单价"></el-table-column>
				<el-table-column prop="amount" label="药品数量"></el-table-column>
				<el-table-column prop="re" label="操作"></el-table-column>
				<el-table-column prop="resultTime" label="操作时间"></el-table-column>
			</el-table>
		</el-form>
		<hr>
		<h4>总计费用:{{money}}</h4>
		<!-- <el-button  @click="giveDrugs()">刷新</el-button> -->
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
				state:'',
				record:1,
				checkApply:[],
				dc:[],
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
					let registId = that.register[0].id
					
					// console.log(res.data[0].id)  老师，对于这些其实是基本数据获取，时间和操作在下面的方法上
					for(let i=0;i<that.register.length;i++){
						let id = that.register[i].id
						console.log("999999"+id)
						that.$axios.get("http://localhost:8080/registerCq/selectDrugs?id="+id).then(function(res){
							let list = res.data
							for(let i=0;i<list.length;i++){
								that.$axios.get("http://localhost:8080/registerCq/selectAmount?registerId="+id+"&drugsId="+list[i].id).then(function(res){
									list[i].amount=res.data[0]
								})
							}
							that.drugslist=list
							
							// that.setDrugs(id)
						})
						
					}
					that.giveDrugs()   //刷新
				})
				},
			giveDrugs(){
				let that=this
				let realName=this.realName
				let caseNumber=this.caseNumber
				that.$axios.get("http://localhost:8080/registerCq/selectRegister?realName="+realName+"&caseNumber="+caseNumber).then(function(res){
					that.register=res.data
					// console.log(res.data[0].id)
					let registId = that.register[0].id
					that.$axios.get("http://localhost:8080/registerCq/selectCheckApply?id="+registId).then(function(res){
						that.checkApply=res.data
						that.drugslist.resultTime=that.checkApply[0].resultTime
						that.getMoney()
						
						that.$axios.get("http://localhost:8080/registerCq/selectPreById?id="+registId).then(function(res){
							console.log(res)	
							that.state=res.data[0].state
							console.log(that.state)
							// console.log(that.state)
							if(that.state==4){
								that.drugslist.re="已发药"
							}
							else if(that.state==5){
								that.drugslist.re="已退药"
							}
							else if(that.state==3){
								that.drugslist.re="已缴费"
							}else if(that.state==6){
								that.drugslist.re="已退费"
							}
							else{
								that.drugslist.re="已开立"
							}
						
							for(let i=0;i<that.drugslist.length;i++){
								console.log(that.drugslist)
								that.$set(that.drugslist[i],"re",that.drugslist.re)
							    //that.drugslist[i].re=that.drugslist.re
							    // that.drugslist[i].resultTime=that.drugslist.resultTime
								that.$set(that.drugslist[i],"resultTime",that.drugslist.resultTime)
							}
							
						})
						
						// that.updated()
						// console.log(that.drugslist)
						
					})
					 // console.log(that.drugslist)
					 
				});
				
			},
			getTime() {
			      var dateee = new Date().toJSON();
			      
				  return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '') 
			    },
			enderTime(date) {
			  var dateee = new Date(date).toJSON();
			  return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '') 
			},
			getMoney(){
				this.money=0
				for(let i=0;i<this.drugslist.length;i++){
					this.money+=this.drugslist[i].drugsPrice*this.drugslist[i].amount
				}
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
	.give .el-table .cell {
		overflow: auto;
	}
</style>