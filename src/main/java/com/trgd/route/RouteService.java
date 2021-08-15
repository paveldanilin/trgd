package com.trgd.route;

import com.trgd.route.model.RouteModel;

import java.util.List;

public interface RouteService {
    List<RouteModel> find(FindRouteDTO findDTO);
}
