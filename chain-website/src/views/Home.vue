<template>
    <a-layout id="home-wrapper">
        <a-layout-sider id="side-bar">
            <div class="logo">
                <span>Crowdchain</span>
            </div>
            <a-menu theme="dark" mode="inline" :defaultSelectedKeys="['3']">
                <a-menu-item key="1">
                    <a-icon type="user" />
                    <span>UserCenter</span>
                </a-menu-item>
                <a-menu-item key="2">
                    <a-icon type="video-camera" />
                    <span>Contest</span>
                </a-menu-item>
                <!--
                <a-menu-item key="3">
                    <a-icon type="upload" />
                    <span>报告管理</span>
                </a-menu-item>
                -->
            </a-menu>
        </a-layout-sider>
        <a-layout>
            <a-layout-header id="home-head-wrapper" style="background: #fff; padding: 0">
                <div id="head-user-info">
                    <span>{{name}}</span>
                    <img id="logo" :src="img.logo" />
                    <img @click="logout" id="logout" :src="img.logout" />
                </div>
            </a-layout-header>
            <a-layout-content
                :style="{ margin: '24px 16px',padding:'20px',background: '#fff', minHeight: '280px' }"
            >
                <router-view></router-view>
            </a-layout-content>
        </a-layout>
    </a-layout>
</template>
<script>
export default {
    name: "Home",
    data() {
        return {
            collapsed: false,
            img: {
                logo: require("@/assets/image/logo1.png"),
                logout: require("@/assets/image/power.png")
            },
            name:""
        };
    },
    created(){
        console.log(this.$route.path);
        if(this.$route.path.toLowerCase() == "/home/managerindex"){
            this.name = "manager2019"
        }else if(this.$route.path.toLowerCase()== "/home/playerindex"){
            this.name = "ZhangHaoming"
        }else if(this.$route.path.toLowerCase() == "/home/platformindex"){
            this.name = "admin"
        }else if(this.$route.path.toLowerCase() == "/home/platformcontest"){
            this.name = "admin"
        }else if(this.$route.path.toLowerCase() == "/home/platformfinal"){
            this.name = "admin"
        }
    },
    methods:{
        logout:function(){
            this.$message.success("登出成功！");
            this.$router.push("/login")
        }
    }
};
</script>
<style>
#home-wrapper {
    height: 100%;
}
#home-wrapper .trigger {
    font-size: 18px;
    line-height: 64px;
    padding: 0 24px;
    cursor: pointer;
    transition: color 0.3s;
}
#home-wrapper .trigger:hover {
    color: #1890ff;
}

#home-wrapper .logo {
    height: 32px;
    background: rgba(255, 255, 255, 0.2);
    margin: 16px;
}
/* 侧栏 */
#side-bar {
    width: 250px !important;
}
#side-bar .logo {
    display: flex;
    justify-content: center;
    align-items: center;
    letter-spacing: 3px;
}
/* 顶栏 */
#home-head-wrapper {
    display: flex;
    align-items: center;
    flex-direction: row-reverse;
}
#head-user-info {
    width: 210px;
}
#head-user-info img {
    cursor: pointer;
}
#logo{
    height: 35px;
    width: 35px;
    margin-right: 10px;
}
#logout{
    height: 25px;
    width: 25px;
}
#head-user-info span {
    width: 107px;
    color: #333333;
    margin-right: 15px;
    font-size: 16px;
}
</style>