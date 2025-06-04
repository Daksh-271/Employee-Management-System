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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author patel
 */
public class EditForm extends HttpServlet {

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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int userId = Integer.parseInt(request.getParameter("id"));
        EmployeeBean eb = dbService.fetchUser(userId);
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("  <meta charset=\"UTF-8\">");
        out.println("  <title>Employee Performance Analyzer</title>");
        out.println("  <script type=\"module\" src=\"https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js\"></script>");
        out.println("  <script nomodule src=\"https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js\"></script>");
        out.println("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">");
        out.println("  <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap'>");
        out.println("  <style>");
        out.println("    * {");
        out.println("      font-family: \"Poppins\";");
        out.println("    }");
        out.println("");
        out.println("    body {");
        out.println("      -webkit-user-select: none;");
        out.println("      -moz-user-select: none;");
        out.println("      -ms-user-select: none;");
        out.println("      user-select: none;");
        out.println("      overflow-y: hidden;");
        out.println("      display: flex;");
        out.println("      justify-content: center;");
        out.println("      align-items: center;");
        out.println("      background: #dde5f4;");
        out.println("      height: 100vh;");
        out.println("    }");
        out.println("");
        out.println("    .screen-1 {");
        out.println("      background: #f1f7fe;");
        out.println("      padding: 2.5em 4em;");
        out.println("      display: flex;");
        out.println("      height: 640px;");
        out.println("      flex-direction: column;");
        out.println("      border-radius: 30px;");
        out.println("      box-shadow: 0 0 2em #e6e9f9;");
        out.println("      gap: 10px;");
        out.println("    }");
        out.println("");
        out.println("    .screen-1 #common {");
        out.println("      display: flex;");
        out.println("      flex-direction: column;");
        out.println("      margin: 10px;");
        out.println("    }");
        out.println("");
        out.println("    .screen-1 .logo {");
        out.println("      margin: auto;");
        out.println("      width: 230px; /* Reduced width */");
        out.println("      height: 230px; /* Reduced height */");
        out.println("    }");
        out.println("");
        out.println("    .screen-1 .username,");
        out.println("    .screen-1 .email,");
        out.println("    .screen-1 .age,");
        out.println("    .screen-1 .employee-id,");
        out.println("    .screen-1 .assigned-employer-id,");
        out.println("    .screen-1 .department,");
        out.println("    .screen-1 .location,");
        out.println("    .screen-1 .education,");
        out.println("    .screen-1 .recruitment-type,");
        out.println("    .screen-1 .job-rating,");
        out.println("    .screen-1 .awards,");
        out.println("    .screen-1 .salary,");
        out.println("    .screen-1 .satisfaction {");
        out.println("      background: white;");
        out.println("      box-shadow: 0 0 2em #e6e9f9;");
        out.println("      padding: 1em 2em 1em 2em;");
        out.println("      display: flex;");
        out.println("      flex-direction: column;");
        out.println("      gap: 0.5em;");
        out.println("      border-radius: 15px;");
        out.println("      color: #4d4d4d;");
        out.println("    }");
        out.println("");
        out.println("    .screen-1 input {");
        out.println("      outline: none;");
        out.println("      border: none;");
        out.println("    }");
        out.println("");
        out.println("    .screen-1 input::placeholder {");
        out.println("      color: black;");
        out.println("      font-size: 0.9em;");
        out.println("      opacity: 50%;");
        out.println("    }");
        out.println("");
        out.println("    .screen-1 ion-icon {");
        out.println("      color: #4d4d4d;");
        out.println("      margin-bottom: -0.2em;");
        out.println("    }");
        out.println("");
        out.println("    .screen-1 .login {");
        out.println("      padding: 1em 2em 1em 2em;");
        out.println("      background: #3e4684;");
        out.println("      color: white;");
        out.println("      border: none;");
        out.println("      border-radius: 25px;");
        out.println("      cursor: pointer;");
        out.println("      font-weight: 600;");
        out.println("    }");
        out.println("    ");
        out.println("    .screen-1 .footer span a{");
        out.println("        cursor: pointer;");
        out.println("        padding-top: 3px;");
        out.println("        text-decoration: none;");
        out.println("        color: black;");
        out.println("        font-size: 14px;");
        out.println("    }");
        out.println("    ");
        out.println("    .hidden {");
        out.println("      display: none;");
        out.println("    }");
        out.println("  </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("  <form action=\"update\" method=\"post\">");
        out.println("    <div class=\"screen-1\">");
        out.println("      <!-- Page 1 -->");
        out.println("      <div id=\"page1\">");
        out.println("          <center><svg class=\"logo\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" viewbox=\"0 0 640 480\" xml:space=\"preserve\">");
        out.println("          <g transform=\"matrix(3.31 0 0 3.31 320.4 240.4)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt;stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(61,71,133); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.98 0 0 0.98 268.7 213.7)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(1.01 0 0 1.01 362.9 210.9)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.92 0 0 0.92 318.5 286.5)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.16 -0.12 0.49 0.66 290.57 243.57)\">");
        out.println("            <polygon style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" points=\"-50,-50 -50,50 50,50 50,-50 \"></polygon>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.16 0.1 -0.44 0.69 342.03 248.34)\">");
        out.println("            <polygon style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" vector-effect=\"non-scaling-stroke\" points=\"-50,-50 -50,50 50,50 50,-50 \"></polygon>");
        out.println("          </g>");
        out.println("          </svg></center>");
        out.println("");
        out.println("            <input type=\"hidden\" name=\"userid\" value='"+ userId +"'/>");
        out.println("        <div class=\"username\" id=\"common\">");
        out.println("          <label for=\"username\">Name</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"person-circle-outline\"></ion-icon>");                
        out.println("            <input type=\"text\" name=\"username\" placeholder=\"Enter Your Name\" value='"+ eb.getE_name() +"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("");
        out.println("        <div class=\"email\" id=\"common\">");
        out.println("          <label for=\"email\">Email</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"mail-outline\"></ion-icon>");
        out.println("            <input type=\"email\" name=\"email\" placeholder=\"Enter Your Email Address\" value='"+ eb.getEmail() +"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("");
        out.println("        <div class=\"age\" id=\"common\">");
        out.println("          <label for=\"age\">Age</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"calendar-outline\"></ion-icon>");
        out.println("            <input type=\"number\" name=\"age\" placeholder=\"Enter Your Age\" value='"+ eb.getAge() +"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("");
        out.println("        <div class=\"employee-id\" id=\"common\">");
        out.println("          <label for=\"employee_id\">Employee ID</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"id-card-outline\"></ion-icon>");
        out.println("            <input type=\"text\" name=\"employee_id\" placeholder=\"Enter Employee ID\" value='"+ eb.getEmp_id() +"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("          ");
        out.println("");
        out.println("        <center><button type=\"button\" class=\"login\" onclick=\"nextPage()\" style=\"margin-top:10px;\">Next</button>");
        out.println("        <div class=\"footer\" id=\"foot\">");
        out.println("            <span><a href=\"dashboard\">Go Back</a></span>");
        out.println("        </div>");
        out.println("        </center>");
        out.println("      </div>");
        out.println("");
        out.println("      <!-- Page 2 -->");
        out.println("      <div id=\"page2\" class=\"hidden\">");
        out.println("          <center><svg class=\"logo\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"300\" height=\"300\" viewbox=\"0 0 640 480\" xml:space=\"preserve\">");
        out.println("          <g transform=\"matrix(3.31 0 0 3.31 320.4 240.4)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt;stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(61,71,133); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.98 0 0 0.98 268.7 213.7)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(1.01 0 0 1.01 362.9 210.9)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.92 0 0 0.92 318.5 286.5)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.16 -0.12 0.49 0.66 290.57 243.57)\">");
        out.println("            <polygon style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" points=\"-50,-50 -50,50 50,50 50,-50 \"></polygon>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.16 0.1 -0.44 0.69 342.03 248.34)\">");
        out.println("            <polygon style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" vector-effect=\"non-scaling-stroke\" points=\"-50,-50 -50,50 50,50 50,-50 \"></polygon>");
        out.println("          </g>");
        out.println("          </svg></center>");
        out.println("");
        out.println("        <div class=\"assigned-employer-id\" id=\"common\">");
        out.println("          <label for=\"assigned-employer_id\">Assigned Employer ID</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"id-card-outline\"></ion-icon>");
        out.println("            <input type=\"text\" name=\"assigned-employer_id\" placeholder=\"Enter ID of Assigned Employer\" value='"+ eb.getAssigned_emp_id() +"' readonly required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("          ");
        out.println("        <div class=\"department\" id=\"common\">");
        out.println("          <label for=\"department\">Department</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"business-outline\"></ion-icon>");
        out.println("            <input type=\"text\" name=\"department\" placeholder=\"Enter Department\" value='"+ eb.getDepartment()+"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("");
        out.println("        <div class=\"location\" id=\"common\">");
        out.println("          <label for=\"location\">Location</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"location-outline\"></ion-icon>");
        out.println("            <input type=\"text\" name=\"location\" placeholder=\"Enter Location\" value='"+ eb.getLocation() +"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("");
        out.println("        <div class=\"education\" id=\"common\">");
        out.println("          <label for=\"education\">Education</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"school-outline\"></ion-icon>");
        out.println("            <input type=\"text\" name=\"education\" placeholder=\"Enter Education\" value='"+ eb.getEducation() +"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("");
        out.println("");
        out.println("        <center><button type=\"button\" class=\"login\" onclick=\"prevPage()\" style=\"margin-top:10px;\">Previous</button>");
        out.println("            <button type=\"button\" class=\"login\" onclick=\"nextPage()\" style=\"margin-top:10px;\">Next</button></center>");
        out.println("      </div>");
        out.println("");
        out.println("      <!-- Page 3 -->");
        out.println("      <div id=\"page3\" class=\"hidden\">");
        out.println("          <center><svg class=\"logo\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"300\" height=\"300\" viewbox=\"0 0 640 480\" xml:space=\"preserve\">");
        out.println("          <g transform=\"matrix(3.31 0 0 3.31 320.4 240.4)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt;stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(61,71,133); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.98 0 0 0.98 268.7 213.7)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(1.01 0 0 1.01 362.9 210.9)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.92 0 0 0.92 318.5 286.5)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.16 -0.12 0.49 0.66 290.57 243.57)\">");
        out.println("            <polygon style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" points=\"-50,-50 -50,50 50,50 50,-50 \"></polygon>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.16 0.1 -0.44 0.69 342.03 248.34)\">");
        out.println("            <polygon style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" vector-effect=\"non-scaling-stroke\" points=\"-50,-50 -50,50 50,50 50,-50 \"></polygon>");
        out.println("          </g>");
        out.println("          </svg></center>");
        out.println("");
        out.println("        <div class=\"recruitment-type\" id=\"common\">");
        out.println("          <label for=\"recruitment_type\">Recruitment Type</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"contract-outline\"></ion-icon>");
        out.println("            <input type=\"text\" name=\"recruitment_type\" placeholder=\"Enter Recruitment Type\" value='"+ eb.getRecruitment_type() +"' required/>");
        out.println("          </div>");
        out.println("        </div>  ");
        out.println("          ");
        out.println("        <div class=\"job-rating\" id=\"common\">");
        out.println("          <label for=\"job_rating\">Job Rating</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"star-outline\"></ion-icon>");
        out.println("            <input type=\"number\" name=\"job_rating\" placeholder=\"Enter Job Rating(0-5)\" value='"+ eb.getJob_rating() +"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("");
        out.println("        <div class=\"awards\" id=\"common\">");
        out.println("          <label for=\"awards\">Awards</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"trophy-outline\"></ion-icon>");
        out.println("            <input type=\"number\" name=\"awards\" placeholder=\"Enter Number of Awards\" value='"+ eb.getAwards() +"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("");
        out.println("        <div class=\"salary\" id=\"common\">");
        out.println("          <label for=\"salary\">Salary</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"card\"></ion-icon>");
        out.println("            <input type=\"number\" name=\"salary\" placeholder=\"Enter Salary\" value='"+ eb.getSalary() +"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("");
        out.println("        <center><button type=\"button\" class=\"login\" onclick=\"prevPage()\" style=\"margin-top:10px;\">Previous</button>");
        out.println("            <button type=\"button\" class=\"login\" onclick=\"nextPage()\" style=\"margin-top:10px;\">Next</button></center>");
        out.println("        ");
        out.println("     </div>");
        out.println("            ");
        out.println("        ");
        out.println("        <!-- Page 4 -->");
        out.println("      <div id=\"page4\" class=\"hidden\">");
        out.println("          <center><svg class=\"logo\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"300\" height=\"300\" viewbox=\"0 0 640 480\" xml:space=\"preserve\">");
        out.println("          <g transform=\"matrix(3.31 0 0 3.31 320.4 240.4)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt;stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(61,71,133); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.98 0 0 0.98 268.7 213.7)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(1.01 0 0 1.01 362.9 210.9)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.92 0 0 0.92 318.5 286.5)\">");
        out.println("            <circle style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" cx=\"0\" cy=\"0\" r=\"40\"></circle>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.16 -0.12 0.49 0.66 290.57 243.57)\">");
        out.println("            <polygon style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" points=\"-50,-50 -50,50 50,50 50,-50 \"></polygon>");
        out.println("          </g>");
        out.println("          <g transform=\"matrix(0.16 0.1 -0.44 0.69 342.03 248.34)\">");
        out.println("            <polygon style=\"stroke: rgb(0,0,0); stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-dashoffset: 0; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;\" vector-effect=\"non-scaling-stroke\" points=\"-50,-50 -50,50 50,50 50,-50 \"></polygon>");
        out.println("          </g>");
        out.println("          </svg></center>");
        out.println("");
        out.println("        <div class=\"satisfaction\" id=\"common\">");
        out.println("          <label for=\"satisfaction\">Satisfaction</label>");
        out.println("          <div class=\"sec-2\">");
        out.println("            <ion-icon name=\"happy-outline\"></ion-icon>");
        out.println("            <input type=\"text\" name=\"satisfaction\" placeholder=\"Enter Yes or No\" value='"+ eb.getSatisfaction() +"' required/>");
        out.println("          </div>");
        out.println("        </div>");
        out.println("");
        out.println("        <center><button type=\"button\" class=\"login\" onclick=\"prevPage()\" style=\"margin-top:10px;\">Previous</button>");
        out.println("            <button type=\"submit\" class=\"login\" style=\"margin-top:10px;\">Update</button>");
        out.println("            ");
        out.println("        <div class=\"footer\" id=\"foot\">");
        out.println("            <span><a href=\"dashboard\">Don't want to Add?</a></span>");
        out.println("        </div>");
        out.println("        </center>");
        out.println("        ");
        out.println("      </div>    ");
        out.println("            ");
        out.println("            ");
        out.println("      ");
        out.println("    </div>");
        out.println("  </form>");
        out.println("");
        out.println("  <script>");
        out.println("    let currentPage = 1;");
        out.println("");
        out.println("    function nextPage() {");
        out.println("      document.getElementById(`page${currentPage}`).classList.add('hidden');");
        out.println("      currentPage++;");
        out.println("      document.getElementById(`page${currentPage}`).classList.remove('hidden');");
        out.println("    }");
        out.println("");
        out.println("    function prevPage() {");
        out.println("      document.getElementById(`page${currentPage}`).classList.add('hidden');");
        out.println("      currentPage--;");
        out.println("      document.getElementById(`page${currentPage}`).classList.remove('hidden');");
        out.println("    }");
        out.println("  </script>");
        out.println("</body>");
        out.println("</html>");
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
