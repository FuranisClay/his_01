<template>
	<div class="backid">
		<el-container>
			<el-aside width="180px"></el-aside>
			<el-main>
				<el-descriptions class="margin-top" title="基本信息录入" :column="3" border>
					<template slot="extra">
						<el-button type="primary" size="small">清空</el-button>
					</template>
					<template slot="extra">
						<el-button type="primary" size="small">挂号</el-button>
					</template>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user"></i>
							姓名
						</template>
						<el-input type="text" v-model="register.rn" placeholder="请输入您的姓名"></el-input>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user-solid"></i>
							身份证
						</template>
						<el-input type="text" v-model="register.IDnumber" placeholder="请输入您的身份证"></el-input>
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
						<el-date-picker type="date" placeholder="选择日期" v-model="register.BirthDate"
							style="width: 100%;"></el-date-picker>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-user-solid"></i>
							年龄
						</template>
						<el-input type="number" v-model="register.Age" placeholder="请输入您的年龄" style="width: 70%;">
						</el-input>
						<el-select v-model="register.AgeType" placeholder="单位" style="width: 80px;">
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
						<el-input type="text" v-model="register.IDnumber" placeholder="请输入您的联系地址"></el-input>
					</el-descriptions-item>
				</el-descriptions>

				<h3>
					<hr>
				</h3>

				<el-descriptions class="margin-top" title="挂号信息录入" :column="3" border>
					<template slot="extra">
						发票号：{{CaseNumber}}
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
						<el-date-picker v-model="register.Registertime" type="datetime" placeholder="选择日期时间"
							value-format="yyyy-MM-dd HH:mm:ss" style="width: 100%">
						</el-date-picker>
					</el-descriptions-item>
					<el-descriptions-item>
						<template slot="label">
							<i class="el-icon-edit"></i>
							午别
						</template>
						<el-select v-model="register.Noon" placeholder="请选择您的午别" style="width: 100%;">
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
						<el-select v-model="register.DeptID" placeholder="请选择您的科室" style="width: 100%;">
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
						<el-select v-model="register.RegistLeID" placeholder="请选择您的号别" style="width: 100%;">
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
						<el-select v-model="register.UserID" placeholder="请选择您的看诊医生" style="width: 100%;">
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
						<el-select v-model="register.SettleID" placeholder="请选择您的支付方式" style="width: 100%;">
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
				CaseNumber:'111',
				register: {
					rn: '',
					gender: '',
					IDnumber: '',
					BirthDate: '',
					Age: '',
					AgeType: '',
					phoneNumber: '',
					HomeA: '',
					visitDate: '',
					Noon:'',
					Registertime:'',
					DeptID:'',
					RegistLeID:'',
					UserID:'',
					SettleID:'',
					IsBook: true,
					money:''
				},
				gender_options: [{
					value: '选项1',
					label: '男'
				}, {
					value: '选项2',
					label: '女'
				}],
				AgeType_options: [{
					value: '选项1',
					label: '岁'
				}, {
					value: '选项2',
					label: '天'
				}],
				Noon_options: [{
					value: '选项1',
					label: '上午'
				}, {
					value: '选项2',
					label: '下午'
				}],
				SettleID_options: [{
					value: '选项1',
					label: '自费'
				}, {
					value: '选项2',
					label: '医保'
				}],

			}
		},
		created() {
			this.getNowTime()
		},
		methods: {
			getNowTime() {
				var now = new Date();
				var year = now.getFullYear(); //得到年份
				var month = now.getMonth(); //得到月份
				var date = now.getDate(); //得到日期
				var dtime = now.getHours();//得到时刻 
				month = month + 1;
				month = month.toString().padStart(2, "0");
				date = date.toString().padStart(2, "0");
				if(0<dtime<12){
					this.$set(this.register,"Noon","上午")
				}
				else{
					this.$set(this.register,"Noon","下午")
				}
				var defaultDate = `${year}-${month}-${date}`;
				var defaultTime = `${now}`;
				this.$set(this.register, "visitDate", defaultDate);
				this.$set(this.register, "Registertime", defaultTime);
			}
		}
	}
</script>
<style>
</style>
