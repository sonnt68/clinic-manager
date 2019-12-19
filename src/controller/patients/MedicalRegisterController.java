/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.patients;

import java.sql.SQLException;
import java.util.List;
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
    
    public List<MedicalRegister> allMedicalRegister() throws SQLException{
        return MedicalRegister.all();
    }
    
    public MedicalRegister save(MedicalRegister medicalRegister) throws SQLException {
        if (medicalRegister != null) {
            medicalRegister.save();
        }
        return medicalRegister;
    }
}
