<template>
    <div id="content-wrapper">
        <div id="table-caption">
            <span id="info1" @click="back">Contest</span>
            <span>/</span>
            <span id="info2">TestReportOverview: QQMusic</span>
        </div>

        <a-table :columns="columns" :dataSource="data"></a-table>
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
    }
];

const data = [
    {
        testReport: "5cc30cf2825a8960cdc7bd6c",
        playername: "JAGLDAG",
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

export default {
    name: "playerIndex",
    data() {
        return {
            data,
            columns
        };
    },
    /*
    created() {
    for (let i = 0; i < this.data.length; i++) {
        this.data[i].time = "2019-01-20 12:01:34";
    }
    },
    */
    methods: {
        back:function(){
            this.$router.push("/Home/platformIndex");
        }
    }
};
</script>

<style scoped>
#content-wrapper {
    height: 100%;
    width: 100%;
}
#info1{
    padding-right: 5px;
    cursor: pointer;
}
#info2{
    padding-left: 5px;
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
