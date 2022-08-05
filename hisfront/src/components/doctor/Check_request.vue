<template>
    <div>
		
		
		
		<div style="font-size:20px;text-align:left">
			<i class="el-icon-document-checked">
				检查申请
			</i>
		</div>
		
		
		<hr>
		<el-form>
			<el-input v-model="registId" placeholder="请输入挂号序列号"></el-input>
			<el-button @click="submit" id="search" style="width: 15%;margin-right: 20px;">搜索</el-button>			
		</el-form>
		<hr>
		
		<div class="el-table el-table--fit el-table--scrollable-x el-table--enable-row-hover" style="width: 80%;">
			
			
			</el-form>
			
			<el-form>
				<el-table :data="checkapply" class="checkapply">
					<el-table-column prop="registId" label="挂号序列"></el-table-column>
					<el-table-column prop="name" label="检查项目名称"></el-table-column>
					<el-table-column prop="objective" label="目的要求"></el-table-column>
					<el-table-column prop="position" label="检查部位"></el-table-column>
					<el-table-column prop="isUrgent" label="是否加急"></el-table-column>
					<el-table-column prop="num" label="数量"></el-table-column>
					<el-table-column prop="creationTime" label="开立时间"></el-table-column>
					<el-table-column prop="state" label="状态"></el-table-column>
				</el-table>
			</el-form>
			
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
							<th colspan="1" class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label " style="width: 120px;">目的要求：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content">
								<div class="el-textarea">
									<textarea autocomplete="off" rows="4" placeholder="请输入检验目的要求" class="el-textarea__inner" style="min-height: 33px;">
										
									</textarea>
								</div>
							</td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1" class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label " style="width: 120px;">检验部位：</th>
							<td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content">
								<div class="el-textarea">
									<textarea autocomplete="off" rows="2" placeholder="请输入检验部位" class="el-textarea__inner" style="min-height: 33px;">
										
									</textarea>
								</div>
							</td>
						</tr>
					</tbody>
					<tbody>
						<tr class="el-descriptions-row">
							<th colspan="1" class="el-descriptions-item__cell el-descriptions-item__label is-bordered-label " style="width: 120px;">备注：</th>
						    <td colspan="1" class="el-descriptions-item__cell el-descriptions-item__content">
						        <div class="el-textarea">
								    <textarea autocomplete="off" rows="4" placeholder="请输入检验事项" class="el-textarea__inner" style="min-height: 33px;">
									
								    </textarea>
							    </div>
						    </td>
					    </tr>
				    </tbody>
				</table>
			</div>
		</div>
		
		
		<!--点击增加时应该是下一行中display：none去掉的状态-->
		<div class="el-dialog__wrapper" style="z-index: 2077;display: none;">
			<div role="dialog" aria-modal="true" aria-label="添加检查申请" class="el-dialog" style="margin-top: 15vh;">
				<div class="el-dialog__header">
					<span class="el-dialog__title">添加检查申请</span>
					<button type="button" aria-label="Close" class="el-dialog__headerbtn">
						<i class="el-dialog__close el-icon el-icon-close"></i>
					</button>
				</div>
				<div class="el-dialog__body">
					<div>
						<span class="el-tag el-tag--light" style="width: 20%;">检查编码：</span>
						<div class="el-input" style="width: 80%;">
							<input type="text" autocomplete="off" placeholder="请输入检查编码" class="el-input__inner">
						</div>
					</div>
					<div>
						<span class="el-tag el-tag--light" style="width: 20%;">检查名称：</span>
						<div class="el-input" style="width: 80%;">
							<input type="text" autocomplete="off" placeholder="请输入检查名称" class="el-input__inner">
					    </div>
					</div>
					<div style="float: right;">
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
							<div></div>
							<div></div>
						</div>
						<div class="el-table__header-wrapper">
							<table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width: 585px;">
								<colgroup>
									<col name="el-table_26_column_163" width="55">
									<col name="el-table_26_column_164" width="150">
									<col name="el-table_26_column_165" width="80">
									<col name="el-table_26_column_166" width="100">
									<col name="el-table_26_column_167" width="100">
									<col name="el-table_26_column_168" width="100">
									<col name="gutter" width="0">
								</colgroup>
								<thead class="has-gutter">
									<tr class>
										<th colspan="1" rowspan="1" class="el-table_26_column_163   el-table-column--selection  is-leaf el-table__cell">
											<div class="cell">
												<label class="el-checkbox is-disabled">
													<span class="el-checkbox__input is-disabled">
														<span class="el-checkbox__inner"></span>
														<input type="checkbox" aria-hidden="false" disabled="disabled" class="el-checkbox__original" value>
													</span>
												</label>
											</div>
										</th>
										<th colspan="1" rowspan="1" class="el-table_26_column_164     is-leaf el-table__cell">
											<div class="cell">检查编码</div>
										</th>
										<th colspan="1" rowspan="1" class="el-table_26_column_165     is-leaf el-table__cell">
											<div class="cell">检查名称</div>
										</th>
										<th colspan="1" rowspan="1" class="el-table_26_column_166     is-leaf el-table__cell">
											<div class="cell">检查规格</div>
										</th>
										<th colspan="1" rowspan="1" class="el-table_26_column_167     is-leaf el-table__cell">
											<div class="cell">单价</div>
										</th>
										<th colspan="1" rowspan="1" class="el-table_26_column_168     is-leaf el-table__cell">
											<div class="cell">费用分类</div>
										</th>
										<th class="el-table__cell gutter" style="width: 0px; display: none;"></th>
									</tr>
								</thead>
							</table>
						</div>
						<div class="el-table__body-wrapper is-scrolling-left">
							<table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width: 585px;">
								<colgroup>
									<col name="el-table_26_column_163" width="55">
									<col name="el-table_26_column_164" width="150">
									<col name="el-table_26_column_165" width="80">
									<col name="el-table_26_column_166" width="100">
									<col name="el-table_26_column_167" width="100">
									<col name="el-table_26_column_168" width="100">
								</colgroup>
								<tbody></tbody>
							</table>
						    <div class="el-table__empty-block" style="height: 100%; width: 585px;">
								<span class="el-table__empty-text">暂无数据</span>
							</div>
						</div>
						<div class="el-table__column-resize-proxy" style="display: none;"></div>
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
		
		
		<div class="el-divider el-divider--horizontal"></div>
		
		<div style="text-align: left; margin-top: 20px;">
			<button type="button" class="el-button el-button--primary">
				<span>申请提交</span>
			</button>
			<button type="button" class="el-button el-button--primary">
				<span>清空表格</span>
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