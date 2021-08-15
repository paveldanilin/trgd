package com.trgd.route.model;

public class FlightModel {
    private final String timeDeparture;
    private final String timeArrival;
    private final String flightNumber;
    private final String airlineName;
    private final String aircraftModel;

    public FlightModel(String timeDeparture, String timeArrival, String flightNumber, String airlineName, String aircraftModel) {
        this.timeDeparture = timeDeparture;
        this.timeArrival = timeArrival;
        this.flightNumber = flightNumber;
        this.airlineName = airlineName;
        this.aircraftModel = aircraftModel;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }
}
