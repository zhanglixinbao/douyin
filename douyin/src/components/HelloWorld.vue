<template>
  <div class="hello">
    <el-form ref="form" :model="form" :rules="rules">
      <el-form-item label="姓名" prop="nickname">
        <el-input v-model="form.nickname" placeholder="请输入姓名"/>
      </el-form-item>
      <el-form-item label="手机号" prop="iphone">
        <el-input v-model="form.iphone" placeholder="请输入电话"/>
      </el-form-item>
      <el-form-item label="所属行业" prop="trade">
        <el-input v-model="form.trade" placeholder="请输入所属行业"/>
      </el-form-item>
      <el-form-item label="是否有营业执照" prop="business">
        <el-radio-group v-model="form.business">
          <el-radio :label="0">否</el-radio>
          <el-radio :label="1">是</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="请选择您所在城市" prop="province">
        <el-select v-model="form.province" placeholder="请选择" @change="getCity()">
          <el-option
            v-for="item in provinceOption"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
        </el-select>
        <el-select v-model="form.city" placeholder="请选择">
          <el-option
            v-for="item in cityOption"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="请选择咨询的产品" prop="products">
        <el-select v-model="form.products" placeholder="请选择" style="width: 100%">
          <el-option
            v-for="item in productsOption"
            :key="item.name"
            :label="item.name"
            :value="item.name">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="请简述下您的需求" prop="ps">
        <el-input
          type="textarea"
          placeholder="请输入内容"
          v-model="form.ps"
          show-word-limit
        />
      </el-form-item>
      <el-button type="primary" @click="submitForm">确 定</el-button>
    </el-form>
  </div>
</template>

<script>

export default {
  name: 'HelloWorld',
  data () {
    // var validatePass = (rule, value, callback) => {
    //   console.log(1)
    //   this.getCity()
    //   callback()
    // }
    return {
      form: {
        userid: undefined,
        nickname: undefined,
        iphone: undefined,
        trade: undefined,
        business: undefined,
        province: undefined,
        city: undefined,
        products: undefined,
        ps: undefined
      },
      productsOption: [{name: '抖音运营'}, {name: '企业网站建设'}],
      provinceOption: [],
      cityOption: [],
      rules: {
        nickname: [
          {required: true, message: '姓名不能为空', trigger: 'blur'}
        ],
        iphone: [
          {required: true, message: '电话不能为空', trigger: 'blur'},
          {
            pattern: /^0{0,1}(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8}$/,
            message: '手机号格式不对',
            trigger: 'blur'
          }
        ],
        trade: [
          {required: true, message: '所属行业不能为空', trigger: 'blur'}
        ],
        business: [
          {required: true, message: '是否营业执照不能为空', trigger: 'blur'}
        ],
        province: [
          // {validator: validatePass, trigger: 'blur'},
          {required: true, message: '所在省不能为空', trigger: 'blur'}

        ],
        city: [
          {required: true, message: '所在市不能为空', trigger: 'blur'}
        ],
        products: [
          {required: true, message: '咨询产品不能为空', trigger: 'blur'}
        ],
        ps: [
          {required: true, message: '需求不能为空', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    submitForm: function () {
      this.$refs['form'].validate(valid => {
        if (valid) {
          this.postRequest('/test',this.form).then(resp => {
          })
        }
      })
    },
    getProvinceList () {
      this.getRequest('/test').then(resp => {
      })
      this.getRequest('/getProvinceList').then(resp => {
        this.provinceOption = resp.rows
      })
    },
    getCity () {
      this.cityOption = []
      this.form.city = undefined
      this.getRequest('/getCity/' + this.form.province).then(resp => {
        this.cityOption = resp.rows
      })
    }
  },
  created () {
    this.getProvinceList()
  }
}
</script>

<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
