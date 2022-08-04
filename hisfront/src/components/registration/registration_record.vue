<template>
	<div>
		<el-container>
			<el-main style="text-align: left;">
				<el-form :inline="true" :model="register" class="demo-form-inline" margin-left="0px;">
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
				<el-descriptions class="margin-top" title="基本信息" :column="3" :size="size" border>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user"></i>
							姓名
						</template>
						{{$store.state.register.realName}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user-solid"></i>
							身份证
						</template>
						{{$store.state.register.idnumber}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-guide"></i>
							性别
						</template>
						{{$store.state.register.gender}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-date"></i>
							出生日期
						</template>
						{{$store.state.register.birthDate}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user-solid"></i>
							年龄
						</template>
						{{$store.state.register.age}}
						{{$store.state.register.ageType}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-mobile-phone"></i>
							联系电话
						</template>
						{{$store.state.register.phoneNumber}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-location-outline"></i>
							联系地址
						</template>
						{{$store.state.register.homeAddress}}
					</el-descriptions-item>
				</el-descriptions>

				<h3>
					<hr>
				</h3>

				<el-descriptions class="margin-top" title="挂号信息录入" :column="3" :size="size" border>
					<template slot="extra">
						病历号：{{$store.state.register.caseNumber}}
					</template>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-date"></i>
							看诊日期
						</template>
						{{$store.state.register.visitDate}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-timer"></i>
							挂号时间
						</template>
						{{$store.state.register.registTime}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							科室
						</template>
						{{$store.state.register.deptId}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							号别
						</template>
						{{register.relid}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							看诊医生
						</template>
						{{register.doctor}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							挂号情况
						</template>
						{{$store.state.register.visitState}}
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
					that.$store.commit('register', res.data[0])
					that.register.realName = res.data[0].realName
					that.register.iDnumber = res.data[0].idnumber
					that.register.caseNumber = res.data[0].caseNumber
					that.register.doctor = res.data[0].user.realName
					that.register.relid = res.data[0].registlevel.registName
					that.register.deptName=res.data[0].departments[0].deptName
				})
			},
			amendSubmit(){
				console.log(this.register);
				let cn = this.$store.state.register.caseNumber
				console.log(cn);
				this.$axios.get("http://localhost:8080/registerch/delrigist?cn="+cn).then(function(res){
					console.log(res);
				})
			},
		}
	}
</script>

<style>

</style>
