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
                                v-model="queryDrugString"
                                type="text"
                                placeholder="请输入拼音助记码">
                        </el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="15">
                    <el-form-item>
                        <el-button
                                type="primary"
                                @click="querydrug"
                                icon="el-icon-search">查询非药品收费项目
                        </el-button>
                    </el-form-item>
                </el-col>
                <el-col :span="30">
                    <el-form-item>
                        <el-button
                                type="primary"
                                @click="addDialog"
                                icon="el-icon-search">新增非药品收费项目
                        </el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <template>
            <el-table
                    ref="multipleTable"
                    :data="medlist.slice((currentPage - 1) * pageSize,currentPage * pageSize)"
                    :row-style="{height: 90 + 'px'}"
                    tooltip-effect="dark"
                    height="520"
                    style="width: 90%; margin: 0 auto;"
            >
                <el-table-column
                        prop="id"
                        label="ID"
                        width="50px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="itemCode"
                        label="项目编码"
                        width="95px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="mnemonicCode"
                        label="拼音助记码"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="itemName"
                        label="项目名称"
                        width="80px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="format"
                        label="规格"
                        width="80px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="price"
                        label="单价"
                        width="50px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="expenseclass.expName"
                        label="所属费用科目名称"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="department.deptName"
                        label="执行科室名称"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="creationDate"
                        label="创建时间"
                        width="100px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="lastUpdateDate"
                        label="最后修改时间"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="recordType"
                        label="项目类型"
                        width="130px"
                        align="center">
                    <template slot-scope="scope">
                        <span style="">{{ formatRecordType(scope.row.recordType) }}</span>
                    </template>
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


        <!--修改对话框-->
        <el-dialog title="非药品收费项目信息修改" :visible.sync="changeDialogVisible" width="25%">
            <el-form>
                <el-form-item label="ID" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.id" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="项目编码" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.itemCode" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="拼音助记码" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.mnemonicCode" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="项目名称" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.itemName" @input="changeTurnPinyin" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="规格" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.format" @input="turnPinyin" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="单价" :label-width="formLabelWidth">
                    <el-input v-model="changeRow.price" @input="turnPinyin" style="width: 75%;"></el-input>
                </el-form-item>

                <el-form-item label="所属费用科目名称" :label-width="formLabelWidth">
                    <el-select v-model="changeRow.expClassId">
                        <el-option
                                v-for="item in expenseclassList"
                                :label="item.expName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="执行科室名称" :label-width="formLabelWidth">
                    <el-select v-model="changeRow.deptId">
                        <el-option
                                v-for="item in deptlist"
                                :label="item.deptName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="项目类型" :label-width="formLabelWidth">
                    <el-select v-model="changeRow.recordType" placeholder="请选择项目类型">
                        <el-option label="检查" value="1"></el-option>
                        <el-option label="检验" value="2"></el-option>
                        <el-option label="处置" value="3"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="changeDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitSave">确 定</el-button>
            </div>
        </el-dialog>


        <!--新增非药品收费项目信息-->
        <el-dialog title="新增非药品收费项目信息" :visible.sync="addDialogVisible" width="25%">
            <el-form>
                <el-form-item label="ID" :label-width="formLabelWidth">
                    <el-input v-model="addRow.id" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="项目编码" :label-width="formLabelWidth">
                    <el-input v-model="addRow.itemCode" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="拼音助记码" :label-width="formLabelWidth">
                    <el-input v-model="addRow.mnemonicCode" disabled="true" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="项目名称" :label-width="formLabelWidth">
                    <el-input v-model="addRow.itemName" @input="addPinyin" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="规格" :label-width="formLabelWidth">
                    <el-input v-model="addRow.format" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="单价" :label-width="formLabelWidth">
                    <el-input v-model="addRow.price" style="width: 75%;"></el-input>
                </el-form-item>
                <el-form-item label="所属费用科目名称" :label-width="formLabelWidth">
                    <el-select v-model="addRow.expClassId">
                        <el-option
                                v-for="item in expenseclassList"
                                :label="item.expName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="执行科室名称" :label-width="formLabelWidth">
                    <el-select v-model="addRow.deptId">
                        <el-option
                                v-for="item in deptlist"
                                :label="item.deptName"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="项目类型" :label-width="formLabelWidth">
                    <el-select v-model="addRow.recordType" placeholder="请选择项目类型">
                        <el-option label="检查" value="1"></el-option>
                        <el-option label="检验" value="2"></el-option>
                        <el-option label="处置" value="3"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitAdd">确 定</el-button>
            </div>
        </el-dialog>


        <template>
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-sizes="[3, 5, 10, 15]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="medlist.length">
            </el-pagination>
        </template>
    </div>
