package com.hibernate;

import jakarta.persistence.Embeddable;

@Embeddable
public class Ename {
    private String FNAME;
    private String LNAME;
    private String MNAME;

    public String getFNAME() {
        return FNAME;
    }

    public void setFNAME(String FNAME) {
        this.FNAME = FNAME;
    }

    public String getLNAME() {
        return LNAME;
    }

    public void setLNAME(String LNAME) {
        this.LNAME = LNAME;
    }

    public String getMNAME() {
        return MNAME;
    }

    public void setMNAME(String MNAME) {
        this.MNAME = MNAME;
    }

    @Override
    public String toString() {
        return "Ename{" +
                "FNAME='" + FNAME + '\'' +
                ", LNAME='" + LNAME + '\'' +
                ", MNAME='" + MNAME + '\'' +
                '}';
    }
}
