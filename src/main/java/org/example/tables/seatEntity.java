package org.example.tables;


import jakarta.persistence.*;

@Entity
@Table(name = "useat")
public class seatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String seatNo;
    private String  available;
    private String busId;

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getBusId() {
        return busId;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }






   /* public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }*/
}
