package web.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String eMail;

    public User(){

    }

    public User(String name, String lastName, String eMail) {
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
    }

    public User(Long id, String name, String lastName, String eMail) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
    }

    public void setId(Long id) {
        this.id = id;
    }
//
    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
