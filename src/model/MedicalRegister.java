/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.interfaces.MedicalRegisterDao;
import dao.interfaces.PatientDao;
import daoFactory.DaoFactory;
import java.sql.SQLException;

/**
 *
 * @author sonnt
 */
public class MedicalRegister {
    private Long id = null;
    private Long idPatient;
    private Long idClinic;

    public MedicalRegister(Long idPatient, Long idClinic) {
        this.idPatient = idPatient;
        this.idClinic = idClinic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public Long getIdClinic() {
        return idClinic;
    }

    public void setIdClinic(Long idClinic) {
        this.idClinic = idClinic;
    }
    
    public void save() throws SQLException{
        medicalRegisterDAO().insert(this);
    }
    private static MedicalRegisterDao medicalRegisterDAO(){
        DaoFactory dao = DaoFactory.getDatabase();
        return dao.getMedicalRegisterDao();
    }
}
