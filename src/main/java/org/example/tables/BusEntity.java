package org.example.tables;


import jakarta.persistence.*;

// the user data are stored in the database using this entity

@Entity
@Table(name = "busdetail")
public class BusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fromPlace;
    private String toPlace;
    private String busNO;
    private String price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusNO() {
        return busNO;
    }

    public void setBusNO(String busNO) {
        this.busNO = busNO;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }
}
