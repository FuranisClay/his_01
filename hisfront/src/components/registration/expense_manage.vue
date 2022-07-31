<template>
	<div>
		<el-container>
			<el-aside width="180px"></el-aside>
			<el-main style="text-align: left;">
				<el-form :inline="true" :model="register" class="demo-form-inline">
					<el-form-item label="姓名:">
						<el-input v-model="register.rn" placeholder="姓名"></el-input>
					</el-form-item>
					<el-form-item label="身份证:">
						<el-input v-model="register.IDnumber" placeholder="身份证号码"></el-input>
					</el-form-item>
					<el-form-item label="发票号:">
						<el-input v-model="register.CaseNumber" placeholder="发票号"></el-input>
					</el-form-item>
					<el-form-item style="float: right;">
						<el-button type="primary" @click="onSubmit">查询</el-button>
					</el-form-item>
				</el-form>
				<hr>
				<el-descriptions class="margin-top" title="基本信息" :column="3" border>
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

				<h5>
					<hr>
				</h5>

				<el-descriptions class="margin-top" title="挂号信息录入" :column="3" border>
					<template slot="extra">
						发票号：{{$store.state.register.caseNumber}}
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
						<!-- {{$store.state.register.registlevel.registName}} -->
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							看诊医生
						</template>
						{{$store.state.register.userId}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							应收金额
						</template>
						{{register.money+777}}
					</el-descriptions-item>
				</el-descriptions>

				<h4>
					<hr>
					项目详情
					<el-button type="primary" @click="chargeSubmit" style="float: right;">缴费</el-button>
					<el-button type="primary" @click="refundSubmit" style="float: right;">退费</el-button>
				<el-table :data="tableData">
					<el-table-column prop="date" label="日期" width="140">
					</el-table-column>
					<el-table-column prop="name" label="姓名" width="120">
					</el-table-column>
					<el-table-column prop="address" label="地址">
					</el-table-column>
				</el-table>
				</h4>
			</el-main>
		</el-container>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				register: {
					CaseNumber: '',
					rn: '',
					gender: '',
					IDnumber: '',
					BirthDate: '',
					Age: '',
					AgeType: '',
					phoneNumber: '',
					HomeA: '',
					visitDate: '',
					Registertime: '',
					DeptID: '',
					RegistLeID: '',
					UserID: '',
					SettleID: '',
					money: ''
				},
			}
		},
		methods: {
			onSubmit() {
				let rn = this.register.rn
				let that = this
				console.log(rn);
				this.$axios.get("http://localhost:8080/register/list?rn=" + rn).then(function(res) {
					console.log(res.data[0]);
					that.$store.commit('register', res.data[0])
				})
			},
			chargeSubmit(){
				
			},
			refundSubmit(){
				
			}

		}
	}
</script>

<style>
	.right-btn {
		float: right;
	}
</style>
