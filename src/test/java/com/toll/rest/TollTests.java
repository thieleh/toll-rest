package com.toll.rest;

import com.toll.rest.dom.VehicleType;
import com.toll.rest.exceptions.TollException;
import com.toll.rest.service.TollService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TollService.class })
public class TollTests {

    @Autowired
    private TollService tollService;

    @Test
    public void shouldPay() {
        assertEquals(0, tollService.pay(VehicleType.BIKE, 0.49, 0), 0.0);
        assertEquals(0, tollService.pay(VehicleType.BEETLE, 2.11, 0), 0.0);
        assertEquals(0, tollService.pay(VehicleType.BUS, 1.59, 0), 0.0);
        assertEquals(0, tollService.pay(VehicleType.MOTORCYCLE, 1.00, 0), 0.0);
    }

    @Test
    public void shouldGiveChange(){
        assertEquals(3.05, tollService.pay(VehicleType.TRUCK, 10.0, 2), 0);
    }

    @Test(expected = TollException.class)
    public void shoultNotAcceptTruckWithouthAxles(){
        tollService.pay(VehicleType.TRUCK, 3.95, null);
    }

    @Test(expected = TollException.class)
    public void shouldNotAcceptBikeWithAxles(){
        tollService.pay(VehicleType.BIKE, 0.49, 2);
    }

    @Test(expected = TollException.class)
    public void notRightAmount(){
        tollService.pay(VehicleType.BUS, 1.0, 0);
    }

    @Test (expected = TollException.class)
    public void negativeCost(){
        tollService.pay(VehicleType.BUS, -3.0, 0);
    }

    @Test (expected = TollException.class)
    public void vehicleNull(){
        tollService.pay(null, 2.0, 0);
    }

    @Test (expected = TollException.class)
    public void negativeAxles(){
        tollService.pay(VehicleType.TRUCK, 5.0, -1);
    }
}
