<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="easyui-layout" data-options="fit:true">
    <div style="padding-left: 1%;padding-top: 2%">
        <input value="输入要查询的日期：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;text-align: center;margin-bottom: 40px;width: auto">
        <input id="date" type="text" class="easyui-datebox" required="required" data-options="onSelect:dateSubmit">
        <a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="showAll()">查看全部</a>
    </div>
    <div style="width:auto;height:88%">
        <table id="dg" class="easyui-datagrid" fit="true" data-options="url:'ShowAccountFlowServlet',rownumbers:true,
                   pagination:true" toolbar="#toolbar2" striped="true" remoteSort="false" nowrap="false">
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

</script>
