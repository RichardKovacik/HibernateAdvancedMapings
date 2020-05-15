package tables;

import javax.persistence.*;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String country;
    @Column
    private  String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Adress() {
    }

    public Adress(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
