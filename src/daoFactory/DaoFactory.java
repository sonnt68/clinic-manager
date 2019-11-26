/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoFactory;

import dao.interfaces.ClinicDao;
import dao.interfaces.MedicalRegisterDao;
import java.sql.Connection;

import dao.interfaces.PatientDao;
/**
 *
 * @author sonnt
 */
public abstract class DaoFactory {

  /* 
   * There will be a method for each DAO that can be
   * created. The concrete factories will have to
   * implement these methods.
   */
  public abstract Connection openConnection();	
  public abstract PatientDao getPatientDao();
  public abstract ClinicDao getClinicDao();
  public abstract MedicalRegisterDao getMedicalRegisterDao();
  
  public static DaoFactory getDatabase() {
      return new Mysql();
  }
}

