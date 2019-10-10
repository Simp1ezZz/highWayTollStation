<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">
    <div style="padding-left: 1%;padding-top: 2%">
        <input value="输入要查询的收费站编号：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;text-align: center;margin-bottom: 40px;width: auto">
        <div class="easyui-textbox" id="tollBooshNo"></div>
        <input value="输入车型(不输入默认所有车型)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;text-align: center;margin-bottom: 40px;width: auto">
        <div class="easyui-textbox" id="carType"></div>
        <input value="输入要查询的日期(不输入默认查询所有日期)：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;text-align: center;margin-bottom: 40px;width: auto">
        <input id="date" type="text" class="easyui-datebox" required="required" data-options="onSelect:dateSubmit">
        <a class="easyui-linkbotton" id="query" onclick="queryVolume()">查询</a>
    </div>
    <div style="padding-left: 1%;padding-top: 2%">
        <input value="总通行量：" readonly unselectable="on"
               style="font-size: 16px;border: none;outline: none;text-align: center;margin-bottom: 40px;width: auto">
        <input readonly unselectable="on" id="numbersOfPass"
               style="font-size: 16px;border: none;outline: none;text-align: center;margin-bottom: 40px;width: auto">
    </div>
    <div style="width:auto;height:88%">
        <table id="dg" class="easyui-datagrid" fit="true" data-options="rownumbers:true,
                   pagination:true" toolbar="#toolbar2" striped="true" remoteSort="false" nowrap="false">
            <thead>
            <tr>
                <th field="time" width="14.28%" align="center" sortable="true">入站时间</th>
                <th field="tollBooshName" width="14.28%" align="center" sortable="true">收费站名称</th>
                <th field="laneName" width="14.28%" align="center" sortable="true">收费车道名称</th>
                <th field="cardNo" width="14.28%" align="center" sortable="true">IC卡编号</th>
                <th field="carType" width="14.28%" align="center" sortable="true">车型</th>
            </tr>
            </thead>
        </table>
    </div>

</div>
