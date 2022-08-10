<template>
    <div>
        <div style="text-align: center"><h3>新增排班规则</h3></div>
        <div style="text-align: center;  margin-top: 30px">
            <el-form :inline="true" class="demo-form-inline">
                <el-form-item label="科室选择：">
                    <el-select v-model="selectdept" placeholder="请选择科室类型">
                        <el-option label="--请选择--"></el-option>
                        <el-option
                                v-for="item in deptlist"
                                :label="item.deptName"
                                :value="item.id"
                        >
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="挂号级别：">
                    <el-select v-model="selectregistlevel" placeholder="请选择挂号级别">
                        <el-option label="--请选择--" value=""></el-option>
                        <el-option
                                v-for="item in registlist"
                                :label="item.registName"
                                :value="item.id"
                        ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" icon="el-icon-search" @click="queryUserList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" plain icon="el-icon-delete" @click="emptyForm">清空</el-button>
                </el-form-item>
            </el-form>
            <el-form>
                <el-table
                        :data="userlist"
                        border
                        style="width: 100%">
                    <!--                    <el-table-column-->
                    <!--                            type="selection"-->
                    <!--                            header-align="center"-->
                    <!--                            align="center"-->
                    <!--                            width="50">-->
                    <!--                    </el-table-column>-->
                    <el-table-column
                            label="医生姓名"
                            width="100">
                        <template slot-scope="scope">
                            <span style="margin-left: 10px">{{ scope.row.realName }}</span>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期一 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox change="onSubmit" v-model="scope.row.rule[0]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期一 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[1]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期二 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[2]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期二 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[3]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期三 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[4]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期三 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[5]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期四 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[6]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期四 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[7]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期五 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[8]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期五 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[9]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期六 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[10]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期六 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[11]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期日 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[12]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期日 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
                                <el-checkbox @click="onSubmit" v-model="scope.row.rule[13]"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                </el-table>
                <div style="margin: 20px 480px;">
                    <el-form-item label="排班规则名称:" label-width="120px">
                        <el-input v-model="rulename" size="medium"></el-input>
                    </el-form-item>
                </div>
                <div>
                    <el-form-item>
                        <el-button type="warning" @click="onSubmit">保存</el-button>
                        <el-button type="primary" plain @click="addScheduleFalse">取消</el-button>
                    </el-form-item>
                </div>
            </el-form>
        </div>
    </div>
</template>

<script>
    import ElForm from "element-ui/packages/form/src/form";
    import Schedule from "./Schedule";

    export default {
        data() {
            return {
                rulename: "",
                selectdept: 0,
                selectregistlevel: 0,
                deptlist: [],
                registlist: [],
                userlist: [],
                checkedlist: [],
                deptNames: []
            }
        },
        methods: {
            queryUserList() {
                console.log("selectdept:" + this.selectdept)
                console.log("selectregistlevel:" + this.selectregistlevel)
                let that = this
                this.$axios.get("http://localhost:8080/userzgy/userlist?deptno=" + that.selectdept + "&registlevel=" + that.selectregistlevel).then(function (res) {
                    that.userlist = res.data
                    console.log(res.data)
                })
            },
            emptyForm() {
                let that = this
                this.$axios.get("http://localhost:8080/userzgy/list").then(function (res) {
                    that.userlist = res.data
                    console.log(res.data)
                })
            },
            addScheduleFalse() {
                console.log("点击取消")
                Schedule.methods.addScheduleFalse()
            },
            onSubmit() {
                let that = this
                for (let i = 0; i < this.userlist.length; i++) {
                    console.log(i)
                    console.log(this.userlist[i])
                    this.$axios.get("http://localhost:8080/rulezgy/addrule?name=" + that.rulename + "&deptid=" + that.userlist[i].deptId + "&userid=" + that.userlist[i].id + "&rule=" + that.userlist[i].rule+"&num="+i).then(function (res) {
                        console.log(res.data)
                    })
                }
                // this.$axios.get("http://localhost:8080/rulezgy/addrule?name="+that.rulename+"&list="+that.userlist).then(function (res) {
                //     console.log(res.data)
                // })
                console.log("lalalalalal")
                console.log(typeof that.userlist)
                console.log(this.rulename)
                console.log(this.userlist)

                Schedule.methods.addScheduleFalse()
            },
            // addScheduleFalse(){
            //     console.log("scheduleadd里的方法")
            // }
        },
        created() {
            let that = this
            this.$axios.get("http://localhost:8080/deptzgy/list").then(function (res) {
                that.deptlist = res.data
                // console.log("部门")
                // console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/registerzgy/list").then(function (res) {
                that.registlist = res.data
                console.log("挂号等级")
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/userzgy/list").then(function (res) {
                that.userlist = res.data
                console.log("用户列表啊啊啊啊啊啊")
                console.log(res.data)
            })
        },
        components: {
            Schedule,
            ElForm
        }
    }
</script>
