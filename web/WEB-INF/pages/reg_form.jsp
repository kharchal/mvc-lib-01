<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title><s:message key="page.title.reg" var="title"/></title>
    <jsp:include page="util/header.jsp"/>
  </head>
  <body>
  <div class="container">
  <h2><c:out value="${title}"/></h2>
  <c:url value="/reg" var="action"/>
  <form:form modelAttribute="reg_user" action="${action}">
    <table class="table">
      <colgroup>
        <col width="15%"/>
        <col width="30%"/>
        <col/>
      </colgroup>
      <tr>
        <td>
          <label for="name"><s:message key="user.name"/>:</label>
        </td>
        <td>
          <form:input path="name" cssClass="form-control"/>
        </td>
        <td>
          <form:errors path="name" cssStyle="color: red"/>
        </td>
      </tr>
      <tr>
        <td>
          <label for="login"><s:message key="user.login"/>:</label>
        </td>
        <td>
          <form:input path="login" cssClass="form-control"/>
        </td>
        <td>
          <form:errors path="login" cssStyle="color: red"/>
        </td>
      </tr>
      <tr>
        <td>
          <label for="password"><s:message key="user.password"/>:</label>
        </td>
        <td>
          <form:input path="password" cssClass="form-control"/>
        </td>
        <td>
          <form:errors path="password" cssStyle="color: red"/>
        </td>
      </tr>
      <tr>
        <td></td>
        <td colspan="2">
          <input type="submit" value="<s:message key="button.register"/>" class="btn btn-info"/>
        </td>
      </tr>
    </table>
  </form:form>
  <jsp:include page="util/footer.jsp"/>
  </div>
  </body>
</html>
