/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gecp.emp_performance.servlets;

import beans.EmployeeBean;
import helper.DbService;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author patel
 */
public class Update extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private DbService dbService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        dbService = context.getBean("dbService", DbService.class);
        //greetingService.sayHello("World");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int user_Id = Integer.parseInt(request.getParameter("userid"));
            String e_name=request.getParameter("username");
            String email=request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            String emp_id=request.getParameter("employee_id");
            String assigned_emp_id=request.getParameter("assigned-employer_id");
            String department=request.getParameter("department");
            String location=request.getParameter("location");
            String education=request.getParameter("education");
            String recruitment_type=request.getParameter("recruitment_type");
            int job_rating = Integer.parseInt(request.getParameter("job_rating"));
            int awards = Integer.parseInt(request.getParameter("awards"));
            float salary = Float.parseFloat(request.getParameter("salary"));
            String satisfaction=request.getParameter("satisfaction");
            //out.println("Error");
            EmployeeBean eb = new EmployeeBean(e_name, email, age, emp_id, assigned_emp_id, department, location, education, recruitment_type, job_rating, awards, salary, satisfaction);
            //out.println("Error1");
            dbService.editEmployee(user_Id, eb);
            RequestDispatcher rd = request.getRequestDispatcher("dashboard");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
