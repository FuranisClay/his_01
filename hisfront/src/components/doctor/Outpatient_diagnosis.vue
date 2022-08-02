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
			<i class="el-icon-document-checked">门诊确诊</i>
		</div>

		<div class="el-divider el-divider--horizontal"></div>

		<div class="el-descriptions" style="width: 80%;">
			<div class="el-descriptions__header">
				<div class="el-descriptions__title">确诊信息录入：</div>
				<div class="el-descriptions__extra"></div>
			</div>
			<div class="el-descriptions__body">
				<table class="el-descriptions__table is-bordered">
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">诊断结果：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content">
								<div class="el-textarea"><textarea autocomplete="off" auto-size="[object Object]"
										placeholder="输入诊断结果判断" class="el-textarea__inner"
										style="min-height: 33px;"></textarea>
									<!---->
								</div>
							</td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1"
								class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label "
								style="width: 120px;">处理意见：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content">
								<div class="el-textarea"><textarea autocomplete="off" auto-size="[object Object]"
										placeholder="输入治疗意见" class="el-textarea__inner"
										style="min-height: 33px;"></textarea>
									<!---->
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="el-divider el-divider--horizontal">
			<!---->
		</div>
		<div style="text-align: left;"><button type="button" class="el-button el-button--primary">
				<!---->
				<!----><span>确诊提交</span>
			</button><button type="button" class="el-button el-button--primary">
				<!---->
				<!----><span>重置输入</span>
			</button></div>
	</div>
	</div>
</template>
<script>
</script>

<style>
</style>
