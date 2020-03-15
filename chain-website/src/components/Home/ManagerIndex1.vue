<template>
  <div id="content-wrapper">
    <div id="table-caption">
      <span>ContestManagement</span>
    </div>
    <a-table :columns="columns" :dataSource="data">
      <span slot="optType" slot-scope="optType">
        <a-button @click="showModal(optType)" type="primary" v-if="optType=='docVerify'">verify</a-button>
        <!--
        <a-modal
          title="Please submit a doc!"
          :visible="visible1"
          @ok="handleOkVerify"
          :confirmLoading="confirmLoading"
          @cancel="handleCancel"
          v-if="optType=='docVerify'"
        >
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
        -->  
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
}
const columns = [
  {
    title: "Contest",
    dataIndex: "contest"
  },
  {
    title: "RequirementsDocumentID",
    dataIndex: "doc"
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
    //key:1,
    contest: "QQBrowser",
    doc: "5cd7c1b9825a8948e757ca09",
    subtime: "2019-12-11 17:15:42",
    optType: "docVerify"
  },
  {
    contest: "QQMusic",
    doc: "5cbc1a9f825a8960cdc7bd4f",
    subtime: "2019-12-10 10:08:01",
    optType: "docVerify"
  },
  {
    contest: "QQReading",
    doc: "5cd7c8e8825a8948e757ca10",
    subtime: "2019-12-09 10:01:33",
    optType: "docVerify"
  },
  {
    contest: "QQInput",
    //doc: "5cd7ca14825a8948e757ca11",
    //subtime: "2019-12-09 09:08:01",
    optType: "submit"
  },
  {
    contest: "QQNews",
    //doc: "5ce4f268c9e77c000e7d8e9a",
    //subtime: "2019-12-09 08:53:01",
    optType: "submit"
  },
  {
    contest: "QQVideos",
    doc: "5ce4f90ec9e77c000e7d8e9d",
    subtime: "2019-12-08 10:08:01",
    optType: "docVerify"
  },
  {
    contest: "QQMap",
    doc: "5ce51125c9e77c000e7d8e9e",
    subtime: "2019-12-08 10:03:44",
    optType: "docVerify"
  },
  {
    contest: "TercentCloud",
    doc: "5cf39370c9e77c000d244c48",
    subtime: "2019-12-08 10:01:53",
    optType: "docVerify"
  },
  {
    contest: "TercentGames",
    doc: "5cf4a3e3c9e77c000ddc48c3",
    subtime: "2019-12-08 09:53:17",
    optType: "docVerify"
  },
  {
    contest: "TercentMcroVideo",
    doc: "5cf61be7c9e77c000e85d3f7",
    subtime: "2019-12-07 09:28:28",
    optType: "docVerify"
  },
  {
    contest: "TercentSing",
    doc: "5cf78160c9e77c000e85d41e",
    subtime: "2019-12-07 08:08:01",
    optType: "docVerify"
  },
  {
    contest: "TercentBuy",
    doc: "5cf78de6c9e77c000e85d42a",
    subtime: "2019-12-06 07:08:01",
    optType: "docVerify"
  }
];

export default {
  name: "manageIndex",
  data() {
    return {
      data,
      columns,
      //ModalText: 'Please submit a doc.',
      visible: false,
      //visible2: false,
      confirmLoading: false,
      nowOptType:"",
    };
  },
  methods: {
    /*
    eventName(){
    },
    docVerify: function() {
      clearTimeout(this.timer); //清除延迟执行
      this.timer = setTimeout(() => {
        //设置延迟执行
        this.$router.push("/Home/managerVerify");
      }, 1000);
      //this.$router.push("/Home/managerVerify");
    },*/
    showModal(optType) {
      this.nowOptType = optType;
      setTimeout(() => {
        this.visible = true;
      }, 100);
    },
    /*
    handleOkVerify(e) {
      //this.ModalText = "Please submit a doc.";
      this.confirmLoading = true;
      setTimeout(() => {
        this.visible = false;
        this.confirmLoading = false;
        this.$router.push("/Home/managerVerify");
      }, 3000);
    },
    */
    handleOkSubmit(optType) {
      //this.ModalText = "Please submit a doc.";
      //debugger
      this.confirmLoading = true;
      setTimeout(() => {
        this.visible = false;
        this.confirmLoading = false;
        if (this.nowOptType=="docVerify") {
          this.$router.push("/Home/managerVerify");
          /*
          const dataSource = [...this.dataSource];
          const target = dataSource.find(item => item.key === key);
          if (target) {
            target[dataIndex] = value;
            this.dataSource = dataSource;
          }
          */
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