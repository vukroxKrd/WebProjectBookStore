package com.braun.servlets;

import com.braun.domain.Book;
import com.braun.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AddToCartServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        //parsing string to integer
        String strId = request.getParameter("id");
        int id = Integer.parseInt(strId);

        out.println("<h1> adding the book with ID "+ id);

        Book requiredBook = BookService.getService().getBookById(id);

        HttpSession session = request.getSession();
        List<Book> cart= (List<Book>) session.getAttribute("cart");
        if (cart == null)
        {
            //if this is the first visit create a new cart
            cart = new ArrayList<Book>();
        }
        cart.add(requiredBook);
        session.setAttribute("cart", cart);

        out.println("<h3>Thanks</h3>");
        String url = "view-cart";

        out.println("<a href='"+url+"'>Click here to visit your cart</a>");
        out.close();
    }
}