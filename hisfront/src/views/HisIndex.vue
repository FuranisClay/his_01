<template>
    <div>
        <el-container>
            <el-header>
                <el-row>
                    <el-col :span="2">{{$store.state.emp.realName}},欢迎登录</el-col>
                    <el-col :span="22">个人信息/退出登录</el-col>
                </el-row>
            </el-header>
            <el-container>
                <el-aside width="200px">
                    <el-menu
                            :router=true
                            default-active="2"
                            class="el-menu-vertical-demo">
                        <el-submenu v-for="sysmenu,index in sysMenuList" :index="index">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>{{sysmenu.menuName}}</span>
                            </template>
                            <el-menu-item-group>
                                <el-menu-item v-for="childmenu,index in sysmenu.childMenu" :index="childmenu.url">
<!--                                    <router-link :to="childmenu.url">{{childmenu.menuName}}</router-link>-->
                                    {{childmenu.menuName}}
                                </el-menu-item>
                            </el-menu-item-group>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <el-container>
                    <el-main>
                        <router-view></router-view>
                    </el-main>
                    <el-footer>Footer</el-footer>
                </el-container>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "HisIndex",
        data(){
            return{
                sysMenuList:[]
            }
        },
        created() {
            let that = this
            //根据登录员工的角色，获取该角色对应的权限列表
            let rid = this.$store.state.emp.useType
            this.$axios.get("http://localhost:8080/sysmenu/list?rid="+rid).then(function (res) {
                console.log(res.data)
                that.sysMenuList=res.data
            })
        }
    }
</script>

<style scoped>
    .el-header{
        background-color: red;
    }
    .el-container .el-aside{
        background-color: pink;
    }
    .el-container .el-container .el-container .el-main{
        height: 750px;
        /*background-color: blue;*/
    }
    .el-container .el-container .el-container .el-footer{
        background-color: orange;
    }
</style>