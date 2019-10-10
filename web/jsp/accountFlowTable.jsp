<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="easyui-layout" data-options="fit:true">
    <div style="padding-left: 3%;padding-top: 2%">
        <input value="输入要查询的日期(默认全部日期)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;margin-bottom: 40px;width: 300px">
        <input id="date2" type="text" class="easyui-datebox" required="required" data-options="required: false">
    </div>
    <div style="padding-left: 3%;padding-top: 1%">
        <input value="输入要查询的收费站编号(默认全部收费站)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;margin-bottom: 40px;width: 300px">
        <div class="easyui-textbox" id="tollBooshNo2"></div>
    </div>
    <div style="padding-left: 3%;padding-top: 1%">
        <input value="输入要查询的收费员编号(默认全部收费员)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;margin-bottom: 40px;width: 300px">
        <div class="easyui-textbox" id="tollCollectorNo2"></div>
    </div>
    <div style="padding-left: 3%;padding-top: 1%">
        <input value="输入要查询的车型(默认全部车型)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;margin-bottom: 40px;width: 300px">
        <div class="easyui-textbox" id="carType2"></div>
    </div>
    <div style="padding-left: 6%;padding-top: 1%;padding-bottom: 10px">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="showAll2()">查看全部</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="querySelect2()">查询所选</a>
    </div>
    <div style="width:auto;height:50%">
        <table id="dg2" class="easyui-datagrid" fit="true" data-options="rownumbers:true,
                   pagination:true,showFooter: true" toolbar="#toolbar2" striped="true" remoteSort="false" nowrap="false" >
            <thead>
            <tr>
                <th field="time2" width="11%" align="center" sortable="true">收费时间</th>
                <th field="tollBooshNo2" width="11%" align="center" sortable="true">收费站编号</th>
                <th field="tollBooshName2" width="11%" align="center" sortable="true">收费站名称</th>
                <th field="laneName2" width="11%" align="center" sortable="true">收费车道名称</th>
                <th field="tollCollectorNo2" width="11%" align="center" sortable="true">收费员编号</th>
                <th field="tollCollectorName2" width="11%" align="center" sortable="true">收费员名称</th>
                <th field="cardNo2" width="11%" align="center" sortable="true">IC卡编号</th>
                <th field="carType2" width="11%" align="center" sortable="true">车型</th>
                <th field="fee2" width="11%" align="center" sortable="true">收取费用</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script>
    function querySelect2() {
        setTimeout(function submit() {
            var date=$("#date2").datebox("getValue");
            var tollBooshNo = $("#tollBooshNo2").val();
            var tollCollectorNo = $("#tollCollectorNo2").val();
            var carType = $("#carType2").val();
            $("#dg2").datagrid("options").url='ShowAccountFlowServlet';
            var queryParams = $('#dg2').datagrid('options').queryParams;
            if(date.length!=0)
                queryParams.date2 = date;
            else
                queryParams.date2 = "null";
            if(tollBooshNo.length!=0)
                queryParams.tollBooshNo2 = tollBooshNo;
            else
                queryParams.tollBooshNo2 = "null";
            if(tollCollectorNo.length!=0)
                queryParams.tollCollectorNo2 = tollCollectorNo;
            else
                queryParams.tollCollectorNo2 = "null";
            if(carType.length!=0)
                queryParams.carType2 = carType;
            else
                queryParams.carType2 = "null";
            $("#dg2").datagrid("reload");
        },200);
    }
    function showAll2() {
        setTimeout(function submit() {
            var date="null";
            var tollBooshNo="null";
            var tollCollectorNo="null";
            var carType="null";
            $("#dg2").datagrid("options").url='ShowAccountFlowServlet';
            var queryParams = $('#dg2').datagrid('options').queryParams;
            queryParams.date2 = date;
            queryParams.tollBooshNo2=tollBooshNo;
            queryParams.tollCollectorNo2=tollCollectorNo;
            queryParams.carType2=carType;
            $("#dg2").datagrid("reload");
        },200);
    }
</script>
