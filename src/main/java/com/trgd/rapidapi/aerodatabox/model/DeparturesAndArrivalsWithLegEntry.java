package com.trgd.rapidapi.aerodatabox.model;

public class DeparturesAndArrivalsWithLegEntry {
    private Departure departure;
    private Arrival arrival;
    private String number;
    private String status;
    private String codeShareStatus;
    private Boolean isCargo;
    private Aircraft aircraft;
    private Airline airline;

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodeShareStatus() {
        return codeShareStatus;
    }

    public void setCodeShareStatus(String codeShareStatus) {
        this.codeShareStatus = codeShareStatus;
    }

    public Boolean getCargo() {
        return isCargo;
    }

    public void setCargo(Boolean cargo) {
        isCargo = cargo;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
