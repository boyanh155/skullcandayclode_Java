package com.k19.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import com.k19.models.member;
import com.k19.DAO.memberDAO;

// servlet mapping
@WebServlet(name = "registerConfirmServlet", urlPatterns = { "/sign-up/confirm" })

public class register extends HttpServlet {
    private memberDAO mdao;

    // init edao when Servlet init
    public register() {
        this.mdao = new memberDAO();
    }

    // [GET] /sign-up/confirm
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    // [POST] /sign-up/confirm
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = null;
        if (action == null) {
            action = "cancel";
        }
        if (action.equals("submit")) {
            // get value
            final String firstName = req.getParameter("firstName");
            final String lastName = req.getParameter("lastName");
            final String fullName = firstName + " " + lastName;
            final String username = req.getParameter("username");
            final String password = req.getParameter("password");
            final String email = req.getParameter("email");
            final String contact = req.getParameter("contact");
            final String gentle = req.getParameter("gentle");
            final member member = new member();
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setFullName(fullName);
            member.setUsername(username);
            member.setPassword(password);
            member.setEmail(email);
            member.setContact(contact);
            member.setGentle(gentle);

            // Halo Data
            try {// try to insert value
                this.mdao.registerMember(member);
                req.setAttribute("user", (member) member);
                url = "/thanks.jsp";
                this.getServletContext().getRequestDispatcher("/WEB-INF/views" + url).forward((ServletRequest) req,
                        (ServletResponse) resp);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("cancel")) {
            resp.sendRedirect(req.getContextPath());
        }
    }
}
