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
				患者叫号
			</i>
		</div>
		
		<div class="el-divider el-divider--horizontal"></div>
		
		<div class="el-row" style="margin-left: -10px; margin-right: -10px; ">
		    <div class="el-col el-col-6" style="padding-left:10px; padding-right:10px;">
				<div class="el-input">
					<input type="text" autocomplete="off" placeholder="请输入患者病历号" class="el-input__inner">
				</div>
		    </div>
			<div class="el-col el-col-6" style="padding-left:10px; padding-right:10px;">
				<div class="el-input">
					<input type="text" autocomplete="off" placeholder="请输入患者姓名" class="el-input__inner">
				</div>
			</div>
			<div class="el-col el-col-2" style="padding-left:10px; padding-right:10px;">
				<button type="button" class="el-button el-button--default">
					<span>搜索</span>
				</button>
			</div>
			<div class="el-col el-col-10" style="padding-left:10px;padding-right:10px;"></div>
		</div>
		
		<div class="el-divider el-divider--horizontal"></div>
		
		<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover"style="width:80%;">
			<div class="hidden-columns"></div>
			<div class="el-table__header-wrapper">
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width:1000px">
					<colgroup>
						<col name="el-table_1_column_1" width="80">
						<col name="el-table_1_column_2" width="180">
						<col name="el-table_1_column_3" width="370">
						<col name="el-table_1_column_4" width="370">
						<col name="gutter" width="0">
					</colgroup>
					<thead class="has-gutter">
						<tr class>
							<th colspan="1" rowspan="1" class="el-table_1_column_1  is-leaf el-table__cell">
								<div class="cell">编号</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_1_column_2  is-leaf el-table__cell">
								<div class="cell">患者姓名</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_1_column_3  is-leaf el-table__cell">
								<div class="cell">患者病历号</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_1_column_4  is-leaf el-table__cell">
								<div class="cell">操作</div>
							</th>
							<th class="el-table__cell gutter" style="width: 0px;display: none;"></th>
						</tr>
					</thead>
				</table>
			</div>
			
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
				<div class="el-table_empty-block" style="height: 100%; width: 1000px; ">
					<span class="el-table__empty-text">暂无数据</span>
				</div>
				<div class="el-table__column-resize-proxy" style="display: none; " ></div>
			</div>
		</div>
		
		<div class="el-divider el-divider--horizontal"></div>
		
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
</script>

<style>
</style>