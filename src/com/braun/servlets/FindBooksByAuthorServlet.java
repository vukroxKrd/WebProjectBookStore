package com.braun.servlets;

import com.braun.domain.Book;
import com.braun.services.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindBooksByAuthorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //find all books by author
        BookService service = BookService.getService();

        //extract the parameter from the form
        String author = request.getParameter("AUTHOR");

        String targetPage;
        List<Book> allBooksByAuthor = service.getAllBooksByAuthor(author);
        if (author.trim().equals("")||allBooksByAuthor.isEmpty()) {
            request.setAttribute("errorMessage","please fill in a name for the author");
            targetPage = "/findbyauthor.jsp";
        } else {
            request.setAttribute("allBooksByAuthor", allBooksByAuthor);
            targetPage = "/find-books-results.jsp";
        }
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(targetPage);
        dispatcher.forward(request, response);
    }
}
