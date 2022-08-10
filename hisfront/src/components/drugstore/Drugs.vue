<template>
  <div class="drugs">
	  <hr>
	  <h4><i class="el-icon-edit-outline"></i>药房管理</h4>
	  <hr>
	<el-form>
		<el-input v-model="drugsId" placeholder="请输入药品id" style="width: 20%;margin-right: 20px;"></el-input>
		<el-input v-model="drugsName" placeholder="请输入药品名称" style="width: 20%;margin-right: 20px;"></el-input>
		<el-button @click="submit" id="search" style="width: 15%;margin-right: 20px;">搜索</el-button>
	</el-form>
	<hr>
	<el-button @click="insert()">新增</el-button>
	<el-button @click="deleteDrugs()">批量删除</el-button>
	<hr>
	<el-table :data="drugslist1" class="drugsTable" @selection-change="hsc">
		<el-table-column
		      type="selection"
		      width="55">
		    </el-table-column>
		<el-table-column prop="id" label="药品id"></el-table-column>
		<el-table-column prop="drugsCode" label="药品编码"></el-table-column>
		<el-table-column prop="drugsName" label="药品名称"></el-table-column>
		<el-table-column prop="drugsFormat" label="药品规格"></el-table-column>
		<el-table-column prop="manufacturer" label="生产厂商"></el-table-column>
		<el-table-column prop="drugsPrice" label="药品单价"></el-table-column>
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
	  :total="drugslist.length"
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
		  <el-form-item label="药品id">
			  <el-input :disabled="true" v-model="updateRow.id" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="药品编码">
		  			  <el-input v-model="updateRow.drugsCode" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="药品名称">
		  			  <el-input v-model="updateRow.drugsName" @input="addPinyin1" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="拼音助记码">
		  			  <el-input v-model="updateRow.mnemonicCode"  id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="药品规格">
		  			  <el-input v-model="updateRow.drugsFormat" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="包装规格">
		  			  <el-input v-model="updateRow.drugsUnit" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="生产厂商">
		  			  <el-input v-model="updateRow.manufacturer" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="药品单价">
		  			  <el-input v-model="updateRow.drugsPrice" id="updateInput"></el-input>
		  </el-form-item>
		  <el-form-item label="药品剂型">
		  			  <el-select v-model="updateRow.drugsDosageId"  placeholder="请选择">
		  			      <el-option
		  			        v-for="item in options1"
		  			        :key="item.id"
		  			        :label="item.constantName"
		  			        :value="item.id">
		  			      </el-option>
		  			    </el-select>
		  </el-form-item>
		  <el-form-item label="药品类型">
		  			  <el-select v-model="updateRow.drugsTypeId" placeholder="请选择">
		  			      <el-option
		  			        v-for="item in options2"
		  			        :key="item.value"
		  			        :label="item.label"
		  			        :value="item.value">
		  			      </el-option>
		  			    </el-select>
		  </el-form-item>
		  <el-form-item label="创建时间" id="creationDate">
		  			 <el-date-picker
		  			       v-model="updateRow.creationDate"
		  			       type="datetime"
		  			       placeholder="选择日期时间"
		  						   value-format="yyyy-MM-dd HH:mm:ss">
		  			     </el-date-picker>
		  					<!-- <el-input v-model="insertRow.creationDate" id="updateInput" placeholder="输入时间年-月-日"
		  						   value-format="yyyy-MM-dd HH:mm:ss" type="datetime"></el-input> -->
		  </el-form-item>
		  <el-form-item label="最后修改时间" id="lastCreationDate">
		  			 <el-date-picker
		  			       v-model="updateRow.lastUpdateDate"
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
	  title="增加药品"
	  :visible.sync="dialogVisible1"
	    width="40%"
	    :before-close="handleClose">
	    <el-form label-width="100px">
	  	  <el-form-item label="药品id">
	  		  <el-input :disabled=true v-model="insertRow.id" id="updateInput"></el-input>
	  	  </el-form-item>
	  	  <el-form-item label="药品编码">
	  	  			  <el-input v-model="insertRow.drugsCode" id="updateInput"></el-input>
	  	  </el-form-item>
	  	  <el-form-item label="药品名称">
	  	  			  <el-input v-model="insertRow.drugsName" @input="addPinyin" id="updateInput"></el-input>
	  	  </el-form-item>
		  <el-form-item label="拼音助记码">
		  			  <el-input v-model="insertRow.mnemonicCode " id="updateInput"></el-input>
		  </el-form-item>
	  	  <el-form-item label="药品规格">
	  	  			  <el-input v-model="insertRow.drugsFormat" id="updateInput"></el-input>
	  	  </el-form-item>
		  <el-form-item label="包装规格">
		  			  <el-input v-model="insertRow.drugsUnit" id="updateInput"></el-input>
		  </el-form-item>
	  	  <el-form-item label="生产厂商">
	  	  			  <el-input v-model="insertRow.manufacturer" id="updateInput"></el-input>
	  	  </el-form-item>
	  	  <el-form-item label="药品单价">
	  	  			  <el-input v-model="insertRow.drugsPrice"  id="updateInput"></el-input>
	  	  </el-form-item>
		  <el-form-item label="药品剂型">
		  			  <el-select v-model="insertRow.drugsDosageId" placeholder="请选择">
		  			      <el-option
		  			        v-for="item in options1"
		  			        :key="item.id"
		  			        :label="item.constantName"
		  			        :value="item.id">
		  			      </el-option>
		  			    </el-select>
		  </el-form-item>
		  <el-form-item label="药品类型">
		  			  <el-select v-model="insertRow.drugsTypeId" placeholder="请选择">
		  			      <el-option
		  			        v-for="item in options2"
		  			        :key="item.value"
		  			        :label="item.label"
		  			        :value="item.value">
		  			      </el-option>
		  			    </el-select>
		  </el-form-item>
		  <el-form-item label="创建时间" id="creationDate">
		  			 <el-date-picker
		  			       v-model="insertRow.creationDate"
		  			       type="datetime"
		  			       placeholder="选择日期时间"
						   value-format="yyyy-MM-dd HH:mm:ss">
		  			     </el-date-picker>
					<!-- <el-input v-model="insertRow.creationDate" id="updateInput" placeholder="输入时间年-月-日"
						   value-format="yyyy-MM-dd HH:mm:ss" type="datetime"></el-input> -->
		  </el-form-item>
		  <el-form-item label="最后修改时间" id="creationDate">
		  			 <el-date-picker
		  			       v-model="insertRow.lastUpdateDate"
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
	.el-input{
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
		name:'Drugs',
		data(){
			return{
				drugslist:[],
				drugslist1:[],
				deletelist:[],
				drugsId:0,
				drugsName:'',
				dialogVisible:false,
				dialogVisible1:false,
				updateRow:{},
				insertRow:{},
				pageSize:7,
				currPage:1,
				options2: [{
				          value: 101,
				          label: '西药'
				        }, {
				          value: 102,
				          label: '中成药'
				        }, {
				          value: 103,
				          label: '中草药'
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
				this.$axios.get("http://localhost:8080/drugsCq/deleteById?id="+row.id).then(function(res){
					console.log(res)
					let drugsName=that.drugsName
					let drugsId=that.drugsId
					that.$axios.get("http://localhost:8080/drugsCq/list?drugsName="+drugsName+"&id="+drugsId).then(function(res){
						that.drugslist=res.data
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
				row.creationDate=this.enderTime(row.creationDate)
				row.lastUpdateDate=this.enderTime(row.lastUpdateDate)
				this.updateRow=row
				this.dialogVisible=true
			},
			submitUpdate(){
				let that = this
				let updateRow=this.updateRow
				// console.log(updateRow)
				// console.log(updateRow.drugsDosageId)
				let ue = this.$qs.stringify(updateRow)
				this.$axios.get("http://localhost:8080/drugsCq/insertDrugs?"+ue).then(function(res){
					that.$axios.get("http://localhost:8080/drugsCq/list?id=0").then(function(res){
						console.log(res)
						that.drugslist=res.data
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
				// console.log(this.drugslist.length+">>>>>>>>>>>>>>")
				insertRow.id=this.drugslist[this.drugslist.length-1].id+1
				// console.log(insertRow.id)
				this.dialogVisible1=true
				// console.log(this.drugslist.length)
			},
			//查询药品
			submit(){
				let drugsName=this.drugsName
				let drugsId=this.drugsId
				let that = this
				this.$axios.get("http://localhost:8080/drugsCq/list?drugsName="+drugsName+"&id="+drugsId).then(function(res){
					that.drugslist=res.data
					that.drugslist1=that.drugslist.slice(0,7)
				})
			},
			//新增药品
			submitInsert(){
				let that = this
				let insertRow=this.insertRow
				console.log(insertRow)
				let ue = this.$qs.stringify(insertRow)
				this.$axios.get("http://localhost:8080/drugsCq/insertDrugs?"+ue).then(function(res){
					that.$axios.get("http://localhost:8080/drugsCq/list?id=0").then(function(res){
						that.drugslist=res.data
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
				this.drugslist1=this.drugslist.slice(start,end)
				
			},
			addPinyin(){
				this.insertRow.mnemonicCode= pinyin.getCamelChars(this.insertRow.drugsName);
			},
			addPinyin1(){
				this.updateRow.mnemonicCode= pinyin.getCamelChars(this.updateRow.drugsName);
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
				that.$axios.get("http://localhost:8080/drugsCq/list?id=0").then(function(res){
					console.log(res)
					that.drugslist=res.data
					that.drugslist1=that.drugslist.slice(0,7)
				})
				that.$axios.get("http://localhost:8080/drugsCq/getConstantItem").then(function(res){
					that.options1=res.data
					// console.log(that.options1)
				})
			}
	}
</script>
