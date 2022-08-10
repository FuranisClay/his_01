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
        <div style="margin: 20px 480px;">
            <div style="display: inline">
                <span class="demonstration">选择排班周次：</span>
                <el-date-picker width="300px" v-model="value" type="week" :format="start+' 至 '+end" @change="showDate"
                                :picker-options="onPicker" placeholder="选择周">
                </el-date-picker>
            </div>
            <el-button type="primary" style="margin-left: 30px" @click="generateScheduling">选取规则生成排班计划</el-button>
        </div>
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
        <!-- 弹窗, 新增 / 修改 -->
        <!--        <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getData"></add-or-update>-->
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
                dataListSelections: [],
                maxid: 0,

                value: "",
                start: "", //起始日期
                end: "", //截止日期
                onPicker: {
                    firstDayOfWeek: 1, //周起始日为星期一
                    disabledDate(value) {
                        let today = new Date(); //获取今天日期
                        let d = today.getDay(); //计算今天是周几。如果是周天，d=0
                        let w = 0;
                        if (d === 0) {
                            w = 7;
                        } else {
                            w = d;
                        }
                        let startTime = today.setDate(today.getDate() - w);
                        return value.getTime() < startTime; //不可选本周一以前的时间
                        // let endTime = today.setDate(today.getDate() + (7 - w));
                        // return value.getTime() > endTime; //不可选本周日以后的时间
                    },
                }
            }
        },
        methods: {
            generateScheduling() {
                console.log(this.dataListSelections)
                console.log(this.start)
                for (let i = 0; i < this.dataListSelections.length; i++) {
                    let time = this.dayjs(this.start).add(i, "day").$d
                    let deptid = this.dataListSelections[i].deptId
                    let userid = this.dataListSelections[i].userId
                    let ruleid = this.dataListSelections[i].id
                    let schedulesplit = this.dataListSelections[i].week.slice(2 * i, 2 * i + 2)
                    for (let j = 0; j < 7; j++) {
                        time = this.dayjs(this.start).add(j, "day").$d
                        time = this.splitDate(time)
                        schedulesplit = this.dataListSelections[i].week.slice(2 * j, 2 * j + 2)
                        console.log("**************************")
                        console.log(time)
                        console.log("time" + typeof time)
                        console.log(schedulesplit)
                        console.log("schedulesplit" + typeof schedulesplit)
                        console.log(deptid)
                        console.log("deptid" + typeof deptid)
                        console.log(userid)
                        console.log("userid" + typeof userid)
                        console.log(ruleid)
                        console.log("ruleid" + typeof ruleid)
                        console.log("___________________________")
                        this.$axios.get("http://localhost:8080/schedulingzgy/add?scheddate=" + time + "&deptid=" + deptid + "&userid=" + userid + "&noon=" + schedulesplit + "&ruleid=" + ruleid).then(function (res) {
                            console.log(res.data)
                        })
                    }
                }
                let endTime = this.dayjs(this.start).add(1, "day").$d;
                endTime = this.splitDate(endTime)
                // console.log(endTime)
            },
            showDate() {
                let startTime = this.dayjs(this.value).subtract(1, "day").$d;
                let endTime = this.dayjs(startTime).add(6, "day").$d;
                this.start = this.splitDate(startTime);
                this.end = this.splitDate(endTime);
                console.log("start:" + this.start)
                console.log("end:" + this.end)
            },
            splitDate(date) {
                return this.dayjs(date).format("YYYY-MM-DD");
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
                this.dataListSelections = val
                // this.dataListSelections.push(val[val.length - 1].id)
                // console.log("排班列表：")
                // console.log(this.dataListSelections)
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
        name: "ScheduleGenerate"
    }
</script>

<style scoped>

</style>

