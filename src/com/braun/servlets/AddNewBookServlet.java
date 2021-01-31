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

public class AddNewBookServlet extends HttpServlet {

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

    {
        BookService bookService = BookService.getService();

        //Requesting parameters from user to produce a new book
        String isbn = request.getParameter("ISBN");
        String title = request.getParameter("TITLE");
        String author = request.getParameter("AUTHOR");
        double price = new Double(request.getParameter("PRICE"));

        String targetPage;
        if (isbn.equals("")||title.equals("")||author.equals("")) {
            request.setAttribute("ISBN", isbn);
            request.setAttribute("TITLE", title);
            request.setAttribute("AUTHOR", author);
            request.setAttribute("price", price);
            targetPage="/addnewbook.jsp";
        } else {
            //Creating a new BookObject based on the provided data
            Book newBook = new Book(isbn,title,author,price);
            bookService.registerNewBook(newBook);
            targetPage="/book-added.jsp";
        }
        //forward User to a JSP page to inform U. that all is well.
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(targetPage);
        dispatcher.forward(request,response);
    }
}
