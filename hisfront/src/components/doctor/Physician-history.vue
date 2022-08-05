<template>
	<div>
		<div class="el-row">
			<div class="el-col el-col-3">
				<span class="el-tag el-tag--success el-tag--light">今日已看诊1人</span>
			</div>
			<div class="el-col el-col-3">
				<span class="el-tag el-tag--warning el-tag--light">当前有0人在排队</span>
			</div>
			<div class="el-col el-col-18"></div>
		 </div>
		 
		<div class="el-divider el-divider--horizontal"></div>
		
		<div style="font-size:20px;text-align:left">
			<i class="el-icon-document-checked">
				看诊记录
			</i>
		</div>
		<h1></h1>

	
		
		<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover"style="width:80%;">
			<div class="hidden-columns"></div>
			<el-form>
				<el-input v-model="registId" placeholder="请输入挂号序列"></el-input>
				
				<el-button @click="submit" id="search" style="width: 15%;margin-right: 20px;">搜索</el-button>
				<el-table :data="checkapply" class="checkapply">
					<el-table-column prop="registId" label="挂号序列"></el-table-column>
					<el-table-column prop="name" label="挂号项目"></el-table-column>
					<el-table-column prop="position" label="检查部位"></el-table-column>
					<el-table-column prop="isUrgent" label="是否加急"></el-table-column>
					<el-table-column prop="creationTime" label="开立时间"></el-table-column>
					<el-table-column prop="checkTime" label="检查时间"></el-table-column>
					<el-table-column prop="resultTime" label="结束时间"></el-table-column>
					<el-table-column prop="result" label="检查结果"></el-table-column>
					<el-table-column prop="state" label="状态"></el-table-column>
				</el-table>
			</el-form>
			
			<div class="el-table__body-wrapper is-scrolling-left">
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width:1000px">
					<colgroup>
						<col name="el-table_1_column_1" width="80">
						<col name="el-table_1_column_2" width="180">
						<col name="el-table_1_column_3" width="370">
						<col name="el-table_1_column_4" width="370">
					</colgroup>
					<tbody>
					</tbody>
				</table>
				
				<div class="el-table__column-resize-proxy" style="display: none; " ></div>
			</div>
		</div>
		
		
		
		<div class="el-pagination" >
			<button type="button" disabled="disabled" class="btn-prev">
				<i class="el-icon el-icon-arrow-left">
				</i>
			</button>
			<ul class="el-pager">
				<li class="number active">1</li>
			</ul>
			<button type="button" disabled="disabled" class="btn-next">
				<i class="el-icon el-icon-arrow-right">
				</i>
			</button>
		</div>
		
	</div>

</template>

<script>
	export default{
		name:'checkapply',
		data(){
			return{				
				checkapply:[],
				registId:'',

			}
		},
		methods:{
			fun(){
				
			},			
				submit(){
					let that = this
					let registId=this.registId
					that.$axios.get("http://localhost:8080/checkapply/list?rid="+registId).then(function(res){					 
						that.checkapply=res.data			
						console.log(res.data)					
				})
				}
		},
	}
</script>

<style>
</style>