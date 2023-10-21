package net.javaguides.springboot.model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "journey_from")
    private String journeyFrom;

    @Column(name = "journey_to")
    private String journeyTo;

    @Column(name = "date_of_journey")
    private String doj;

    @Column(name = "date_of-return")
    private String dor;

    @Column(name = "bus_type")
    private String busTypes;

    @Column(name = "operator")
    private String operator;

    @Column(name = "departure_time")
    private Time departureTime;

    @Column(name = "arrive_time")
    private Time arriveTime;

    @Column(name = "seats_available")
    private Integer seatAvailable;

    @Column(name = "fare")
    private Integer fare;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJourneyFrom() {
        return journeyFrom;
    }

    public void setJourneyFrom(String journeyFrom) {
        this.journeyFrom = journeyFrom;
    }

    public String getJourneyTo() {
        return journeyTo;
    }

    public void setJourneyTo(String journeyTo) {
        this.journeyTo = journeyTo;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public String getBusTypes() {
        return busTypes;
    }

    public void setBusTypes(String busTypes) {
        this.busTypes = busTypes;
    }


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Integer getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(Integer seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
    }
}
