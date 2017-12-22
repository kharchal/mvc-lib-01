<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<jsp:useBean class="ua.com.hav.site.IndexBean" id="manager">
    <jsp:setProperty name="manager" property="request" value="${pageContext.request}"/>
    <jsp:setProperty name="manager" property="response" value="${pageContext.response}"/>
</jsp:useBean>
hello, this is the index page.
<button onclick="foo();">Go...</button>
<hr>
<%--${manager.foo()}--%>
<div id="tbl">table</div>
</body>
<script>
    function foo() {
        // alert("foo works...");
        $.get("ajax/index.jsp", function (data) {
            // alert(data);
            $("#tbl").html(data);
        });
    }
</script>
</html>
