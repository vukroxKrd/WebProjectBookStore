<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Find books by Author</title>
    <link href="styles.css" rel="Stylesheet" type="text/css">
</head>

<body>
<div id="books">
    <jsp:include page="header.jsp"/>
    <h1>Which Author's Books?</h1>

    <c:out value="${errorMessage}"/>
    </p>

    <div>
        <form action="http://127.0.0.1:8080/mywebapp/find-author" method="GET" id="findByAuthor">
            <label for="messageBody">Find by author:</label>
            <input type="text" id="messageBody" placeholder="Enter message" name="AUTHOR">
            <button type="submit">Find</button>
            <br/>
            <button type="reset" id="clearBody">Clear</button>
        </form>
    </div>

    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>

