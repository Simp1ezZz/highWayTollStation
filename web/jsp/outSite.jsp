<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .text{
        font-size: 18px;
        border: 0px;
        outline: none;
        text-align: center;
        width:200px;
        padding: 30px 0 0 0;
    }
</style>
<div>
    <input class="text" value="出口车道：" readonly unselectable="on">
    <input class="text" id="outTollBooshName" readonly unselectable="on">
    <input class="text" id="outLaneName" readonly unselectable="on">
    <input id="tollBooshNo" readonly unselectable="on" type="hidden">
    <input id="laneNo" readonly unselectable="on" type="hidden">
</div>
<div>
    <input class="text" value="当前时间：" readonly unselectable="on">
    <input class="text" id="endTime" readonly unselectable="on">
</div>

<div>
    <input class="text" value="IC卡号：" readonly unselectable="on">
    <input style="font-size: 20px" id="cardNo2" onkeyup="query2()">

</div>
<div>
    <input class="text" value="车型：" readonly unselectable="on">
    <input class="text" id="carType2" readonly unselectable="on">

</div>
<div>
    <input class="text" value="车牌号：" readonly unselectable="on">
    <input class="text" id="numberPlate2" readonly unselectable="on">
</div>
<div>
    <input class="text" value="进站车道：" readonly unselectable="on">
    <input class="text" id="startTollBooshName" readonly unselectable="on">
    <input class="text" id="startLaneName" readonly unselectable="on">
</div>
<div>
    <input class="text" value="里程数：" readonly unselectabel="on">
    <input class="text" id="mile" readonly unselectable="on">
</div>
<div>
    <input class="text" value="通行费用：" readonly unselectable="on">
    <input class="text" id="totalFee" readonly unselectable="on">
</div>
<div style="padding-left: 200px;padding-top: 50px">
    <a href="javascript:void(0)" id="outSite-submit-btn"
       class="easyui-linkbutton" style="width: 80px" onclick="outSiteSubmit()">收费出站</a>
</div>
<script type="text/javascript">
    //查询ic卡信息并显示
    function query2() {
        document.getElementById("carType2").value ='';
        document.getElementById("numberPlate2").value ='';
        document.getElementById("mile").value='';
        document.getElementById("totalFee").value= '';
        document.getElementById("startTollBooshName").value='';
        document.getElementById("startLaneName").value='';
        var cardNo = $("#cardNo2").val();
        if(cardNo!=null){
            $.ajax({
                url:"ShowSiteInfoServlet",
                type:"POST",
                async:false,
                data:{
                    cardNo:cardNo.replace(/(^\s*)|(\s*$)/g, '')
                },
                success:function (result2) {
                    var data = eval('('+result2+')');
                    if(data.carType!=null) {
                        document.getElementById("carType2").value = data.carType;
                        document.getElementById("numberPlate2").value = data.numberPlate;
                        showMileAndFee();
                    }
                }
            })
        }
    }
    //显示当前收费站信息
    function showInfo() {
        $.ajax({
            url:"ShowSiteInfoServlet",
            type:"POST",
            async:false,
            success:function (jsonData) {
                var data = eval('('+jsonData+')');
                document.getElementById("outTollBooshName").value=data.tollBooshName;
                document.getElementById("outLaneName").value=data.laneName;
                document.getElementById("tollBooshNo").value=data.tollBooshNo;
                document.getElementById("laneNo").value=data.laneNo;
            }
        })
    }
    //显示当前收费时间
    function getOutTime() {
        var nowYear=new Date().getFullYear().toString()
        var nowMonth=(new Date().getMonth() + 1).toString()
        var nowDay=new Date().getDate().toString();
        var nowHours= new Date().getHours().toString();       //获取当前小时数(0-23)
        var nowMin= new Date().getMinutes().toString();     //获取当前分钟数(0-59)
        var nowSeconds= new Date().getSeconds().toString();     //获取当前秒数(0-59)
        function timeAdd0(str) {
            if(str.length<=1){
                str='0'+str;
            }
            return str
        }
        nowYear=timeAdd0(nowYear)
        nowMonth=timeAdd0(nowMonth)
        nowDay=timeAdd0(nowDay)
        nowHours=timeAdd0(nowHours)
        nowMin=timeAdd0(nowMin)
        nowSeconds=timeAdd0(nowSeconds)

        var currentTime = nowYear+'-'+nowMonth+'-'+nowDay+' '+nowHours+':'+nowMin+':'+nowSeconds;
        document.getElementById("endTime").value=currentTime;
    }
    //显示里程及通行费用
    function showMileAndFee() {

        var cardNo = $("#cardNo2").val();
        var time = $("#endTime").val();
        var tollBooshNo = $("#tollBooshNo").val();
        $.ajax({
            url:"ShowMileAndFeeServlet",
            type:"POST",
            async:false,
            data:{
                cardNo:cardNo,
                time:time,
                tollBooshNo:tollBooshNo
            },
            success:function (jsonData) {
                var data = eval('('+jsonData+')');
                var fee = data.totalFee;
                document.getElementById("mile").value=data.mile;
                document.getElementById("totalFee").value=fee.toFixed(2);
                document.getElementById("startTollBooshName").value=data.startTollBooshName;
                document.getElementById("startLaneName").value=data.startLaneName;
            }
        })
    }
    function outSiteSubmit() {
        var time = $("#endTime").val();
        var cardNo = $("#cardNo2").val();
        var tollBooshNo = $("#tollBooshNo").val();
        var laneNo = $("#laneNo").val();
        if(cardNo.replace(/(^\s*)|(\s*$)/g, '')) {
            $.ajax({
                url: "OutSiteServlet",
                type: "POST",
                async: false,
                data: {
                    cardNo: cardNo.replace(/(^\s*)|(\s*$)/g, ''),
                    endTime: time,
                    tollBooshNo: tollBooshNo,
                    laneNo:laneNo
                },
                success: function (jsonObject) {
                    var result = eval('(' + jsonObject + ')');
                    console.log(result.msg);
                    $.messager.alert('提示', result.msg);
                }
            })
        }else {
            $.messager.alert('提示', "请输入正确的IC卡号！");
        }
    }

    showInfo();
    getOutTime();
    setInterval(getOutTime,1000);
</script>
