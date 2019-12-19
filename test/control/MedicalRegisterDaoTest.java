/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.concrete.MysqlMedicalRegisterDao;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Clinic;
import model.MedicalRegister;
import model.Patient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sonnt
 */
public class MedicalRegisterDaoTest {
    static MysqlMedicalRegisterDao dao = new MysqlMedicalRegisterDao();
    public MedicalRegisterDaoTest() {
        MysqlMedicalRegisterDao dao = new MysqlMedicalRegisterDao();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllMedicalRegister() throws SQLException {
        ArrayList<MedicalRegister> list = new ArrayList<>();
        list = (ArrayList<MedicalRegister>) dao.all();
        assertEquals(list.size(), 6);
    }
    
    @Test
    public void testGetPatient() throws SQLException {
        long idPatien = dao.getPatient(1).getId();
        int idPatienInt = (int) idPatien;
        assertEquals(idPatienInt, 1);
        assertEquals(dao.getPatient(1).getName(), "Nguyễn Văn A");
        assertEquals(dao.getPatient(1234),null);
    }
    
    @Test
    public void testGetClinic() throws SQLException {
        long idClinic = dao.getClinic(1).getId();
        int idClinicInt = (int) idClinic;
        assertEquals(idClinicInt, 1);
        assertEquals(dao.getClinic(1).getName(), "Da Liễu");
        assertEquals(dao.getClinic(1).getRoom(), "202_c2");
        assertEquals(dao.getClinic(1).getType(), "Lâm sàng");
        assertEquals(dao.getClinic(1234),null);
    }
    
    @Test
    public void testInsertMedicalRegister() throws SQLException {
        MedicalRegister medical = new MedicalRegister();
        Clinic clinic = dao.getClinic(1);
        Patient patient = dao.getPatient(1);
        medical.setClinic(clinic);
        medical.setPatient(patient);
                
        assertEquals(dao.insert(medical), medical);
    }
}
