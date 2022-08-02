<template>
  <div>
		<div style="text-align: left;"> 患者信息： 
		    <span class="el-tag el-tag--light">姓名：</span>
		    <span class="el-tag el-tag--light">病历号：</span>
		    <span class="el-tag el-tag--light">年龄：</span>
		    <span class="el-tag el-tag--light">性别：</span>
		</div>
		
		<div class="el-divider el-divider--horizontal"></div>
		
		<div style="font-size: 20px; text-align: left;">
			<i class="el-icon-document-checked">看诊记录</i>
		</div>
		
		<div class="el-divider el-divider--horizontal"></div>
		
		<div class="el-row" style="margin-left: -10px; margin-right: -10px;">
			<div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
				<div class="el-input">
					<input type="text" autocomplete="off" placeholder="请输入患者病历号" class="el-input__inner">
				</div>
			</div>
			<div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
				<div class="el-input">
					<input type="text" autocomplete="off" placeholder="请输入患者姓名" class="el-input__inner">
				</div>
			</div>
			<div class="el-col el-col-2" style="padding-left: 10px; padding-right: 10px;">
				<button type="button" class="el-button el-button--default">
					<span>搜索</span>
				</button>
			</div>
			<div class="el-col el-col-10" style="padding-left: 10px; padding-right: 10px;"></div>
		</div>
		<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover" style="width: 80%; margin-top: 10px;">
			<div class="hidden-columns">
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
			</div>
			<div class="el-table__header-wrapper">
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width: 1000px;">
					<colgroup>
						<col name="el-table_81_column_551" width="50">
						<col name="el-table_81_column_552" width="150">
						<col name="el-table_81_column_553" width="150">
						<col name="el-table_81_column_554" width="150">
						<col name="el-table_81_column_555" width="120">
						<col name="el-table_81_column_556" width="260">
						<col name="el-table_81_column_557" width="120">
						<col name="gutter" width="0">
					</colgroup>
				<thead class="has-gutter">
					<tr class>
						<th colspan="1" rowspan="1" class="el-table_81_column_551     is-leaf el-table__cell">
							<div class="cell">编号</div>
						</th>
						<th colspan="1" rowspan="1" class="el-table_81_column_552     is-leaf el-table__cell">
							<div class="cell">患者病历号</div>
						</th>
						<th colspan="1" rowspan="1" class="el-table_81_column_553     is-leaf el-table__cell">
							<div class="cell">患者姓名</div>
						</th>
						<th colspan="1" rowspan="1" class="el-table_81_column_554     is-leaf el-table__cell">
							<div class="cell">患者身份证</div>
						</th>
						<th colspan="1" rowspan="1" class="el-table_81_column_555     is-leaf el-table__cell">
							<div class="cell">患者状态</div>
						</th>
						<th colspan="1" rowspan="1" class="el-table_81_column_556     is-leaf el-table__cell">
							<div class="cell">挂号时间</div>
						</th>
						<th colspan="1" rowspan="1" class="el-table_81_column_557     is-leaf el-table__cell">
							<div class="cell">操作</div>
						</th>
						<th class="el-table__cell gutter" style="width: 0px; display: none;"></th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="el-table__body-wrapper is-scrolling-left">
			<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width: 1000px;">
				<colgroup>
					<col name="el-table_81_column_551" width="50">
					<col name="el-table_81_column_552" width="150">
					<col name="el-table_81_column_553" width="150">
					<col name="el-table_81_column_554" width="150">
					<col name="el-table_81_column_555" width="120">
					<col name="el-table_81_column_556" width="260">
					<col name="el-table_81_column_557" width="120">
				</colgroup>
				<tbody></tbody>
			</table>
		    <div class="el-table__empty-block" style="height: 100%; width: 930px;">
			    <span class="el-table__empty-text">暂无数据</span>
			</div>
		</div>
		<div class="el-table__column-resize-proxy" style="display: none;"></div>
	</div>
	
	<div style="width: 80%; margin-top: 10px; text-align: right;">
		<div class="el-pagination">
			<button type="button" disabled="disabled" class="btn-prev">
				<i class="el-icon el-icon-arrow-left"></i>
			</button>
			<ul class="el-pager">
				<li class="number active">1</li>
		    </ul>
			<button type="button" disabled="disabled" class="btn-next">
				<i class="el-icon el-icon-arrow-right"></i>
			</button>
		</div>
	</div>
  </div>
</template>

<script>
</script>

<style>
</style>