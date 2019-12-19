/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.SQLException;
import java.util.List;
import model.MedicalRegister;

/**
 *
 * @author sonnt
 */
public interface MedicalRegisterDao {
    List<MedicalRegister> all() throws SQLException;
    MedicalRegister insert(MedicalRegister object) throws SQLException;
}
