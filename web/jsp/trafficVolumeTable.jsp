<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">
    <div style="padding-left: 3%;padding-top: 2%">
        <input value="输入要查询的日期(默认全部日期)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;margin-bottom: 40px;width: 300px">
        <input id="date1" type="text" class="easyui-datebox" required="required" data-options="required: false">
    </div>
    <div style="padding-left: 3%;padding-top: 1%">
        <input value="输入要查询的收费站编号(默认全部收费站)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;margin-bottom: 40px;width: 300px">
        <div class="easyui-textbox" id="tollBooshNo1"></div>
    </div>
    <div style="padding-left: 3%;padding-top: 1%">
        <input value="输入要查询的车型(默认全部车型)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;margin-bottom: 40px;width: 300px">
        <div class="easyui-textbox" id="carType1"></div>
    </div>
    <div style="padding-left: 6%;padding-top: 1%;padding-bottom: 10px">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="showAll1()">查看全部</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="querySelect1()">查询所选</a>
    </div>
    <div style="width:auto;height:60%">
        <table id="dg1" class="easyui-datagrid" fit="true" data-options="rownumbers:true,
                   pagination:true,showFooter: true" toolbar="#toolbar2" striped="true" remoteSort="false" nowrap="false">
            <thead>
            <tr>
                <th field="time1" width="16.66%" align="center" sortable="true">入站时间</th>
                <th field="tollBooshNo1" width="16.66%" align="center" sortable="true">收费站编号</th>
                <th field="tollBooshName1" width="16.66%" align="center" sortable="true">收费站名称</th>
                <th field="laneName1" width="16.66%" align="center" sortable="true">收费车道名称</th>
                <th field="cardNo1" width="16.66%" align="center" sortable="true">IC卡编号</th>
                <th field="carType1" width="16.66%" align="center" sortable="true">车型</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script>
    function querySelect1() {
        setTimeout(function submit1() {
            var date=$("#date1").datebox("getValue");
            var tollBooshNo = $("#tollBooshNo1").val();
            var carType = $("#carType1").val();
            $("#dg1").datagrid("options").url='ShowTrafficVolumeServlet';
            var queryParams = $('#dg1').datagrid('options').queryParams;
            if(date.length!=0)
                queryParams.date1 = date;
            else
                queryParams.date1 = "null";
            if(tollBooshNo.length!=0)
                queryParams.tollBooshNo1 = tollBooshNo;
            else
                queryParams.tollBooshNo1 = "null";
            if(carType.length!=0)
                queryParams.carType1 = carType;
            else
                queryParams.carType1 = "null";
            $("#dg1").datagrid("reload");
        },200);
    }
    function showAll1() {
        setTimeout(function submit1() {
            var date="null";
            var tollBooshNo="null";
            var carType="null";
            $("#dg1").datagrid("options").url='ShowTrafficVolumeServlet';
            var queryParams = $('#dg1').datagrid('options').queryParams;
            queryParams.date1 = date;
            queryParams.tollBooshNo1=tollBooshNo;
            queryParams.carType1=carType;
            $("#dg1").datagrid("reload");
        },200);
    }
</script>
