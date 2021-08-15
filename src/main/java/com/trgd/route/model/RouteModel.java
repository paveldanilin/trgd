package com.trgd.route.model;


import java.util.List;

public class RouteModel {
    private final Integer maxTermHours;
    private final String destinationAirportIcao;
    private final String destinationAirportName;

    private final List<FlightModel> departures;
    private final List<FlightModel> arrivals;

    public RouteModel(Integer maxTermHours, String destinationAirportIcao, String destinationAirportName, List<FlightModel> departures, List<FlightModel> arrivals) {
        this.maxTermHours = maxTermHours;
        this.destinationAirportIcao = destinationAirportIcao;
        this.destinationAirportName = destinationAirportName;
        this.departures = departures;
        this.arrivals = arrivals;
    }

    public Integer getMaxTermHours() {
        return this.maxTermHours;
    }

    public String getDestinationAirportIcao() {
        return destinationAirportIcao;
    }

    public String getDestinationAirportName() {
        return destinationAirportName;
    }

    public List<FlightModel> getDepartures() {
        return departures;
    }

    public List<FlightModel> getArrivals() {
        return arrivals;
    }
}
