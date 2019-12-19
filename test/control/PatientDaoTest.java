/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.concrete.MysqlPatientDao;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class PatientDaoTest {
    static MysqlPatientDao dao = new MysqlPatientDao();
    public PatientDaoTest() {
        MysqlPatientDao dao = new MysqlPatientDao();
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
    public void testGetAllPatient() throws SQLException {
        ArrayList<Patient> list = new ArrayList<>();
        list = (ArrayList<Patient>) dao.all();
        assertEquals(list.size(), 7);
    }
    
    @Test
    public void testFindByName() throws SQLException {
        ArrayList<Patient> list = new ArrayList<>();
        list = (ArrayList<Patient>) dao.findByName("son");
        assertEquals(list.size(), 2);
    }
    
    @Test
    public void testInsertPatient() throws SQLException {
        
        Patient patient = new Patient();
        patient.setName("Nguyễn Quang Minh");
        patient.setAge("24");
        patient.setPhone("0940538");
        patient.setAddress("Ha Noi");
        
        assertEquals(dao.insert(patient), patient);
    }
}
