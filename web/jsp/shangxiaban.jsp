<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 组织机构管理 -->
<div class="easyui-layout" data-options="fit:true">
    <div class="inner-header" data-options="region:'north'">
        <a href="#" class="easyui-linkbutton" iconCls="icon-back" onclick="startWorkSubmit()">打卡上班</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="finishWorkSubmit()">打卡下班</a>
    </div>
    <div class="inner-content" data-options="region:'center'">
        <!-- 数据表 -->
        <table id="dg" class="easyui-datagrid" title="出勤状况" fit="true"
               data-options="fitColumns:true,url:'WorkLogPrintServlet',rownumbers:true,
               pagination:true" toolbar="#toolbar2" striped="true" remoteSort="false" nowrap="false">
            <thead>
            <tr>
                <th field="tollCollectorNo" width="240px" align="center" sortable="true">收费员编号</th>
                <th field="tollBooshNo" width="240px" align="center" sortable="true">收费站编号</th>
                <th field="startWorkTime" width="440px" align="center" sortable="true">上班时间</th>
                <th field="finishWorkTime" width="440px" align="center" sortable="true">下班时间</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script>
    function startWorkSubmit() {
        var data = $('#dg').datagrid('getData');

        var user = <%=session.getAttribute("user")%>;
        for(var i=1;i<data.total;i++){
            if(user=data.rows[i].tollCollectorNo && data.rows[i].finishWorkTime==null) {
                $.messager.alert('请勿重复点击打卡！', '确保你之前的下班打卡已经完成！');
                return;
            }
        }
        $.ajax({
            url: "StartWorkServlet",
            type:"POST"
        });
        setTimeout(function yanchi(){$("#dg").datagrid("reload")},200);

    }

    function finishWorkSubmit() {
        var data = $('#dg').datagrid('getData');

        var user = <%=session.getAttribute("user")%>;
        for(var i=1;i<data.total;i++){
            if(user=data.rows[i].tollCollectorNo && data.rows[i].finishWorkTime==null) {
                $.ajax({
                    url: "FinishWorkServlet",
                    type: "POST",
                    data:{
                        startWorkTime:data.rows[i].startWorkTime
                    }
                });
                setTimeout(function yanchi() {
                    $("#dg").datagrid("reload")
                }, 200);
                return;
            }
        }
        $.messager.alert('请勿重复点击打卡！', '确保你之前已经上班打卡！');
    }

</script>

