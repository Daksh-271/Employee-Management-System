package com.gecp.emp_performance.servlets;

import beans.EmployeeBean;
import helper.DbService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Emp_Dashboard extends HttpServlet {

    private DbService dbService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        dbService = context.getBean("dbService", DbService.class);
        //greetingService.sayHello("World");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int i = 1;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Employer Dashboard</title>");
             out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; display: flex; }");
            out.println(".sidebar { position: fixed; left: 0; top: 0; width: 60px; height: 100vh; background: #2c3e50; color: white; transition: width 0.3s; overflow: hidden; padding-top: 20px; }");
            out.println(".sidebar.open { width: 250px; }");
            out.println(".sidebar img { width: 40px; height: 40px; margin: 10px; cursor: pointer; }");
            out.println(".menu-item { display: flex; align-items: center; padding: 10px; cursor: pointer; color: white; text-decoration: none; }");
            out.println(".menu-item:hover { background: #34495e; }");
            out.println(".menu-item img { width: 30px; height: 30px; margin-right: 10px; }");
            out.println(".menu-text { display: none; }");
            out.println(".sidebar.open .menu-text { display: inline; }");
            out.println(".page { display:flex; flex-direction: column; padding:20px; margin-left: 60px; transition: margin-left 0.3s; }");
            //out.println(".main-content { flex: 1; padding: 20px; margin-left: 60px; transition: margin-left 0.3s; }");
            out.println(".sidebar.open + .page { margin-left: 250px; }");
            out.println(".page a { text-decoration: none; color: black; cursor: pointer; }");
            out.println("#employer-info{ background-color: #fff; margin-left: 20px; height: 120px; width: 300px; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);}");
            out.println("</style>");

            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            
            HttpSession httpsession = request.getSession();
            String employer_name = (String) httpsession.getAttribute("manager");
            String employer_id = (String) httpsession.getAttribute("manager_id");
            
            out.println("<div class='sidebar' id='sidebar'>");
            out.println("<img src='images/bg.png' alt='Logo' id='toggleBtn'>");  // Sidebar toggle button (Logo)
            out.println("<a href='add' class='menu-item'><img src='images/add-emp.png' alt='Add'><span class='menu-text'>Add Employee</span></a>");
            out.println("</div>");
            
            out.println("<div class='page'>");
            out.println("<main>");
            out.println("<section id='employer-info'>");
            out.println("<h2>Welcome, " + employer_name + "!</h2>");
            out.println("<p>Employer id: " + employer_id + "</p>");
            out.println("<a href='Logout_Servlet'><p>Logout</p></a>");
            out.println("</section>");
            out.println("</main>");
            
            
            List<EmployeeBean> allEmps = dbService.fetchAllEmployees(employer_id);
            
            out.println("<div class='main-content'>");
            out.println("<h2>Employee Information</h2>");
            out.println("<table border='1' cellpadding='5' cellspacing='0'>");
            out.println("<tr><th>ID</th><th>Employee Name</th><th>Email</th><th>Age</th><th>Employee ID</th><th>Assigned Employer ID</th><th>Department</th><th>Location</th><th>Education</th><th>Recruitment Type</th><th>Job Rating</th><th>Awards</th><th>Salary</th><th>Satisfaction</th><th colspan='2'>Action</th></tr>");
                       
            for (EmployeeBean eb: allEmps) {
                
                out.println("<tr>"
                        + "<td>"+ i++ +"</td>"
                        + "<td>"+ eb.getE_name() +"</td>"
                        + "<td>"+ eb.getEmail() +"</td>"
                        + "<td>"+ eb.getAge() +"</td>"
                        + "<td>"+ eb.getEmp_id() +"</td>"
                        + "<td>"+ employer_id +"</td>"
                        + "<td>"+ eb.getDepartment() +"</td>"
                        + "<td>"+ eb.getLocation() +"</td>"
                        + "<td>"+ eb.getEducation() +"</td>"
                        + "<td>"+ eb.getRecruitment_type() +"</td>"
                        + "<td>"+ eb.getJob_rating() +"</td>"
                        + "<td>"+ eb.getAwards() +"</td>"
                        + "<td>"+ eb.getSalary() +"</td>"
                        + "<td>"+ eb.getSatisfaction() +"</td>"
                                + "<td><a href='edit?id=" + eb.getId() + "'>Edit</a></td>"
                                + "<td><a href='deleteEmployee?id=" + eb.getId() + "' onclick=\"return confirm('Are you sure?')\">Delete</a></td>"
                        + "</tr>");
                
                
            }
            out.println("</table>");  
            out.println("</div>");
            out.println("</div>");
            out.println("</center>");

            out.println("<script>");
            out.println("document.getElementById('toggleBtn').addEventListener('click', function() {");
            out.println("    var sidebar = document.getElementById('sidebar');");
            out.println("    sidebar.classList.toggle('open');");
            out.println("});");
            out.println("document.addEventListener('click', function(event) {");
            out.println("    var sidebar = document.getElementById('sidebar');");
            out.println("    var toggleBtn = document.getElementById('toggleBtn');");
            out.println("    if (!sidebar.contains(event.target) && event.target !== toggleBtn) {");
            out.println("        sidebar.classList.remove('open');");
            out.println("    }");
            out.println("});");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Employer Dashboard";
    }
}
