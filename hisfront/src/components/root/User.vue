<template>
    <div style="margin-top: 50px;background-color:;">
        <el-form
                :inline="true"
                :model="formInline"
                :rules="rules"
                status-icon
                style="margin-top: -15px; height: 35px;"
                ref="formInline"
                size="mini">
            <el-row>
                <el-col :span="5">
                    <el-form-item prop="prescriptionCode" style="position: absolute;">
                        <el-input
                                name="prescriptionCode"
                                v-model="queryUserString"
                                type="text"
                                placeholder="请输入用户真实姓名">
                        </el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="15">
                    <el-form-item>
                        <el-button
                                type="primary"
                                @click="queryUser"
                                icon="el-icon-search">查询用户
                        </el-button>
                    </el-form-item>
                </el-col>
                <el-col :span="30">
                    <el-form-item>
                        <el-button
                                @click="addDialog"
                                type="primary"
                                icon="el-icon-search">新增用户
                        </el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <template>
            <el-table
                    ref="multipleTable"
                    :data="userlist.slice((currentPage - 1) * pageSize,currentPage * pageSize)"
                    :row-style="{height: 90 + 'px'}"
                    tooltip-effect="dark"
                    height="520"
                    style="width: 90%; margin: 0 auto;"
            >
                <el-table-column
                        prop="id"
                        label="用户ID"
                        width="70px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="userName"
                        label="登录名"
                        width="90px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="password"
                        label="密码"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="realName"
                        label="真实姓名"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="useType"
                        label="用户类别"
                        width="130px"
                        align="center">
                    <template slot-scope="scope">
                        <span style="">{{ formatUserType(scope.row.useType) }}</span>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="constantitem.constantName"
                        label="医生职称"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="isScheduling"
                        label="是否参与排班"
                        width="110px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="department.deptName"
                        label="所在科室名称"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="registlevel.registName"
                        label="挂号级别名称"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        label="编辑">
                    <template #default="scope">
                        <el-button @click="changeDialog(scope.row)" icon="el-icon-edit">修改</el-button>
                        <el-button @click="deleteDialog(scope.row)" icon="el-icon-delete">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </template>
        <template>
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-sizes="[3, 5, 10, 15]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="userlist.length">
            </el-pagination>
        </template>


        <!--        修改对话框-->
        <el-dialog title="科室信息修改" :visible.sync="changeDialogVisible" width="25%">
            <el-form>
                <el-form-item label="用户ID" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.id" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="登录名" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.userName" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="密码" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.password" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="真实姓名" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.realName" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="用户类别" :label-width="formLabelWidth">
                    <el-select v-model="changeRow.useType" placeholder="请选择用户类别">
                        <el-option label="医院管理员" value="1"></el-option>
                        <el-option label="挂号员" value="2"></el-option>
                        <el-option label="门诊医生" value="3"></el-option>
                        <el-option label="医技医生" value="4"></el-option>
                        <el-option label="药房操作员" value="5"></el-option>
                        <el-option label="财务管理员" value="6"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="医生职称" :label-width="formLabelWidth">
                    <el-select v-model="changeRow.docTitleId">
                        <el-option
                                v-for="item in doctitlelist"
                                :label="item.constantName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="是否参与排班" :label-width="formLabelWidth">
                    <el-select v-model="changeRow.isScheduling">
                        <el-option label="是" value="是"></el-option>
                        <el-option label="否" value="否"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="所在科室名称" :label-width="formLabelWidth">
                    <el-select v-model="changeRow.deptId">
                        <el-option
                                v-for="item in deptlist"
                                :label="item.deptName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="挂号级别名称" :label-width="formLabelWidth">
                    <el-select v-model="changeRow.registLeId">
                        <el-option
                                v-for="item in registlevellist"
                                :label="item.registName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="changeDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitSave">确 定</el-button>
            </div>
        </el-dialog>

        <!--新增对话框-->
        <el-dialog title="科室信息修改" :visible.sync="addDialogVisible" width="25%">
            <el-form>
                <el-form-item label="用户ID" :label-width="formLabelWidth">
                    <el-input v-model="addRow.id" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="登录名" :label-width="formLabelWidth">
                    <el-input v-model="addRow.userName" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="密码" :label-width="formLabelWidth">
                    <el-input v-model="addRow.password" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="真实姓名" :label-width="formLabelWidth">
                    <el-input v-model="addRow.realName" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="用户类别" :label-width="formLabelWidth">
                    <el-select v-model="addRow.useType" placeholder="请选择用户类别">
                        <el-option label="医院管理员" value="1"></el-option>
                        <el-option label="挂号员" value="2"></el-option>
                        <el-option label="门诊医生" value="3"></el-option>
                        <el-option label="医技医生" value="4"></el-option>
                        <el-option label="药房操作员" value="5"></el-option>
                        <el-option label="财务管理员" value="6"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="医生职称" :label-width="formLabelWidth">
                    <el-select v-model="addRow.docTitleId">
                        <el-option
                                v-for="item in doctitlelist"
                                :label="item.constantName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="是否参与排班" :label-width="formLabelWidth">
                    <el-select v-model="addRow.isScheduling">
                        <el-option label="是" value="是"></el-option>
                        <el-option label="否" value="否"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="所在科室名称" :label-width="formLabelWidth">
                    <el-select v-model="addRow.deptId">
                        <el-option
                                v-for="item in deptlist"
                                :label="item.deptName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="挂号级别名称" :label-width="formLabelWidth">
                    <el-select v-model="addRow.registLeId">
                        <el-option
                                v-for="item in registlevellist"
                                :label="item.registName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitAdd">确 定</el-button>
            </div>
        </el-dialog>


    </div>
