<template>
  <el-container style="height: 100%">
    <el-aside
      :width="sidewidth + 'px'"
      style="background-color: rgb(211, 241, 246); height: 100%"
    >
      <el-menu
        :default-openeds="['1', '3']"
        background-color="black"
        style="overflow-x: hidden; min-height: 100%"
        :collapse="isCollapse"
        :collapse-transition="false"
      >
        <el-submenu index="1">
          <template slot="title"
            ><i class="el-icon-message"></i>
            <span>导航一</span>
          </template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="1-1">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="1-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="1-4">
            <template slot="title">选项4</template>
            <el-menu-item index="1-4-1">选项4-1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title"
            ><i class="el-icon-menu"></i><span>导航二</span></template
          >
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="2-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="2-4">
            <template slot="title">选项4</template>
            <el-menu-item index="2-4-1">选项4-1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title"
            ><i class="el-icon-setting"></i><span>导航三</span></template
          >
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="3-1">选项1</el-menu-item>
            <el-menu-item index="3-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="3-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="3-4">
            <template slot="title">选项4</template>
            <el-menu-item index="3-4-1">选项4-1</el-menu-item>
          </el-submenu>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="font-size: 12px">
        <i
          class="el-icon-s-unfold"
          @click="dj"
          style="cursor: pointer; font-size: 20px"
        ></i>
        <span style="margin-left: 1160px">王小虎</span>
        <el-dropdown>
          <i class="el-icon-user" style="margin-left: 5px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>

      <el-main style="margin: 0px 10px">
        <el-input
          type="text"
          placeholder="请输入名字"
          style="width: 150px"
          class="ma"
          v-model="username"
        />
        <el-input
          type="text"
          placeholder="请输入邮箱"
          style="width: 150px"
          class="ma"
          v-model="email"
        />
        <el-button icon="el-icon-search" circle @click="btu_find"></el-button>
        <el-button type="primary" icon="el-icon-plus" circle></el-button>

        <el-table :data="tableData">
          <el-table-column prop="id" label="id" width="140">
          </el-table-column>
          <el-table-column prop="name" label="姓名" width="240">
          </el-table-column>
          <el-table-column prop="age" label="年龄" width="240">
          </el-table-column>
          <el-table-column prop="phone" label="电话" width="240">
          </el-table-column>
          <el-table-column prop="email" label="邮箱" width="240">
          </el-table-column>
          <el-table-column prop="c" label="操作" width="160">
            <el-button type="danger" icon="el-icon-edit" circle></el-button>
            <el-popconfirm
              title="这是一段内容确定删除吗？"
              style="margin: 0px 10px"
            >
              <!-- <el-button slot="reference">删除</el-button> -->
              <el-button
                slot="reference"
                type="danger"
                icon="el-icon-delete"
                circle
              ></el-button>
            </el-popconfirm>
          </el-table-column>
        </el-table>
      </el-main>
      <div class="block">
        <span class="demonstration"></span>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page.sync="currentPage2"
          :page-sizes="[2, 5, 8]"
          :page-size="pageSize"
          layout="sizes, prev, pager, next"
          :total="total"
        >
        </el-pagination>
      </div>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      tableData: [],
      isCollapse: false,
      sidewidth: 200,
      pageNum:1,
      pageSize:2,
      currentPage2: 0,
      total:0,
      username:'',
      email:''
    };
  },
  //创建时填充数据 钩子函数
  created() {
    //调用查询方法
    this.load();
  },
  methods: {
    dj() {
      this.isCollapse = !this.isCollapse;
      if (this.isCollapse) {
        this.sidewidth = 64;
      } else {
        this.sidewidth = 200;
      }
    },
    //搜索
    btu_find(){
      console.info(this.username)
      console.info(this.email)
      this.load()
    },
    //定义一个获取所有user数据的方法
    load(){
      this.request.get('http://localhost:9090/user/page',{
        params:{
          pageNum:this.pageNum,
          pageSize: this.pageSize,
          username: this.username,
          email: this.email
        }
      }).then(res=>{
        console.info(res)
        this.tableData = res.records
        this.total = res.total
      })
    },
    changLoad(pageSize){
      this.request.get('http://localhost:9090/user/page',{
        params:{
          pageNum:this.pageNum,
          pageSize: pageSize,
          username: this.username,
          email: this.email
        }
      }).then(res=>{
        console.info(res)
        this.tableData = res.records
        this.total = res.total
      })
    },
    handleSizeChange(val) {
      //当前页
      this.pageSize=val
      this.changLoad(val)
    },
    handleCurrentChange(val) {
      this.pageNum=val
      console.info('handleCurrentChange',val)
      this.load()
    },
  },
};
</script>
<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
.ma {
  margin-right: 5px;
}
</style>
