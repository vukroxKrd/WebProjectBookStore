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

public class DisplayAllBooksServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        //do some work
        BookService bookService = BookService.getService();
        List<Book> allBooks = bookService.getEntireCatalogue();

        //set up the data to forward to a JSP file inside an attribute
        request.setAttribute("allBooks", allBooks);


        //forward to the displayallbooks.jsp page to display the results
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/displayallbooks.jsp");
        dispatcher.forward(request,response);
    }
}
