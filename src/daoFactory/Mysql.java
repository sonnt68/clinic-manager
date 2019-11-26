/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoFactory;

import dao.concrete.MysqlClinicDao;
import dao.concrete.MysqlMedicalRegisterDao;
import dao.concrete.MysqlPatientDao;
import dao.interfaces.ClinicDao;
import dao.interfaces.MedicalRegisterDao;
import dao.interfaces.PatientDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author sonnt
 */
public class Mysql extends DaoFactory {
    private static String url = "jdbc:mysql://127.0.0.1:3306/";
    private static String database = "hospital";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String user = "root";
    private static String password = "";
    
    public Connection openConnection() {
        try {
            Class.forName(driver).newInstance();
            Connection connection = DriverManager.getConnection(
                url + database + "?useUnicode=true&characterEncoding=UTF-8",
                user, 
                password
            );
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex){
            System.err.println(
                    "Connect database fail!");
        }
        return null;
    }

    @Override
    public PatientDao getPatientDao() {
        return new MysqlPatientDao();
    }

    @Override
    public ClinicDao getClinicDao() {
        return new MysqlClinicDao();
    }

    @Override
    public MedicalRegisterDao getMedicalRegisterDao() {
        return new MysqlMedicalRegisterDao();
    }

}