</template>

<script>
    import {makeUserType} from '../../../src/TypeFormat'
    import {makeYNType} from '../../../src/TypeFormat'

    export default {
        inject:['reload'],
        data() {
            return {
                addDialogVisible: false,
                queryUserString: "",
                value1: true,
                deleteRow:{},
                changeRow: {},
                addRow: {},
                maxid: 0,
                changeDialogVisible: false,
                formLabelWidth: '20%',
                currentPage: 1,
                pageSize: 3,
                tableDataEnd: [],
                userlist: [],
                registlevellist: [],
                deptlist: [],
                doctitlelist: []
            }
        },
        methods: {
            submitAdd(){
                this.addDialogVisible = false
                // delete this.updateRow.constantitem    //删除多余的属性，不用往后台传递
                console.log(this.addRow)
                let ue = this.$qs.stringify(this.addRow)
                this.$axios.get("http://localhost:8080/userzgy/add?"+ue).then(function (res) {
                    console.log(res)
                })
                this.reload()
            },
            addDialog() {
                this.addDialogVisible = true
                this.addRow.id = this.maxid + 1
            },
            queryUser(){
                let that = this
                this.$axios.get("http://localhost:8080/userzgy/list?name=" + that.queryUserString).then(function (res) {
                    that.userlist = res.data
                })
                console.log(this.queryUserString)
            },
            deleteDialog(row){
                this.deleteRow = row
                console.log(this.deleteRow)
                this.open()
            },
            open() {
                this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // this.$message({
                    //     type: 'success',
                    //     message: '删除成功!'
                    // });
                    this.deleteDialogTrue()
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            deleteDialogTrue(){
                let that = this
                this.$axios.get("http://localhost:8080/userzgy/delete?id="+that.deleteRow.id).then(function (res) {
                    console.log(res)
                    console.log(that.deleteRow.id)
                })
                this.reload()
            },
            submitSave() {
                this.changeDialogVisible = false
                // console.log(this.updateRow.deptId)
                // console.log(this.updateRow.realName)
                delete this.changeRow.constantitem    //删除多余的属性，不用往后台传递
                delete this.changeRow.department
                delete this.changeRow.registlevel
                //修改保存到数据库中，以json对象为单位进行传参
                let ue = this.$qs.stringify(this.changeRow)
                this.$axios.get("http://localhost:8080/userzgy/update?"+ue).then(function (res) {
                    console.log(res)
                })
                this.reload()
            },
            changeDialog(row) {
                this.changeDialogVisible = true
                console.log(row)
                this.changeRow = row
            },
            handleSizeChange(val) {
                this.pageSize = val
                this.handleCurrentChange(this.currentPage)
            },
            handleCurrentChange(val) {
                this.currentPage = val
                this.currentChangePage()
            },
            currentChangePage() {
                let start = (this.currentPage - 1) * this.pageSize
                let end = this.currentPage * this.pageSize
                this.tableDataEnd = []
                this.tableDataEnd = this.userlist.slice(start, end)
                // deptlist.slice((currentPage - 1) * pageSize,currentPage * pageSize)
            },
            formatUserType(user) {
                return makeUserType(user)
            },
        },
        name: "User",
        created() {
            let that = this
            this.$axios.get("http://localhost:8080/userzgy/list").then(function (res) {
                that.userlist = res.data
                console.log("用户列表：")
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/deptzgy/list").then(function (res) {
                that.deptlist = res.data
                console.log("部门列表：")
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/registerzgy/list").then(function (res) {
                that.registlevellist = res.data
                console.log("挂号信息列表：")
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/constantitemzgy/doctitlelist").then(function (res) {
                that.doctitlelist = res.data
                console.log("医生职称列表：")
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/userzgy/maxid").then(function (res) {
                that.maxid = res.data
                console.log(res.data)
            })
        }
    }
</script>

<style scoped>

</style>