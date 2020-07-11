<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="姓名" prop="nickname">
        <el-input
          v-model="queryParams.nickname"
          placeholder="请输入姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话" prop="iphone">
        <el-input
          v-model="queryParams.iphone"
          placeholder="请输入电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属行业" prop="trade">
        <el-input
          v-model="queryParams.trade"
          placeholder="请输入所属行业"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否营业执照" prop="business">
        <el-input
          v-model="queryParams.business"
          placeholder="请输入是否营业执照"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所在省" prop="province">
        <el-input
          v-model="queryParams.province"
          placeholder="请输入所在省"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所在市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入所在市"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="咨询产品" prop="products">
        <el-input
          v-model="queryParams.products"
          placeholder="请输入咨询产品"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="需求" prop="ps">
        <el-input
          v-model="queryParams.ps"
          placeholder="请输入需求"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:customer:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:customer:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:customer:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:customer:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="customerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户id" align="center" prop="userid" />
      <el-table-column label="姓名" align="center" prop="nickname" />
      <el-table-column label="电话" align="center" prop="iphone" />
      <el-table-column label="所属行业" align="center" prop="trade" />
      <el-table-column label="是否营业执照" align="center" prop="business" />
      <el-table-column label="所在省" align="center" prop="province" />
      <el-table-column label="所在市" align="center" prop="city" />
      <el-table-column label="咨询产品" align="center" prop="products" />
      <el-table-column label="需求" align="center" prop="ps" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:customer:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:customer:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改客户对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="nickname">
          <el-input v-model="form.nickname" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="电话" prop="iphone">
          <el-input v-model="form.iphone" placeholder="请输入电话" />
        </el-form-item>
        <el-form-item label="所属行业" prop="trade">
          <el-input v-model="form.trade" placeholder="请输入所属行业" />
        </el-form-item>
        <el-form-item label="是否营业执照" prop="business">
          <el-input v-model="form.business" placeholder="请输入是否营业执照" />
        </el-form-item>
        <el-form-item label="所在省" prop="province">
          <el-input v-model="form.province" placeholder="请输入所在省" />
        </el-form-item>
        <el-form-item label="所在市" prop="city">
          <el-input v-model="form.city" placeholder="请输入所在市" />
        </el-form-item>
        <el-form-item label="咨询产品" prop="products">
          <el-input v-model="form.products" placeholder="请输入咨询产品" />
        </el-form-item>
        <el-form-item label="需求" prop="ps">
          <el-input v-model="form.ps" placeholder="请输入需求" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCustomer, getCustomer, delCustomer, addCustomer, updateCustomer, exportCustomer } from "@/api/system/customer";

export default {
  name: "Customer",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 总条数
      total: 0,
      // 客户表格数据
      customerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        nickname: undefined,
        iphone: undefined,
        trade: undefined,
        business: undefined,
        province: undefined,
        city: undefined,
        products: undefined,
        ps: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询客户列表 */
    getList() {
      this.loading = true;
      listCustomer(this.queryParams).then(response => {
        this.customerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        userid: undefined,
        nickname: undefined,
        iphone: undefined,
        trade: undefined,
        business: undefined,
        province: undefined,
        city: undefined,
        products: undefined,
        ps: undefined
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.userid)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加客户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const userid = row.userid || this.ids
      getCustomer(userid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改客户";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.userid != undefined) {
            updateCustomer(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addCustomer(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const userids = row.userid || this.ids;
      this.$confirm('是否确认删除客户编号为"' + userids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delCustomer(userids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有客户数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportCustomer(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>