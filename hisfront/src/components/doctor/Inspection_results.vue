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
			<i class="el-icon-document-checked">检验结果</i>
		</div>

		<div class="el-divider el-divider--horizontal"></div>

		<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover" style="width: 80%;">
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
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width: 850px;">
					<colgroup>
						<col name="el-table_82_column_558" width="50">
						<col name="el-table_82_column_559" width="180">
						<col name="el-table_82_column_560" width="80">
						<col name="el-table_82_column_561" width="180">
						<col name="el-table_82_column_562" width="120">
						<col name="el-table_82_column_563" width="120">
						<col name="el-table_82_column_564" width="120">
						<col name="gutter" width="0">
					</colgroup>
					<thead class="has-gutter">
						<tr class>
							<th colspan="1" rowspan="1" class="el-table_82_column_558     is-leaf el-table__cell">
								<div class="cell"></div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_82_column_559     is-leaf el-table__cell">
								<div class="cell">检验编码</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_82_column_560     is-leaf el-table__cell">
								<div class="cell">检验名称</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_82_column_561     is-leaf el-table__cell">
								<div class="cell">规格</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_82_column_562     is-leaf el-table__cell">
								<div class="cell">单价</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_82_column_563     is-leaf el-table__cell">
								<div class="cell">状态</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_82_column_564     is-leaf el-table__cell">
								<div class="cell">费用分类</div>
							</th>
							<th class="el-table__cell gutter" style="width: 0px; display: none;"></th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="el-table__body-wrapper is-scrolling-left">
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width: 850px;">
					<colgroup>
						<col name="el-table_82_column_558" width="50">
						<col name="el-table_82_column_559" width="180">
						<col name="el-table_82_column_560" width="80">
						<col name="el-table_82_column_561" width="180">
						<col name="el-table_82_column_562" width="120">
						<col name="el-table_82_column_563" width="120">
						<col name="el-table_82_column_564" width="120">
					</colgroup>
					<tbody></tbody>
				</table>
				<div class="el-table__empty-block" style="height: 100%; width: 850px;">
					<span class="el-table__empty-text">暂无数据</span>
				</div>
			</div>
			<div class="el-table__column-resize-proxy" style="display: none;"></div>
		</div>

		<div class="el-divider el-divider--horizontal"></div>

		<div class="el-descriptions" style="width: 80%;">
			<div class="el-descriptions__header">
				<div class="el-descriptions__title">检验结果详情：</div>
				<div class="el-descriptions__extra"></div>
			</div>
			<div class="el-descriptions__body">
				<table class="el-descriptions__table is-bordered">
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">开立时间：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content"
								style="background-color: rgb(244, 244, 245);">
								<span class="el-tag el-tag--info el-tag--light"></span>
							</td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">检验医生：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content"
								style="background-color: rgb(244, 244, 245);">
								<span class="el-tag el-tag--info el-tag--light"></span>
							</td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">检验部位：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content"
								style="background-color: rgb(244, 244, 245);">
								<span class="el-tag el-tag--info el-tag--light"></span>
							</td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">目的要求：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content"
								style="background-color: rgb(244, 244, 245);">
								<span class="el-tag el-tag--info el-tag--light"></span>
							</td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">医嘱备注：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content"
								style="background-color: rgb(244, 244, 245);">
								<span class="el-tag el-tag--info el-tag--light"></span>
							</td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">检验结果：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content"
								style="background-color: rgb(244, 244, 245);"><span
									class="el-tag el-tag--info el-tag--light"></span></td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">检验时间：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content"
								style="background-color: rgb(244, 244, 245);"><span
									class="el-tag el-tag--info el-tag--light"></span></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	</div>
</template>

<script>
</script>

<style>
</style>
