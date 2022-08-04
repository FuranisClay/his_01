<template>
    <div>
        <div style="text-align: center"><h3>新增排班规则</h3></div>
        <div style="text-align: center;  margin-top: 30px">
            <el-form :inline="true" :model="form" class="demo-form-inline">
                <el-form-item label="科室选择：">
                    <el-select v-model="form.deptName" placeholder="请选择科室类型">
                        <el-option label="--请选择--"></el-option>
                        <el-option
                                v-for="item in deptlist"
                                :label="item.deptName"
                                :value="item.id"
                        >
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="挂号级别：">
                    <el-select v-model="form.level" placeholder="请选择挂号级别">
                        <el-option label="--请选择--" value=""></el-option>
                        <el-option
                                v-for="item in registlist"
                                :label="item.registName"
                                :value="item.id"
                        ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" icon="el-icon-search" @click="">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" plain icon="el-icon-delete" @click="">清空</el-button>
                </el-form-item>
            </el-form>
            <el-form>
                <el-table
                        :data="userlist"
                        border
                        style="width: 100%">
                    <!--                    <el-table-column-->
                    <!--                            type="selection"-->
                    <!--                            header-align="center"-->
                    <!--                            align="center"-->
                    <!--                            width="50">-->
                    <!--                    </el-table-column>-->
                    <el-table-column
                            label="医生姓名"
                            width="100">
                        <template slot-scope="scope">
                            <span style="margin-left: 10px">{{ scope.row.realName }}</span>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期一 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox change="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期一 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期二 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期二 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期三 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期三 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期四 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期四 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期五 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期五 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期六 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期六 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期日 上午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="星期日 下午"
                            width="100">
                        <template slot-scope="scope">
                            <div style="margin-left: 30px">
<!--                                <el-checkbox @click="onSubmit" v-model=""></el-checkbox>-->
                                <el-checkbox @click="onSubmit"></el-checkbox>
                            </div>
                        </template>
                    </el-table-column>
                </el-table>
                <div style="margin: 20px 480px;">
                    <el-form-item label="排班规则名称:" label-width="120px">
                        <el-input v-model="form.name" size="medium"></el-input>
                    </el-form-item>
                </div>
                <div>
                    <el-form-item>
                        <el-button type="warning" @click="onSubmit">保存</el-button>
                        <el-button type="primary" plain>取消</el-button>
                    </el-form-item>
                </div>
            </el-form>
        </div>
    </div>
</template>

<script>
    import ElForm from "element-ui/packages/form/src/form";

    export default {
        components: {ElForm},
        data() {
            return {
                deptlist: [],
                registlist: [],
                userlist: [],
                checkedlist: [],
                form: {
                    deptName: '',
                    level: ''
                },
                deptNames: []
            }
        },
        methods: {
            selDepartName() {

            },
            onSubmit() {
                console.log(this.scope.row);
            }
        },
        created() {
            let that = this
            this.$axios.get("http://localhost:8080/deptzgy/list").then(function (res) {
                that.deptlist = res.data
                // console.log("部门")
                // console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/registerzgy/list").then(function (res) {
                that.registlist = res.data
                console.log("挂号等级")
                console.log(res.data)
            })
            this.$axios.get("http://localhost:8080/userzgy/list").then(function (res) {
                that.userlist = res.data
                console.log(res.data)
            })
        }
    }
</script>
