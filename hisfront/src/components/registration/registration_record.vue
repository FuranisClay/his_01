<template>
	<div>
		<el-container>
			<el-main style="text-align: left;">
				<el-form :inline="true" :model="register" class="demo-form-inline" margin-left="0px;">
					<el-form-item label="身份证:">
						<el-input v-model="register.iDnumber" placeholder="身份证号码"></el-input>
					</el-form-item>
					<el-form-item label="病历号:">
						<el-input v-model="register.caseNumber" placeholder="病历号"></el-input>
					</el-form-item>
					<el-form-item style="float: right;">
						<el-button type="primary" @click="clearSubmit">清空</el-button>
					</el-form-item>
					<el-form-item style="float: right;">
						<el-button type="primary" @click="onSubmit">查询</el-button>
					</el-form-item>
				</el-form>
				<hr>
				<el-descriptions class="margin-top" title="基本信息" :column="3" border>
					<template slot="extra">
						病历号：{{register.caseNumber}}
					</template>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user"></i>
							姓名
						</template>
						{{register.realName}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user-solid"></i>
							身份证
						</template>
						{{register.iDnumber}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-guide"></i>
							性别
						</template>
						{{register.gender}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-date"></i>
							出生日期
						</template>
						{{register.birthDate}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user-solid"></i>
							年龄
						</template>
						{{register.age}}
						{{register.ageType}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-mobile-phone"></i>
							联系电话
						</template>
						{{register.phoneNumber}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-location-outline"></i>
							联系地址
						</template>
						{{register.homeAddress}}
					</el-descriptions-item>
				</el-descriptions>
				
				<h5>
					<hr>
				</h5>
				
				<el-descriptions class="margin-top" title="挂号信息录入" :column="3" border>				
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-date"></i>
							看诊日期
						</template>
						{{register.visitDate}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-timer"></i>
							挂号时间
						</template>
						{{register.registTime}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							缴费方式
						</template>
						{{register.settleId}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							科室
						</template>
						{{register.deptId}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							号别
						</template>
						{{register.registLeId}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							看诊医生
						</template>
						{{register.userId}}
					</el-descriptions-item>
				</el-descriptions>

				<h3>
					<hr>
				</h3>
				
				<el-button type="primary" @click="amendSubmit" icon="el-icon-delete"  style="float: right;">退号</el-button>

			</el-main>
		</el-container>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				register: {
					caseNumber: 0,
					realName: '',
					iDnumber: 0,
					doctor:'',
					relid:'',
					deptName:''
				},
			}
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
					that.register.realName = res.data[0].realName
					that.register.iDnumber = res.data[0].idnumber
					that.register.caseNumber = res.data[0].caseNumber
					that.register.gender = res.data[0].sex.sex
					that.register.birthDate = res.data[0].birthDate
					that.register.age = res.data[0].age
					that.register.ageType = res.data[0].ageType
					that.register.phoneNumber = res.data[0].phoneNumber
					that.register.homeAddress = res.data[0].homeAddress			
					that.register.registTime = res.data[0].registTime
					that.register.visitDate = res.data[0].visitDate
					that.register.settleId = res.data[0].settlecategory[0].settleName
					that.register.deptId = res.data[0].departments[0].deptName
					that.register.registLeId = res.data[0].registlevel.registName
					that.register.userId = res.data[0].user.realName
					that.register.gender = res.data[0].sex.sex
				})
			},
			// 清空按钮
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
				this.register.deptId='',
				this.register.registLeId='',
				this.register.userId='',
				this.register.settleId='',
				this.register.money='',
				this.register.registTime='',
				this.register.visitDate=''
			},
			amendSubmit(){
				console.log(this.register);
				let cn = this.register.caseNumber
				console.log(cn);
				this.$axios.get("http://localhost:8080/registerch/delrigist?cn="+cn).then(function(res){
					console.log(res);
				})
				this.$notify({
					title: '成功',
					message: '患者退号成功',
					type: 'success'
				});
			},
		}
	}
</script>

<style>

</style>
