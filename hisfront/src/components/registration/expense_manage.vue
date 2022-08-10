<template>
	<div>
		<el-container>
			<el-main>
				<div style="text-align: left;">

					<el-form :inline="true" :model="register" class="demo-form-inline">
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
							<el-button type="primary" @click="changeDialogVisible = true" icon="el-icon-edit"
								style="float: right;">修改信息</el-button>
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
						<template slot="extra">
							病历号：{{register.caseNumber}}
						</template>
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


					<hr>
					<h4>
						项目详情
						<el-button type="primary" @click="chargeSubmit" style="float: right;">缴费</el-button>
						<el-button type="primary" @click="refundSubmit" style="float: right;">退费</el-button>
					</h4>
				</div>

				<el-table :data="subNews" style="width: 80%">
					<el-table-column prop="name" label="项目名称" width="180">
					</el-table-column>
					<el-table-column prop="price" label="单价" width="180">
					</el-table-column>
					<el-table-column prop="amount" label="数量" width="180">
					</el-table-column>
					<el-table-column prop="createtime" label="开立时间" width="180">
					</el-table-column>
				</el-table>
				<el-pagination background :page-size="pageSize" layout="prev, pager, next" :total="news.length"
					@current-change="dopaging">
				</el-pagination>


				<el-dialog title="患者信息修改" :visible.sync="changeDialogVisible" width="25%">
					<el-form>
						<el-form-item label="病历号" :label-width="formLabelWidth">
							<el-input v-model="register.caseNumber" disabled="true" style="width: 75%;"></el-input>
						</el-form-item>
						<el-form-item label="姓名" :label-width="formLabelWidth">
							<el-input v-model="register.realName" style="width: 75%;"></el-input>
						</el-form-item>
						<el-form-item label="联系电话" :label-width="formLabelWidth">
							<el-input v-model="register.phoneNumber" style="width: 75%;"></el-input>
						</el-form-item>
						<el-form-item label="联系地址" :label-width="formLabelWidth">
							<el-input v-model="register.homeAddress" style="width: 75%;"></el-input>
						</el-form-item>
						<el-form-item label="缴费方式" :label-width="formLabelWidth">
							<el-select v-model="register.settleId" placeholder="请选择您的支付方式" style="width: 100%;">
								<el-option v-for="item in SettleID_options" :key="item.value" :label="item.label"
									:value="item.value">
								</el-option>
							</el-select>
						</el-form-item>
					</el-form>
					<div slot="footer" class="dialog-footer">
						<el-button @click="changeDialogVisible = false">取 消</el-button>
						<el-button type="primary" @click="updateregSubmit">确 定</el-button>
					</div>
				</el-dialog>

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
					id: '',
					realName: '',
					caseNumber: 0,
					gender: '',
					iDnumber: 0,
					birthDate: '',
					age: '',
					ageType: '',
					phoneNumber: '',
					homeAddress: '',
					visitDate: '',
					Noon: '',
					registTime: '',
					deptId: '',
					registLeId: '',
					userId: '',
					settleId: '',
					IsBook: true,
					registerId: '',
					visitState: '1'
				},
				news: [],
				subNews: [],
				SettleID_options: [],
				gender_options: [],
				currPage: 1,
				pageSize: 3
			}
		},
		created() {
			this.clearSubmit(),
			this.getSettleID_options(),
			this.getgender_options()
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
				this.$axios.get("http://localhost:8080/registerch/list?rn=" + rn + "&cn=" + cn + "&uid=" + uid).then(
					function(res) {
						console.log(res.data[0]);
						that.register.id = res.data[0].id
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
						console.log(that.register.id);
						that.getregitems()
					})

			},
			dopaging(currPage) {
				this.currPage = currPage //将当前选择的页码存储到vue的全局变量里
				//根据当前页进行分页
				//currpage      pageSize     start   end
				// 1               2          0       2        0,1
				// 2               2          2       4        2,3
				//3  ...
				let start = (currPage - 1) * this.pageSize
				let end = currPage * this.pageSize

				this.subNews = this.news.slice(start, end)

			},
			getregitems() {
				var i
				var id = this.register.id
				let that = this
				// console.log(that.register.id);
				this.$axios.get("http://localhost:8080/pationcostsch/list?RID=" + id).then(
					function(res) {
						console.log(res.data)
						that.news = res.data
						that.dopaging(1)
					})

			},
			getgender_options() {
				var i;
				var that = this;
				this.$axios.get("http://localhost:8080/sexch/list").then(function(res) {
					console.log(res.data)
					for (i in res.data) {
						// console.log(res.data[i])
						that.gender_options.push({
							value: res.data[i].id,
							label: res.data[i].sex
						})
					}
					console.log(that.gender_options);

				})
			},
			getSettleID_options() {
				var i;
				var that = this;
				this.$axios.get("http://localhost:8080/settlrcategorych/list").then(function(res) {
					console.log(res.data)
					for (i in res.data) {
						console.log(res.data[i])
						that.SettleID_options.push({
							value: res.data[i].id,
							label: res.data[i].settleName
						})
					}
					console.log(that.SettleID_options);

				})
			},
			// 清空按钮
			clearSubmit() {
				this.register.realName = '',
					this.register.caseNumber = 0,
					this.register.gender = '',
					this.register.iDnumber = 0,
					this.register.birthDate = '',
					this.register.age = '',
					this.register.ageType = '',
					this.register.phoneNumber = '',
					this.register.homeAddress = '',
					this.register.deptId = '',
					this.register.registLeId = '',
					this.register.userId = '',
					this.register.settleId = '',
					this.register.money = '',
					this.register.registTime = '',
					this.register.visitDate = ''
				this.tableData = []
			},
			updateregSubmit() {
				console.log(this.register);
				delete this.register.deptId
				delete this.register.registLeId
				delete this.register.registerId
				delete this.register.userId
				if(this.register.gender==='男'){
					this.register.gender = 71
				}
				if(this.register.gender ==='女'){
					this.register.gender = 72
				}
				if(this.register.settleId==='自费'){
					this.register.settleId = 1
				}
				if(this.register.settleId ==='市医保'){
					this.register.settleId = 2
				}
				let reg = this.$qs.stringify(this.register)

				this.$axios.get("http://localhost:8080/registerch/updatereg?" + reg).then(function(res) {
					console.log(res);
				})
				this.onSubmit()
				this.$notify({
					title: '成功',
					message: '患者信息修改成功',
					type: 'success'
				});
			},
			chargeSubmit() {
				this.$router.push('/finance/charge')
			},
			refundSubmit() {
				this.$router.push('/finance/refund')
			},
			recordSubmit() {
				this.$router.push('/registration/recored')
			},
		}
	}
</script>

<style>
	.right-btn {
		float: right;
	}

	.el-table {
		margin: 0px auto;
	}
</style>
