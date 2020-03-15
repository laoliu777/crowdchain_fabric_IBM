<template>
    <div id="content-wrapper">
        <!--<router-view v-if="isRouterAlive=='true'">-->
        <a-row>
            <a-col :span="13">
                <div id="table-caption">
                    <span id="info1" @click="back">Contest</span>
                    <span> : QQMusic /</span>
                    <span id="info2">TestReportOverview</span>
                </div>
                <a-table :columns="columns" :dataSource="data" :rowSelection="rowSelection" >
                </a-table>
            </a-col>
            <a-col :span="1"></a-col>
            <a-col :span="9">
                <div id="table-caption">
                    <span>FinalReport</span>
                </div>
                <a-table :columns="columns2" :pagination="false" :dataSource="data2">
                    <!--<a-button slot="finalVerification" @click="finalverify" type="primary">Click</a-button>-->
                    <span slot="operation" >
                        <a-button @click="showModalFinal" type="primary" slot="operation">Click</a-button>
                        <a-modal
                        title="Please submit a doc!"
                        :visible="visibleFinal"
                        @ok="handleOkSubmitFinal"
                        :confirmLoading="confirmLoadingFinal"
                        @cancel="handleCancelFinal"
                        >
                        <!--<p>{{ModalText}}</p>@click="docSubmit"-->
                        <a-upload-dragger
                            name="file"
                            :multiple="true"
                            action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
                            @change="handleChange"
                        >
                            <p class="ant-upload-drag-icon">
                            <a-icon type="inbox" />
                            </p>
                            <p class="ant-upload-text">Click or drag file to this area to upload</p>
                            <p class="ant-upload-hint">
                            Support for a single or bulk upload. Strictly prohibit from uploading company data or other
                            band files
                            </p>
                        </a-upload-dragger>
                        </a-modal>
                    </span>
                </a-table>
                <div id="verify">
                    <!--
                    <a-button style="float:right" @click="verify" size="large" type="primary">SourceVerify</a-button>
                    <a-icon v-show="checked" type="check" />
                    -->
                    <a-button type="primary" @click="showModalSource">SourceVerify</a-button>
                    <a-modal
                        title="Verification succeeded!"
                        :visible="visibleSource"
                        @ok="handleOkSource"
                        :confirmLoading="confirmLoadingSource"
                        @cancel="handleCancelSource"
                    >
                    <p>{{ModalText1}}</p>
                    <p>{{ModalText2}}</p>
                    <p>{{ModalText3}}</p>
                    </a-modal>
                </div>
            </a-col>
        </a-row>
        <!--</router-view>-->
    </div>
</template>

<script>
const columns = [
    {
        title: "TestReportID",
        dataIndex: "testReport"
    },
    {
        title: "PlayerName",
        dataIndex: "playername"
    },
    {
        title: "SubmitTime",
        dataIndex: "subtime"
    },
   
];

const data = [
        {
        testReport: "5cc30cf2825a8960cdc7bd6c",
        playername: "ZhangHaoming",
        subtime:"2019-12-10 12:01:34"
    },
    {
        testReport: "5cc5717e825a8960cdc7bd9b",
        playername: "WangWu",
        subtime:"2019-12-10 11:08:01"
    },
    {
        testReport: "5cc5b99f825a8938b52ec7ef",
        playername: "ZhangSan",
        subtime:"2019-12-10 10:49:37"
    },
    {
        testReport: "5cd7c1b9825a8948e757ca09",
        playername: "LiSi",
        subtime:"2019-12-10 10:07:45"
    },
    {
        testReport: "5cd7c8e8825a8948e757ca10",
        playername: "MaLa",
        subtime:"2019-12-10 10:01:44"
    },
    {
        testReport: "5cd7ca14825a8948e757ca11",
        playername: "YuanWu",
        subtime:"2019-12-10 09:51:41"
    },
    {
        testReport: "5ce4f268c9e77c000e7d8e9a",
        playername: "KevinKing",
        subtime:"2019-12-10 09:36:18"
    },
    {
        testReport: "5ce4f90ec9e77c000e7d8e9d",
        playername: "LilWayne",
        subtime:"2019-12-10 08:01:34"
    },
    {
        testReport: "5ce51125c9e77c000e7d8e9e",
        playername: "FrankBrown",
        subtime:"2019-12-09 22:01:44"
    },
    {
        testReport: "5cf39370c9e77c000d244c48",
        playername: "DwayneIsia",
        subtime:"2019-12-09 21:47:37"
    },
    {
        testReport: "5cf4a3e3c9e77c000ddc48c3",
        playername: "TiaSadd",
        subtime:"2019-12-09 20:01:34"
    },
    {
        testReport: "5cf61be7c9e77c000e85d3f7",
        playername: "QuincyDunt",
        subtime:"2019-12-09 19:56:54"
    },
    {
        testReport: "5cf78160c9e77c000e85d41e",
        playername: "BobbyTaylor",
        subtime:"2019-12-09 18:47:75"
    },
    {
        testReport: "5cf78de6c9e77c000e85d42a",
        playername: "TanYin",
        subtime:"2019-12-09 17:34:17"
    },
    {
        testReport: "5cf8b069c9e77c000e85d42b",
        playername: "LiTi",
        subtime:"2019-12-09 16:16:46"
    },
    {
        testReport: "5cf8b2c4c9e77c000e85d431",
        playername: "LiYu",
        subtime:"2019-12-09 15:28:08"
    },
    {
        testReport: "5cfb7f93c9e77c000e3e1c06",
        playername: "WangEnbo",
        subtime:"2019-12-09 14:41:34"
    },


];

