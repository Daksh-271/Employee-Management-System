/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;
import beans.EmployeeBean;
import beans.ManagerBean;
import hibernateUtil.HibernateUtil;
import org.hibernate.*;
import java.util.*;
/**
 *
 * @author patel
 */
public class DbService {
    public ManagerBean validateManager(ManagerBean mb) { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            String hql = "FROM ManagerBean WHERE name = :username AND password = :password";
            ManagerBean manager = (ManagerBean) session.createQuery(hql)
                .setParameter("username", mb.getName())
                .setParameter("password", mb.getPassword())
                .uniqueResult();
            session.getTransaction().commit();
            return manager;  
        } finally {
            session.close();
        } 
    }
    public void insertManager(ManagerBean mb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(mb);
            tx.commit();
        } 
        catch (Exception e) {
            if (tx != null) tx.rollback();
        } 
        finally {
            session.close();
        }
    }
    
    public List<EmployeeBean> fetchAllEmployees(String employerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            String hql = "FROM EmployeeBean WHERE assigned_emp_id = :employerId";
            Query query = session.createQuery(hql);
            query.setParameter("employerId", employerId);
            session.getTransaction().commit();
            return query.list();
        } finally {
            session.close();
        }
    }
    
    public void addEmployee(EmployeeBean eb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(eb);
            tx.commit();
        } 
        catch (Exception e) {
            if (tx != null) tx.rollback();
        } 
        finally {
            session.close();
        }
    }
    
    public EmployeeBean fetchUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        EmployeeBean employee = null;
        try {
            session.beginTransaction();
            String hql = "FROM EmployeeBean WHERE id = :emp_id";
            Query query = session.createQuery(hql);  // Use single-arg version
            query.setParameter("emp_id", id);
            employee = (EmployeeBean) query.uniqueResult();  // Cast explicitly
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return employee;
    }
    
    public void editEmployee(int employeeId, EmployeeBean updatedData) {
        Transaction tx;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        try{
            EmployeeBean employee = (EmployeeBean) session.get(EmployeeBean.class, employeeId);
            if (employee != null) {
                employee.setE_name(updatedData.getE_name());
                employee.setEmail(updatedData.getEmail());
                employee.setAge(updatedData.getAge());
                employee.setEmp_id(updatedData.getEmp_id());
                employee.setAssigned_emp_id(updatedData.getAssigned_emp_id());
                employee.setDepartment(updatedData.getDepartment());
                employee.setLocation(updatedData.getLocation());
                employee.setEducation(updatedData.getEducation());
                employee.setRecruitment_type(updatedData.getRecruitment_type());
                employee.setJob_rating(updatedData.getJob_rating());
                employee.setAwards(updatedData.getAwards());
                employee.setSalary(updatedData.getSalary());
                employee.setSatisfaction(updatedData.getSatisfaction());

                session.update(employee);
            }
            tx.commit();
        } 
        catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    
    public void deleteEmployee(int employeeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            EmployeeBean employee = (EmployeeBean) session.get(EmployeeBean.class, employeeId);
            if (employee != null) {
                session.delete(employee);
            }
            tx.commit();
        } 
        catch (Exception e) {
            if (tx != null) tx.rollback();
        } 
        finally {
            session.close();
        }
    }
}
