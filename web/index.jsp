<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta charset="utf-8" />
    <title>高速公路收费管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="css/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout" id="layout" style="visibility:hidden;">

<div region="north" id="header">
    <img src="img/logo.png" class="logo" />
    <div class="top-btns">
        <span>欢迎您，管理员</span>
        <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-lock'">注销登录</a>
        <div id="w" class="easyui-window" title="请先登录！" collapsible="false"
             minimizable="false" maximizable="false" icon="icon-save"
             style="width: 400px; height: 285px; padding: 30px; background: #fafafa;"
             data-options="closable:false,draggable:false" modal="true">
            <form id="formlogin" method="post" action="LoginServlet">
                <!-- menulogin -->
                <div style="margin-bottom: 20px">
                    用户名：<input class="easyui-textbox" id="loginname" name="usercode"
                           prompt="usercode" iconWidth="28"
                           style="width: 300px; height: 34px; padding: 10px;">
                </div>
                <div style="margin-bottom: 20px">
                    密&nbsp;&nbsp;&nbsp;码：<input class="easyui-passwordbox" id="password" name="password"
                           prompt="password" iconWidth="28"
                           style="width: 300px; height: 34px; padding: 10px">
                </div>
            </form>
            <div style="text-align: center; padding: 5px 0">
                <a href="javascript:void(0)" id="login-submit-btn"
                   class="easyui-linkbutton" style="width: 80px">登录</a>
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   onclick="clearForm()" style="width: 80px">取消</a>
            </div>
        </div>
        <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-clear'">退出系统</a>
        <select class="easyui-combobox" data-options="editable:false">
            <option value="0" selected="selected">中文</option>
            <option value="1">English</option>
        </select>

    </div>
</div>

<div region="west" split="true" title="导航菜单" id="naver">
    <div class="easyui-accordion" fit="true" id="navmenu">
        <div title="指标体系">
            <ul class="navmenu">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#" data-url="html/page01.html">组织机构管理</a></li>
                <li><a href="#" data-url="html/page02.html">指标库列表</a></li>
            </ul>s
        </div>
        <div title="绩效考核"></div>
        <div title="报表管理"></div>
        <div title="系统管理"></div>
        <div title="组件示例">
            <ul class="navmenu">
                <li><a href="#" data-url="html/demo01.html">锁定行和列</a></li>
            </ul>
        </div>
    </div>
</div>

<div region="center" id="content">
    <div class="easyui-tabs" fit="true" id="tt">

        <div title="首页" iconCls="icon-ok">
            <div class="easyui-accordion" data-options="fit:true">
                <div title="待办事项">
                    <div class="flow-panel">
                        <div class="flow-todo">
                            <ul class="todo-list">
                                <li>
                                    <span>代办事项 A</span>
                                    <a href="#" class="num">5</a>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>
                <div title="系统公告">
                    <ul class="notice-list">
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
</div>

<div region="south" id="footer">某某后台管理系统 V1.0</div>

<script type="text/javascript">
    $(function() {
        //添加新的Tab页
        $("#navmenu").on("click", "a[data-url]", function(e) {
            e.preventDefault();
            var tabTitle = $(this).text();
            var tabUrl = $(this).data("url");

            if($("#tt").tabs("exists", tabTitle)) { //判断该Tab页是否已经存在
                $("#tt").tabs("select", tabTitle);
            }else {
                $("#tt").tabs("add", {
                    title: tabTitle,
                    href: tabUrl,
                    closable: true
                });
            }
            $("#navmenu .active").removeClass("active");
            $(this).parent().addClass("active");
        });

        //解决闪屏的问题
        window.setTimeout(function() {
            $("#layout").css("visibility", "visible");
        }, 800);
    });
</script>
<script>
    $(function() {
        if("${msg }"!=""){
            //$.messager.alert('提示',"${msg }");
            var showmsg="${msg }";
            $.messager.show({
                title:'提示',
                msg:showmsg
            });
        }
        /*获取焦点*/
        $('#loginname').textbox('textbox').focus();
        /** 给登录按钮绑定点击事件  */
        $("#login-submit-btn").on("click", function() {
            /** 校验登录参数 ctrl+K */
            var loginname = $("#loginname").val();
            var password = $("#password").val();
            if($("#formlogin").form('validate')){
                var msg = "";
                if (!/^\w{1,20}$/.test(loginname)) {
                    msg = "登录名长度必须是1~20之间";
                } else if (!/^\w{1,20}$/.test(password)) {
                    msg = "密码长度必须是1~20之间";
                }
                if (msg != "") {
                    $.messager.alert('用户名或密码错误',msg,'info');
                    return false;
                }
                $("#formlogin").submit();
            }
        });
        /** 按了回车键 */
        $(document).keydown(function(event) {
            if (event.keyCode == 13) {
                $("#login-submit-btn").trigger("click");
            }
        })
    })
    function clearForm() {
        $('#formlogin').form('clear');
    }
    $('#easyui-textbox').textbox({
        label: '用户名：'
    });
</script>
</body>
</html>
