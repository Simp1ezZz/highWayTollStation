<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .text{
        font-size: 20px;
        border: 0px;
        outline: none;
        text-align: center;
        width:250px;
        padding: 50px 0 0 0;
        margin-right: 30px;
    }
</style>
<div>
    <input class="text" value="入口车道：" readonly unselectable="on">
    <input class="text" id="tollBooshName" readonly unselectable="on">
    <input class="text" id="laneName" readonly unselectable="on">
</div>
<div>
    <input class="text" value="当前时间：" readonly unselectable="on">
    <input class="text" id="startTime" readonly unselectable="on">
</div>

<div style="margin-bottom: 30px">
    <input class="text" value="IC卡号：" readonly unselectable="on">
    <input style="font-size: 20px" id="cardNo1" onkeyup="query1()">

</div>
<div>
    <input class="text" value="车型：" readonly unselectable="on">
    <input class="text" id="carType1" readonly unselectable="on">

</div>
<div style="margin-bottom: 25px">
    <input class="text" value="车牌号：" readonly unselectable="on">
    <input class="text" id="numberPlate1" readonly unselectable="on">

</div>
<div style="padding-left: 350px;padding-top: 50px">
    <a href="javascript:void(0)" id="inSite-submit-btn"
       class="easyui-linkbutton" style="width: 80px" onclick="inSiteSubmit()">进站提交</a>
</div>


<script type="text/javascript">
    var tollBooshNo;
    var laneNo;
    //查询ic卡信息并显示
     function query1() {
         document.getElementById("carType1").value ='';
         document.getElementById("numberPlate1").value ='';
         var cardNo = $("#cardNo1").val();
         if(cardNo!=null){
             $.ajax({
                 url:"ShowSiteInfoServlet",
                 type:"POST",
                 async:false,
                 data:{
                     cardNo:cardNo.replace(/\s*/g,"")
                 },
                 success:function (result) {
                     var data = eval('('+result+')');
                     if(data.carType!=null) {
                         document.getElementById("carType1").value = data.carType;
                         document.getElementById("numberPlate1").value = data.numberPlate;

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
                document.getElementById("tollBooshName").value=data.tollBooshName;
                document.getElementById("laneName").value=data.laneName;
                tollBooshNo = data.tollBooshNo;
                laneNo = data.laneNo;
            }
        })
    }
    //显示当前收费时间
    function getInTime() {
        var myDate = new Date();
        var date = myDate.toLocaleDateString();
        var hours = myDate.getHours();
        var minutes = myDate.getMinutes();
        var seconds = myDate.getSeconds();
        var currentTime = date+' '+hours+':'+minutes+':'+seconds;
        document.getElementById("startTime").value=currentTime;
    }
     showInfo();
     getInTime();
     setInterval(getInTime,1000);
    function inSiteSubmit() {
        var startTime = $("#startTime").val();
        var cardNo = $("#cardNo1").val();
        if(cardNo.replace(/(^\s*)|(\s*$)/g, '')) {
            $.ajax({
                url: "InSiteServlet",
                type: "POST",
                async: false,
                data: {
                    cardNo: cardNo.replace(/\s*/g,""),
                    startTime: startTime,
                    tollBooshNo: tollBooshNo,
                    laneNo:laneNo
                },
                success: function (json) {
                    var result = eval('(' + json + ')');
                    $.messager.alert('提示', result.msg);
                }
            })
        }else {
            $.messager.alert('提示', "请输入IC卡号！");
        }
    }
</script>