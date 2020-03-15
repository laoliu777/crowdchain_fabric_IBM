<template>
  <div id="content-wrapper">
    <div id="table-caption">
      <span>ContestManagement</span>
    </div>

    <!--<a-table :columns="columns" :dataSource="allData">-->
    <a-table :columns="columns" :dataSource="data">
       <span slot="optType" slot-scope="optType">
        <a-button @click="showModal(optType)" type="primary" v-if="optType=='reportVerify'">verify</a-button>
        <a-button @click="showModal(optType)" type="primary" v-if="optType=='submit'">submit</a-button>
        <a-modal
          title="Please submit a doc!"
          :visible="visible"
          @ok="handleOkSubmit"
          :confirmLoading="confirmLoading"
          @cancel="handleCancel"
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
  </div>
</template>

<script>
function createHash(hashLength) {
  if (!hashLength || typeof Number(hashLength) != "number") {
    return;
  }
  var ar = [
    "1","2",    "3","4",    "5",    "6",    "7",    "8",    "9",    "0",    "a",    "b",    "c",    "d",    "e",    "f",    "g",    "h",    "i",    "j",    "k",    "l",    "m",    "n",    "o",    "p",    "q",    "r",    "s",    "t",    "u",    "v",
    "w",    "x",    "y",    "z"
  ];
  var hs = [];
  var hl = Number(hashLength);
  var al = ar.length;
  for (var i = 0; i < hl; i++) {
    hs.push(ar[Math.floor(Math.random() * al)]);
  }

  return hs.join("");
};
const columns = [
  {
    title: "Contest",
    dataIndex: "contest"
  },
  {
    title: "TestReportID",
    dataIndex: "testReport"
  },
  {
    title: "SubmitTime",
    dataIndex: "subtime"
  },
  {
    title: "Operation",
    dataIndex: "optType",
    scopedSlots: { customRender: "optType" }
  }
];
const data = [
  {
    contest: "QQBrowser",
    testReport: "5cf8b069c9e77c000e85d42b",
    subtime: "2019-12-11 17:16:32",
    optType: "reportVerify"
  },
  {
    contest: "QQMusic",
    testReport: "5cc30cf2825a8960cdc7bd6c",
    subtime: "2019-12-10 12:01:34",
    optType: "reportVerify"
  },
  {
    contest: "Alipay",
    testReport: "5cf8b2c4c9e77c000e85d431",
    subtime: "2019-12-09 14:29:48",
    optType: "reportVerify"
  },
  {
    contest: "Hupu",
    testReport: "5cfb7f93c9e77c000e3e1c06",
    subtime: "2019-12-09 14:19:42",
    optType: "reportVerify"
  },
  {
    contest: "Weibo",
    testReport: "5d070ab8c9e77c000e3e1c08",
    subtime: "2019-12-09 13:42:18",
    optType: "reportVerify"
  },
  {
    contest: "QQMap",
    testReport: "5d3e4f52c9e77c000e3e1c17",
    subtime: "2019-12-08 14:21:17",
    optType: "reportVerify"
  }
];

export default {
  name: "playerIndex",
  data() {
    return {
      //allData:[],
      data,
      columns,
      visible: false,
      //visible2: false,
      confirmLoading: false,
      nowOptType:"",
    };
  },
  /*
    created(){
        this.axios.get("queryReport").then(res=>{
            debugger;
            this.allData = [];
            for(let i=0;i<res.data.length;i++){
                res.data[i].time = "2019-01-20";
                this.allData.push(res.data[i]);
            }
        }).catch(err=>{
            console.log(err);
        })
    },
    */
  methods: {
    showModal(optType) {
      this.nowOptType = optType;
      setTimeout(() => {
        this.visible = true;
      }, 100);
    },
    handleOkSubmit(optType) {
      //this.ModalText = "Please submit a doc.";
      //debugger
      this.confirmLoading = true;
      setTimeout(() => {
        this.visible = false;
        this.confirmLoading = false;
        if (this.nowOptType=="reportVerify") {
          this.$router.push("/Home/playerVerify");
          }
      }, 3000);
    },
    handleCancel(e) {
      console.log("Clicked cancel button");
      this.visible = false;
    },
    handleChange(info) {
      const status = info.file.status;
      if (status !== "uploading") {
        console.log(info.file, info.fileList);
      }
      if (status === "done") {
        this.$message.success(`${info.file.name} file uploaded successfully.`);
      } else if (status === "error") {
        this.$message.error(`${info.file.name} file upload failed.`);
      }
    }
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
</style>