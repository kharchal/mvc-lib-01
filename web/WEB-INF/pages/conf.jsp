<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title><s:message key="page.title.conf" var="title"/></title>
    <jsp:include page="util/header.jsp"/>
  </head>
  <body>
    <div class="container">
    <h2><c:out value="${title}"/></h2>
    <c:if test="${empty sessionScope.user}" var="cond">
      <div style="color: red;" class="alert alert-danger">
        <s:message key="msg.login.unlogged"/>
      </div>
    </c:if>
    <c:if test="${not cond}">
      <h3><s:message key="${msg}"/></h3>
      <s:message key="page.conf.welcome"/><c:out value="${sessionScope.user.name}"/>
    </c:if>
    <table class="table table-hover">
      <tr>
        <th><s:message key="user.name"/></th>
        <th><s:message key="user.login"/></th>
        <th><s:message key="user.password"/></th>
      </tr>
      <c:forEach var="user" items="${list}">
        <tr>
          <td><c:out value="${user.name}"/></td>
          <td><c:out value="${user.login}"/></td>
          <td><c:out value="${user.password}"/></td>
        </tr>
      </c:forEach>
    </table>
    <jsp:include page="util/footer.jsp"/>
    </div>
  </body>
</html>
