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
    <img src="img/logo1.png" class="logo" />
    <div class="top-btns">
        <%if (session.getAttribute("user")!=null){%>
        <span>欢迎您，<%=session.getAttribute("user")%></span>
        <a href="logout.jsp" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-lock'" onclick="">注销登录</a>
        <%}%>
        <% if (session.getAttribute("user")==null){
        %>
        <%--login--%>
        <div id="wLogin" class="easyui-window" title="请先登录！" collapsible="false"
             minimizable="false" maximizable="false" icon="icon-save"
             style="width: 400px; height: 290px; padding: 30px; background: #fafafa;"
             data-options="closable:false,draggable:false" modal="true">
            <form id="formlogin" method="post" action="LoginServlet">
                <!-- menulogin -->
                <div style="margin-bottom: 20px">
                    用户名：<input class="easyui-textbox" id="loginname" name="userName"
                           prompt="userName" iconWidth="28"
                           style="width: 300px; height: 34px; padding: 10px;">
                </div>
                <div style="margin-bottom: 20px">
                    密&nbsp;&nbsp;&nbsp;码：<input class="easyui-passwordbox" id="passWord" name="passWord"
                           prompt="passWord" iconWidth="28"
                           style="width: 300px; height: 34px; padding: 10px">
                </div>
            </form>
            <div style="text-align: center; padding: 5px 0">
                <a href="javascript:void(0)" id="login-submit-btn"
                   class="easyui-linkbutton" style="width: 80px">登录</a>
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   onclick="register()" style="width: 110px">注册新账号</a>
            </div>
        </div>
        <%}%>
        <%--register--%>
        <div id="wRegister" class="easyui-window" title="管理员注册" collapsible="false"
             minimizable="false" maximizable="false" icon="icon-save"
             style="width: 400px; height: 400px; padding: 30px; background: #fafafa;"
             data-options="closable:false,draggable:false,windows:close" modal="true" closed="true">
            <form id="formRegister" method="post" action="RegisterServlet">
                <!-- menuRegister -->
                <div style="margin-bottom: 20px">
                    用户名：<input class="easyui-textbox" id="registerName" name="userName"
                               prompt="userName" iconWidth="28"
                               style="width: 300px; height: 34px; padding: 10px;">
                </div>
                <div style="margin-bottom: 20px">
                    工号：<input class="easyui-textboxbox" id="tollCollectorNo" name="tollCollectorNo"
                              prompt="tollCollectorNo" iconWidth="28"
                              style="width: 300px; height: 34px; padding: 10px">
                </div>
                <div style="margin-bottom: 20px">
                    密码：<input class="easyui-passwordbox" id="registerPassWord1" name="passWord1"
                              prompt="password" iconWidth="28"
                              style="width: 300px; height: 34px; padding: 10px">
                </div>
                <div style="margin-bottom: 20px">
                    确认密码：<input class="easyui-passwordbox" id="registerPassWord2" name="passWord2"
                                prompt="Confirm Password" iconWidth="28"
                                style="width: 300px; height: 34px; padding: 10px">
                </div>
            </form>
            <div style="text-align: center; padding: 5px 0">
                <a href="javascript:void(0)" id="register-submit-btn"
                   class="easyui-linkbutton" style="width: 80px">注册</a>
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   onclick="toLogin()" style="width: 140px">已有账号，去登陆</a>
            </div>
        </div>
    </div>
</div>

<div region="west" split="true" title="导航菜单" id="naver">
    <div class="easyui-accordion" fit="true" id="navmenu">
        <div title="车道收费">
            <ul class="navmenu">
                <li><a href="#" data-url="jsp/shangxiaban.jsp">上下班</a></li>
                <li><a href="#" data-url="jsp/page01.html">车辆进站</a></li>
                <li><a href="#" data-url="html/page02.html">收费出站</a></li>
            </ul>
        </div>
        <div title="收费站管理">
            <ul class="navmenu">
                <li><a href="#" data-url="html/page01.html">查询班次</a></li>
                <li><a href="#" data-url="html/page01.html">安排班次</a></li>
                <li><a href="#" data-url="html/page02.html">收费员信息</a></li>
                <li><a href="#" data-url="html/page02.html">车道信息</a></li>
            </ul>
        </div>
        <div title="行车卡管理">
            <ul class="navmenu">
                <li><a href="#" data-url="html/page01.html">办理行车卡</a></li>
                <li><a href="#" data-url="html/page01.html">注销行车卡</a></li>
                <li><a href="#" data-url="html/page02.html">行车卡充值</a></li>
                <li><a href="#" data-url="html/page02.html">查询卡信息</a></li>
            </ul>
        </div>
        <div title="结算中心">
            <ul class="navmenu">
                <li><a href="#" data-url="html/page01.html">查看费率</a></li>
                <li><a href="#" data-url="html/page01.html">修改费率</a></li>
                <li><a href="#" data-url="html/page02.html">拆分账目</a></li>
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
                            <span>黄金周出行高峰，各收费员辛苦了！</span>
                            <span class="date">2019-9-28</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
</div>

<div region="south" id="footer">高速收费管理系统 V0.1</div>
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
    //Login
    $(function() {
        if("${msg }"!=""){
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
    })
    function register() {
        $('#wLogin').window("close");
        $('#wRegister').window("open");
    };

    //register
    $(function() {
        /*获取焦点*/
        $('#registerName').textbox('textbox').focus();
        /** 给登录按钮绑定点击事件  */
        $("#register-submit-btn").on("click", function() {
            /** 校验登录参数 ctrl+K */
            var registerName = $("#registerName").val();
            var tollCollectorNo = $("#tollCollectorNo").val()
            var registerPassWord1 = $("#registerPassWord1").val();
            var registerPassWord2 = $("#registerPassWord2").val();
            if($("#formRegister").form('validate')){
                var msg = "";
                if (!/^\w{1,20}$/.test(registerName)) {
                    msg = "登录名长度必须是1~20之间";
                } else if (!/^\w{1,20}$/.test(registerPassWord1)) {
                    msg = "密码长度必须是1~20之间";
                } else if (registerPassWord1!=registerPassWord2){
                    msg = "两次密码不一致！";
                } else if(!/^\w{1,6}$/.test(tollCollectorNo)){
                    msg = "工号为1-6位数";
                }
                if (msg != "") {
                    $.messager.alert('输入错误！',msg,'info');
                    return false;
                }
                $("#formRegister").submit();
            }
        });
    })
    function toLogin() {
        $('#wRegister').window("close")
        $('#wLogin').window("open");
    }
</script>
</body>
</html>
