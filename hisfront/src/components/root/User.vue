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
                    :data="userlist"
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
                        width="60px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="docTitleId"
                        label="医生职称"
                        width="60px"
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
                        label="所在科室ID"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="registLeId"
                        label="挂号级别ID"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        label="编辑">
                    <template #default="scope">
                        <el-button @click="" icon="el-icon-edit">修改</el-button>
                        <el-button @click="" icon="el-icon-delete">删除</el-button>
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
    </div>
</template>

<script>
    export default {
        data() {
            return {
                userlist: []
            }
        },
        name: "User",
        created() {
            let that = this
            this.$axios.get("http://localhost:8080/user/list").then(function (res) {
                that.userlist = res.data
                console.log(res.data)
            })
        }
    }
</script>

<style scoped>

</style>