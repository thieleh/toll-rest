package com.toll.rest.service;

import com.toll.rest.dom.VehicleType;
import com.toll.rest.exceptions.TollException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TollService {


    public Double pay(VehicleType vehicleType, Double cost, Integer axles) {
        if (vehicleType == null || cost == null || axles == null) {
            throw new TollException("Null values are not accepted.");
        } else if (vehicleType.equals(VehicleType.TRUCK) && axles <= 0) {
            throw new TollException("Please inform the quantities of axles.");
        } else if (cost < 0) {
            throw new TollException("The payment must not be negative");
        } else if (axles < 0) {
            throw new TollException("You can't have less then 0 axles.");
        }

        VehicleType vehicle = vehicleType.getVehicleType(vehicleType);

        double price;
        if (vehicleType.equals(VehicleType.TRUCK)) {
            price = axles * vehicleType.getPrice() / 2;
        } else {
            price = vehicle.getPrice();
        }
        if (cost < price) {
            throw new TollException("Please pay the right amount. You owe: " + (price - cost));
        }
        return cost - price;
    }

    public List<String> getPrices() {
        List<String> prices = new ArrayList<>();
        prices.add(VehicleType.BUS.getVehicle());
        prices.add(VehicleType.MOTORCYCLE.getVehicle());
        prices.add(VehicleType.BIKE.getVehicle());
        prices.add(VehicleType.TRUCK.getVehicle());
        prices.add(VehicleType.BEETLE.getVehicle());

        return prices;
    }
}
