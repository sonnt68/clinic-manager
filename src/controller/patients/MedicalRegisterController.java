/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.patients;

import java.sql.SQLException;
import model.MedicalRegister;

/**
 *
 * @author sonnt
 */
public class MedicalRegisterController {
    private static MedicalRegisterController instance = new MedicalRegisterController();
    
    private MedicalRegisterController(){}
    
    public static MedicalRegisterController getInstance() {
        return instance;
    }
    
    public MedicalRegister save(MedicalRegister medicalRegister) throws SQLException {
        if (medicalRegister != null) {
            medicalRegister.save();
        }
        return medicalRegister;
    }
}
