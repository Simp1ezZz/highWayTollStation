<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .text{
        font-size: 20px;
        border: 0px;
        outline: none;
        text-align: center;
        width:150px;
        padding: 50px 0 0 0;
        margin-right: 30px;
    }
    .radioSpan {
        position: relative;
        border: 0px;
        background-color: #fff;
        vertical-align: middle;
        display: inline-block;
        overflow: hidden;
        white-space: nowrap;
        margin: 0;
        padding: 30px 0 0 0;
        -moz-border-radius: 5px 5px 5px 5px;
        -webkit-border-radius: 5px 5px 5px 5px;
        border-radius: 5px 5px 5px 5px;
        display:block;
    }
</style>
<p style="font-size: 18px">入口车道：&nbsp;&nbsp;&nbsp;&nbsp;
    <%=request.getParameter("tollBooshName") %>&nbsp;&nbsp;&nbsp;&nbsp;
    <%=request.getParameter("laneName")%>
</p>
<%--<div style="width:auto">
    <input class="text" value="入口车道：" readonly unselectable="on">
    <input class="text" value="合肥高速收费站" id="shoufeizhan" name="shoufeizhan"readonly unselectable="on">
    <input class="text" value="12车道" id="chedao" name="chedao"readonly unselectable="on">
</div>
<div style="margin-bottom: 30px; width:auto ">
    <input class="text" value="入口车道：" readonly unselectable="on">
    <input class="text" value="入口1班组" id="banzu" name="banzu"readonly unselectable="on">
    <input class="text" value="3班次" id="banci" name="banci"readonly unselectable="on">
    <input class="text" value="" id="y_m_d" name="y_m_d"&lt;%&ndash;readonly unselectable="on"&ndash;%&gt;>
    <input class="text" value="" id="time" name="time"&lt;%&ndash;readonly unselectable="on"&ndash;%&gt;>
</div>--%>
<div style="margin-bottom: 30px">
    <input class="text" value="IC卡号：" readonly unselectable="on">
    <div class="easyui-textbox" id="cardNo" name="cardNo"></div>
    <a href="javascript:void(0)" id="inSite-query-btn"
       class="easyui-linkbutton" style="width: 80px" onclick="query()">查询</a>
</div>
<div>

    <div class="easyui-textbox" value="<%=session.getAttribute("carType")%>>"></div>
    <div class="easyui-textbox" value="<%=session.getAttribute("numberPlate")%>"></div>
    <%--<span class="radioSpan">
        <input type="radio" name="carStyle" value="0">客车(7座以下)</input>
        <input type="radio" name="carStyle" value="1">客车(8-19座)</input>
        <input type="radio" name="carStyle" value="2">客车(20座及以上)</input>
        <input type="radio" name="carStyle" value="3">货车(5吨以下)</input>
        <input type="radio" name="carStyle" value="4">货车(5-15吨)</input>
        <input type="radio" name="carStyle" value="5">货车(15吨以上)</input>
    </span>--%>
</div>
<div style="margin-bottom: 25px">
    <input class="text" value="车牌号：" readonly unselectable="on">
    <%--<select class="easyui-combobox" lable="车牌号：" lablePosition="before"
            style="width: 100px" id="chepaihao1" name="chePaiHao1">
        <option value="jing">京</option>
        <option value="wan">皖</option>
    </select>
    <div class="easyui-textbox" id="chepaihao2" name="chePaiHao2"></div>--%>
</div>
<div style="text-align: center; padding: 5px 0">
    <a href="javascript:void(0)" id="inSite-submit-btn"
       class="easyui-linkbutton" style="width: 80px">提交</a>
</div>


<script type="text/javascript">
     function query() {
         var cardNo = $("#cardNo").val();
         if(cardNo!=null){
             $.ajax({
                 url:"InSiteServlet",
                 type:"POST",
                 data:{
                     cardNo:cardNo
                 }
             })
         }
     }
    var y_m_d = new Date().toLocaleDateString();
    var time = new Date().toLocaleTimeString();
    $("#y_m_d").attr("value",y_m_d);
    $("#time").attr("value",time);
    $(function () {
        //表单提交
        $("#inSite-submit-btn").onclick("click",function () {
            //参数完整性校验


            //提交
            $("#inSiteSubmit").submit;
        })
    })
</script>