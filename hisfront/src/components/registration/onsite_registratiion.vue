<template>
	<div class="backid">
		<el-container>
			<el-main style="text-align: left;">
				<el-form :inline="true" :model="register" class="demo-form-inline">
					<el-form-item label="姓名:">
						<el-input v-model="register.realName" placeholder="姓名"></el-input>
					</el-form-item>
					<el-form-item label="身份证:">
						<el-input v-model="register.iDnumber" placeholder="身份证号码"></el-input>
					</el-form-item>
					<el-form-item label="病历号:">
						<el-input v-model="register.caseNumber" placeholder="病历号"></el-input>
					</el-form-item>
					<el-form-item style="float: right;">
						<el-button type="primary" @click="onSubmit">查询</el-button>
					</el-form-item>
				</el-form>
				<hr>
				<el-descriptions class="margin-top" title="基本信息录入" :column="3" border>
					<template slot="extra">
						<el-button type="primary" @click="clearSubmit">清空</el-button>
					</template>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user"></i>
							姓名
						</template>
						<el-input type="text" v-model="register.realName" placeholder="请输入您的姓名"></el-input>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user-solid"></i>
							身份证
						</template>
						<el-input type="text" v-model="register.iDnumber" placeholder="请输入您的身份证"></el-input>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-guide"></i>
							性别
						</template>
						<el-select v-model="register.gender" placeholder="请选择您的性别" style="width: 100%;">
							<el-option v-for="item in gender_options" :key="item.value" :label="item.label"
								:value="item.value">
							</el-option>
						</el-select>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-date"></i>
							出生日期
						</template>
						<el-date-picker type="date" placeholder="选择日期" v-model="register.birthDate"
							style="width: 100%;"></el-date-picker>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user-solid"></i>
							年龄
						</template>
						<el-input type="number" v-model="register.age" placeholder="请输入您的年龄" style="width: 70%;">
						</el-input>
						<el-select v-model="register.ageType" placeholder="单位" style="width: 80px;">
							<el-option v-for="item in AgeType_options" :key="item.value" :label="item.label"
								:value="item.value">
							</el-option>
						</el-select>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-mobile-phone"></i>
							联系电话
						</template>
						<el-input type="text" v-model="register.phoneNumber" placeholder="请输入您的联系电话"></el-input>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-location-outline"></i>
							联系地址
						</template>
						<el-input type="text" v-model="register.homeAddress" placeholder="请输入您的联系地址"></el-input>
					</el-descriptions-item>
				</el-descriptions>

				<h5>
					<hr>
				</h5>

				<el-descriptions class="margin-top" title="挂号信息录入" :column="3" border>
					<template slot="extra">
						病历号：{{register.caseNumber}}
					</template>
					<template slot="extra">
						<el-button type="primary" @click="registerSubmit">挂号</el-button>
					</template>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-date"></i>
							看诊日期
						</template>
						<el-date-picker v-model="register.visitDate" value-format="yyyy-MM-dd" type="date"
							placeholder="选择授权时间" style="width: 100%" readonly="true">
						</el-date-picker>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-timer"></i>
							挂号时间
						</template>
						<el-date-picker v-model="register.registertime" type="datetime" placeholder="选择日期时间"
							value-format="yyyy-MM-dd HH:mm:ss" style="width: 100%">
						</el-date-picker>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							午别
						</template>
						<el-select v-model="register.Noon" filterable placeholder="请选择您的午别" style="width: 100%;">
							<el-option v-for="item in Noon_options" :key="item.value" :label="item.label"
								:value="item.value">
							</el-option>
						</el-select>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							科室
						</template>
						<el-select v-model="register.deptID" filterable placeholder="请选择您的科室" style="width: 100%;">
							<el-option v-for="item in DeptID_options" :key="item.value" :label="item.label"
								:value="item.value">
							</el-option>
						</el-select>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							号别
						</template>
						<el-select v-model="register.registLeID" filterable placeholder="请选择您的号别" style="width: 100%;">
							<el-option v-for="item in RegistLeID_options" :key="item.value" :label="item.label"
								:value="item.value">
							</el-option>
						</el-select>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							看诊医生
						</template>
						<el-select v-model="register.userID" filterable placeholder="请选择您的看诊医生" style="width: 100%;">
							<el-option v-for="item in UserID_options" :key="item.value" :label="item.label"
								:value="item.value">
							</el-option>
						</el-select>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							应收金额
						</template>
						<el-input type="text" v-model="register.money" placeholder=""></el-input>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							支付方式
						</template>
						<el-select v-model="register.settleID" placeholder="请选择您的支付方式" style="width: 100%;">
							<el-option v-for="item in SettleID_options" :key="item.value" :label="item.label"
								:value="item.value">
							</el-option>
						</el-select>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							病历本
						</template>
						<el-switch v-model="register.IsBook">
						</el-switch>
					</el-descriptions-item>
				</el-descriptions>
			</el-main>
		</el-container>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				price:'0',
				register: {
					realName: '',
					caseNumber:0,
					gender: '',
					iDnumber: 0,
					birthDate: '',
					age: '',
					ageType: '',
					phoneNumber: '',
					homeAddress: '',
					visitDate: '',
					Noon:'',
					Registertime:'',
					deptID:'',
					registLeID:'',
					userID:'',
					settleID:'',
					IsBook: true,
					money:'',
					registerID:'', 
					visitState:'1'
				},
				gender_options: [{
					value: '男',
					label: '男'
				}, {
					value: '男',
					label: '女'
				}],
				AgeType_options: [{
					value: '岁',
					label: '岁'
				}, {
					value: '天',
					label: '天'
				}],
				Noon_options: [{
					value: '上午',
					label: '上午'
				}, {
					value: '下午',
					label: '下午'
				}],
				SettleID_options: [],
				DeptID_options:[],
				RegistLeID_options:[],
				UserID_options:[{
					value: '扁鹊',
					label: '扁鹊'
				},],
			}
		},
		created() {
			this.getSettleID_options(),
			this.getNowTime(),
			this.getDeptID_options(),
			this.getRegistLeID_options()			
		},
		methods: {
			onSubmit() {
				let rn = this.register.realName
				let uid = this.register.iDnumber
				let cn = this.register.caseNumber
				let that = this
				console.log(rn);
				this.$axios.get("http://localhost:8080/registerch/list?rn="+rn+"&cn="+cn+"&uid="+uid).then(function(res) {
					console.log(res.data[0]);
					that.$store.commit('register', res.data[0])
					that.register.realName = res.data[0].realName
					that.register.iDnumber = res.data[0].idnumber
					that.register.caseNumber = res.data[0].caseNumber
					that.register.gender = res.data[0].gender
					that.register.birthDate = res.data[0].birthDate
					that.register.age = res.data[0].age
					that.register.ageType = res.data[0].ageType
					that.register.phoneNumber = res.data[0].phoneNumber
					that.register.homeAddress = res.data[0].homeAddress
					that.register.registerID = $store.state.emp.realName
				})
			},
			clearSubmit(){
				this.register.realName='',
				this.register.caseNumber=0,
				this.register.gender='',
				this.register.iDnumber=0,
				this.register.birthDate='',
				this.register.age='',
				this.register.ageType='',
				this.register.phoneNumber= '',
				this.register.homeAddress= '',
				this.register.deptID='',
				this.register.registLeID='',
				this.register.userID='',
				this.register.settleID='',
				this.register.money=''
			},
			registerSubmit(){
				console.log(this.register);
				// delete this.register.doctor
				// delete this.register.registlevel
				// delete this.register.patientcosts
				// delete this.register.birthDate
				// delete this.register.Noon
				let reg = this.$qs.stringify(this.register)
				this.$axios.get("http://localhost:8080/registerch/regadd?"+reg).then(function(res){
					console.log(res);
				})
			},
			getNowTime() {
				var now = new Date();
				var year = now.getFullYear(); //得到年份
				var month = now.getMonth(); //得到月份
				var date = now.getDate(); //得到日期
				var dtime = now.getHours();//得到时刻 
				console.log(dtime);
				month = month + 1;
				month = month.toString().padStart(2, "0");
				date = date.toString().padStart(2, "0");
				if(12<dtime<24){
					console.log(1000111);
					console.log(dtime);
					this.$set(this.register,"Noon","下午")
				}
				else{
					console.log(224243242);
					console.log(dtime);
					this.$set(this.register,"Noon","上午")
				}
				var defaultDate = `${year}-${month}-${date}`;
				var defaultTime = `${now}`;
				this.$set(this.register, "visitDate", defaultDate);
				this.$set(this.register, "registertime", defaultTime);
			},
			getSettleID_options(){
				var i;
				var that = this;
				this.$axios.get("http://localhost:8080/settlrcategorych/list").then(function(res){
					console.log(res.data)
					for(i in res.data){
						// console.log(res.data[i].settleName)
						that.SettleID_options.push({
							value:res.data[i].id,
							label:res.data[i].settleName})
					}
					console.log(that.register.SettleID_options);
					
				})
			},
			getDeptID_options(){
				var i;
				var that = this;
				this.$axios.get("http://localhost:8080/departmentch/list").then(function(res){
					console.log(res.data)
					for(i in res.data){
						// console.log(res.data[i].deptName)
						that.DeptID_options.push({
							value:res.data[i].id,
							label:res.data[i].deptName})
					}
					// that.getUserID_options()
					console.log(that.register.deptID);
				})
			},
			getRegistLeID_options(){
				var i;
				var that = this;
				this.$axios.get("http://localhost:8080/registlevelch/list").then(function(res){
					// console.log(res.data)
					for(i in res.data){
						console.log(res.data[i].registName)
						that.RegistLeID_options.push({
							value:res.data[i].id,
							label:res.data[i].registName})
					}
					console.log(that.RegistLeID_option);
				})
			},
			getUserID_options(){
				
			}
		}
	}
</script>
<style>
</style>
