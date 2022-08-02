<template>
	<div>
		<div style="text-align: left; ">
			患者信息：
			<span class="el-tag el-tag--light">姓名:</span>
			<span class="el-tag el-tag--light">病历号:</span>
			<span class="el-tag el-tag--light">年龄:</span>
		 <span class="el-tag el-tag--light">性别:</span>
		</div>

		<div class="el-divider el-divider--horizontal"></div>

		<div style="font-size: 20px; text-align: left; ">
			<i class="el-icon-document-checked">
				病历首页
			</i>
		</div>

		<div class="el-divider el-divider--horizontal"></div>

		<div class="el-descriptions" style="margin-top: 20px;width: 80%;">
			<div class="el-descriptions__header">
				<div class="el-descriptions__title">病案首页</div>
				<div class="el-descriptions__extra"></div>
			</div>
			<div class="el-descriptions__body">
				<table class="el-descriptions__table is-bordered">

					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px; ">主诉
							</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item_content">
								<div class="el-textarea">
									<textarea autocomplete="off" placeholder="请输入主诉" class="el-textarea__inner"
										style="min-height: 54px; height: 54px; ">

								  </textarea>
								</div>
							</td>
					 </tr>
					</tbody>

					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px; ">现病史
							</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item_content">
								<div class="el-textarea">
									<textarea autocomplete="off" placeholder="请输入现病史" class="el-textarea__inner"
										style="min-height: 54px; height: 54px; ">

				  					</textarea>
								</div>
							</td>
						</tr>
					</tbody>

					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px; ">现病治疗情况
							</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item_content">
								<div class="el-textarea">
									<textarea autocomplete="off" placeholder="请输入现病治疗情况" class="el-textarea__inner"
										style="min-height: 54px; height: 54px; ">

				  					</textarea>
								</div>
							</td>
						</tr>
					</tbody>

					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px; ">既往史
							</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item_content">
								<div class="el-textarea">
									<textarea autocomplete="off" placeholder="请输入既往史" class="el-textarea__inner"
										style="min-height: 54px; height: 54px; ">

				  					</textarea>
								</div>
							</td>
						</tr>
					</tbody>

					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px; ">过敏史
							</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item_content">
								<div class="el-textarea">
									<textarea autocomplete="off" placeholder="请输入过敏史" class="el-textarea__inner"
										style="min-height: 54px; height: 54px; ">

				  					</textarea>
								</div>
							</td>
						</tr>
					</tbody>

					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px; ">体格检查
							</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item_content">
								<div class="el-textarea">
									<textarea autocomplete="off" placeholder="请输入体格检查" class="el-textarea__inner"
										style="min-height: 54px; height: 54px; ">

				  					</textarea>
								</div>
							</td>
						</tr>
					</tbody>

					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px; ">诊断
							</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item_content">
								<div class="el-table el-table--fit el-table--enable-row-hover" style="width: 100%;">
									<div class="hidden-columns">

									</div>

									<div class="el-table__header-wrapper">
										<table cellspacing="0" cellpadding="0" border="0" class="el-table__header "
											style="width: 855px;">
											<colgroup>
												<col name="el-table_1_column_1" width="55">
												<col name="el-table_1_column_2" width="180">
												<col name="el-table_1_column_3" width="180">
												<col name="el-table_1_column_4" width="180">
												<col name="el-table_1_column_5" width="180">
												<col name="el-table_1_column_6" width="80">
												<col name="gutter" width="0">
											</colgroup>
											<thead class="has-gutter">
												<tr class>
													<th colspan="1" ouspan="1"
														class="el-table_1_column_1 el-table-column--selection is-leaf el-table_cell">
														<div class="cell">
															<label class="el-checkbox is-disabled">
																<span class="el-checkbox__input is-disabled">
																	<span class="el-checkbox__inner">
																	</span>
																	<input type="checkbox" aria-hidden="false"
																		disabled="disabled"
																		class="el-checkbox__original" value>
																</span>
															</label>
														</div>
													</th>
													<th colspan="1" rowspan="1"
														class="el-table_1_column_2 is-leaf el-table_cell">
														<div class="cell">疾病编码</div>
													</th>
													<th colspan="1" rowspan="1"
														class="el-table_1_column_3 is-leaf el-table_cell">
														<div class="cell">疾病名称</div>
													</th>
													<th colspan="1" rowspan="1"
														class="el-table_1_column_4 is-leaf el-table_cell">
														<div class="cell">国际ICD编码</div>
													</th>
													<th colspan="1" rowspan="1"
														class="el-table_1_column_5 is-leaf el-table_cell">
														<div class="cell">疾病类型</div>
													</th>
													<th colspan="1" rowspan="1"
														class="el-table_1_column_6 is-leaf el-table_cell">
														<div class="cell">
															<button type="button" class="el-button el-button--text">
																<span>
																	删除
																</span>
															</button>
															<button type="button" class="el-button el-button--text">
																<span>
																	增加
																</span>
															</button>
														</div>
													</th>
													<th class="el-table__cell gutter" style="width: 0px;display: none;">
													</th>
												</tr>
											</thead>
										</table>
									</div>

									<div class="el-table__body-wrapper is-scrolling-none">
										<table cellspacing="0" cellpadding="0" border="0" class="el-table__body"
											style="width: 855px; ">
											<colgroup>
												<col name="el-table_1_column_1" width="55">
												<col name="el-table_1_column_2" width="180">
												<col name="el-table_1_column_3" width="180">
												<col name="el-table_1_column_4" width="180">
												<col name="el-table_1_column_5" width="180">
												<col name="el-table_1_column_6" width="80">
												<col name="gutter" width="0">
											</colgroup>
											<tbody>

											</tbody>
										</table>
										<div class="el-table__empty-block" style="height: 100%; width: 855px; ">
											<span class="el-table__empty-text">暂无数据</span>
										</div>
									</div>
									<div class="el-table_column-resize-proxy" style="display: none; "></div>
								</div>
							</td>
						</tr>
					</tbody>

					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px; ">检查/检验建议
							</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item_content">
								<div class="el-textarea">
									<textarea autocomplete="off" placeholder="请输入检查/检验建议" class="el-textarea__inner"
										style="min-height: 54px; height: 54px; ">

				  					</textarea>
								</div>
							</td>
						</tr>
				 </tbody>

					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px; ">注意事项
							</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item_content">
								<div class="el-textarea">
									<textarea autocomplete="off" placeholder="请输入注意事项" class="el-textarea__inner"
										style="min-height: 54px; height: 54px; ">

				  					</textarea>
								</div>
							</td>
						</tr>
					</tbody>
                </table>
			</div>
        </div>
		
		<div class="el-divider el-divider--horizontal"></div>
		
		<div style="text-align: left;margin-top: 20px;">
			
			<button type="button" class="el-button el-button--primary">
				<span>保存</span>
			</button>
			<button type="button" class="el-button el-button--primary">
				<span>清空</span>
			</button>
		</div>
		
		<!--点击第六行增加时应该是下一行中display：none去掉的状态-->
		<div class="el-dialog__wrapper" style="z-index: ;display: none">
			<div role="dialog" aria-modal= "true" aria-label="添加疾病诊断" class="el-dialog" style="margin-top: 15vh;">
				<div class="el-dialog__header">
					<span class="el-dialog__title">添加疾病诊断</span>
					<button type="button" aria-label="Close" class="el-dialog__headerbtn">
						<i class="el-dialog__close el-icon el-icon-close"></i>
					</button>
				</div>
				
				<div class="el-dialog__body">
					<div>
						<span class="el-tag el-tag--light" style="width: 20%;">疾病名称:</span>
						<div class="el-input" style="width: 80%; ">
							<input type="text" autocomplete="off" placeholder="请输入疾病名称" class="el-input__inner">
						</div>
					</div>
					<div>
						<span class="el-tag el-tag--light" style="width: 20%;">疾病助记码:</span>
						<div class="el-input" style="width: 80%; ">
							<input type="text" autocomplete="off" placeholder="请输入助记码" class="el-input__inner">
						</div>
					</div>
					<div>
						<span class="el-tag el-tag--light" style="width: 20%;">疾病ICD:</span>
						<div class="el-input" style="width: 80%; ">
							<input type="text" autocomplete="off" placeholder="请输入疾病ICD编码" class="el-input__inner">
						</div>
					</div>
					<div style="float: right; ">
						<button type="button" class="el-button el-button--default">
							<span>搜索</span>
						</button>
					</div>
					<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover">
						<div class="hidden-columns">
							<div></div>
							<div></div>
							<div></div>
							<div></div>
						</div>
						<div class="el-table__header-wrapper">
							<table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width: 485px;">
								<colgroup>
									<col name="el-table_2_column_7" width="55">
									<col name="el-table_2_column_8" width="150">
									<col name="el-table_2_column_9" width="200">
									<col name="el-table_2_column_10" width="80">
									<col name="gutter" width="0">
								</colgroup>
								<thead class="has-gutter">
									<tr class>
										<th colspan="1" rowspan="1" class="el-table_2_column_7   el-table-column--selection  is-leaf el-table__cell">
											<div class="cell">
												<label class="el-checkbox is-disabled">
													<span class="el-checkbox__input is-disabled">
														<span class="el-checkbox__inner"></span>
														<input type="checkbox" aria-hidden="false" disabled="disabled" class="el-checkbox__original" value>
													</span>
												</label>
											</div>
											</th>
											<th colspan="1" rowspan="1" class="el-table_2_column_8     is-leaf el-table__cell">
												<div class="cell">疾病名称</div>
											</th>
											<th colspan="1" rowspan="1" class="el-table_2_column_9     is-leaf el-table__cell">
												<div class="cell">疾病助记码</div>
											</th>
											<th colspan="1" rowspan="1" class="el-table_2_column_10     is-leaf el-table__cell">
												<div class="cell">疾病ICD</div>
											</th>
											<th class="el-table__cell gutter" style="width: 0px; display: none;"></th>
										</tr>
									</thead>
								</table>
							</div>
							<div class="el-table__body-wrapper is-scrolling-left">
								<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width: 485px;">
							        <colgroup>
										<col name="el-table_2_column_7" width="55">
										<col name="el-table_2_column_8" width="150">
										<col name="el-table_2_column_9" width="200">
										<col name="el-table_2_column_10" width="80">
									</colgroup>
									<tbody></tbody>
								</table>
								<div class="el-table__empty-block" style="height: 100%; width: 485px;">
									<span class="el-table__empty-text">暂无数据</span>
								</div>
							</div>
							<div class="el-table__column-resize-proxy" style="display: none;">
                        </div>
					</div>
                    <div>
						<button type="button" class="el-button el-button--primary">
							<span>添加</span>
						</button>
						<button type="button" class="el-button el-button--info">
							<span>关闭</span>
						</button>
					</div>
				</div>
				
			</div>
		</div>
		
	</div>
</template>

<script>
</script>

<style>
</style>
