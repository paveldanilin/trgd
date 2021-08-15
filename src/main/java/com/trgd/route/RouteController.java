package com.trgd.route;

import com.trgd.route.model.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class RouteController {

    private RouteService routeService;

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/api/v1/routes")
    public List<RouteModel> find(@Valid  @RequestBody FindRouteDTO findDTO) {
        return this.routeService.find(findDTO);
    }
}
