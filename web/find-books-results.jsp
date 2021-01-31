<%@ page import= "java.util.List" %>
<%@ page import="com.braun.domain.Book" %>
<% List<Book> allBooksByAuthor = (List<Book>) request.getAttribute("allBooksByAuthor");%>

<html>

<head>
    <title>Find books by Author</title>
    <link href="styles.css" rel="Stylesheet" type="text/css">
</head>

<body>
<jsp:include page="header.jsp"/>
<h1>Which Author's Books?</h1>

<div id="books">
    <h1>Your search results are: </h1>
    <ul>
    <% for (Book nextBook: allBooksByAuthor) {
        %>
        <li><%out.println (nextBook.getTitle());%></li>
        <%
            }
        %>
    </ul>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>