package com.k19.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registerNav extends HttpServlet {
    // [GET] /sign-up
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        final RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/register.jsp");
        rd.forward((HttpServletRequest) req, (HttpServletResponse) resp);
    }
}
