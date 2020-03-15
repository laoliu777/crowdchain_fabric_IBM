<template>
  <div id="content-wrapper">
    <div id="table-caption">
      <span id="info1" @click="back">Contest</span>
      <span> : QQMusic /</span>
      <span id="info2">RequirementDocVerification</span>
    </div>
    <a-table :columns="columns" :dataSource="data" :pagination="false" bordered>
      <template slot="title">
        <font size="5px" color="green">It has been verified that the file on the blockchain has not been tampered with!</font>
        <!--<font size="5px" color="red">It has been verified that the file on the blockchain has been tampered with!</font>-->
      </template>
      <!--<template slot="footer" >Footer</template>-->
    </a-table>
  </div>
</template>

<script>
const columns = [
  {
    title: "attribute",
    dataIndex: "attribute"
  },
  {
    title: "value",
    dataIndex: "value"
  }
];

/*
  const data = [
    {
      attribute: '区块hash',
      value: '897837647367236782237667282',
    },
    {
      attribute: '上一个区块hash',
      value: '9275339874441986697533369',
    },
    {
      attribute: '区块版本',
      value: '1.4.0',
    },
    {
      attribute: '成块时间',
      value: '2019-12-05 10:12:08',
    },
    {
      attribute: '合约地址',
      value: '332454599456247460002654',
    },
    {
      attribute: '链上文件hash',
      value: '758995279635481126875222799',
    },
    {
      attribute: '本地文件hash',
      value: '758995279635481126875222799',
    },
  ];
*/

const data = [
  {
    attribute: "Hash Value Of the Current Block",
    value: "85753ashs9w7dt4iu6d5f49e"
  },
  {
    attribute: "Hash Value Of the Last Block",
    value: "85493ashs9w7dt4iuf7e3d3a"
  },
  {
    attribute: "Blockchain Version",
    value: "1.4.0"
  },
  {
    attribute: "Block Time",
    value: "2019-12-05 10:12:08"
  },
  {
    attribute: "Contract Address",
    value: "8581ashs9w7dt4i4f4c9b3d2"
  },
  {
    attribute: "Hash Value Of the File on the Blockchain",
    value: "5cbc1a9f825a8960cdc7bd4f"
  },
  {
    attribute: "Hash Value Of the Local File",
    value: "5cbc1a9f825a8960cdc7bd4f"
    //value: "5cbcab8c9e77c0020e3e1c08"
  }
];

export default {
  data() {
    return {
      data,
      columns
    };
  },
  methods: {
    back: function() {
      this.$router.push("/Home/managerIndex1");
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
  color: black;
}
#table-caption span {
  margin: 0px 0px 10px 0;
  font-size: 20px;
  color: black;
}
#div-verifychaincode {
  display: flex;
  align-items: center;
  text-align: center;
  width: 40%;
  border: 2px solid #efefef;
  border-radius: 2px;
}
/* flex 布局 */

th.column-money,
td.column-money {
  text-align: right !important;
}
#info1 {
    padding-right: 5px;
    cursor: pointer;
}
#info2 {
    padding-left: 5px;
}
</style>