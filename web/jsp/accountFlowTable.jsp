<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="easyui-layout" data-options="fit:true">
    <div style="padding-left: 3%;padding-top: 2%">
        <input value="输入要查询的日期(默认全部日前)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;margin-bottom: 40px;width: 300px">
        <input id="date" type="text" class="easyui-datebox" required="required" data-options="onSelect:dateSubmit,required: false">
    </div>
    <div style="padding-left: 3%;padding-top: 1%">
        <input value="输入要查询的收费站(默认全部收费站)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;margin-bottom: 40px;width: 300px">
        <div class="easyui-textbox" id="tollBooshNo"></div>
    </div>
    <div style="padding-left: 3%;padding-top: 1%">
        <input value="输入要查询的收费员编号(默认全部收费员)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;margin-bottom: 40px;width: 300px">
        <div class="easyui-textbox" id="tollCollector"></div>
    </div>
    <div style="padding-left: 6%;padding-top: 1%">
        <a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="showAll()">查看全部</a>
    </div>
    <div style="width:auto;height:50%">
        <table id="dg" class="easyui-datagrid" fit="true" data-options="rownumbers:true,
                   pagination:true,showFooter: true" toolbar="#toolbar2" striped="true" remoteSort="false" nowrap="false" >
            <thead>
            <tr>
                <th field="time" width="14.28%" align="center" sortable="true">收费时间</th>
                <th field="tollBooshName" width="14.28%" align="center" sortable="true">收费站名称</th>
                <th field="laneName" width="14.28%" align="center" sortable="true">收费车道名称</th>
                <th field="tollCollectorName" width="14.28%" align="center" sortable="true">收费员名称</th>
                <th field="cardNo" width="14.28%" align="center" sortable="true">IC卡编号</th>
                <th field="carType" width="14.28%" align="center" sortable="true">车型</th>
                <th field="fee" width="14.28%" align="center" sortable="true">收取费用</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script>
    function dateSubmit() {
        setTimeout(function submit() {
            var date=$("#date").datebox("getValue");
            $("#dg").datagrid("options").url='ShowAccountFlowServlet';
            var queryParams = $('#dg').datagrid('options').queryParams;
            queryParams.date = date;
            $("#dg").datagrid("reload");
        },200);
    }
    function showAll() {
        setTimeout(function submit() {
            var date="null";
            $("#dg").datagrid("options").url='ShowAccountFlowServlet';
            var queryParams = $('#dg').datagrid('options').queryParams;
            queryParams.date = date;
            $("#dg").datagrid("reload");
        },200);
    }
    /*var rows = $('#dg').datagrid('getFooterRows');
    rows[0]["Price"] = 0;
    rows[0]["Manufacturer"] = "合计：";
    $('#PlanDetail_tab').datagrid('reloadFooter');

    //$('#PlanDetail_tab').datagrid('reloadFooter', [
    //        { Price: '0',  },
    //]);*/

</script>
