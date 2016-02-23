package model;

import java.util.Date;
import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Teachers {

    private int idteacher;
    private String firstname;
    private String lastname;
    private Date dateofbirth;

    public Teachers() {
        // TODO Auto-generated constructor stub
    }

    public Teachers(int idteacher, String firstname, String lastname, Date dateofbirth) {
        super();
        this.idteacher = idteacher;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
    }

    public int getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(int idteacher) {
        this.idteacher = idteacher;
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
