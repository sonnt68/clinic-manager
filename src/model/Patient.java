/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.interfaces.PatientDao;
import daoFactory.DaoFactory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sonnt
 */
public class Patient {
    private Long id = null;
    private String name;
    private String age;
    private String address;
    private String phone;
    
    public Patient() {
    }

    public Patient(String name, String age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String[] toArray(){
        return new String[] {this.id.toString(), this.name, this.age, this.address, this.phone};
    }
    
    public void save() throws SQLException{
        patientDAO().insert(this);
    }
    
    public static List<Patient> all() throws SQLException {
        return patientDAO().all();
    }
    
    public static List<Patient> findByName(String name) throws SQLException {
        return patientDAO().findByName(name);
    }
    
    private static PatientDao patientDAO(){
        DaoFactory dao = DaoFactory.getDatabase();
        return dao.getPatientDao();
    }
}
