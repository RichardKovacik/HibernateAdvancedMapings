package tables;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private Adress adress;
    @OneToMany(mappedBy = "instructor",
    cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Course> courses;

    public void add(Course course){
        if (courses==null){
            courses= new ArrayList<>();
        }
        courses.add(course);
        course.setInstructor(this);

    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

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
        return adress;
    }

    public void setAdressId(Adress adressId) {
        this.adress = adressId;
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
                ", adressId=" + adress +
                '}';
    }
}
