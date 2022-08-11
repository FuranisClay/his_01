<template>
	<div class="give">
		<hr>
		<h4><i class="el-icon-edit-outline"></i>处方开设</h4>
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
		<el-input v-model="Medical.readme" placeholder="主诉" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Medical.present" placeholder="现病史" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Medical.presentTreat" placeholder="现病治疗情况" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Medical.history" placeholder="既往史" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Medical.allergy" placeholder="过敏史" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Medical.physique" placeholder="体格检查" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Medical.proposal" placeholder="检查建议" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Medical.careful" placeholder="注意事项" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Medical.checkResult" placeholder="检查结果" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Medical.diagnosis" placeholder="诊断结果" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Medical.handling" placeholder="处理意见" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<el-input v-model="Prescription.prescriptionName" placeholder="请输入处方名称" style="width: 100%;"></el-input>
		<hr style="color: aqua;" color="skyblue">
		<hr>
		<el-button  @click="setPre()">处方开设</el-button>
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
				Preid:'',
				state:4,
				record:1,
				checkApply:[],
				Prescription:{},
				Medical:{},
				checkApply1:{}
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
									// console.log(list[j].amount)
								}
								// console.log(that.getTime())
								that.drugslist=list
								console.log(that.drugslist)
							})
							that.$axios.get("http://localhost:8080/registerCq/getPreId?id="+id).then(function(res){
								that.Preid=res.data
								// console.log(res.data)
							})
							// that.setDrugs(id)
						})
					}
				})
				},
			setPre(){
				let that = this
				let realName=this.realName
				let caseNumber=this.caseNumber
				that.$axios.get("http://localhost:8080/registerCq/selectRegister?realName="+realName+"&caseNumber="+caseNumber).then(function(res){
					that.register=res.data
					that.Medical.caseNumber=that.register[0].caseNumber
					that.Medical.registId=that.register[0].id
					that.Medical.caseState=1
					that.$axios.get("http://localhost:8080/registerCq/selectAllM").then(function(res){
						that.Medical.id=res.data[res.data.length-1].id+1
						that.Prescription.medicalId=that.Medical.id
						that.Prescription.registId=that.register[0].id
						that.Prescription.userId=that.$store.state.emp.id
						that.Prescription.prescriptionTime=that.getTime()
						that.Prescription.prescriptionState=1
						let ue = that.$qs.stringify(that.Medical)
						let ue1 = that.$qs.stringify(that.Prescription)
						that.$axios.get("http://localhost:8080/registerCq/insertPr?"+ue1).then(function(res){
							that.$axios.get("http://localhost:8080/registerCq/selectM?id="+that.register[0].id).then(function(res){
								// console.log(res.data)
								that.checkApply1.medicalId=res.data[0].id
								that.checkApply1.registId=that.register[0].id
								that.checkApply1.itemId=3
								that.checkApply1.name="检测"
								that.checkApply1.creationTime=that.getTime()
								that.checkApply1.checkOperId=that.$store.state.emp.id
								that.checkApply1.resultOperId=that.$store.state.emp.id
								that.checkApply1.recordType=1
								that.checkApply1.resultTime=that.getTime()
								console.log(that.checkApply1)
								let ue1 = that.$qs.stringify(that.checkApply1)
									that.$axios.get("http://localhost:8080/registerCq/insertCheckApply?"+ue1).then(function(res){
										
										})
								})
						})
						that.$axios.get("http://localhost:8080/registerCq/insertMedical?"+ue).then(function(res){
							
						})
						that.open()
					})
				})
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
			open() {
			        this.$alert('处方开设完毕', '系统提示', {
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