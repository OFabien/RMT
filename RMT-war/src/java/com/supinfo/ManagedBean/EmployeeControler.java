/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.ManagedBean;

import com.supinfo.Entity.Employee;
import com.supinfo.Entity.Manager;
import com.supinfo.Entity.User;
import com.supinfo.sessionBean.UserSessionBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author fabien
 */
@ManagedBean
@RequestScoped
public class EmployeeControler {

    /**
     * Creates a new instance of EmployeeControler
     */
    
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Date birthdate;
    
    private Employee newEmployee = new Employee();
    private List<Employee> listEmployees;
    
    @EJB
    private UserSessionBean usb;
    
    public EmployeeControler() {
    }
    
    //Ajoute un employé dans la db
    public String AddEmployee() {
        usb.addUser(newEmployee);
        return "manage_home.xhtml";
    }
    
    public String ListEmployee() {
        Manager mana = (Manager) usb.getUser("manager@test.fr");
        listEmployees = new ArrayList<>(mana.getEmployees());
        return "manage_home.xhtml";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Employee getNewEmployee() {
        return newEmployee;
    }

    public void setNewEmployee(Employee newEmployee) {
        this.newEmployee = newEmployee;
    }

    public List<Employee> getListEmployees() {
        ListEmployee();
        return listEmployees;
    }

    public void setListEmployees(List<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }
}
