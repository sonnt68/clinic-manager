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
        Clinic clinic = new Clinic(
            rset.getString("name"),
            rset.getString("room"),
            rset.getString("type")
        );
        
        clinic.setId(rset.getLong("id"));
        
        return clinic;
    }
}
