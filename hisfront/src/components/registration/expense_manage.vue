<template>
	<div>
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
				<el-descriptions class="margin-top" title="基本信息" :column="3" border>
					<template slot="extra">
						<el-button type="primary" @click="updateregSubmit" style="float: right;">修改信息</el-button>
					</template>
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
							缴费方式
						</template>
						{{$store.state.register.settlecategory[0].settleName}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							科室
						</template>
						{{$store.state.register.departments[0].deptName}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							号别
						</template>
						{{$store.state.register.registlevel.registName}}
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							看诊医生
						</template>
						{{$store.state.register.user.realName}}
					</el-descriptions-item>
					<template slot="extra">
						<el-button type="primary" @click="recordSubmit">退号</el-button>
					</template>
				</el-descriptions>

				<h4>
					<hr>
					项目详情
					<el-button type="primary" @click="chargeSubmit" style="float: right;">缴费</el-button>
					<el-button type="primary" @click="refundSubmit" style="float: right;">退费</el-button>
				<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover"
					style="margin-top: 10px; width: 80%;">
					<div class="hidden-columns">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="el-table__header-wrapper">
						<table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width: 815px;">
							<colgroup>
								<col name="el-table_108_column_742" width="55">
								<col name="el-table_108_column_743" width="80">
								<col name="el-table_108_column_744" width="80">
								<col name="el-table_108_column_745" width="80">
								<col name="el-table_108_column_746" width="120">
								<col name="el-table_108_column_747" width="120">
								<col name="el-table_108_column_748" width="80">
								<col name="el-table_108_column_749" width="200">
								<col name="gutter" width="0">
							</colgroup>
							<thead class="has-gutter">
								<tr class="">
									<th colspan="1" rowspan="1"
										class="el-table_108_column_742   el-table-column--selection  is-leaf el-table__cell">
										<div class="cell"><label class="el-checkbox is-disabled"><span
													class="el-checkbox__input is-disabled"><span
														class="el-checkbox__inner"></span><input type="checkbox"
														aria-hidden="false" disabled="disabled" class="el-checkbox__original"
														value=""></span>
												<!---->
											</label></div>
									</th>
									<th colspan="1" rowspan="1" class="el-table_108_column_743     is-leaf el-table__cell">
										<div class="cell">项目名称</div>
									</th>
									<th colspan="1" rowspan="1" class="el-table_108_column_744     is-leaf el-table__cell">
										<div class="cell">单价</div>
									</th>
									<th colspan="1" rowspan="1" class="el-table_108_column_745     is-leaf el-table__cell">
										<div class="cell">类型</div>
									</th>
									<th colspan="1" rowspan="1" class="el-table_108_column_746     is-leaf el-table__cell">
										<div class="cell">规格</div>
									</th>
									<th colspan="1" rowspan="1" class="el-table_108_column_747     is-leaf el-table__cell">
										<div class="cell">状态</div>
									</th>
									<th colspan="1" rowspan="1" class="el-table_108_column_748     is-leaf el-table__cell">
										<div class="cell">数量</div>
									</th>
									<th colspan="1" rowspan="1" class="el-table_108_column_749     is-leaf el-table__cell">
										<div class="cell">开立时间</div>
									</th>
									<th class="el-table__cell gutter" style="width: 0px; display: none;"></th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="el-table__body-wrapper is-scrolling-left">
						<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width: 815px;">
							<colgroup>
								<col name="el-table_108_column_742" width="55">
								<col name="el-table_108_column_743" width="80">
								<col name="el-table_108_column_744" width="80">
								<col name="el-table_108_column_745" width="80">
								<col name="el-table_108_column_746" width="120">
								<col name="el-table_108_column_747" width="120">
								<col name="el-table_108_column_748" width="80">
								<col name="el-table_108_column_749" width="200">
							</colgroup>
							<tbody>
								<!---->
							</tbody>
						</table>
						<div class="el-table__empty-block" style="height: 100%; width: 815px;"><span
								class="el-table__empty-text">暂无数据</span></div>
						<!---->
					</div>
					<!---->
					<!---->
					<!---->
					<!---->
					<div class="el-table__column-resize-proxy" style="display: none;"></div>
				</div>
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
				changeDialogVisible: false,
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
					
				},
				tableData:[]
			}
		},
		created() {
			this.getpatientcosts()
		},
		methods: {
			onSubmit() {
				let rn = this.register.realName
				let cn = this.register.caseNumber
				let uid = this.register.iDnumber
				let that = this
				console.log(rn);
				console.log(cn);
				console.log(uid);
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
				})
			},
			updateregSubmit(){
				let reg = this.$qs.stringify(this.register)
				this.$axios.get("http://localhost:8080/registerch/updatereg?"+reg).then(function(res){
					console.log(res);
				})
			},
			chargeSubmit(){
				this.$router.push('/finance/charge')
			},
			refundSubmit(){
				this.$router.push('/finance/refund')
			},
			recordSubmit(){
				this.$router.push('/registration/recored')
			},
			getpatientcosts(){
				
			},
			
		}
	}
</script>

<style>
	.right-btn {
		float: right;
	}
</style>
