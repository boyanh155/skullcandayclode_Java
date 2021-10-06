package com.k19.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.k19.models.member;
import com.k19.DAO.memberDAO;

// servlet mapping
@WebServlet(name = "loginConfirmServlet", urlPatterns = { "/sign-in/confirm" })

public class login extends HttpServlet {

    private memberDAO edao;

    public login() {
        this.edao = new memberDAO();
    }

    // [GET] /sign-in/confirm
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    // [POST] /sign-in/confirm
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get info
        String uname = req.getParameter("username");
        String passwd = req.getParameter("password");

        final member member = new member();
        member.setUsername(uname);
        member.setPassword(passwd);

        // Halo Data
        try {
            if (this.edao.loginMember(member)) {
                // valid
                // set session
                HttpSession session = req.getSession();
                session.setAttribute("username", uname);
                req.setAttribute("user", (member) member);
                // create cookies
                Cookie cookie = new Cookie("username", uname);
                cookie.setMaxAge(60 * 60 * 24);
                cookie.setPath("/");
                resp.addCookie(cookie);

                // change it to Home
                String url = "/ownhome.jsp";
                getServletContext().getRequestDispatcher("/WEB-INF/views/member" + url).forward((ServletRequest) req,
                        (ServletResponse) resp);
            } else {
                // invalid
                // HttpSession session = req.getSession();
                // session.setAttribute("user", username);
                resp.sendRedirect(req.getContextPath() + "/sign-in");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
