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
                        label="疾病ID"
                        width="90px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="itemCode"
                        label="疾病助记编码"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="mnemonicCode"
                        label="疾病名称"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="itemName"
                        label="国际ICD编码"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="format"
                        label="疾病所属分类编码"
                        width="80px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="price"
                        label="疾病所属分类名称"
                        width="80px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="expenseclass.expName"
                        label="所属费用科目名称"
                        width="140px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="department.deptName"
                        label="疾病类型"
                        width="130px"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="creationDate"
                        label="显示顺序号"
                        width="100px"
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
        name: "Contents"
    }
</script>

<style scoped>

</style>