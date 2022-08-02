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
			<i class="el-icon-document-checked">处置申请</i>
		</div>

		<div class="el-divider el-divider--horizontal"></div>

		<div style="display: flex;"><button disabled="disabled" type="button"
				class="el-button el-button--primary is-disabled">
				<!----><i class="el-icon-price-tag"></i><span>项目金额：0元</span>
			</button></div>
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
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width: 795px;">
					<colgroup>
						<col name="el-table_100_column_685" width="55">
						<col name="el-table_100_column_686" width="180">
						<col name="el-table_100_column_687" width="80">
						<col name="el-table_100_column_688" width="100">
						<col name="el-table_100_column_689" width="100">
						<col name="el-table_100_column_690" width="100">
						<col name="el-table_100_column_691" width="180">
						<col name="gutter" width="0">
					</colgroup>
					<thead class="has-gutter">
						<tr class="">
							<th colspan="1" rowspan="1"
								class="el-table_100_column_685   el-table-column--selection  is-leaf el-table__cell">
								<div class="cell"><label class="el-checkbox is-disabled"><span
											class="el-checkbox__input is-disabled"><span
												class="el-checkbox__inner"></span><input type="checkbox"
												aria-hidden="false" disabled="disabled" class="el-checkbox__original"
												value=""></span>
										<!---->
									</label></div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_100_column_686     is-leaf el-table__cell">
								<div class="cell">处置编码</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_100_column_687     is-leaf el-table__cell">
								<div class="cell">处置名称</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_100_column_688     is-leaf el-table__cell">
								<div class="cell">处置规格</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_100_column_689     is-leaf el-table__cell">
								<div class="cell">单价</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_100_column_690     is-leaf el-table__cell">
								<div class="cell">费用分类</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_100_column_691     is-leaf el-table__cell">
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
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width: 795px;">
					<colgroup>
						<col name="el-table_100_column_685" width="55">
						<col name="el-table_100_column_686" width="180">
						<col name="el-table_100_column_687" width="80">
						<col name="el-table_100_column_688" width="100">
						<col name="el-table_100_column_689" width="100">
						<col name="el-table_100_column_690" width="100">
						<col name="el-table_100_column_691" width="180">
					</colgroup>
					<tbody>
						<!---->
					</tbody>
				</table>
				<div class="el-table__empty-block" style="height: 100%; width: 795px;"><span
						class="el-table__empty-text">暂无数据</span></div>
				<!---->
			</div>
			<!---->
			<!---->
			<!---->
			<!---->
			<div class="el-table__column-resize-proxy" style="display: none;"></div>
		</div>
		<div class="el-descriptions" style="width: 80%; margin-top: 20px;">
			<div class="el-descriptions__header">
				<div class="el-descriptions__title">医嘱</div>
				<div class="el-descriptions__extra"></div>
			</div>
			<div class="el-descriptions__body">
				<table class="el-descriptions__table is-bordered">
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">目的要求：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content">
								<div class="el-textarea"><textarea autocomplete="off" rows="4" placeholder="请输入检验目的要求"
										class="el-textarea__inner" style="min-height: 33px;"></textarea>
									<!---->
								</div>
							</td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">检验部位：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content">
								<div class="el-textarea"><textarea autocomplete="off" rows="2" placeholder="请输入检验部位"
										class="el-textarea__inner" style="min-height: 33px;"></textarea>
									<!---->
								</div>
							</td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">备注：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content">
								<div class="el-textarea"><textarea autocomplete="off" rows="4" placeholder="请输入检验事项"
										class="el-textarea__inner" style="min-height: 33px;"></textarea>
									<!---->
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="el-dialog__wrapper" style="display: none;">
			<div role="dialog" aria-modal="true" aria-label="添加处置申请" class="el-dialog" style="margin-top: 15vh;">
				<div class="el-dialog__header"><span class="el-dialog__title">添加处置申请</span><button type="button"
						aria-label="Close" class="el-dialog__headerbtn"><i
							class="el-dialog__close el-icon el-icon-close"></i></button></div>
				<!---->
				<!---->
			</div>
		</div>
		<div class="el-divider el-divider--horizontal">
			<!---->
		</div>
		<div style="text-align: left; margin-top: 20px;"><button type="button" class="el-button el-button--primary">
				<!---->
				<!----><span>申请提交</span>
			</button><button type="button" class="el-button el-button--primary">
				<!---->
				<!----><span>清空表格</span>
			</button></div>
	</div>
	</div>
</template>

<script>
</script>

<style>
</style>
