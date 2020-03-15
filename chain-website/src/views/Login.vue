<template>
    <div id="wrapper">
        <div id="content-wrapper">
            <!-- 头部信息 -->
            <div id="head-wrapper">
                <div id="logo-wrapper">
                    <img :src="logo" />
                </div>
                <div id="head-info-wrapper">
                    <span id="head-info">Crowdchain</span>
                </div>
            </div>
            <!-- 登陆表单信息 -->
            <div id="form-wrapper">
                <a-form id="form" :form="form" @submit="handleSubmit">
                    <a-form-item label="Username">
                        <a-input
                            v-decorator="['username',{
                                rules: [{ required: true, message: 'Username is required!' }],
                            },]"
                        />
                    </a-form-item>
                    <a-form-item label="Password">
                        <a-input
                            v-decorator="['password',{
                                rules: [{ required: true, message: 'Password is required!' }],
                            },]"
                            type="password"
                        />
                    </a-form-item>

                    <a-button type="primary" html-type="submit">登陆</a-button>
                </a-form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Login",
    data() {
        return {
            formLayout: "horizontal",
            logo: require("@/assets/image/logo1.png"),
            form: this.$form.createForm(this, { name: "coordinated" })
        };
    },
    methods: {
        handleSubmit(e) {
            e.preventDefault();
            console.log(this.form.getFieldsValue());
            let data = {
                username: this.form.getFieldValue("username"),
                password: this.form.getFieldValue("password")
            };

            if (data.username == "ZhangHaoming" && data.password == 123456) {
                // 测试 直接跳转
                setTimeout(() => {
                    this.$message.success("登陆成功！");
                }, 500);
                setTimeout(() => {
                    this.$router.push("/Home/playerIndex");
                }, 1000);
            } else if (data.username == "manager2019" && data.password == 123456) {
                // 测试 直接跳转
                setTimeout(() => {
                    this.$message.success("登陆成功！");
                }, 500);
                setTimeout(() => {
                    this.$router.push("/Home/managerIndex");
                }, 1000);
            } else if (data.username == "admin" && data.password == 123456) {
                setTimeout(() => {
                    this.$message.success("登陆成功！");
                }, 500);
                setTimeout(() => {
                    this.$router.push("/Home/platformIndex");   
                }, 1000);
            }else{
                setTimeout(() => {
                    this.$message.warning("用户名或密码错误，请重新输入");    
                }, 500);
            }
            // this.axios
            //     .post("/login", data)
            //     .then(res => {
            //         if (res.data.status == "success") {
            //             this.$message.success("登陆成功！");
            //             // 跳转

            //         }else{
            //             this.$message.warning("用户名或密码错误，请重新输入...");
            //         }
            //     })
            //     .catch(err => {
            //         this.$message.warning("登陆失败，请稍后再试...");
            //         console.log(err);
            //     });
        }
    },
    created() {}
};
</script>

<style scoped>
#wrapper {
    background-color: #f9f9f9;
    height: 100%;
    width: 100%;
    display: flex;
    justify-content: center;
}
#content-wrapper {
    width: 360px;
    height: 400px;
}
/* 头部信息  */
#head-wrapper {
    background-color: transparent;
    height: 150px;
    width: 100%;
}
#logo-wrapper {
    height: 90px;
    display: flex;
    justify-content: center;
    align-items: center;
}
#head-wrapper img {
    margin-top: 15px;
    height: 50px;
    width: 50px;
}
#head-info-wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 60px;
    width: 100%;
    color: #333333;
    font-size: 25px;
}
#head-info-wrapper span {
    margin-bottom: 15px;
}
/* 登陆表单信息 */
#form-wrapper {
    padding: 10px 20px 20px 20px;
    background-color: #ffffff;
    border: 1px solid #d8dee2;
}
#form button {
    width: 100%;
}
</style>