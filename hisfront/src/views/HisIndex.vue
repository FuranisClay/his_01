<template>
    <div>
        <el-container>
            <el-header>
				<hr>
                <el-row>
                    <el-col span="5" style="float: left;">{{$store.state.emp.realName}},欢迎登录</el-col>
                    <el-col span="5" style="float: right;">
                    	  <i class="el-icon-setting" style="margin-right: 15px"></i>
                    	  <router-link to="/login" style="text-decoration: none;color: black">退出登录</router-link> 
                    </el-col>
                </el-row>
				<hr>
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
        background-color: ;
    }
    .el-container .el-aside{
        background-color: ;
    }
    .el-container .el-container .el-container .el-main{
        height: 750px;
        /*background-color: blue;*/
    }
    .el-container .el-container .el-container .el-footer{
        background-color: orange;
    }
</style>