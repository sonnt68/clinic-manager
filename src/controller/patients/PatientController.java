/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.patients;

import java.sql.SQLException;
import java.util.List;
import model.Patient;

/**
 *
 * @author sonnt
 */
public class PatientController {
    
    private static PatientController instance = new PatientController();
    
    private PatientController(){}
    
    public static PatientController getInstance() {
        return instance;
    }
    
    public Patient save(Patient patient) throws SQLException {
        if (patient != null) {
            patient.save();
        }
        return patient;
    }
    
    public List<Patient> allPatient() throws SQLException{
        return Patient.all();
    }
    public List<Patient> findByName(String name) throws SQLException{
        return Patient.findByName(name);
    }
}
