package model;

import java.util.Date;
import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Students {

    private int nregistratio;
    private String firstname;
    private String lastname;
    private Date dateofbirth;

    public Students() {
        // TODO Auto-generated constructor stub
    }

    public Students(int nregistratio, String firstname, String lastname, Date dateofbirth) {
        super();
        this.nregistratio = nregistratio;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
    }

    public int getNregistratio() {
        return nregistratio;
    }

    public void setNregistratio(int nregistratio) {
        this.nregistratio = nregistratio;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}
