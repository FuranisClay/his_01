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
			<i class="el-icon-document-checked">开立处方</i>
		</div>

		<div class="el-divider el-divider--horizontal"></div>
		<div style="display: flex;"><button disabled="disabled" type="button"
				class="el-button el-button--primary is-disabled">
				<!----><i class="el-icon-price-tag"></i><span>处方金额：0.00元</span>
			</button></div>
		<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover">
			<div class="hidden-columns">
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
			</div>
			<div class="el-table__header-wrapper">
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width: 1110px;">
					<colgroup>
						<col name="el-table_99_column_677" width="55">
						<col name="el-table_99_column_678" width="55">
						<col name="el-table_99_column_679" width="280">
						<col name="el-table_99_column_680" width="160">
						<col name="el-table_99_column_681" width="100">
						<col name="el-table_99_column_682" width="80">
						<col name="el-table_99_column_683" width="200">
						<col name="el-table_99_column_684" width="180">
						<col name="gutter" width="0">
					</colgroup>
					<thead class="has-gutter">
						<tr class="">
							<th colspan="1" rowspan="1"
								class="el-table_99_column_677   el-table-column--selection  is-leaf el-table__cell">
								<div class="cell"><label class="el-checkbox is-disabled"><span
											class="el-checkbox__input is-disabled"><span
												class="el-checkbox__inner"></span><input type="checkbox"
												aria-hidden="false" disabled="disabled" class="el-checkbox__original"
												value=""></span>
										<!---->
									</label></div>
							</th>
							<th colspan="1" rowspan="1"
								class="el-table_99_column_678   undefined el-table__expand-column  is-leaf el-table__cell">
								<div class="cell"></div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_99_column_679     is-leaf el-table__cell">
								<div class="cell">药品名称</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_99_column_680     is-leaf el-table__cell">
								<div class="cell">药品规格</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_99_column_681     is-leaf el-table__cell">
								<div class="cell">单价</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_99_column_682     is-leaf el-table__cell">
								<div class="cell">用法用量</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_99_column_683     is-leaf el-table__cell">
								<div class="cell">数量</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_99_column_684     is-leaf el-table__cell">
								<div class="cell"><button type="button" class="el-button el-button--text">
										<!---->
										<!----><span>删除</span>
									</button><button type="button" class="el-button el-button--text">
										<!---->
										<!----><span>增加</span>
									</button></div>
							</th>
							<th class="el-table__cell gutter" style="width: 0px; display: none;"></th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="el-table__body-wrapper is-scrolling-left">
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width: 1110px;">
					<colgroup>
						<col name="el-table_99_column_677" width="55">
						<col name="el-table_99_column_678" width="55">
						<col name="el-table_99_column_679" width="280">
						<col name="el-table_99_column_680" width="160">
						<col name="el-table_99_column_681" width="100">
						<col name="el-table_99_column_682" width="80">
						<col name="el-table_99_column_683" width="200">
						<col name="el-table_99_column_684" width="180">
					</colgroup>
					<tbody>
						<!---->
					</tbody>
				</table>
				<div class="el-table__empty-block" style="height: 100%; width: 1110px;"><span
						class="el-table__empty-text">暂无数据</span></div>
				<!---->
			</div>
			<!---->
			<!---->
			<!---->
			<!---->
			<div class="el-table__column-resize-proxy" style="display: none;"></div>
		</div>
		<div style="text-align: left; margin-top: 20px;"><button type="button" class="el-button el-button--primary">
				<!---->
				<!----><span>开立处方</span>
			</button><button type="button" class="el-button el-button--primary">
				<!---->
				<!----><span>重置处方</span>
			</button></div>
		<div class="el-dialog__wrapper" style="display: none;">
			<div role="dialog" aria-modal="true" aria-label="添加药品" class="el-dialog" style="margin-top: 15vh;">
				<div class="el-dialog__header"><span class="el-dialog__title">添加药品</span><button type="button"
						aria-label="Close" class="el-dialog__headerbtn"><i
							class="el-dialog__close el-icon el-icon-close"></i></button></div>
				<!---->
				<!---->
			</div>
		</div>
	</div>
	</div>
</template>
<script>
</script>

<style>
</style>
