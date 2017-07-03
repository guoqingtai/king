<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'dwr.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<%=path%>/dwr/engine.js" type="text/javascript"></script>
<script src="<%=path%>/dwr/util.js" type="text/javascript"></script>
<script src="<%=path%>/dwr/interface/HelloDwr.js" type="text/javascript"></script>


<script type="text/javascript">
	function queryMessage() {
		alert("123" + HelloDwr.getMsg());
	}

	function Test() {
		//调用Java类Test的getString方法，callBackFun为回调函数
		HelloDwr.getMsg(callBackFun);

		//回调函数
		function callBackFun(data) {
			alert(data);
		}
	}
	
	function onPageLoad() {
		alert("123");
	}
</script>
</head>

<body
	onload="dwr.engine.setActiveReverseAjax(true);dwr.engine.setNotifyServerOnPageUnload(true,true);onPageLoad();dwr.engine.setErrorHandler(function(){});">
	This is my JSP page.
	<input type="button" onclick="Test()">
	<br>
</body>
</html>
