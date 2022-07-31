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
                    :data="medlist"
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
                        prop="itemCode"
                        label="项目编码"
                        width="130px"
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
                        width="130px"
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
                medlist: []
            }
        },
        name: "Drugpay",
        created() {
            let that = this
            this.$axios.get("http://localhost:8080/fmeditem/list").then(function (res) {
                that.medlist = res.data
                console.log(res.data)
            })
        }
    }
</script>

<style scoped>

</style>