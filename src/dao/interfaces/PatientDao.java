/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.SQLException;
import java.util.List;
import model.Patient;

/**
 *
 * @author sonnt
 */
public interface PatientDao {
    Patient insert(Patient object) throws SQLException;
    List<Patient> all() throws SQLException;
    List<Patient> findByName(String name) throws SQLException;
}