const rowSelection = {
    onChange: (selectedRowKeys, selectedRows) => {
      console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
    },
    onSelect: (record, selected, selectedRows) => {
      console.log(record, selected, selectedRows);
    },
    onSelectAll: (selected, selectedRows, changeRows) => {
      console.log(selected, selectedRows, changeRows);
    },
  };

// 右方表格
const columns2 = [
    {
        title: "FinalReport",
        dataIndex: "finalReport"
    },
    {
        title: "TraceHash",
        dataIndex: "tracehash"
    },
    {
        title: "Verify",
        dataIndex: "operation",
        scopedSlots: { customRender: "operation" }
    }
];

const data2 = [
    {
        finalReport: "QQMusicFinalReport",
        tracehash: "9d070ab8c9e77c000e3e1c08",
        //finalVerification: ""
    }
];

export default {
    name: "platformFinal",
    provide () {
        return {
            reload: this.reload
        }
    },
    inject:['reload'],
    data() {
        return {
            data,
            data2,
            columns,
            columns2,
            rowSelection,
            checked: false,
            ModalText1: 'Hash Sum Of Source Reports:9d070ab8c9e77c000e3e1c08',
            ModalText2: 'Hash Of the Final Report:  9d070ab8c9e77c000e3e1c08',
            ModalText3: 'Calculated hash value in report overview matches final result',            
            visibleSource: false,
            confirmLoadingSource: false,
            visibleFinal: false,
            confirmLoadingFinal: false,
            isRouterAlive: true,
        };
    },
    methods: {
        /*
        verify: function() {
            clearTimeout(this.timer);  //清除延迟执行 
            this.timer = setTimeout(()=>{   //设置延迟执行
                this.$message.success(
                    "经计算，报告概览中哈希值与最终结果相符\n验证成功"
                );
                this.checked = true;
            },1000);
        },
        */
        back: function() {
            this.$router.push("/Home/platformIndex");
        },
       
        showModalSource() {
            setTimeout(() => {
                this.visibleSource = true;
            }, 1500);
        },
        handleOkSource(e) {
            //this.ModalText1 = 'Hash Sum Of Source Reports:9d070ab8c9e77c000e3e1c08';
            //this.ModalText2 = 'Hash Of the Final Report:  9d070ab8c9e77c000e3e1c08';
            //this.ModalText3 = 'Calculated hash value in report overview matches final result!';
            this.confirmLoadingSource = true;
            setTimeout(() => {
                this.visibleSource = false;
                this.confirmLoadingSource = false;
                //this.reload();
                location.reload();
                this.checked = true;
            }, 0);
        },
        handleCancelSource(e) {
            console.log('Clicked cancel button');
            this.visibleSource = false;
        },
        showModalFinal() {
            setTimeout(() => {
                this.visibleFinal = true;
            }, 1500);
        },
        handleOkSubmitFinal() {
            //this.ModalText = "Please submit a doc.";
            this.confirmLoadingFinal = true;
            setTimeout(() => {
                this.visibleFinal = false;
                this.confirmLoadingFinal = false;
                this.$router.push("/Home/platformFinalVerify");               
            }, 3000);
        },
        handleCancelFinal(e) {
            console.log('Clicked cancel button');
            this.visibleFinal = false;
        },
        reload () {
            this.isRouterAlive = false;
            this.$nextTick(function () {
                this.isRouterAlive = true;
            })
        },
    }
};
</script>

<style scoped>
#content-wrapper {
    height: 100%;
    width: 100%;
}
#table-caption {
    display: flex;
    align-items: center;
    height: 40px;
    width: 100%;
    color: #333333;
}
#table-caption span {
    margin: 0px 0px 10px 0;
    font-size: 20px;
}
#verify {
    height: 300px;
    padding-top: 50px;
    display: flex;
    flex-direction: row-reverse;
}
#verify i {
    color: green;
    width: 40px;
    height: 40px;
    display: flex;
    justify-content: center;
    align-items: center;
}
#verify i svg {
    color: green;
    width: 25px;
    height: 25px;
}
#info1 {
    padding-right: 5px;
    cursor: pointer;
}
#info2 {
    padding-left: 5px;
}
</style>