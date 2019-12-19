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
import java.util.List;

/**
 *
 * @author sonnt
 */
public class MedicalRegister {
    private Long id = null;
    private Patient patient;
    private Clinic clinic;

    public MedicalRegister() {
    }
    
    public MedicalRegister(Patient patient, Clinic clinic) {
        this.patient = patient;
        this.clinic = clinic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
    
    public String[] toArray(){
        return new String[] {
            this.patient.getName(),
            this.patient.getAge(),
            this.patient.getPhone(),
            this.patient.getAddress(),
            this.clinic.getName(),
            this.clinic.getRoom(),
            this.clinic.getType()
        };
    }

    public static List<MedicalRegister> all() throws SQLException {
        return medicalRegisterDAO().all();
    }
    public void save() throws SQLException{
        medicalRegisterDAO().insert(this);
    }
    private static MedicalRegisterDao medicalRegisterDAO(){
        DaoFactory dao = DaoFactory.getDatabase();
        return dao.getMedicalRegisterDao();
    }
}
