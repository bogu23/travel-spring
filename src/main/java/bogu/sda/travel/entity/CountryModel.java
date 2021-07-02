package bogu.sda.travel.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class CountryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private ContinentModel continent;

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

    public ContinentModel getContinent() {
        return continent;
    }

    public void setContinent(ContinentModel continent) {
        this.continent = continent;
    }
}
