<template>
    <div class="backid">
        <el-container>
            <el-main style="text-align: left;">
                <el-form :inline="true" :model="register" class="demo-form-inline">
                    <el-form-item label="身份证:">
                        <el-input v-model="register.iDnumber" placeholder="身份证号码"></el-input>
                    </el-form-item>
                    <el-form-item label="病历号:">
                        <el-input v-model="register.caseNumber" placeholder="病历号"></el-input>
                    </el-form-item>
                    <el-form-item style="float: right;">
                        <el-button type="primary" @click="onSubmit" @change="on_change">查询</el-button>
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
                            <i class="el-icon-user"></i>
                            病历号
                        </template>
                        <el-input type="text" v-model="register.caseNumber" placeholder="请输入您的病历号"></el-input>
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-user-solid"></i>
                            身份证
                        </template>
                        <el-form :rules="IdCardRules" :model="register">
                            <el-form-item prop="iDnumber">
                                <el-input type="text" v-model="register.iDnumber" placeholder="请输入您的身份证"></el-input>
                            </el-form-item>
                        </el-form>
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-guide"></i>
                            性别
                        </template>
                        <el-select v-model="register.gender" @click="getgender_options" @change="gender_change"
                                   placeholder="请选择您的性别" style="width: 100%;">
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
                        <el-date-picker v-model="register.birthDate" value-format="yyyy-MM-dd" type="date"
                                        placeholder="选择日期" style="width: 100%;"></el-date-picker>
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
                                        placeholder="选择授权时间" style="width: 100%">
                        </el-date-picker>
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-timer"></i>
                            挂号时间
                        </template>
                        <el-date-picker v-model="register.registTime" @change="NowTime_change" type="datetime"
                                        placeholder="选择日期时间" value-format="yyyy-MM-dd HH:mm:ss" style="width: 100%">
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
                        <el-select v-model="register.deptId" @change="deptID_change" filterable placeholder="请选择您的科室"
                                   style="width: 100%;">
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
                        <el-select v-model="register.registLeId" @change="registLeID_change" filterable
                                   placeholder="请选择您的号别" style="width: 100%;">
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
                        <el-select v-model="register.userId" @change="user_change" filterable placeholder="请选择您的看诊医生"
                                   style="width: 100%;">
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
                        <el-input type="text" v-model="register.money" placeholder="" readonly="true"></el-input>
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-edit"></i>
                            支付方式
                        </template>
                        <el-select v-model="register.settleId" placeholder="请选择您的支付方式" style="width: 100%;">
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
                IdCardRules: {
                    iDnumber: [{
                        required: true,
                        message: '请输入身份证号码',
                        trigger: 'blur'
                    },
                        {
                            validator: this.checkID,
                            trigger: 'blur'
                        }
                    ]

                },
                price: '0',
                register: {
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
                    money: '',
                    registerId: '',
                    visitState: '1'
                },
                gender_options: [],
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
                DeptID_options: [],
                RegistLeID_options: [],
                UserID_options: [],
            }
        },
        created() {
            this.getSettleID_options(),
                this.getNowTime(),
                this.getDeptID_options(),
                this.getRegistLeID_options(),
                // this.getmoney(),
                this.getgender_options()
            // this.getUserID_options()
        },
        methods: {
            // 查询患者基本信息显示
            onSubmit() {
                let rn = this.register.realName
                let uid = this.register.iDnumber
                let cn = this.register.caseNumber
                let that = this
                console.log(rn);
                this.$axios.get("http://localhost:8080/registerch/list?rn=" + rn + "&cn=" + cn + "&uid=" + uid).then(
                    function (res) {
                        console.log(res.data[0]);
                        that.$store.commit('register', res.data[0])
                        that.register.realName = res.data[0].realName
                        that.register.iDnumber = res.data[0].idnumber
                        that.register.caseNumber = res.data[0].caseNumber
                        that.register.gender = res.data[0].sex.id
                        that.register.birthDate = res.data[0].birthDate
                        that.register.age = res.data[0].age
                        that.register.ageType = res.data[0].ageType
                        that.register.phoneNumber = res.data[0].phoneNumber
                        that.register.homeAddress = res.data[0].homeAddress
                        console.log(that.register.registerId);
                    })
                this.$notify({
                    title: '成功',
                    message: '患者信息导入成功',
                    type: 'success'
                });
            },
            user_change() {
                // console.log(this.UserID_options.length+'<<<<<<<<<<<<<<<<<!!!!!');
                // this.UserID_options.splice(0,this.UserID_options.length);
                // console.log(this.UserID_options);
            },
            gender_change() {
                console.log(this.register.gender)
            },
            // 部门选择
            deptID_change() {
                console.log(this.register.deptId);
                console.log(this.register.registLeId);
                // this.register.visitDate = this.enderTime(this.register.visitDate)
                console.log(this.register.visitDate);
                this.getUserID_options()
            },

            // 挂号等级选择
            registLeID_change() {
                // 	this.getmoney()
                // },
                // // 挂号费显示
                // getmoney(){
                console.log(12341245);
                this.register.userId = ''
                var id = this.register.registLeId
                console.log(id);
                var that = this;
                this.$axios.get("http://localhost:8080/registlevelch/fee?id=" + id).then(function (res) {
                    console.log(res.data);
                    that.register.money = res.data
                })
                this.getUserID_options()
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
                    this.register.money = ''
                this.$notify({
                    title: '成功',
                    message: '患者信息清空成功',
                    type: 'success'
                });
            },
            registerSubmit() {
                if (this.register.gender === '男') {
                    this.register.gender = 71
                }
                if (this.register.gender === '女') {
                    this.register.gender = 72
                }
                this.register.registerId = this.$store.state.emp.id
                this.register.registTime = this.enderTime(this.register.registTime)
                console.log(this.register);
                // delete this.register.doctor
                // delete this.register.registlevel
                // delete this.register.patientcosts
                // delete this.register.birthDate
                // delete this.register.Noon
                let reg = this.$qs.stringify(this.register)
                this.$axios.get("http://localhost:8080/registerch/regadd?" + reg).then(function (res) {
                    console.log(res);
                })
                this.$notify({
                    title: '成功',
                    message: '挂号成功',
                    type: 'success'
                });
            },
            getNowTime() {
                var now = new Date();
                var year = now.getFullYear(); //得到年份
                var month = now.getMonth(); //得到月份
                var date = now.getDate(); //得到日期
                let dtime = now.getHours(); //得到时刻
                console.log(dtime);
                if (dtime > 12) {
                    console.log(dtime);
                    this.register.Noon = "下午";
                    this.$set(this.register, "Noon", "下午");
                } else {
                    console.log(dtime);
                    this.register.Noon = "上午";
                    this.$set(this.register, "Noon", "上午");
                }
                month = month + 1;
                month = month.toString().padStart(2, "0");
                date = date.toString().padStart(2, "0");
                var defaultDate = `${year}-${month}-${date}`;
                var defaultTime = `${now}`;
                this.$set(this.register, "visitDate", defaultDate);
                this.$set(this.register, "registTime", defaultTime);
            },
            enderTime(date) {
                var dateee = new Date(date).toJSON();
                return new Date(+new Date(dateee)).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/,
                    '')
            },
            getgender_options() {
                var i;
                var that = this;
                this.$axios.get("http://localhost:8080/sexch/list").then(function (res) {
                    console.log(res.data)
                    for (i in res.data) {
                        // console.log(res.data[i])
                        that.gender_options.push({
                            value: res.data[i].id,
                            label: res.data[i].sex
                        })
                    }
                    console.log(that.register.gender);

                })
            },
            getSettleID_options() {
                var i;
                var that = this;
                this.$axios.get("http://localhost:8080/settlrcategorych/list").then(function (res) {
                    console.log(res.data)
                    for (i in res.data) {
                        // console.log(res.data[i])
                        that.SettleID_options.push({
                            value: res.data[i].id,
                            label: res.data[i].settleName
                        })
                    }
                    console.log(this.SettleID_options);

                })
            },
            getDeptID_options() {
                var i;
                var that = this;
                this.$axios.get("http://localhost:8080/departmentch/list").then(function (res) {
                    console.log(res.data)
                    for (i in res.data) {
                        // console.log(res.data[i])
                        that.DeptID_options.push({
                            value: res.data[i].id,
                            label: res.data[i].deptName
                        })
                    }
                    // that.getUserID_options()
                    console.log(that.register.deptId);
                })
            },
            getRegistLeID_options() {
                var i;
                var that = this;
                this.$axios.get("http://localhost:8080/registlevelch/list").then(function (res) {
                    console.log(res.data)
                    for (i in res.data) {
                        console.log(res.data[i].registName)
                        that.RegistLeID_options.push({
                            value: res.data[i].id,
                            label: res.data[i].registName
                        })
                    }
                    console.log(that.RegistLeID_option);
                })
            },
            getUserID_options() {
                this.UserID_options.splice(0, this.UserID_options.length);
                console.log(this.register.deptId);
                console.log(this.register.registLeId);
                // this.register.visitDate = this.enderTime(this.register.visitDate)
                console.log(this.register.visitDate);
                var i;
                var did = this.register.deptId
                var vdate = this.register.visitDate
                var noon = this.register.Noon
                var rid = this.register.registLeId
                console.log(rid + '<<<<<<<<<<<<<<<');
                var that = this;
                this.$axios.get("http://localhost:8080/schedulingch/list?deptId=" + did + "&vdate=" + vdate + "&noon=" +
                    noon).then(function (res) {
                    console.log(res.data)
                    for (i in res.data) {
                        console.log(res.data[i].userId)
                        var Did = res.data[i].userId
                        that.$axios.get("http://localhost:8080/User/list?Did=" + Did + "&rid=" + rid).then(function (res) {
                            console.log(res.data)
                            that.UserID_options.push({
                                value: res.data[0].id,
                                label: res.data[0].realName
                            })
                            console.log(that.UserID_options);
                        })
                    }


                })
            },
            //轮询校验
            checkID(rule, value, callback) {
                console.log("校验身份证", value)
                if (value == null) {
                    callback();
                }
                //不用分顺序--截取位数校验
                if (this.checkCode(value)) {
                    var date = value.substring(6, 14);
                    var sex = value.substring(16, 17);
                    if (sex % 2 === 0)
                        this.register.gender = '女';
                    else
                        this.register.gender = '男';
                    if (this.checkDate(date)) {
                        if (this.checkProv(value.substring(0, 2))) {
                            callback()
                        }
                    }
                    this.getAge(value)
                }
                callback(new Error("身份证校验失败"));
            },
            //iden参数是身份证号
            getAge(iden) {
                console.log(iden);
                let val = iden.length;
                let myDate = new Date();
                let month = myDate.getMonth() + 1;
                let day = myDate.getDate();
                let age = 0;
                if (val === 18) {
                    age = myDate.getFullYear() - iden.substring(6, 10) - 1;
                    if (iden.substring(10, 12) < month || iden.substring(10, 12) == month && iden.substring(12, 14) <= day) age++;
                }
                //把算出的年龄给复制给from表单
                this.$set(this.register, "age", age);
                this.register.ageType = '岁'
            },
            //1、省级地址码的方法--固定
            checkProv(val) {
                var pattern = /^[1-9][0-9]/;
                var provs = {
                    11: '北京',
                    12: '天津',
                    13: '河北',
                    14: '山西',
                    15: '内蒙古',
                    21: '辽宁',
                    22: '吉林',
                    23: '黑龙江',
                    31: '上海',
                    32: '江苏',
                    33: '浙江',
                    34: '安徽',
                    35: '福建',
                    36: '江西',
                    37: '山东',
                    41: '河南',
                    42: '湖北',
                    43: '湖南',
                    44: '广东',
                    45: '广西',
                    46: '海南',
                    50: '重庆',
                    51: '四川',
                    52: '贵州',
                    53: '云南',
                    54: '西藏',
                    61: '陕西',
                    62: '甘肃',
                    63: '青海',
                    64: '宁夏',
                    65: '新疆',
                    71: '台湾',
                    81: '香港',
                    82: '澳门'
                };
                if (pattern.test(val)) {
                    if (provs[val]) {
                        console.log(provs[val]);
                        this.register.homeAddress = provs[val]
                        console.log(this.register.homeAddress);
                        return true;
                    }
                }
                return false;
            },
            //2、验证出生年月日-时间校验
            checkDate(val) {
                var pattern = /^(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)$/;
                if (pattern.test(val)) {
                    var year = val.substring(0, 4);
                    var month = val.substring(4, 6);
                    var date = val.substring(6, 8);
                    var date2 = new Date(year + "-" + month + "-" + date);
                    if (date2 && date2.getMonth() == (parseInt(month) - 1)) {
                        var year1 = date2.getFullYear(); //得到年份
                        var month1 = date2.getMonth(); //得到月份
                        month1 = month1 + 1
                        var date1 = date2.getDate(); //得到日期
                        var date3 = `${year1}-${month1}-${date1}`;
                        console.log(date3);
                        this.register.birthDate = date3
                        console.log(this.register.birthDate);
                        return true;
                    }
                }
                return false;
            },
            //3、校验码--最后一位的校验
            checkCode(val) {
                var p = /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
                var factor = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
                var parity = [1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2];
                var code = val.substring(17);
                if (p.test(val)) {
                    var sum = 0;
                    for (var i = 0; i < 17; i++) {
                        sum += val[i] * factor[i];
                    }
                    if (parity[sum % 11] == code.toUpperCase()) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
</script>
<style>
</style>
