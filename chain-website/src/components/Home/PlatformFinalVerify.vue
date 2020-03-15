<template>
  <div id="content-wrapper">
    <div id="table-caption">
      <span id="info1" @click="backtoContest">Contest</span>
      <span> : QQMusic /</span>
      <span id="info1" @click="backtoFinal">PlatformFinalVerification</span>
    </div>
    <a-table :columns="columns" :dataSource="data" :pagination="false" bordered>
      <template slot="title">
        <font
          size="5px"
          color="green"
        >It has been verified that the files on the blockchain have not been tampered with!</font>
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

const data = [
  {
    attribute: "Hash Value Of the Current Block",
    value: "85t6hg37s9w7dt4iu6t428dc"
  },
  {
    attribute: "Hash Value Of the Last Block",
    value: "85z53ahjhj43524iu6d8idd0"
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
    value: "8566du45s678k8fyi8ac65bd"
  },
  {
    attribute: "Hash Value Of the File on the Blockchain",
    value: "9d070ab8c9e77c000e3e1c08"
  },
  {
    attribute: "Hash Value Of the Local File",
    value: "9d070ab8c9e77c000e3e1c08"
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
    backtoFinal: function() {
      this.$router.push("/Home/platformFinal");
    },
    backtoContest: function() {
      this.$router.push("/Home/platformIndex");
    }
  },
  
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