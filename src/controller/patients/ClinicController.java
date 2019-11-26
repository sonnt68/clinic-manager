/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.patients;

import java.sql.SQLException;
import java.util.List;
import model.Clinic;

/**
 *
 * @author sonnt
 */
public class ClinicController {
    private static ClinicController instance = new ClinicController();
    
    private ClinicController(){}
    
    public static ClinicController getInstance() {
        return instance;
    }
    public List<Clinic> allClinic() throws SQLException{
        return Clinic.all();
    }
}
