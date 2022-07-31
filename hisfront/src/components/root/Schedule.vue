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
                    :data="schedulinglist"
                    :row-style="{height: 90 + 'px'}"
                    tooltip-effect="dark"
                    height="520"
                    style="width: 80%; margin: 0 auto;"
            >
                <el-table-column
                        prop="id"
                        label="ID"
                        width="90px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="schedDate"
                        label="排班日期"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="department.deptName"
                        label="科室"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="user.realName"
                        label="医生"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="noon"
                        label="午别"
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
    </div>
</template>

<script>
    export default {
        data() {
            return {
                formLabelWidth: '20%',
                schedulinglist: [],
                maxid: 0,
                changeDialogVisible: false,
                addDialogVisible: false,
                changeRow: {},
                deleteRow:{},
                addRow:{},
                queryRegistString: ""
            }
        },
        created() {
            let that = this
            this.$axios.get("http://localhost:8080/scheduling/list").then(function (res) {
                that.schedulinglist = res.data
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/register/maxid").then(function (res) {
                that.maxid = res.data
                console.log(res.data)
            })
        },
        name: "Schedule"
    }
</script>

<style scoped>

</style>