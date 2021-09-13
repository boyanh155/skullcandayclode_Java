package com.k19.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.k19.DAO.employeeDAO;
import com.k19.models.employeeModel;

public class employeeServlet extends HttpServlet {
    private employeeDAO edao;

    // init edao when Servlet init
    public employeeServlet() {
        this.edao = new employeeDAO();
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
            final String username = req.getParameter("username");
            final String password = req.getParameter("password");
            final String address = req.getParameter("address");
            final String contact = req.getParameter("contact");
            final String gentle = req.getParameter("gentle");
            final employeeModel employee = new employeeModel();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setUsername(username);
            employee.setPassword(password);
            employee.setAddress(address);
            employee.setContact(contact);
            employee.setGentle(gentle);
            try {// try to insert value
                this.edao.registerEmployee(employee);
                req.setAttribute("user", (employeeModel) employee);
                url = "/thanks.jsp";
                this.getServletContext().getRequestDispatcher("/WEB-INF/views" + url).forward((ServletRequest) req,
                        (ServletResponse) resp);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if (action.equals("cancel")) {
            resp.sendRedirect(req.getContextPath());
        }
    }
}
