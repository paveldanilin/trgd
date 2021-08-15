package com.trgd.rapidapi.aerodatabox.model;

import java.util.List;

public class DeparturesAndArrivalsWithLeg {
    private List<DeparturesAndArrivalsWithLegEntry> departures;
    private List<DeparturesAndArrivalsWithLegEntry> arrivals;

    public List<DeparturesAndArrivalsWithLegEntry> getDepartures() {
        return departures;
    }

    public void setDepartures(List<DeparturesAndArrivalsWithLegEntry> departures) {
        this.departures = departures;
    }

    public List<DeparturesAndArrivalsWithLegEntry> getArrivals() {
        return arrivals;
    }

    public void setArrivals(List<DeparturesAndArrivalsWithLegEntry> arrivals) {
        this.arrivals = arrivals;
    }
}
