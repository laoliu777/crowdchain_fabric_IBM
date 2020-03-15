<template>
    <div id="content-wrapper">
        <div id="table-caption">
            <span>ContestManagement</span>
        </div>
        <a-table :columns="columns" :dataSource="data">
            <!--
            <span class="c-overall" slot="overall" slot-scope="overall" @click="turnToOverall">{{overall}}</span>
            <span class="c-final" slot="final" slot-scope="final" @click="turnToFinal">{{final}}</span>
            -->
            <a-button slot="overall" @click="turnToOverall" type="primary">Click</a-button>
            <a-button slot="final" @click="turnToFinal" type="primary">Click</a-button>
        </a-table>
    </div>
</template>

<script>
const columns = [
    {
        title: "Contest",
        dataIndex: "contest"
    },
    {
        title: "TestReportOverview",
        dataIndex: "overall",
        scopedSlots: { customRender: 'overall' },
    },
    {
        title: "FinalReport",
        dataIndex: "final",
        scopedSlots: { customRender: 'final' },
    }
];
const data = [
    {
        key: "1",
        contest: "QQMusic",
        overall: "Click",
        final: "Click"
    },
        {
        key: "2",
        contest: "QQBrowser",
        overall: "Click",
        final: "Click"
    },
    {
        key: "1",
        contest: "Alipay",
        overall: "Click",
        final: "Click"
    },
        {
        key: "3",
        contest: "QQReading",
        overall: "Click",
        final: "Click"
    },   
    {
        key: "1",
        contest: "Hupu",
        overall: "Click",
        final: "Click"
    },
     {
        key: "1",
        contest: "QQInput",
        overall: "Click",
        final: "Click"
    },   
    {
        key: "1",
        contest: "Tiktok",
        overall: "Click",
        final: "Click"
    },
     {
        key: "1",
        contest: "QQNews",
        overall: "Click",
        final: "Click"
    },   
    {
        key: "1",
        contest: "Weibo",
        overall: "Click",
        final: "Click"
    },
     {
        key: "1",
        contest: "QQVideos",
        overall: "Click",
        final: "Click"
    },   
     {
        key: "1",
        contest: "QQMap",
        overall: "Click",
        final: "Click"
    },   
     {
        key: "1",
        contest: "TercentCloud",
        overall: "Click",
        final: "Click"
    },   
     {
        key: "1",
        contest: "TercentGames",
        overall: "Click",
        final: "Click"
    },   
     {
        key: "1",
        contest: "TercentMcroVideo",
        overall: "Click",
        final: "Click"
    },  
      {
        key: "1",
        contest: "TercentSing",
        overall: "Click",
        final: "Click"
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
    methods: {
        turnToOverall: function() {
            setTimeout(() => {
                this.$router.push("/Home/PlatformContest");
            }, 1000);
        },
        turnToFinal: function() {
            setTimeout(() => {
                this.$router.push("/Home/PlatformFinal");
            }, 1000);
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
/* 表格数据 */
.c-overall,.c-final{
    color: blue;
    cursor: pointer;
}
</style>