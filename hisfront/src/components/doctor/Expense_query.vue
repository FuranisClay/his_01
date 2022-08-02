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
			<i class="el-icon-document-checked">费用查询</i>
		</div>

		<div class="el-divider el-divider--horizontal"></div>

		<div class="el-row" style="margin-left: -10px; margin-right: -10px;">
			<div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
				<div class="el-input">
					<!----><input type="text" autocomplete="off" placeholder="请输入患者病历号" class="el-input__inner">
					<!---->
					<!---->
					<!---->
					<!---->
				</div>
			</div>
			<div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
				<div class="el-input">
					<!----><input type="text" autocomplete="off" placeholder="请输入患者姓名" class="el-input__inner">
					<!---->
					<!---->
					<!---->
					<!---->
				</div>
			</div>
			<div class="el-col el-col-2" style="padding-left: 10px; padding-right: 10px;"><button type="button"
					class="el-button el-button--default">
					<!---->
					<!----><span>搜索</span>
				</button></div>
			<div class="el-col el-col-10" style="padding-left: 10px; padding-right: 10px;"></div>
		</div>
		<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover el-table--enable-row-transition el-table--mini"
			style="margin-top: 5px; width: 80%;">
			<div class="hidden-columns">
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
			</div>
			<div class="el-table__header-wrapper">
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width: 820px;">
					<colgroup>
						<col name="el-table_107_column_736" width="80">
						<col name="el-table_107_column_737" width="180">
						<col name="el-table_107_column_738" width="80">
						<col name="el-table_107_column_739" width="180">
						<col name="el-table_107_column_740" width="180">
						<col name="el-table_107_column_741" width="120">
						<col name="gutter" width="0">
					</colgroup>
					<thead class="has-gutter">
						<tr class="">
							<th colspan="1" rowspan="1" class="el-table_107_column_736     is-leaf el-table__cell">
								<div class="cell">编号</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_107_column_737     is-leaf el-table__cell">
								<div class="cell">患者姓名</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_107_column_738     is-leaf el-table__cell">
								<div class="cell">患者病历号</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_107_column_739     is-leaf el-table__cell">
								<div class="cell">患者年龄</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_107_column_740     is-leaf el-table__cell">
								<div class="cell">患者性别</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_107_column_741     is-leaf el-table__cell">
								<div class="cell"></div>
							</th>
							<th class="el-table__cell gutter" style="width: 0px; display: none;"></th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="el-table__body-wrapper is-scrolling-left">
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width: 820px;">
					<colgroup>
						<col name="el-table_107_column_736" width="80">
						<col name="el-table_107_column_737" width="180">
						<col name="el-table_107_column_738" width="80">
						<col name="el-table_107_column_739" width="180">
						<col name="el-table_107_column_740" width="180">
						<col name="el-table_107_column_741" width="120">
					</colgroup>
					<tbody>
						<tr class="el-table__row">
							<td rowspan="1" colspan="1" class="el-table_107_column_736   el-table__cell">
								<div class="cell">
									<div>1</div>
								</div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_737   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_738   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_739   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_740   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_741   el-table__cell">
								<div class="cell"><button type="button"
										class="el-button el-button--primary el-button--mini">
										<!---->
										<!----><span>费用详情</span>
									</button></div>
							</td>
						</tr>
						<tr class="el-table__row">
							<td rowspan="1" colspan="1" class="el-table_107_column_736   el-table__cell">
								<div class="cell">
									<div>2</div>
								</div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_737   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_738   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_739   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_740   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_741   el-table__cell">
								<div class="cell"><button type="button"
										class="el-button el-button--primary el-button--mini">
										<!---->
										<!----><span>费用详情</span>
									</button></div>
							</td>
						</tr>
						<tr class="el-table__row">
							<td rowspan="1" colspan="1" class="el-table_107_column_736   el-table__cell">
								<div class="cell">
									<div>3</div>
								</div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_737   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_738   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_739   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_740   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_741   el-table__cell">
								<div class="cell"><button type="button"
										class="el-button el-button--primary el-button--mini">
										<!---->
										<!----><span>费用详情</span>
									</button></div>
							</td>
						</tr>
						<tr class="el-table__row">
							<td rowspan="1" colspan="1" class="el-table_107_column_736   el-table__cell">
								<div class="cell">
									<div>4</div>
								</div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_737   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_738   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_739   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_740   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_741   el-table__cell">
								<div class="cell"><button type="button"
										class="el-button el-button--primary el-button--mini">
										<!---->
										<!----><span>费用详情</span>
									</button></div>
							</td>
						</tr>
						<tr class="el-table__row">
							<td rowspan="1" colspan="1" class="el-table_107_column_736   el-table__cell">
								<div class="cell">
									<div>5</div>
								</div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_737   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_738   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_739   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_740   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_741   el-table__cell">
								<div class="cell"><button type="button"
										class="el-button el-button--primary el-button--mini">
										<!---->
										<!----><span>费用详情</span>
									</button></div>
							</td>
						</tr>
						<tr class="el-table__row">
							<td rowspan="1" colspan="1" class="el-table_107_column_736   el-table__cell">
								<div class="cell">
									<div>6</div>
								</div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_737   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_738   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_739   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_740   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_741   el-table__cell">
								<div class="cell"><button type="button"
										class="el-button el-button--primary el-button--mini">
										<!---->
										<!----><span>费用详情</span>
									</button></div>
							</td>
						</tr>
						<tr class="el-table__row">
							<td rowspan="1" colspan="1" class="el-table_107_column_736   el-table__cell">
								<div class="cell">
									<div>7</div>
								</div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_737   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_738   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_739   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_740   el-table__cell">
								<div class="cell"></div>
							</td>
							<td rowspan="1" colspan="1" class="el-table_107_column_741   el-table__cell">
								<div class="cell"><button type="button"
										class="el-button el-button--primary el-button--mini">
										<!---->
										<!----><span>费用详情</span>
									</button></div>
							</td>
						</tr>
						<!---->
					</tbody>
				</table>
				<!---->
				<!---->
			</div>
			<!---->
			<!---->
			<!---->
			<!---->
			<div class="el-table__column-resize-proxy" style="display: none;"></div>
		</div>
		<div style="margin-top: 5px; text-align: right; width: 80%;">
			<div class="el-pagination"><button type="button" disabled="disabled" class="btn-prev"><i
						class="el-icon el-icon-arrow-left"></i></button>
				<ul class="el-pager">
					<li class="number active">1</li>
					<!---->
					<!---->
					<!---->
				</ul><button type="button" disabled="disabled" class="btn-next"><i
						class="el-icon el-icon-arrow-right"></i></button>
			</div>
		</div>
		<div class="el-divider el-divider--horizontal">
			<!---->
		</div>
		<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover"
			style="margin-top: 10px; width: 80%;">
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
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width: 815px;">
					<colgroup>
						<col name="el-table_108_column_742" width="55">
						<col name="el-table_108_column_743" width="80">
						<col name="el-table_108_column_744" width="80">
						<col name="el-table_108_column_745" width="80">
						<col name="el-table_108_column_746" width="120">
						<col name="el-table_108_column_747" width="120">
						<col name="el-table_108_column_748" width="80">
						<col name="el-table_108_column_749" width="200">
						<col name="gutter" width="0">
					</colgroup>
					<thead class="has-gutter">
						<tr class="">
							<th colspan="1" rowspan="1"
								class="el-table_108_column_742   el-table-column--selection  is-leaf el-table__cell">
								<div class="cell"><label class="el-checkbox is-disabled"><span
											class="el-checkbox__input is-disabled"><span
												class="el-checkbox__inner"></span><input type="checkbox"
												aria-hidden="false" disabled="disabled" class="el-checkbox__original"
												value=""></span>
										<!---->
									</label></div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_108_column_743     is-leaf el-table__cell">
								<div class="cell">项目名称</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_108_column_744     is-leaf el-table__cell">
								<div class="cell">单价</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_108_column_745     is-leaf el-table__cell">
								<div class="cell">类型</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_108_column_746     is-leaf el-table__cell">
								<div class="cell">规格</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_108_column_747     is-leaf el-table__cell">
								<div class="cell">状态</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_108_column_748     is-leaf el-table__cell">
								<div class="cell">数量</div>
							</th>
							<th colspan="1" rowspan="1" class="el-table_108_column_749     is-leaf el-table__cell">
								<div class="cell">开立时间</div>
							</th>
							<th class="el-table__cell gutter" style="width: 0px; display: none;"></th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="el-table__body-wrapper is-scrolling-left">
				<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width: 815px;">
					<colgroup>
						<col name="el-table_108_column_742" width="55">
						<col name="el-table_108_column_743" width="80">
						<col name="el-table_108_column_744" width="80">
						<col name="el-table_108_column_745" width="80">
						<col name="el-table_108_column_746" width="120">
						<col name="el-table_108_column_747" width="120">
						<col name="el-table_108_column_748" width="80">
						<col name="el-table_108_column_749" width="200">
					</colgroup>
					<tbody>
						<!---->
					</tbody>
				</table>
				<div class="el-table__empty-block" style="height: 100%; width: 815px;"><span
						class="el-table__empty-text">暂无数据</span></div>
				<!---->
			</div>
			<!---->
			<!---->
			<!---->
			<!---->
			<div class="el-table__column-resize-proxy" style="display: none;"></div>
		</div>
	</div>
	</div>
</template>

<script>
</script>

<style>
</style>
