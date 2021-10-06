package com.k19.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

// servlet mapping
@WebServlet(name = "memberNavServlet", urlPatterns = { "/sign-up", "/sign-in" })
public class memberNav extends HttpServlet {
    // [GET] /sign-up
    // [GET] /sign-in
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        String url = "/WEB-INF/views/register.jsp";
        // uri from webapp
        // url from host
        // tomcat path : host/webapp/path
        // tomcat path : host/path
        String temp = req.getRequestURI().toString();
        String slug = temp.substring(8, temp.length());
        System.out.println(temp);
        // heroku
        String path = req.getPathInfo();
        System.out.println(slug);

        System.out.println(slug);
        // [GET] /sign-in
        if (temp.equals("/sign-in")) {
            System.out.println("Im 0");
            url = "/WEB-INF/views/login.jsp";

        }
        // [GET] /sign-up
        else if (temp.equals("/sign-up")) {
            System.out.println("Im 1");
            url = "/WEB-INF/views/register.jsp";
        }
        // getServletContext().getRequestDispatcher(req.getContextPath() +
        // "/WEB-INF/views/register.jsp")
        // .forward((HttpServletRequest) req, (HttpServletResponse) resp);

        final RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward((HttpServletRequest) req, (HttpServletResponse) resp);
    }
}
