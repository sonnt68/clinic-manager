/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.concrete.MysqlClinicDao;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Clinic;
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
public class ClinicDaoTest {
    static MysqlClinicDao dao = new MysqlClinicDao();
    public ClinicDaoTest() {
        MysqlClinicDao dao = new MysqlClinicDao();
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
    public void testGetAllClinic() throws SQLException {
        ArrayList<Clinic> list = new ArrayList<>();
        list = (ArrayList<Clinic>) dao.all();
        assertEquals(list.size(), 6);
    }
    
    @Test
    public void testGetExamination() throws SQLException {
        long idExamination = dao.getExamination(1).getId();
        int idExaminationInt = (int) idExamination;
        assertEquals(idExaminationInt, 1);
        assertEquals(dao.getExamination(1).getDoctor().getDoctorName(), "Nguyễn Đức Quang");
        assertEquals(dao.getExamination(1234),null);
    }
    
    @Test
    public void testGetDoctor() throws SQLException {
        long idDoctor = dao.getDoctor(1).getId();
        int idDoctorInt = (int) idDoctor;
        assertEquals(idDoctorInt, 1);
        assertEquals(dao.getDoctor(1).getDoctorName(), "Nguyễn Đức Quang");
        assertEquals(dao.getDoctor(1234),null);
    }
    
}