</template>

<script>
    import {pinyin} from '../../../src/chineseTurnPinyin.js'
    import {makeRecordType} from '../../../src/TypeFormat'

    export default {
        data() {
            return {
                currentPage: 1,
                pageSize: 3,
                tableDataEnd: [],
                formLabelWidth: '20%',
                maxid: 0,
                medlist: [],
                queryDrugString: "",
                changeDialogVisible: false,
                addDialogVisible: false,
                changeRow: {},
                deleteRow: {},
                addRow: {},
                deptlist: [],
                expenseclassList: []
            }
        },
        methods: {
            formatRecordType(record) {
                return makeRecordType(record)
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
                this.tableDataEnd = this.medlist.slice(start, end)
                // deptlist.slice((currentPage - 1) * pageSize,currentPage * pageSize)
            },
            changeTurnPinyin() {
                // console.log(pinyin.getCamelChars(this.changeRow.registName).toLowerCase())
                this.changeRow.mnemonicCode = pinyin.getCamelChars(this.changeRow.itemName).toUpperCase();
            },
            submitAdd() {
                this.addDialogVisible = false
                console.log(this.addRow)
                let ue = this.$qs.stringify(this.addRow)
                this.$axios.get("http://localhost:8080/fmeditemzgy/add?" + ue).then(function (res) {
                    console.log(res)
                })
                this.reload()
            },
            submitSave() {
                console.log(this.changeRow)
                this.changeDialogVisible = false
                delete this.changeRow.department    //删除多余的属性，不用往后台传递
                delete this.changeRow.expenseclass
                this.changeRow.lastUpdateDate =
                    console.log(this.changeRow)
                //修改保存到数据库中，以json对象为单位进行传参
                let ue = this.$qs.stringify(this.changeRow)
                this.$axios.get("http://localhost:8080/fmeditemzgy/update?" + ue).then(function (res) {
                    console.log(res)
                })
                this.reload()
            },
            addDialog() {
                this.addDialogVisible = true
                this.addRow.id = this.maxid + 1
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
            querydrug() {
                let that = this
                this.$axios.get("http://localhost:8080/fmeditemzgy/list?string=" + this.queryDrugString).then(function (res) {
                    that.medlist = res.data
                })
                console.log(this.queryDrugString)
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
            deleteDialogTrue() {
                let that = this
                this.$axios.get("http://localhost:8080/fmeditemzgy/delete?id=" + that.deleteRow.id).then(function (res) {
                    console.log(res)
                    console.log(that.deleteRow.id)
                })
                this.reload()
            },
            addPinyin() {
                this.addRow.mnemonicCode = pinyin.getCamelChars(this.addRow.itemName).toUpperCase();
            }
        },
        name: "Drugpay",
        created() {
            let that = this
            this.$axios.get("http://localhost:8080/fmeditemzgy/list").then(function (res) {
                that.medlist = res.data
                console.log("listsdfsafasfasfasfsadfasfdasfadsfsadfa")
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/fmeditemzgy/maxid").then(function (res) {
                that.maxid = res.data
                // console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/expenseclasszgy/expenseclasslist").then(function (res) {
                that.expenseclassList = res.data
                // console.log("123")
                // console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/deptzgy/list").then(function (res) {
                that.deptlist = res.data
                // console.log("部门")
                // console.log(res.data)
            })
        }
    }
</script>

<style scoped>

</style>