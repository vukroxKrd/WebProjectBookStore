<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
    <link href="styles.css" rel="Stylesheet" type="text/css"/>
    <title>Add a new book page</title>
</head>

<body>
<jsp:include page="/header.jsp"/>
    <h1>Add a new book to the database</h1>
        <div id="addBook">
            <form action="http://127.0.0.1:8080/mywebapp/add-new-book" method="POST" id="addnewbook.html">
                <label for="addnewbook.html">Please input below with the following parameters to add a new book to the database: </label>
                    <p>ISBN: <input type="TEXT" id="isbn" placeholder="Enter isbn" name="ISBN"/></p>
                    <p>Author: <input type="TEXT" id="author" placeholder="Enter author" name="AUTHOR"/></p>
                    <p>Title: <input type="TEXT" id="title" placeholder="Enter title" name="TITLE"/></p>
                    <p>Price: <input type="TEXT" id="price" placeholder="Enter price" name="PRICE"/></p>
                        <button type="submit">Add new Book</button>
                            <br/>
                        <button type="reset" id="clearBody" placeholder="Enter to clear">Clear</button>
            </form>
        </div>
</body>
<footer>
    <jsp:include page="/footer.jsp"/>
</footer>
</html>