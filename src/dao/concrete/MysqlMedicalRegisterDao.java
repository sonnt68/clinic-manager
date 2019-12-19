/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.concrete;

import dao.interfaces.MedicalRegisterDao;
import daoFactory.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Clinic;
import model.MedicalRegister;
import model.Patient;


/**
 *
 * @author sonnt
 */
public class MysqlMedicalRegisterDao implements MedicalRegisterDao {

    public MedicalRegister insert(MedicalRegister medicalRegister) throws SQLException {
        String sql = "INSERT INTO medical_register (id_patient, id_clinic) VALUES (?, ?)";
        
        Connection c = DaoFactory.getDatabase().openConnection();
        PreparedStatement pstmt = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        pstmt.setLong(1, medicalRegister.getPatient().getId());
        pstmt.setLong(2, medicalRegister.getClinic().getId());
         
        pstmt.executeUpdate();
        ResultSet rset = pstmt.getGeneratedKeys();
        
        rset.next();
        Long idGenerated = rset.getLong(1);
        medicalRegister.setId(idGenerated);
        
        pstmt.close();
        c.close();
       
        return medicalRegister;
    }
    
    public List<MedicalRegister> all() throws SQLException {
        String sql = "SELECT * FROM medical_register";
        ArrayList<MedicalRegister> medicalRegister = new ArrayList<MedicalRegister>();
        
        Connection c = DaoFactory.getDatabase().openConnection();
        PreparedStatement pstmt = c.prepareStatement(sql);
        
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()){
            medicalRegister.add(createMedicalRegister(rset));
        }
        
        pstmt.close();
        c.close();
        
        return medicalRegister;
    }
    
    private MedicalRegister createMedicalRegister(ResultSet rset) throws SQLException{
        MedicalRegister medicalRegister = new MedicalRegister();
//            rset.getString("name"),
//            rset.getString("age"),
//            rset.getString("address"),
//            rset.getString("phone")
//        );
        
        medicalRegister.setId(rset.getLong("id"));
        
        long idClinic = rset.getLong("id_clinic");
        Clinic clinic = getClinic(idClinic);
        medicalRegister.setClinic(clinic);
        
        long idPatient = rset.getLong("id_patient");
        Patient patient = getPatient(idPatient);
        medicalRegister.setPatient(patient);
        
        return medicalRegister;
    }
    
    public Clinic getClinic(long idClinic) throws SQLException{
        String sql = "SELECT * FROM clinics WHERE id = ?";
        Clinic clinic = new Clinic();
        Connection c = DaoFactory.getDatabase().openConnection();
        PreparedStatement pstmt = c.prepareStatement(sql);
        
        pstmt.setLong(1, idClinic);
        
        ResultSet rset = pstmt.executeQuery();
        
        while(rset.next()){
            clinic.setId(idClinic);
            clinic.setName(rset.getString("name"));
            clinic.setRoom(rset.getString("room"));
            clinic.setType(rset.getString("type"));
            return clinic;
        }
        return null;
    }
    public Patient getPatient(long idPatient) throws SQLException{
        String sql = "SELECT * FROM patients WHERE id = ?";
        Patient patient = new Patient();
        Connection c = DaoFactory.getDatabase().openConnection();
        PreparedStatement pstmt = c.prepareStatement(sql);
        
        pstmt.setLong(1, idPatient);
        
        ResultSet rset = pstmt.executeQuery();
        
        while(rset.next()){
            patient.setId(idPatient);
            patient.setName(rset.getString("name"));
            patient.setAge(rset.getString("age"));
            patient.setPhone(rset.getString("phone"));
            patient.setAddress(rset.getString("address"));
            return patient;
        }
        return null;
    }
}
