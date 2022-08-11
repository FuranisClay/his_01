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
                                v-model="queryRegistString"
                                type="text"
                                placeholder="请输入挂号信息编号">
                        </el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="15">
                    <el-form-item>
                        <el-button
                                type="primary"
                                @click="queryRegist"
                                icon="el-icon-search">查询挂号级别信息
                        </el-button>
                    </el-form-item>
                </el-col>
                <el-col :span="30">
                    <el-form-item>
                        <el-button
                                @click="addDialog"
                                type="primary"
                                icon="el-icon-search">新增挂号级别
                        </el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <template>
            <el-table
                    ref="multipleTable"
                    :data="registlist.slice((currentPage - 1) * pageSize,currentPage * pageSize)"
                    :row-style="{height: 90 + 'px'}"
                    tooltip-effect="dark"
                    height="520"
                    style="width: 90%; margin: 0 auto;"
            >
                <el-table-column
                        prop="id"
                        label="ID"
                        width="90px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="registCode"
                        label="号别编码"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="registName"
                        label="号别名称"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="sequenceNo"
                        label="显示顺序号"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="registFee"
                        label="挂号费"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="registQuota"
                        label="挂号限额"
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
                    :total="registlist.length">
            </el-pagination>
        </template>


        <!--        修改对话框-->
        <el-dialog title="挂号级别信息修改" :visible.sync="changeDialogVisible" width="25%">
            <el-form>
                <el-form-item label="ID" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.id" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="号别编码" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.registCode" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="号别名称" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.registName" @input="turnPinyin" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="显示顺序号" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.sequenceNo" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="挂号费" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.registFee" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="挂号限额" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.registQuota" style="width: 75%;"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="changeDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitSave">确 定</el-button>
            </div>
        </el-dialog>

        <!--        添加挂号级别对话框-->
        <el-dialog title="新增挂号级别信息" :visible.sync="addDialogVisible" width="25%">
            <el-form>
                <el-form-item label="ID" :label-width="formLabelWidth">
                    <el-input v-model="addRow.id" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="号别编码" :label-width="formLabelWidth">
                    <el-input v-model="addRow.registCode" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="号别名称" :label-width="formLabelWidth">
                    <el-input v-model="addRow.registName" @input="addPinyin" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="显示顺序号" :label-width="formLabelWidth">
                    <el-input v-model="addRow.sequenceNo" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="挂号费" :label-width="formLabelWidth">
                    <el-input v-model="addRow.registFee" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="挂号限额" :label-width="formLabelWidth">
                    <el-input v-model="addRow.registQuota" style="width: 75%;"></el-input>
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
    import {pinyin} from '../../../src/chineseTurnPinyin.js'

    export default {
        inject:['reload'],
        data() {
            return {
                currentPage: 1,
                pageSize: 3,
                tableDataEnd: [],
                formLabelWidth: '20%',
                registlist: [],
                maxid: 0,
                changeDialogVisible: false,
                addDialogVisible: false,
                changeRow: {},
                deleteRow: {},
                addRow: {},
                queryRegistString: ""
            }
        },
        methods: {
            queryRegist() {
                let that = this
                this.$axios.get("http://localhost:8080/registerzgy/list?string=" + this.queryRegistString).then(function (res) {
                    that.registlist = res.data
                })
                console.log(this.queryRegistString)
            },
            submitSave() {
                this.changeDialogVisible = false
                // console.log(this.updateRow.deptId)
                // console.log(this.updateRow.realName)
                // delete this.updateRow.department    //删除多余的属性，不用往后台传递
                //修改保存到数据库中，以json对象为单位进行传参
                let ue = this.$qs.stringify(this.changeRow)
                this.$axios.get("http://localhost:8080/registerzgy/update?" + ue).then(function (res) {
                    console.log(res)
                })
                this.reload()
            },
            addDialog() {
                this.addDialogVisible = true
                this.addRow.id = this.maxid + 1
            },
            submitAdd() {
                this.addDialogVisible = false
                console.log(this.addRow)
                let ue = this.$qs.stringify(this.addRow)
                this.$axios.get("http://localhost:8080/registerzgy/add?" + ue).then(function (res) {
                    console.log(res)
                })
                this.reload()
            },
            addPinyin() {
                this.addRow.registCode = pinyin.getCamelChars(this.addRow.registName).toLowerCase();
            },
            turnPinyin() {
                // console.log(pinyin.getCamelChars(this.changeRow.registName).toLowerCase())
                this.changeRow.registCode = pinyin.getCamelChars(this.changeRow.registName).toLowerCase();
            },
            changeDialog(row) {
                this.changeDialogVisible = true
                console.log(row)
                this.changeRow = row
            },
            deleteDialog(row) {
                this.deleteRow = row
                console.log(this.deleteRow)
                this.open()
            },
            deleteDialogTrue() {
                let that = this
                this.$axios.get("http://localhost:8080/registerzgy/delete?id=" + that.deleteRow.id).then(function (res) {
                    console.log(res)
                    console.log(that.deleteRow.id)
                })
                this.reload()
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
                this.tableDataEnd = this.deptlist.slice(start, end)
                // deptlist.slice((currentPage - 1) * pageSize,currentPage * pageSize)
            }
        },
        name: "Register",
        created() {
            let that = this
            this.$axios.get("http://localhost:8080/registerzgy/list").then(function (res) {
                that.registlist = res.data
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/registerzgy/maxid").then(function (res) {
                that.maxid = res.data
                console.log(res.data)
            })
        }
    }
</script>


<style scoped>

</style>