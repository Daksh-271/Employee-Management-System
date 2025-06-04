/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author patel
 */
public class EmployeeBean {
    private int id;
    private String e_name;
    private String email;
    private int age;
    private String emp_id;
    private String assigned_emp_id;
    private String department;
    private String location;
    private String education;
    private String recruitment_type;
    private int job_rating;
    private int awards;
    private float salary;
    private String satisfaction;

    public EmployeeBean() {
    }
    
    public EmployeeBean(String e_name, String email, int age, String emp_id, String assigned_emp_id, String department, String location, String education, String recruitment_type, int job_rating, int awards, float salary, String satisfaction) {
        this.e_name = e_name;
        this.email = email;
        this.age = age;
        this.emp_id = emp_id;
        this.assigned_emp_id = assigned_emp_id;
        this.department = department;
        this.location = location;
        this.education = education;
        this.recruitment_type = recruitment_type;
        this.job_rating = job_rating;
        this.awards = awards;
        this.salary = salary;
        this.satisfaction = satisfaction;
    }

    public int getId() {
        return id;
    }

    public String getE_name() {
        return e_name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public String getAssigned_emp_id() {
        return assigned_emp_id;
    }

    public String getDepartment() {
        return department;
    }

    public String getLocation() {
        return location;
    }

    public String getEducation() {
        return education;
    }

    public String getRecruitment_type() {
        return recruitment_type;
    }

    public int getJob_rating() {
        return job_rating;
    }

    public int getAwards() {
        return awards;
    }

    public float getSalary() {
        return salary;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public void setAssigned_emp_id(String assigned_emp_id) {
        this.assigned_emp_id = assigned_emp_id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setRecruitment_type(String recruitment_type) {
        this.recruitment_type = recruitment_type;
    }

    public void setJob_rating(int job_rating) {
        this.job_rating = job_rating;
    }

    public void setAwards(int awards) {
        this.awards = awards;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }
}
