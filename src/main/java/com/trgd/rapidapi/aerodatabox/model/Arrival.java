package com.trgd.rapidapi.aerodatabox.model;

public class Arrival {
    private Airport airport;
    private String scheduledTimeLocal;
    private String actualTimeLocal;
    private String scheduledTimeUtc;
    private String actualTimeUtc;
    private String baggageBelt;
    private String terminal;
    private String number;

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public String getScheduledTimeLocal() {
        return scheduledTimeLocal;
    }

    public void setScheduledTimeLocal(String scheduledTimeLocal) {
        this.scheduledTimeLocal = scheduledTimeLocal;
    }

    public String getActualTimeLocal() {
        return actualTimeLocal;
    }

    public void setActualTimeLocal(String actualTimeLocal) {
        this.actualTimeLocal = actualTimeLocal;
    }

    public String getScheduledTimeUtc() {
        return scheduledTimeUtc;
    }

    public void setScheduledTimeUtc(String scheduledTimeUtc) {
        this.scheduledTimeUtc = scheduledTimeUtc;
    }

    public String getActualTimeUtc() {
        return actualTimeUtc;
    }

    public void setActualTimeUtc(String actualTimeUtc) {
        this.actualTimeUtc = actualTimeUtc;
    }

    public String getBaggageBelt() {
        return baggageBelt;
    }

    public void setBaggageBelt(String baggageBelt) {
        this.baggageBelt = baggageBelt;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
