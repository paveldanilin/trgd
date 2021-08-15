package com.trgd;

import com.trgd.rapidapi.transport.okhttp.OkHttpTransportConfig;
import com.trgd.route.RouteService;
import com.trgd.route.RouteServiceImpl;
import com.trgd.rapidapi.aerodatabox.AeroDataBoxClient;
import com.trgd.rapidapi.transport.okhttp.OkHttpTransport;
import com.trgd.rapidapi.core.RapidApiTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouteService routeService(AeroDataBoxClient aeroDataBoxClient) {
        RouteServiceImpl routeService = new RouteServiceImpl();
        routeService.setAeroDataBoxClient(aeroDataBoxClient);
        return routeService;
    }

    @Bean
    public AeroDataBoxClient aeroDataBoxClient(RapidApiTransport rapidApiTransport) {
        return new AeroDataBoxClient(rapidApiTransport);
    }

    @Bean
    public RapidApiTransport rapidApiTransport(@Value("${rapid.api.key}") String rapidApiKey, @Value("${rapid.api.host}") String rapidApiHost) {
        OkHttpTransportConfig config = new OkHttpTransportConfig();
        config.setRapidApiKey(rapidApiKey);
        config.setRapidApiHost(rapidApiHost);
        return new OkHttpTransport(config);
    }
}
