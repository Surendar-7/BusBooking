package org.example.tables;


import jakarta.persistence.*;

@Entity
@Table(name = "places")
public class BusDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fromlocation;
    private String tolocation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFromlocation() {
        return fromlocation;
    }

    public void setFromlocation(String fromlocation) {
        this.fromlocation = fromlocation;
    }

    public String getTolocation() {
        return tolocation;
    }

    public void setTolocation(String tolocation) {
        this.tolocation = tolocation;
    }



}
