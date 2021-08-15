package com.trgd.rapidapi.aerodatabox.model;

public class Departure {
    private String scheduledTimeLocal;
    private String actualTimeLocal;
    private String scheduledTimeUtc;
    private String actualTimeUtc;
    private String terminal;
    private String checkInDate;
    private String gate;

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

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }
}
