<template>
    <div>
        <el-form
                :inline="true"
                :model="formInline"
                :rules="rules"
                status-icon
                style="margin-top: -15px; height: 35px;"
                ref="formInline"
                size="mini">
            <el-row>
                <el-col :span="25">
                    <el-date-picker
                            format="yyyy 年 MM 月 dd 日"
                            value-format="yyyy-MM-dd"
                            v-model="timevalue"
                            type="daterange"
                            range-separator="至"
                            start-placeholder="开始日期"
                            end-placeholder="结束日期">
                    </el-date-picker>
                </el-col>
                <el-col :span="5">
                    <el-form-item>
                        <el-button
                                type="primary"
                                @click="querySchedule"
                                icon="el-icon-search">查询医生排班
                        </el-button>
                    </el-form-item>
                </el-col>
                <el-col :span="1">
                    <el-form-item>
                        <el-button
                                @click="queryRule"
                                type="primary"
                                icon="el-icon-search">查询排班规则
                        </el-button>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item>
                        <el-button
                                @click="addSchedule"
                                type="primary"
                                icon="el-icon-search">新增排班规则
                        </el-button>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item>
                        <el-button
                                @click="generateSchedule"
                                type="primary"
                                icon="el-icon-search">生成排班计划
                        </el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <template style="margin: 0 auto">
            <el-table
                    ref="multipleTable"
                    :data="schedulinglist.slice((currentPage - 1) * pageSize,currentPage * pageSize)"
                    :row-style="{height: 90 + 'px'}"
                    tooltip-effect="dark"
                    height="520"
                    style="width: 80%; margin: 0 auto;"
            >
                <el-table-column
                        prop="id"
                        label="ID"
                        width="190px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="schedDate"
                        label="排班日期"
                        width="230px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="department.deptName"
                        label="科室"
                        width="230px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="user.realName"
                        label="医生"
                        width="230px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="noon"
                        label="午别"
                        width="230px"
                        align="center">
                </el-table-column>
                <!--                <el-table-column-->
                <!--                        label="编辑">-->
                <!--                    <template #default="scope">-->
                <!--                        <el-button @click="changeDialog(scope.row)" icon="el-icon-edit">修改</el-button>-->
                <!--                        <el-button @click="deleteDialog(scope.row)" icon="el-icon-delete">删除</el-button>-->
                <!--                    </template>-->
                <!--                </el-table-column>-->
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
                    :total="schedulinglist.length">
            </el-pagination>
        </template>

        <el-dialog :visible.sync="addScheduleVisible" width="90%">
            <addSchedule></addSchedule>
        </el-dialog>

        <el-dialog :visible.sync="queryRuleVisible" width="90%">
            <queryRule></queryRule>
        </el-dialog>

        <el-dialog :visible.sync="generateScheduleVisible" width="90%">
            <generateSchedule></generateSchedule>
        </el-dialog>

    </div>
</template>

<script>
    import addSchedule from '../../../src/components/root/ScheduleAdd'
    import queryRule from './Rule'
    import generateSchedule from "./ScheduleGenerate";

    export default {
        data() {
            return {
                currentPage: 1,
                pageSize: 3,
                tableDataEnd:[],
                generateScheduleVisible: false,
                queryRuleVisible: false,
                addScheduleVisible: false,
                timearray: [],
                timevalue: "",
                starttime: "",
                endtime: "",
                formLabelWidth: '20%',
                schedulinglist: [],
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
            },
            generateSchedule() {
                this.generateScheduleVisible = true
            },
            queryRule() {
                this.queryRuleVisible = true
            },
            addSchedule() {
                this.addScheduleVisible = true
            },
            addScheduleFalse() {
                console.log("点击取消2")
                // console.log("hhhhhhh")
                this.addScheduleVisible = false
            },
            querySchedule() {
                this.timevalue = this.timevalue + ""
                // this.starttime = this.timevalue.slice(0,this.timevalue.indexOf(','))
                // this.endtime = this.timevalue.slice(this.timevalue.indexOf(',')+1,this.timevalue.length)
                // console.log("起始时间"+this.starttime)
                // console.log("结束时间"+this.endtime)
                // console.log("时间为："+this.timevalue)
                let that = this
                this.$axios.get("http://localhost:8080/schedulingzgy/list?string=" + that.timevalue).then(function (res) {
                    that.schedulinglist = res.data
                })
            }
        },
        created() {
            let that = this
            this.$axios.get("http://localhost:8080/schedulingzgy/list").then(function (res) {
                that.schedulinglist = res.data
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/registerzgy/maxid").then(function (res) {
                that.maxid = res.data
                console.log(res.data)
            })
        },
        components: {
            addSchedule,
            queryRule,
            generateSchedule
        },
        mounted() {
            addSchedule.methods.addScheduleFalse()
        },
        name: "Schedule"
    }
</script>

<style scoped>

</style>