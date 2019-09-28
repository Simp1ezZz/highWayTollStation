<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 组织机构管理 -->
<div class="easyui-layout" data-options="fit:true">
    <div class="inner-header" data-options="region:'north'">
        <a href="#" class="easyui-linkbutton" iconCls="icon-back">打卡上班</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add">打卡下班</a>
    </div>
    <div class="inner-content" data-options="region:'center'">
        <!-- 数据表 -->
        <table id="dg" class="easyui-datagrid" title="出勤状况" fit="true"
               data-options="fitColumns:true,url:'WorkLogPrintServlet',rownumbers:true,
               autoRowHeight:false,pagination:true" toolbar="#toolbar2" striped="true" remoteSort="false">
            <thead>
            <tr>
                <th field="tollCollectorNo" width="240px" align="center" sortable="true">收费员编号</th>
                <th field="tollBooshNo" width="240px" align="center" sortable="true">收费站编号</th>
                <th field="startWorkTime" width="440px" align="center" sortable="true">上班时间</th>
                <th field="finishWorkTime" width="440px" align="center" sortable="true">下班时间</th>
            </tr>
            </thead>
        </table>

        <!-- 数据表工具栏 -->
        <!-- /数据表工具栏 -->
    </div>
</div>

