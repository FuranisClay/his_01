<template>
  <div id="app">
	  门诊医生模块
	  <br />
    <nav>
      <router-link to="/">Home</router-link> |
<!--      <router-link to="/about">About</router-link> |
	  <router-link to="/hisindex">东软云医院</router-link> -->
	  <router-link to="/physician_patient">患者查看</router-link> |
	  <router-link to="/doctor">医生诊疗</router-link> |
	  <router-link to="/expense_query">费用查询</router-link> 
    </nav>
    <router-view/>
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
