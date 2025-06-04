/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author patel
 */
public class ManagerBean {
    private int id;
    private String name;
    private String email;
    private String employer_id;
    private String department;
    private String password;

    public ManagerBean() {
    }

    public ManagerBean(String name, String email, String employer_id, String department, String password) {
        this.name = name;
        this.email = email;
        this.employer_id = employer_id;
        this.department = department;
        this.password = password;
    }

    public ManagerBean(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(String employer_id) {
        this.employer_id = employer_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
