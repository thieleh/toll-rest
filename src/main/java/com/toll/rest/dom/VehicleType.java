package com.toll.rest.dom;

public enum VehicleType {
    BUS("BUS", 1.59),
    BIKE("BIKE", 0.49),
    MOTORCYCLE("MOTORCYCLE", 1.0),
    TRUCK("TRUCK", 3.95),
    BEETLE("BEETLE", 2.11);

    private double price;
    private String type;

    private VehicleType(String type, double price) {
        this.price = price;
        this.type = type;
    }

    public VehicleType getVehicleType(VehicleType vehicleType) {
        return vehicleType;
    }

    public String getVehicle() {
        return "{ Vehicle: " + type + " | Price: " + price + " } ";
    }

    public double getPrice() {
        return price;
    }
}

