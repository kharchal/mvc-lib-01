<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title><s:message key="page.title.login" var="title"/></title>
    <jsp:include page="util/header.jsp"/>
  </head>
  <body>
  <div class="container">
  <h2><c:out value="${title}"/></h2>
  <c:url value="/login" var="action"/>
  <c:if test="${not empty msg}">
    <div style="color: red;" class="alert alert-danger">
      <s:message key="${msg}"/>
    </div>
  </c:if>
  <form:form modelAttribute="log_user" action="${action}">
    <table class="table">
      <tr>
        <td>
          <label for="login"><s:message key="user.login"/></label>
        </td>
        <td>
          <form:input path="login" cssClass="form-control"/>
        </td>
      </tr>
      <tr>
        <td>
          <label for="password"><s:message key="user.password"/></label>
        </td>
        <td>
          <form:input path="password" cssClass="form-control"/>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="submit" value="<s:message key="button.login"/>" class="btn btn-info"/>
        </td>
      </tr>
    </table>
  </form:form>
  <jsp:include page="util/footer.jsp"/>

    <br><a href="<c:url value='/backdoorentrance'/>">Back Door Entrance...</a>

  </div>
  </body>
</html>
