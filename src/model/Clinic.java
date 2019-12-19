/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.interfaces.ClinicDao;
import daoFactory.DaoFactory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sonnt
 */
public class Clinic {
    private Long id = null;
    private String name;
    private String room;
    private String type;
    private Examination examination;

    public Clinic(String name, String room, String type, Examination examination) {
        this.name = name;
        this.room = room;
        this.type = type;
        this.examination = examination;
    }
    
    public Clinic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    
    public String[] toArray(){
        return new String[] {
            this.id.toString(),
            this.name,
            this.room,
            this.type,
            this.examination.getStartTime(),
            this.examination.getEndTime(),
            this.examination.getDoctor().getDoctorName(),
            this.examination.getDoctor().getId().toString()
        };
    }
    public static List<Clinic> all() throws SQLException {
        return clinicDAO().all();
    }
    private static ClinicDao clinicDAO(){
        DaoFactory dao = DaoFactory.getDatabase();
        return dao.getClinicDao();
    }
}
