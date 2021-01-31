package com.braun.servlets;

import com.braun.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewCartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<html><body><h1>Your Cart</h1><ul>");

        HttpSession session = request.getSession();
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart != null) {
            for (Book nextBook : cart) {
                out.println("<li>" + nextBook.getTitle() + ": $" + nextBook.getPrice() + "</li>");
            }
        } else {
            out.println("<p>Your cart is empty<p>");
        }
        out.println("</ul></body></html>");
        out.close();
    }
}
