package com.trgd.route;


import com.trgd.rapidapi.aerodatabox.AeroDataBoxClient;
import com.trgd.rapidapi.aerodatabox.model.Departure;
import com.trgd.rapidapi.aerodatabox.model.DeparturesAndArrivalsWithLeg;
import com.trgd.route.model.RouteModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RouteServiceImpl implements RouteService {

    private final Logger logger = LoggerFactory.getLogger(RouteServiceImpl.class);
    private AeroDataBoxClient aeroDataBoxClient;

    public void setAeroDataBoxClient(AeroDataBoxClient aeroDataBoxClient) {
        this.aeroDataBoxClient = aeroDataBoxClient;
    }

    @Override
    public List<RouteModel> find(FindRouteDTO findDTO) {
        this.logger.info(
                "Entered find({},{},{},{})",
                findDTO.getBaseAirport(),
                findDTO.getDepartureDatetime(),
                findDTO.getReturnDatetime(),
                findDTO.getTermHours()
        );

        try {
            DeparturesAndArrivalsWithLeg data = this.aeroDataBoxClient
                    .getDeparturesAndArrivalsWithLegByAirportICAO(
                            findDTO.getBaseAirport(),
                            findDTO.getDepartureDatetime(),
                            findDTO.getReturnDatetime()
                    );


            List<String> toAirports = data.getDepartures()
                    .stream()
                    .map(entry -> entry.getArrival().getAirport().getName())
                    .distinct()
                    .collect(Collectors.toList());

            logger.info("Result {}", toAirports);

        } catch (IOException ioException) {
            this.logger.error(ioException.getMessage(), ioException);
        }

        return new ArrayList<>();
    }
}