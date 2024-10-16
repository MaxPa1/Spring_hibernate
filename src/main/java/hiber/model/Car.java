package hiber.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name= "series")
    private String series;

    public Car() {}

    public Car(String model, String series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public String getSeries() { return series; }

    public void setSeries(String series) { this.series = series; }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series='" + series + '\'' +
                '}';
    }
}
