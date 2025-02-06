package com.hibernate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="EMP")
public class Employee {
    private long EMPNO;
    private Ename ENAME;
    private String WORKDEPT;
    private long PHONENO;

    @Id
    public long getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(long EMPNO) {
        this.EMPNO = EMPNO;
    }

    public Ename getENAME() {
        return ENAME;
    }

    public void setENAME(Ename ENAME) {
        this.ENAME = ENAME;
    }

    public String getWORKDEPT() {
        return WORKDEPT;
    }

    public void setWORKDEPT(String WORKDEPT) {
        this.WORKDEPT = WORKDEPT;
    }

    public long getPHONENO() {
        return PHONENO;
    }

    public void setPHONENO(long PHONENO) {
        this.PHONENO = PHONENO;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EMPNO=" + EMPNO +
                ", ENAME=" + ENAME +
                ", WORKDEPT='" + WORKDEPT + '\'' +
                ", PHONENO=" + PHONENO +
                '}';
    }
}

