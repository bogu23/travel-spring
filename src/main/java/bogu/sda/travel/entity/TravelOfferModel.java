package bogu.sda.travel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offers")
public class TravelOfferModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    double pricePerNight;
    private String description;
    private String title;
    private String contactNumber;

    @ManyToOne
    private TravelDestinationModel destination;

    @ManyToMany
    private List<CustomerModel> customers = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public TravelDestinationModel getDestination() {
        return destination;
    }

    public void setDestination(TravelDestinationModel destination) {
        this.destination = destination;
    }

    public List<CustomerModel> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerModel> customers) {
        this.customers = customers;
    }
}
