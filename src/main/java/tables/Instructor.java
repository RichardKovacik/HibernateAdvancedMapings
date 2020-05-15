package tables;

import javax.persistence.*;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adressId")
    private Adress adressId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Adress getAdressId() {
        return adressId;
    }

    public void setAdressId(Adress adressId) {
        this.adressId = adressId;
    }

    public Instructor() {
    }

    public Instructor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", adressId=" + adressId +
                '}';
    }
}
