<template>
  <el-container>
    <el-main>
      <div class="login-panle">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="活动名称">
            <el-input ></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-main>
  </el-container>
</template>

<script>
    export default {
        name: "Login"
    }
</script>

<style scoped>
  .el-form label{
    color: azure;
    font-weight: bolder;
  }
  .el-form{
    width: 360px;
    margin: 60px auto;

  }
  .login-panle{
    width: 900px;
    height: 500px;
    background-color: #2c3e50;
    margin-left: auto;
    margin-right: auto;
    margin-top: 0;
    margin-bottom: 0;
    color: azure;
  }
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
    height: 960px;
    display: flex;
    align-items: center; /*定义body的元素垂直居中*/
    justify-content: center; /*定义body的里的元素水平居中*/
  }
  body > .el-container {
    margin-bottom: 40px;
  }

</style>
