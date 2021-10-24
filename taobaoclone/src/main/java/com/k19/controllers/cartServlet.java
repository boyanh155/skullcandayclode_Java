package com.k19.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.k19.models.cart;

public class cartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();

        String action = "cart";

        String url = "/index.jsp";
        if (action.equals("shop")) {
            url = "/index.jsp";
        } else if (action.equals("cart")) {
            HttpSession session = req.getSession();
            // check cart
            cart cart = (cart) session.getAttribute("cart");
            // init cart
            if (cart == null) {
                cart = new cart();
            }
        } else if (action.equals("checkout")) {
            url = "/checkout.jsp";
        }
        // nav
        if (url.equals("/index.jsp")) {
            sc.getRequestDispatcher(url).forward(req, resp);

        } else {
            sc.getRequestDispatcher("/WEB-INF/views/cart" + url).forward(req, resp);
        }
    }
}
