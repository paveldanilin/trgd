package com.trgd.route;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FindRouteDTO {
    @NotBlank(message = "The ICAO code of the base airport")
    @Length(min = 4, max = 4)
    private String baseAirport;

    @NotBlank(message = "Date time")
    private String departureDatetime;

    @NotBlank(message = "Date time")
    private String returnDatetime;

    @Min(value = 1)
    @Max(value = 120)
    private Integer termHours;

    public void setBaseAirport(String baseAirport) {
        this.baseAirport = baseAirport;
    }

    public String getBaseAirport() {
        return this.baseAirport;
    }

    public void setDepartureDatetime(String departureDatetime) {
        this.departureDatetime = departureDatetime;
    }

    public String getDepartureDatetime() {
        return this.departureDatetime;
    }

    public void setReturnDatetime(String returnDatetime) {
        this.returnDatetime = returnDatetime;
    }

    public String getReturnDatetime() {
        return this.returnDatetime;
    }

    public void setTermHours(Integer termHours) {
        this.termHours = termHours;
    }

    public Integer getTermHours() {
        return this.termHours;
    }
}
