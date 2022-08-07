<template>
  <div class="disease">
	  <div style="font-size:20px;text-align:left">
	  	<i class="el-icon-document-checked">
	  		门诊确诊
	  	</i>
	  </div>
	  <hr>
	<el-form>
		<el-input v-model="diseaseId" placeholder="请输入门诊确诊序号" style="width: 20%;margin-right: 20px;"></el-input>
		<el-input v-model="diseaseName" placeholder="请输入确诊疾病名称" style="width: 20%;margin-right: 20px;"></el-input>
		<el-button @click="submit" id="search" style="width: 15%;margin-right: 20px;">搜索</el-button>
	</el-form>
	<hr>
	<el-button @click="insert()">新增确诊</el-button>
	<el-button @click="deleteDrugs()">批量删除</el-button>
	<hr>
	<el-table :data="diseaselist1" class="drugsTable" @selection-change="hsc">
		<el-table-column
		      type="selection"
		      width="55">
		    </el-table-column>
		<el-table-column prop="id" label="门诊确诊序号"></el-table-column>
		<el-table-column prop="caseNumber" label="患者病历号"></el-table-column>
		<el-table-column prop="diseaseName" label="确诊疾病名称"></el-table-column>
		<el-table-column prop="diseCategoryId" label="疾病所属分类"></el-table-column>
		<el-table-column prop="advice" label="医师治疗意见"></el-table-column>
		<el-table-column prop="diseaseICD" label="疾病国际ICD编码"></el-table-column>
		<el-table-column>
			<template slot-scope="scope">
			        <el-button icon="el-icon-edit" @click="update(scope.row)"></el-button>
			        <el-button icon="el-icon-delete" @click="delRow(scope.row,scope.$index)"></el-button>
			      </template>
		</el-table-column>
	</el-table>
	<!-- 分页 -->
	<el-pagination
	  background
	  :page-size="pageSize"
	  layout="prev, pager, next"
	  :total="diseaselist.length"
	  @current-change="dopaging"
	  >
	</el-pagination>
	<!-- 修改 -->
	<el-dialog
	  title="信息更改"
	  :visible.sync="dialogVisible"
	  width="40%"
	  :before-close="handleClose">
	  <el-form label-width="100px">
		  <el-form-item label="门诊确诊序号">
			  <el-input :disabled="false" v-model="updateRow.id" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="患者病历号">
		  			  <el-input v-model="updateRow.caseNumber" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="确诊疾病名称">
		  			  <el-input v-model="updateRow.diseaseName" @input="addPinyin1" id="updateInput"></el-input>
		  </el-form-item>

		  <el-form-item label="疾病所属分类">
		  			  <el-input v-model="updateRow.diseCategoryId" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="治疗意见">
		  			  <el-input v-model="updateRow.advice" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="疾病国际ICD编码">
		  			  <el-input v-model="updateRow.diseaseICD" id="updateInput"></el-input>
		  </el-form-item>

		  <el-form-item label="病因">
		  			  <el-select v-model="updateRow.objective"  placeholder="请选择">
		  			      <el-option
		  			        v-for="item in options1"
		  			        :key="item.id"
		  			        :label="item.disecategory"
		  			        :value="item.id">
		  			      </el-option>
		  			    </el-select>
		  </el-form-item>
		  <el-form-item label="确诊状态">
		  			  <el-select v-model="updateRow.recordType" placeholder="请选择">
		  			      <el-option
		  			        v-for="item in options2"
		  			        :key="item.value"
		  			        :label="item.label"
		  			        :value="item.value">
		  			      </el-option>
		  			    </el-select>
		  </el-form-item>

		  
		  <el-form-item>
		  			  <el-button @click="submitUpdate">提交</el-button>
					  <el-button @click="dialogVisible = false">取消</el-button>
		  </el-form-item>
	  </el-form>
	</el-dialog>
	<!-- 新增 -->
	<el-dialog
	  title="增加确诊结果"
	  :visible.sync="dialogVisible1"
	    width="40%"
	    :before-close="handleClose">
	    <el-form label-width="100px">
	  	  <el-form-item label="门诊确诊序号">
	  		  <el-input :disabled=true v-model="insertRow.id" id="updateInput"></el-input>
	  	  </el-form-item>
	  	  <el-form-item label="患者病历号">
	  	  			  <el-input v-model="insertRow.caseNumber" id="updateInput"></el-input>
	  	  </el-form-item>
	  	  <el-form-item label="确诊疾病名称">
	  	  			  <el-input v-model="insertRow.diseaseName" @input="addPinyin" id="updateInput"></el-input>
	  	  </el-form-item>

	  	  <el-form-item label="疾病所属分类">
	  	  			  <el-input v-model="insertRow.diseCategoryId" id="updateInput"></el-input>
	  	  </el-form-item>
		  <el-form-item label="治疗意见">
		  			  <el-input v-model="insertRow.advice" id="updateInput"></el-input>
		  </el-form-item>
	  	  <el-form-item label="疾病国际ICD编码">
	  	  			  <el-input v-model="insertRow.diseaseICD" id="updateInput"></el-input>
	  	  </el-form-item>

		  <el-form-item label="病因">
		  			  <el-select v-model="insertRow.objective" placeholder="请选择">
		  			      <el-option
		  			        v-for="item in options1"
		  			        :key="item.id"
		  			        :label="item.disecategory"
		  			        :value="item.id">
		  			      </el-option>
		  			    </el-select>
		  </el-form-item>
		  <el-form-item label="确诊状态">
		  			  <el-select v-model="insertRow.recordType" placeholder="请选择">
		  			      <el-option
		  			        v-for="item in options2"
		  			        :key="item.value"
		  			        :label="item.label"
		  			        :value="item.value">
		  			      </el-option>
		  			    </el-select>
		  </el-form-item>

	  	  <el-form-item>
	  	  			  <el-button @click="submitInsert()">提交</el-button>
	  				  <el-button @click="dialogVisible1 = false">取消</el-button>
	  	  </el-form-item>
	    </el-form>
	  </el-dialog>
  </div>
