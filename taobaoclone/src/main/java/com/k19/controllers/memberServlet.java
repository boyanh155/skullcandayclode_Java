package com.k19.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.k19.DAO.memberDAO;
import com.k19.models.member;
import com.k19.utils.cookieUtil;

public class memberServlet extends HttpServlet {
    // get current action
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "viewAlbums"; // default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("viewAlbums")) {
            url = "/index.jsp";
        } else if (action.equals("checkUser")) {
            try {
                url = checkUser(req, resp);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        // forward to the view
        getServletContext().getRequestDispatcher("/WEB-INF/views" + url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("registerUser")) {
            url = "/register.jsp";
        }

        // forward to the view
        getServletContext().getRequestDispatcher("/WEB-INF/views" + url).forward(req, resp);
    }

    // Check user
    private String checkUser(HttpServletRequest req, HttpServletResponse resp)
            throws ClassNotFoundException, SQLException {
        String productCode = req.getParameter("productCode");
        HttpSession session = req.getSession();
        session.setAttribute("productCode", productCode);
        member member = (member) session.getAttribute("member");

        String url;
        // if User object doesn't exist, check email cookie
        if (member == null) {
            Cookie[] cookies = req.getCookies();
            String username = cookieUtil.getCookieValue(cookies, "usernameCookies");
            // if cookie doesn't exist, go to Registration page
            if (username == null || username.equals("")) {
                url = "/register.jsp";
            }
            // if cookie exists, create User object and go to member page
            else {
                member = memberDAO.selectMember(username);
                session.setAttribute("member", member);
                url = "/member/ownhome.jsp";
            }
        }
        // if User object exists, go to Downloads page
        else {
            url = "/member/ownhome.jsp";
        }
        return url;
    }

}
