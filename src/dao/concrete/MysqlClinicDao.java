/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.concrete;

import dao.interfaces.ClinicDao;
import daoFactory.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Clinic;
import model.Doctor;
import model.Examination;

/**
 *
 * @author sonnt
 */
public class MysqlClinicDao implements ClinicDao {
    private static final String
        ALL = "SELECT * FROM clinics";
    public List<Clinic> all() throws SQLException {
        ArrayList<Clinic> clinics = new ArrayList<Clinic>();
        
        Connection c = DaoFactory.getDatabase().openConnection();
        PreparedStatement pstmt = c.prepareStatement(ALL);
        
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()){
            clinics.add(createClinic(rset));
        }
        
        pstmt.close();
        c.close();
        
        return clinics;
    }
    
    private Clinic createClinic(ResultSet rset) throws SQLException{
        Clinic clinic = new Clinic();
        clinic.setId(rset.getLong("id"));
        clinic.setName(rset.getString("name"));
        clinic.setRoom(rset.getString("room"));
        clinic.setType(rset.getString("type"));
        long idExamination = rset.getLong("id_examination");
        Examination examination = getExamination(idExamination);
        
        clinic.setExamination(examination);
        
        return clinic;
    }
    
    public Examination getExamination(long idExamination) throws SQLException{
        String sql = "SELECT * FROM examination WHERE id = ?";
        Examination examination = new Examination();
        
        Connection c = DaoFactory.getDatabase().openConnection();
        PreparedStatement pstmt = c.prepareStatement(sql);
        
        pstmt.setLong(1, idExamination);
        
        ResultSet rset = pstmt.executeQuery();
        while(rset.next()){
            examination.setId(idExamination);
            examination.setStartTime(rset.getString("start_time"));
            examination.setEndTime(rset.getString("end_time"));
            
            long idDoctor = rset.getLong("id_doctor");
            Doctor doctor = getDoctor(idDoctor);
            examination.setDoctor(doctor);
            
            return examination;
        }
        return null;
    }
    
    public Doctor getDoctor(long idDoctor) throws SQLException{
        String sql = "SELECT * FROM doctor WHERE id = ?";
        Doctor doctor = new Doctor();
        Connection c = DaoFactory.getDatabase().openConnection();
        PreparedStatement pstmt = c.prepareStatement(sql);
        
        pstmt.setLong(1, idDoctor);
        
        ResultSet rset = pstmt.executeQuery();
        
        while(rset.next()){
            doctor.setId(idDoctor);
            doctor.setDoctorName(rset.getString("name"));
            return doctor;
        }
        return null;
    }
}
