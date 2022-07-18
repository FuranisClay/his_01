<!-- <template>
  <div class="about">
	  <el-button @click="getData">获取数据</el-button>
    {{msg}}
	<hr />
	
	<el-table
	    :data="news"
	    style="width: 40%">
	    <el-table-column
	      prop="index"
	      label="编号"
	      >
	    </el-table-column>
	    <el-table-column
	      prop="word"
	      label="内容"
	      >
		  </el-table-column>
	  </el-table>
	  
  </div>
</template>

<script>
	export default{
		data(){
			return{
				msg:'123456',
				news:[]
			}
		},
		methods:{
			getData(){
				//通过axios框架，获取服务器数据--天行数据
				this.$axios.get("http://api.tianapi.com/wxhottopic/index?key=b6e65a01ee580698e8507be338aaca2a").then((res)=>{
					console.log(res.data.newslist);
					
					this.news=res.data.newslist
					
				})
			}
		}
	}
	
	
</script>
<style>
	.el-table{
		margin:0px auto;
	}
</style>
 -->

<template>
	<div class="about">
		<el-button @click="delSelectionRows">批量删除</el-button>
		<el-button @click="getData">获取数据</el-button>
        <el-button @click="InsertdialogVisible=true">添加数据</el-button>
		<hr />
		<el-table :data="subNews" @selection-change="hsc" style="width: 60%">
			<el-table-column  type="selection"  width="55">
			</el-table-column>
			<el-table-column prop="index" label="编号">
			</el-table-column>
			<el-table-column prop="word" label="内容">
			</el-table-column>
			<el-table-column label="编辑">
				<template slot-scope="scope">
					<el-button @click="doUpdate(scope.row)" icon="el-icon-edit"></el-button>
					&nbsp;
					<el-button @click="delRow(scope.$index)" icon="el-icon-delete"></el-button>
				</template>
			</el-table-column>
		</el-table>
		<el-pagination
		  background
		  :page-size="pageSize"
		  layout="prev, pager, next"
		  :total="news.length"
		  @current-change="dopaging"
		  >
		</el-pagination>
		
		<!-- 修改对话框 -->
		<el-dialog
		  title="修改信息"
		  :visible.sync="dialogVisible"
		  width="30%">
		  <el-form  label-width="80px">
		    <el-form-item label="编码">
		      <el-input disabled=true v-model="updateRow.index"></el-input>
		    </el-form-item>
		    <el-form-item label="内容">
		      <el-input v-model="updateRow.word"></el-input>
		    </el-form-item>
		    <el-form-item>
		        <el-button @click="dialogVisible=false">提交</el-button>
		        <el-button @click="dialogVisible=false">取消</el-button>
		      </el-form-item>
		  </el-form>
		</el-dialog>
	    <!-- 添加对话框 -->
		<el-dialog
		  title="添加信息"
		  :visible.sync="InsertdialogVisible"
		  width="30%">
		  <el-form  label-width="80px">
		    <el-form-item label="编码">
		      <el-input v-model="InsertRow.index"></el-input>
		    </el-form-item>
		    <el-form-item label="内容">
		      <el-input v-model="InsertRow.word"></el-input>
		    </el-form-item>
		    <el-form-item>
		        <el-button @click="doInsert">提交</el-button>
		        <el-button @click="dialogVisible=false">取消</el-button>
		      </el-form-item>
		  </el-form>
		</el-dialog>
	</div>

</template>

<script>
	export default {
		data() {
			return {
				dialogVisible:false,
				InsertdialogVisible:false,
				
				msg: '>>>>>>',
				news: [],
				subNews:[],
				delArr:[],
				pageSize:2,
				currPage:1,
				updateRow:{},
				InsertRow:{}
			}
		},
		methods: {
			doInsert(){
				this.news.unshift(this.InsertRow)
				this.InsertRow={}
				this.dopaging(1)
				
				this.InsertdialogVisible=false
			},
			doUpdate(row){
				this.updateRow=row
				this.dialogVisible=true
			},
			dopaging(currPage){
				this.currPage=currPage   //将当前选择的页码存储到vue的全局变量里
				//根据当前页进行分页
				//currpage      pageSize     start   end
				// 1               2          0       2        0,1
				// 2               2          2       4        2,3
				//3  ...
				let start=(currPage-1)*this.pageSize 
				let end=currPage*this.pageSize
				
				this.subNews=this.news.slice(start,end)
				
			},
			delSelectionRows(){
				
				for(let i in this.delArr){
					let dr=this.delArr[i]   
					console.log(dr)
					for(let j in this.news){
						if(dr.index==this.news[j].index){
							this.news.splice(j,1)
						}
					}
				}
				//重新计算分页
				this.dopaging(this.currPage)
			},
			delRow(index){
				console.log(index+">>>>>>>>>>>>>.")
				//this.news.splice(index,1)
				let r=this.subNews.splice(index,1)  //从数据表格中正在显示的数据中删除
		
				//将数据从news中删除
				for(let i in this.news){
					if(this.news[i].index==r[0].index){
						this.news.splice(i,1)
					}
				}
				
				this.dopaging(this.currPage)  //删除成功后，重新分页
			},
			hsc(arr){
				this.delArr=arr
			},
			getData() {
				//通过axios框架，获取服务器数据---天行数据
				let key = "b6e65a01ee580698e8507be338aaca2a"
				this.$axios.get("http://api.tianapi.com/wxhottopic/index?key=" + key).then((res) => {
					console.log(res.data.newslist)
					this.news = res.data.newslist
					this.dopaging(1)

				})
			},
			
		}
	}
</script>

<style>
	.el-table {
		margin: 0px auto;
	}
</style>
