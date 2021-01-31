<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
    <title>All books for our store</title>
    <link href="styles.css" rel="Stylesheet" type="text/css">
</head>

<body>

<jsp:include page="/header.jsp"/>

<div id="books">

    <ul>
        <%--    Открывающий тэг должен быть заключен в скриптлет тэг и опступать--%>
        <c:forEach items="${allBooks}" var="nextBook">
            <li>
                <h2>${fn:toUpperCase(nextBook.title)}</h2>
                <p>
                    <span>  by <c:out value="${nextBook.author}"/>
                            costs <fmt:formatNumber value="${nextBook.price}"
                                                    type="currency"
                                                    currencyCode="USD"/>
                <form method="post" action="add-to-cart">
                    <input type="hidden" name="id" value='<c:out value="${nextBook.id }"/>'/>
                    <input type="image" src="cart-button.png"/>
                </form>
                </span>
                </p>
            </li>
        </c:forEach>
    </ul>

</div>
</body>

<footer>
    <jsp:include page="/footer.jsp"/>
</footer>

</html>