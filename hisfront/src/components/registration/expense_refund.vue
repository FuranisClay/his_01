<template>
	<div id="refund">
		<el-container>
		  <el-aside width="180px"></el-aside>
		  <el-main>
		  	<el-table :data="tableData">
		  		<el-table-column prop="date" label="日期" width="140">
		  		</el-table-column>
		  		<el-table-column prop="name" label="姓名" width="120">
		  		</el-table-column>
		  		<el-table-column prop="address" label="地址">
		  		</el-table-column>
		  	</el-table>
		  </el-main>
		</el-container>
	</div>
</template>

<script>
</script>

<style>
</style>
