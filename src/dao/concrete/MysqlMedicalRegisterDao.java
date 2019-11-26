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
import model.MedicalRegister;


/**
 *
 * @author sonnt
 */
public class MysqlMedicalRegisterDao implements MedicalRegisterDao {
    private static final String
        INSERT = "INSERT INTO medical_register (id_patient, id_clinic) VALUES (?, ?)";
    public MedicalRegister insert(MedicalRegister medicalRegister) throws SQLException {
        Connection c = DaoFactory.getDatabase().openConnection();
        
        PreparedStatement pstmt = c.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
        
        pstmt.setLong(1, medicalRegister.getIdPatient());
        pstmt.setLong(2, medicalRegister.getIdClinic());
        
        pstmt.executeUpdate();
        
        ResultSet rset = pstmt.getGeneratedKeys();
        
        rset.next();
        Long idGenerated = rset.getLong(1);
        medicalRegister.setId(idGenerated);
        
        pstmt.close();
        c.close();
        
        return medicalRegister;
    }
}
