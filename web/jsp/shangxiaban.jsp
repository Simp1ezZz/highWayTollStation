<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 组织机构管理 -->
<div class="easyui-layout" data-options="fit:true">
    <div class="inner-content" data-options="region:'center'">
        <!-- 数据表 -->
        <table class="easyui-datagrid" title="出勤状况" fit="true" fitColumns="false"
               url="data/griddata2.json" method="get" toolbar="#toolbar2"
               striped="true" rownumbers="true" pagination="true" remoteSort="false">
            <thead>
            <tr>
                <th field="workLogNo" width="240px" align="center" sortable="true">编号</th>
                <th field="tollCollecterNo" width="240px" align="center" sortable="true">收费员编号</th>
                <th field="tollBooshNo" width="240px" align="center" sortable="true">收费站编号</th>
                <th field="startWorkTime" width="440px" align="center" sortable="true">上班时间</th>
                <th field="finshWorkTime" width="440px" align="center" sortable="true">下班时间</th>
            </tr>
            </thead>
        </table>

        <!-- 数据表工具栏 -->
        <div class="toolbar" id="toolbar2">
            <div class="ctrl-div">
                <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">打卡上班</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">打卡下班</a>
            </div>
        </div>
        <!-- /数据表工具栏 -->
    </div>
</div>
