<template>
  <div id="app">
	  <br />
	  医生诊疗
    <nav>
      <router-link to="/home_medical_record">病历首页</router-link> |
	  <router-link to="/check_request">检查申请</router-link> |
	  <router-link to="/inspection_request">检验申请</router-link> |
	  <router-link to="/physician-history">看诊记录</router-link> |
	  <router-link to="/check_results">检查结果查看</router-link> |
	  <router-link to="/inspection_results">检验结果查看</router-link> |
	  <router-link to="/outpatient_diagnosis">门诊确诊</router-link> |
	  <router-link to="/write_prescription">开立处方</router-link> |
	  <router-link to="/disposal_request">处置申请</router-link> 
    </nav>
    <router-view/>
  </div>
</template>

<script>
</script>

<style>
</style>