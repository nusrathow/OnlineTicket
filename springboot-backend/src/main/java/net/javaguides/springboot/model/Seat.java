package net.javaguides.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {
    @Id
    private Long id;

    @JoinColumn(name = "busId")
    private Long busId;

    @JoinColumn(name = "ticketId")
    private Long ticketId;

    @Column(name = "seatNo")
    private String seatNo;

    @Column(name = "seatClass")
    private String seatClass;

    @Column(name = "fare")
    private Long fare;

    public Long getId() {return id;}
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTicketId() {
        return ticketId;
    }
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
    public String getSeatNo() {
        return seatNo;
    }
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    public String getSeatClass() {
        return seatClass;
    }
    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }
    public Long getFare() {
        return fare;
    }
    public void setFare(Long fare) {
        this.fare = fare;
    }
    public Long getBusId() {return busId;}
    public void setBusId(Long busId) {this.busId = busId;}
}
