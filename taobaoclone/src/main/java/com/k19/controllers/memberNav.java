package com.k19.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.k19.utils.cookieUtil;

import javax.servlet.annotation.WebServlet;

// servlet mapping
@WebServlet(name = "memberNavServlet", urlPatterns = { "/member/sign-up", "/member/sign-in" })
public class memberNav extends HttpServlet {
    // [GET] /member/sign-up
    // [GET] /member/sign-in
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String url = "/WEB-INF/views/register.jsp";
        // uri from webapp
        // url from host
        // tomcat path : host/webapp/path
        // tomcat path : host/path
        String temp = req.getRequestURI().toString();
        String slug = temp.substring(15, temp.length());
        // heroku
        // String path = req.getPathInfo();
        // ----------------------------------------

        // [GET] /sign-in

        // We will check cookies first time when member try to login
        if (slug.equals("sign-in")) {
            Cookie[] allc = req.getCookies();
            // get last value
            String c = cookieUtil.getCookieValue(allc, "usernameCookie");

            // first time
            if (c.equals("") || c.equals(null)) {
                url = "/WEB-INF/views/login.jsp";
            }

            // come back
            else {
                String tempurl = "/ownhome.jsp";
                session.setAttribute("message", "Halo welcome back my friend");
                getServletContext().getRequestDispatcher("/WEB-INF/views/member" + tempurl)
                        .forward((ServletRequest) req, (ServletResponse) resp);
            }

        }

        // ----------------------------------------
        // [GET] /sign-up
        else if (slug.equals("sign-up")) {
            Cookie[] allc = req.getCookies();
            // get last value
            String c = cookieUtil.getCookieValue(allc, "usernameCookie");

            // first time
            if (c.equals("") || c.equals(null)) {
                url = "/WEB-INF/views/register.jsp";

            }
            // come back
            else {
                String tempurl = "/ownhome.jsp";
                session.setAttribute("message", "Halo welcome back my friend");
                getServletContext().getRequestDispatcher("/WEB-INF/views/member" + tempurl)
                        .forward((ServletRequest) req, (ServletResponse) resp);
            }
        }
        // getServletContext().getRequestDispatcher(req.getContextPath() +
        // "/WEB-INF/views/register.jsp")
        // .forward((HttpServletRequest) req, (HttpServletResponse) resp);

        final RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward((HttpServletRequest) req, (HttpServletResponse) resp);
    }
}
