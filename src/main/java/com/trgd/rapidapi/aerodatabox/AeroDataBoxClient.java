package com.trgd.rapidapi.aerodatabox;

import com.trgd.rapidapi.RapidApiClient;
import com.trgd.rapidapi.aerodatabox.model.DeparturesAndArrivalsWithLeg;
import com.trgd.rapidapi.core.RapidApiResponse;
import com.trgd.rapidapi.core.RapidApiTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;

public class AeroDataBoxClient extends RapidApiClient {

    private final Logger logger = LoggerFactory.getLogger(AeroDataBoxClient.class);

    public AeroDataBoxClient(RapidApiTransport transport) {
        super("aerodatabox.p.rapidapi.com", transport);
    }

    public DeparturesAndArrivalsWithLeg getDeparturesAndArrivalsWithLegByAirportICAO(String icao, String fromLocal, String toLocal) throws IOException {

        this.logger.info("Entered getDeparturesAndArrivalsWithLegByAirportICAO({},{},{})", icao, fromLocal, toLocal);

        HashMap<String, String> pathParameters = new HashMap<>();
        pathParameters.put("icao", icao);
        pathParameters.put("fromLocal", fromLocal);
        pathParameters.put("toLocal", toLocal);

        RapidApiResponse response = this.getTransport().call(
                this.getRequestBuilder()
                        .path("/flights/airports/icao/{icao}/{fromLocal}/{toLocal}?withLeg=true")
                        .pathParameters(pathParameters)
                        .build()
        );

        this.logger.info(response.getRawResponse());

        return response.getFieldValue("$", DeparturesAndArrivalsWithLeg.class);
    }

}
