<template>
    <div style="margin-top: 50px;background-color:#E2FFB7;">
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
                                v-model="queryDeptString"
                                type="text"
                                placeholder="请输入科室编号">
                        </el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="15">
                    <el-form-item>
                        <el-button
                                type="primary"
                                @click="queryDept"
                                icon="el-icon-search">查询科室
                        </el-button>
                    </el-form-item>
                </el-col>
                <el-col :span="30">
                    <el-form-item>
                        <el-button
                                @click="addDialog"
                                type="primary"
                                icon="el-icon-search">新增科室
                        </el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <template>
            <el-table
                    ref="multipleTable"
                    :data="deptlist"
                    :row-style="{height: 90 + 'px'}"
                    tooltip-effect="dark"
                    height="520"
                    style="width: 80%; margin: 0 auto;"
            >
                <el-table-column
                        prop="id"
                        label="科室id"
                        width="90px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="deptCode"
                        label="科室编号"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="deptName"
                        label="科室名称"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="constantitem.constantName"
                        label="科室分类"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="deptType"
                        label="科室类型"
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
            <div class="block">
                <el-pagination
                        :page-sizes="[5, 10, 20, 50]"
                        :page-size="pageSize"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="total">
                </el-pagination>
            </div>
        </template>



        <!--        修改对话框-->
        <el-dialog title="科室信息修改" :visible.sync="changeDialogVisible" width="25%">
            <el-form>
                <el-form-item label="科室ID" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.id" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="科室编号" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.deptCode" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="科室名称" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.deptName" @input="turnPinyin" style="width: 75%;"></el-input>
                </el-form-item>

                <el-form-item label="科室分类" :label-width="formLabelWidth">
                    <el-select v-model="changeRow.deptCategoryId">
                        <el-option
                                v-for="item in deptCategoryList"
                                :label="item.constantName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="科室类型" :label-width="formLabelWidth">
                    <el-select v-model="changeRow.deptType" placeholder="请选择科室类型">
                        <el-option label="临床" value="1"></el-option>
                        <el-option label="医技" value="2"></el-option>
                        <el-option label="财务" value="3"></el-option>
                        <el-option label="行政" value="4"></el-option>
                        <el-option label="其他" value="5"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="changeDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitSave">确 定</el-button>
            </div>
        </el-dialog>


        <!--        新增科室对话框-->
        <el-dialog title="新增科室信息" :visible.sync="addDialogVisible" width="25%">
            <el-form>
                <el-form-item label="科室ID" :label-width="formLabelWidth">
                    <el-input v-model="addRow.id" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="科室编号" :label-width="formLabelWidth">
                    <el-input v-model="addRow.deptCode" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="科室名称" :label-width="formLabelWidth">
                    <el-input v-model="addRow.deptName" @input="addPinyin" style="width: 75%;"></el-input>
                </el-form-item>
                <!--                <el-form-item label="科室分类" :label-width="formLabelWidth">-->
                <!--                    <el-input v-model="addRow.deptCategoryId" style="width: 75%;"></el-input>-->
                <!--                </el-form-item>-->
                <el-form-item label="科室分类" :label-width="formLabelWidth">
                    <el-select v-model="addRow.deptCategoryId">
                        <el-option
                                v-for="item in deptCategoryList"
                                :label="item.constantName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <!--                <el-form-item label="科室类型" :label-width="formLabelWidth">-->
                <!--                    <el-input v-model="addRow.deptType" style="width: 75%;"></el-input>-->
                <!--                </el-form-item>-->
                <el-form-item label="科室类型" :label-width="formLabelWidth">
                    <el-select v-model="addRow.deptType" placeholder="请选择科室类型">
                        <el-option label="临床" value="1"></el-option>
                        <el-option label="医技" value="2"></el-option>
                        <el-option label="财务" value="3"></el-option>
                        <el-option label="行政" value="4"></el-option>
                        <el-option label="其他" value="5"></el-option>
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
    import {pinyin} from '../../../src/chineseTurnPinyin.js'

    export default {
        data() {
            return {
                changeDialogVisible: false,
                formLabelWidth: '20%',
                addDialogVisible: false,
                addRow: {},
                changeRow: {},
                deptlist: [],
                deptCategoryList: [],
                queryDeptString: "",
                maxid: 0,
                deleteRow:{}
            }
        },
        methods: {
            changeDialog(row) {
                this.changeDialogVisible = true
                console.log(row)
                this.changeRow = row
                if (this.changeRow.deptType == 1){
                    this.changeRow.deptTypeName="临床"
                }else if (this.changeRow.deptType == 2){
                    this.changeRow.deptTypeName="医技"
                }else if (this.changeRow.deptType == 3){
                    this.changeRow.deptTypeName="财务"
                }else if (this.changeRow.deptType == 4){
                    this.changeRow.deptTypeName="行政"
                }else if (this.changeRow.deptType == 5){
                    this.changeRow.deptTypeName="其他"
                }
            },
            submitSave() {
                this.changeDialogVisible = false
                // console.log(this.updateRow.deptId)
                // console.log(this.updateRow.realName)
                // delete this.updateRow.department    //删除多余的属性，不用往后台传递
                //修改保存到数据库中，以json对象为单位进行传参
                let ue = this.$qs.stringify(this.changeRow)
                this.$axios.get("http://localhost:8080/dept/update?"+ue).then(function (res) {
                    console.log(res)
                })
            },
            submitAdd(){
                this.addDialogVisible = false
                // delete this.updateRow.constantitem    //删除多余的属性，不用往后台传递
                console.log(this.addRow)
                let ue = this.$qs.stringify(this.addRow)
                this.$axios.get("http://localhost:8080/dept/add?"+ue).then(function (res) {
                    console.log(res)
                })
            },
            addDialog() {
                this.addDialogVisible = true
                this.addRow.id = this.maxid + 1
            },
            addPinyin() {
                this.addRow.deptCode = pinyin.getCamelChars(this.addRow.deptName).toUpperCase();
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
                this.$axios.get("http://localhost:8080/dept/delete?id="+that.deleteRow.id).then(function (res) {
                    console.log(res)
                    console.log(that.deleteRow.id)
                })
            },
            queryDept() {
                let that = this
                this.$axios.get("http://localhost:8080/dept/list?string=" + this.queryDeptString).then(function (res) {
                    that.deptlist = res.data
                })
                console.log(this.queryDeptString)
            }
        },
        name: "Department",
        created() {
            let that = this
            this.$axios.get("http://localhost:8080/dept/list").then(function (res) {
                that.deptlist = res.data
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/dept/maxid").then(function (res) {
                that.maxid = res.data
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/constantitem/categorylist").then(function (res) {
                that.deptCategoryList = res.data
                console.log(res.data)
            })
        }
    }
</script>

<style scoped>

</style>