</template>
<style>
	.drugs .el-form{
		text-align: left;
		/* height: 50px; */
		/* position: relative; */
	}
	.drugs .el-form-item{
		height: 50px;
	}
	#search{
		width: 60%;
		/* position: absolute; */
		/* margin-left: 100px; */
	}
	.drugs .el-input{
		width: 100%;
	}
	.drugs{
		text-align: left;
	}
	#updateInput{
		width: 80%;
	}
</style>
<script>
	import {pinyin} from '../../../src/chineseTurnPinyin.js'
	
	export default{
		name:'disease',
		data(){
			return{
				diseaselist:[],
				diseaselist1:[],
				deletelist:[],
				diseaseId:2,
				diseaseName:'中型[典型]霍乱',
				dialogVisible:false,
				dialogVisible1:false,
				updateRow:{},
				insertRow:{},
				pageSize:7,
				currPage:1,
				options2: [{
				          value: 101,
				          label: '未确诊'
				        }, {
				          value: 102,
				          label: '已确诊'
				        }, {
				          value: 103,
				          label: '结果未知'
				        }],
				options1:[]
			}
		},
		methods:{
			fun(){
				
			},
			//删除药品
			delRow(row){
				// this.dopaging(this.currPage)
				// this.updateRow=row
				let that = this
				this.$axios.get("http://localhost:8080/disease/deleteById?id="+row.id).then(function(res){
					let diseaseName=that.diseaseName
					let diseaseId=that.diseaseId
					that.$axios.get("http://localhost:8080/disease/list?diseaseName="+diseaseName+"&id="+diseaseId).then(function(res){
						that.diseaselist=res.data
						that.dopaging(that.currPage)
					})
				})
			},
			handleClose(done) {
			        this.$confirm('确认关闭？')
			          .then(_ => {
			            done();
			          })
			          .catch(_ => {});
			},
			//修改
			update(row){
				// console.log(row)
				
				this.updateRow=row
				this.dialogVisible=true
			},
			submitUpdate(){
				let that = this
				let updateRow=this.updateRow
				// console.log(updateRow)
				// console.log(updateRow.drugsDosageId)
				let ue = this.$qs.stringify(updateRow)
				this.$axios.get("http://localhost:8080/disease/insertDrugs?"+ue).then(function(res){
					that.$axios.get("http://localhost:8080/disease/list?id=0").then(function(res){
						// console.log(res)
						that.diseaselist=res.data
					})
				})
				this.dialogVisible=false
			},
			enderTime(date) {
			  var dateee = new Date(date).toJSON();
			  return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '') 
			},
			// 药品插入
			insert(){
				let insertRow=this.insertRow
				// console.log(this.diseaselist.length+">>>>>>>>>>>>>>")
				insertRow.id=this.diseaselist[this.diseaselist.length-1].id+1
				// console.log(insertRow.id)
				this.dialogVisible1=true
				// console.log(this.diseaselist.length)
			},
			//查询药品
			submit(){
				let diseaseName=this.diseaseName
				let diseaseId=this.diseaseId
				let that = this
				this.$axios.get("http://localhost:8080/disease/list?diseaseName="+diseaseName+"&id="+diseaseId).then(function(res){
					that.diseaselist=res.data
			        console.log(res)
					that.diseaselist1=that.diseaselist.slice(0,7)
				})
			},
			//新增药品
			submitInsert(){
				let that = this
				let insertRow=this.insertRow
				console.log(insertRow)
				let ue = this.$qs.stringify(insertRow)
				this.$axios.get("http://localhost:8080/disease/insertDrugs?"+ue).then(function(res){
					that.$axios.get("http://localhost:8080/disease/list?id=0").then(function(res){
						that.diseaselist=res.data
					})
				})
				
				// console.log(currPage)
				this.dialogVisible1=false
			},
			//分页操作
			dopaging(currPage){
				this.currPage=currPage
				let start=(currPage-1)*this.pageSize
				let end=currPage*this.pageSize
				this.diseaselist1=this.diseaselist.slice(start,end)
				
			},
			addPinyin(){
				this.insertRow.mnemonicCode= pinyin.getCamelChars(this.insertRow.name);
			},
			addPinyin1(){
				this.updateRow.mnemonicCode= pinyin.getCamelChars(this.updateRow.name);
			},
			onInput(key, event){
			   this.form[key] = event.match(/^\d*(\.?\d{0,5})/g)[0]
			},
			// 批量操作
			hsc(arr){
				this.deletelist=arr
			},
			deleteDrugs(){
				for(let i=0;i<this.deletelist.length;i++){
					this.delRow(this.deletelist[i])
				}
			}
			
			
			},
			created() {
				let that=this;
				that.$axios.get("http://localhost:8080/disease/list?id=0").then(function(res){
					 //console.log(res)
					that.diseaselist=res.data
					that.diseaselist1=that.diseaselist.slice(0,7)
				})
				that.$axios.get("http://localhost:8080/disease/getConstantItem").then(function(res){
					that.options1=res.data
					 //console.log(that.options1)
				})
			}
	}
</script>
