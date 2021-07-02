package bogu.sda.travel.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String lastName;

    @ManyToMany(mappedBy = "customers")
    private List<TravelOfferModel> reservation;

    public List<TravelOfferModel> getReservation() {
        return reservation;
    }

    public void setReservation(List<TravelOfferModel> reservation) {
        this.reservation = reservation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
