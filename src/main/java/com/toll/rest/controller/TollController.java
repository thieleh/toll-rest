package com.toll.rest.controller;

import com.toll.rest.dom.VehicleType;
import com.toll.rest.service.TollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toll")
public class TollController {

    @Autowired
    private TollService tollService;

    @GetMapping(value = "/{vehicleType}", params = "cost")
    public String calculateToll(@PathVariable VehicleType vehicleType, @RequestParam Double cost, Integer axles) {
        return String.format("Change: %.2f", tollService.pay(vehicleType, cost, axles));
    }

    @GetMapping(value = "/prices")
    public List<String> prices() {
        return tollService.getPrices();
    }
}
