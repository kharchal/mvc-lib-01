<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title><s:message key="page.title.welcome" var="title"/></title>
    <jsp:include page="util/header.jsp"/>
  </head>
  <body>
  <div class="container">
  <h2><c:out value="${title}"/></h2>
  <jsp:include page="util/footer.jsp"/>
  </div>
  </body>
</html>
