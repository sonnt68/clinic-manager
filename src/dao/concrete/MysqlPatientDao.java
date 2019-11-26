/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.concrete;

import dao.interfaces.PatientDao;
import daoFactory.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Patient;

/**
 *
 * @author sonnt
 */
public class MysqlPatientDao implements PatientDao {

    private static final String
        INSERT = "INSERT INTO patients (name, age, address, phone) VALUES (?, ?, ?, ?)";
    
    private static final String
        ALL = "SELECT * FROM patients";
    private static final String
        FIND_BY_NAME = "SELECT * FROM patients WHERE name LIKE ?";
    
    public Patient insert(Patient patient) throws SQLException {
        Connection c = DaoFactory.getDatabase().openConnection();
        
        PreparedStatement pstmt = c.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, patient.getName());
        pstmt.setString(2, patient.getAge());
        pstmt.setString(3, patient.getAddress());
        pstmt.setString(4, patient.getPhone());
        
        pstmt.executeUpdate();
        
        ResultSet rset = pstmt.getGeneratedKeys();
        
        rset.next();
        Long idGenerated = rset.getLong(1);
        patient.setId(idGenerated);
        
        pstmt.close();
        c.close();
        
        return patient;
    }
    
    
    public List<Patient> all() throws SQLException {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        
        Connection c = DaoFactory.getDatabase().openConnection();
        PreparedStatement pstmt = c.prepareStatement(ALL);
        
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()){
            patients.add(createPatient(rset));
        }
        
        pstmt.close();
        c.close();
        
        return patients;
    }
    
    public List<Patient> findByName(String name) throws SQLException {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        
        Connection c = DaoFactory.getDatabase().openConnection();
        PreparedStatement pstmt = c.prepareStatement(FIND_BY_NAME);
        pstmt.setString(1, '%' + name + '%');
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()){
            patients.add(createPatient(rset));
        }
        pstmt.close();
        c.close();
        
        return patients;
    }
    
    private Patient createPatient(ResultSet rset) throws SQLException{
        Patient patient = new Patient(
            rset.getString("name"),
            rset.getString("age"),
            rset.getString("address"),
            rset.getString("phone")
        );
        
        patient.setId(rset.getLong("id"));
        
        return patient;
    }
}
