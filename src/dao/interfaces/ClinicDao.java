/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.SQLException;
import java.util.List;
import model.Clinic;

/**
 *
 * @author sonnt
 */
public interface ClinicDao {
    List<Clinic> all() throws SQLException;
}
