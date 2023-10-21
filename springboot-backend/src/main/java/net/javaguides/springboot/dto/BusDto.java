package net.javaguides.springboot.dto;

import jakarta.persistence.Column;

import java.sql.Time;

public class BusDto {
    private String journeyFrom;
    private String journeyTo;
    private String doj;
    private String dor;
    private String busTypes;
    private String operator;
    private Time departureTime;
    private Time arriveTime;
    private Integer seatAvailable;
    private Integer fare;

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
