<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="<c:url value='/'/>"><s:message key="ref.home"/></a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
<a href="<c:url value='/login'/>"><s:message key="ref.login"/></a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
<a href="<c:url value='/reg'/>"><s:message key="ref.reg"/></a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
<a href="<c:url value='/conf'/>"><s:message key="ref.conf"/></a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
<a href="<c:url value='/logout'/>"><s:message key="ref.logout"/></a>
<hr>
<c:out value="(c) HAV, 2017"/>
