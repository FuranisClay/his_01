<template>
    <div class="login">
        <el-form label-width="80px">
            <el-form-item label="用户名">
                <el-input v-model="ename"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input type="password" v-model="pwd"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button @click="submit">登录</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                ename: "",
                pwd: ""
            }
        },
        methods: {
            submit() {
                let en = this.ename
                let pw = this.pwd
                let that = this
                this.$axios.get("http://localhost:8080/User/validate?rn=" + en + "&pw=" + pw).then(function (res) {
                    console.log(res.data)
                    if (res.data == null || res.data == "") {
                        that.$message.error("登录失败，请重新尝试！")
                    } else {
                        that.$store.commit('emp',res.data)
                        that.$router.push("/his")
                    }
                })
            }
        }
    }
</script>

<style scoped>
    .login {
        width: 300px;
        margin: 30px auto;
    }
</style>