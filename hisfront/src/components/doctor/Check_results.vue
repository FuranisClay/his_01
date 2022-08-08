<template>
  <div class="checkapply">
	  <div style="font-size:20px;text-align:left">
	  	<i class="el-icon-document-checked">
	  		检查结果查看
	  	</i>
	  </div>
	  <hr>
	<el-form>
		<el-input v-model="projectId" placeholder="请输入检查项目id" style="width: 20%;margin-right: 20px;"></el-input>
		<el-input v-model="name" placeholder="请输入项目名称" style="width: 20%;margin-right: 20px;"></el-input>
		<el-button @click="submit" id="search" style="width: 15%;margin-right: 20px;">搜索</el-button>
	</el-form>
	<hr>
	<el-button @click="insert()">新增结果</el-button>
	<el-button @click="deleteDrugs()">批量删除</el-button>
	<hr>
	<el-table :data="checkapplylist1" class="drugsTable" @selection-change="hsc">
		<el-table-column
		      type="selection"
		      width="55">
		    </el-table-column>
		<el-table-column prop="id" label="检查项目id"></el-table-column>
		<el-table-column prop="registerId" label="挂号序号"></el-table-column>
		<el-table-column prop="name" label="项目名称"></el-table-column>
		<el-table-column prop="num" label="数量"></el-table-column>
		<el-table-column prop="result" label="检查结果"></el-table-column>
		<el-table-column prop="state" label="检查状态"></el-table-column>
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
	  :total="checkapplylist.length"
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
		  <el-form-item label="项目id">
			  <el-input :disabled="false" v-model="updateRow.id" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="挂号序号">
		  			  <el-input v-model="updateRow.registId" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="项目名称">
		  			  <el-input v-model="updateRow.name" @input="addPinyin1" id="updateInput"></el-input>
		  </el-form-item>

		  <el-form-item label="数量">
		  			  <el-input v-model="updateRow.num" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="检查结果">
		  			  <el-input v-model="updateRow.result" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="状态">
		  			  <el-input v-model="updateRow.state" id="updateInput"></el-input>
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
		  <el-form-item label="检查项目状态">
		  			  <el-select v-model="updateRow.recordType" placeholder="请选择">
		  			      <el-option
		  			        v-for="item in options2"
		  			        :key="item.value"
		  			        :label="item.label"
		  			        :value="item.value">
		  			      </el-option>
		  			    </el-select>
		  </el-form-item>
		  <el-form-item label="创建时间" id="creationTime">
		  			 <el-date-picker
		  			       v-model="updateRow.creationTime"
		  			       type="datetime"
		  			       placeholder="选择日期时间"
		  						   value-format="yyyy-MM-dd HH:mm:ss">
		  			     </el-date-picker>
		  					<!-- <el-input v-model="insertRow.creationDate" id="updateInput" placeholder="输入时间年-月-日"
		  						   value-format="yyyy-MM-dd HH:mm:ss" type="datetime"></el-input> -->
		  </el-form-item>
		  <el-form-item label="最后修改时间" id="resultTime">
		  			 <el-date-picker
		  			       v-model="updateRow.resultTime"
		  			       type="datetime"
		  			       placeholder="选择日期时间"
		  						   value-format="yyyy-MM-dd HH:mm:ss">
		  			     </el-date-picker>
		  					<!-- <el-input v-model="insertRow.creationDate" id="updateInput" placeholder="输入时间年-月-日"
		  						   value-format="yyyy-MM-dd HH:mm:ss" type="datetime"></el-input> -->
		  </el-form-item>
		  
		  <el-form-item>
		  			  <el-button @click="submitUpdate">提交</el-button>
					  <el-button @click="dialogVisible = false">取消</el-button>
		  </el-form-item>
	  </el-form>
	</el-dialog>
	<!-- 新增 -->
	<el-dialog
	  title="增加检查结果"
	  :visible.sync="dialogVisible1"
	    width="40%"
	    :before-close="handleClose">
	    <el-form label-width="100px">
	  	  <el-form-item label="项目id">
	  		  <el-input :disabled=true v-model="insertRow.id" id="updateInput"></el-input>
	  	  </el-form-item>
	  	  <el-form-item label="挂号序列">
	  	  			  <el-input v-model="insertRow.registId" id="updateInput"></el-input>
	  	  </el-form-item>
	  	  <el-form-item label="项目名称">
	  	  			  <el-input v-model="insertRow.name" @input="addPinyin" id="updateInput"></el-input>
	  	  </el-form-item>

	  	  <el-form-item label="数量">
	  	  			  <el-input v-model="insertRow.num" id="updateInput"></el-input>
	  	  </el-form-item>
		  <el-form-item label="检查结果">
		  			  <el-input v-model="insertRow.result" id="updateInput"></el-input>
		  </el-form-item>
	  	  <el-form-item label="检查状态">
	  	  			  <el-input v-model="insertRow.stste" id="updateInput"></el-input>
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
		  <el-form-item label="检查项目状态">
		  			  <el-select v-model="insertRow.recordType" placeholder="请选择">
		  			      <el-option
		  			        v-for="item in options2"
		  			        :key="item.value"
		  			        :label="item.label"
		  			        :value="item.value">
		  			      </el-option>
		  			    </el-select>
		  </el-form-item>
		  <el-form-item label="创建时间" id="creationTime">
		  			 <el-date-picker
		  			       v-model="insertRow.creationTime"
		  			       type="datetime"
		  			       placeholder="选择日期时间"
						   value-format="yyyy-MM-dd HH:mm:ss">
		  			     </el-date-picker>
					<!-- <el-input v-model="insertRow.creationDate" id="updateInput" placeholder="输入时间年-月-日"
						   value-format="yyyy-MM-dd HH:mm:ss" type="datetime"></el-input> -->
		  </el-form-item>
		  <el-form-item label="最后修改时间" id="resultTime">
		  			 <el-date-picker
		  			       v-model="insertRow.resultTime"
		  			       type="datetime"
		  			       placeholder="选择日期时间"
		  						   value-format="yyyy-MM-dd HH:mm:ss">
		  			     </el-date-picker>
		  					<!-- <el-input v-model="insertRow.creationDate" id="updateInput" placeholder="输入时间年-月-日"
		  						   value-format="yyyy-MM-dd HH:mm:ss" type="datetime"></el-input> -->
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
		name:'checkapply',
		data(){
			return{
				checkapplylist:[],
				checkapplylist1:[],
				deletelist:[],
				projectId:1,
				name:'腹痛',
				dialogVisible:false,
				dialogVisible1:false,
				updateRow:{},
				insertRow:{},
				pageSize:7,
				currPage:1,
				options2: [{
				          value: 101,
				          label: '未检查'
				        }, {
				          value: 102,
				          label: '正在检查'
				        }, {
				          value: 103,
				          label: '检查结束'
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
				this.$axios.get("http://localhost:8080/checkapply/deleteById?id="+row.id).then(function(res){
					let name=that.name
					let projectId=that.projectId
					that.$axios.get("http://localhost:8080/checkapply/list1?name="+name+"&id="+projectId).then(function(res){
						that.checkapplylist=res.data
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
				row.creationTime=this.enderTime(row.creationTime)
				row.resultTime=this.enderTime(row.resultTime)
				this.updateRow=row
				this.dialogVisible=true
			},
			submitUpdate(){
				let that = this
				let updateRow=this.updateRow
				// console.log(updateRow)
				// console.log(updateRow.drugsDosageId)
				let ue = this.$qs.stringify(updateRow)
				this.$axios.get("http://localhost:8080/checkapply/insertDrugs?"+ue).then(function(res){
					that.$axios.get("http://localhost:8080/checkapply/list1?id=0").then(function(res){
						// console.log(res)
						that.checkapplylist=res.data
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
				// console.log(this.checkapplylist.length+">>>>>>>>>>>>>>")
				insertRow.id=this.checkapplylist[this.checkapplylist.length-1].id+1
				// console.log(insertRow.id)
				this.dialogVisible1=true
				// console.log(this.checkapplylist.length)
			},
			//查询药品
			submit(){
				let name=this.name
				let projectId=this.projectId
				let that = this
				this.$axios.get("http://localhost:8080/checkapply/list1?name="+name+"&id="+projectId).then(function(res){
					that.checkapplylist=res.data
					that.checkapplylist1=that.checkapplylist.slice(0,7)
				})
			},
			//新增药品
			submitInsert(){
				let that = this
				let insertRow=this.insertRow
				console.log(insertRow)
				let ue = this.$qs.stringify(insertRow)
				this.$axios.get("http://localhost:8080/checkapply/insertDrugs?"+ue).then(function(res){
					that.$axios.get("http://localhost:8080/checkapply/list1?id=0").then(function(res){
						that.checkapplylist=res.data
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
				this.checkapplylist1=this.checkapplylist.slice(start,end)
				
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
				that.$axios.get("http://localhost:8080/checkapply/list1?id=0").then(function(res){
					// console.log(res)
					that.checkapplylist=res.data
					that.checkapplylist1=that.checkapplylist.slice(0,7)
				})
				that.$axios.get("http://localhost:8080/checkapply/getConstantItem").then(function(res){
					that.options1=res.data
					// console.log(that.options1)
				})
			}
	}
</script>
