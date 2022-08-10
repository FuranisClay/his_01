<template>
    <div>
        <div style="text-align: center"><h3>排班规则表</h3></div>
        <div style="text-align: center;  margin-top: 30px">
            <el-form>
                <el-form-item label="科室选择：">
                    <el-select v-model="deptId" placeholder="请选择科室类型：">
                        <el-option label="--请选择--" value=""></el-option>
                        <el-option
                                v-for="item in deptlist"
                                :label="item.deptName"
                                :value="item.id"
                        >
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button @click="getData()">查询</el-button>
                    <el-button type="danger" @click="deleteRules" :disabled="dataListSelections.length <= 0">批量删除</el-button>
                </el-form-item>
            </el-form>
        </div>
        <el-table
                :data="rulelist.slice((currentPage - 1) * pageSize,currentPage * pageSize)"
                border
                @selection-change="selectionChangeHandle"
                style="width: 100%;">
            <el-table-column
                    type="selection"
                    header-align="center"
                    align="center"
                    width="50">
            </el-table-column>
            <el-table-column
                    type="index"
                    :index="indexMethod"
                    label="序号"
                    width="50"
                    header-align="center"
                    align="center">
            </el-table-column>
            <el-table-column
                    prop="ruleName"
                    header-align="center"
                    align="center"
                    label="规则名称">
            </el-table-column>
            <el-table-column
                    prop="department.deptName"
                    header-align="center"
                    align="center"
                    label="科室名称">
            </el-table-column>
            <el-table-column
                    prop="user.realName"
                    header-align="center"
                    align="center"
                    label="医生姓名">
            </el-table-column>
            <el-table-column
                    prop="week"
                    header-align="center"
                    align="center"
                    label="星期">
            </el-table-column>
        </el-table>
        <template>
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-sizes="[3, 5, 10, 15]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="rulelist.length">
            </el-pagination>
        </template>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                deptId: 0,
                deptlist: [],
                userlist: [],
                rulelist: [],
                currentPage: 1,
                pageSize: 3,
                tableDataEnd: [],
                dataListSelections: []
            }
        },
        methods: {
            deleteRules() {
                let that = this
                this.$axios.get("http://localhost:8080/rulezgy/delete?list=" + that.dataListSelections).then(function (res) {
                    // that.rulelist = res.data
                    // console.log("规则列表：")
                    // console.log(res.data)
                })
                this.currentChangePage()
            },
            getData() {
                let that = this
                this.$axios.get("http://localhost:8080/rulezgy/list?deptno=" + that.deptId).then(function (res) {
                    that.rulelist = res.data
                    console.log("规则列表：")
                    console.log(res.data)
                })
                this.currentChangePage()
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
                this.tableDataEnd = this.rulelist.slice(start, end)
                // deptlist.slice((currentPage - 1) * pageSize,currentPage * pageSize)
            },
            selectionChangeHandle(val) {
                console.log(val)
                this.dataListSelections.push(val[val.length-1].id)
                console.log("删除列表：")
                console.log(this.dataListSelections)
            }
        },
        components: {
            // AddOrUpdate
        },
        //dom未生成之前触发
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
            this.$axios.get("http://localhost:8080/rulezgy/list?deptno=" + that.deptId).then(function (res) {
                that.rulelist = res.data
                console.log("规则列表：")
                console.log(res.data)
            })
            this.currentChangePage()
        },
        name: "rule"
    }
</script>

<style scoped>

</style>