<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="todaysDate" value="<%= new java.util.Date() %>"/>

<h1>Slava <span>Braun</span> <small>programmer since 1923</small></h1>

<p style="text-indent:150px"><fmt:formatDate value="${todaysDate}" type="both"/></p>

<div id="links">
	<ul>
		<li><a href='all-books'>All Books</a></li>
		<li><a href='<c:url value="/view-cart"/>'>Your Shopping Cart</a></li>
		<li><a href='tc.jsp'>Terms and Conditions</a></li>
		<li><a href='addnewbook.jsp'>Add a New Book</a></li>
	</ul>
</div>