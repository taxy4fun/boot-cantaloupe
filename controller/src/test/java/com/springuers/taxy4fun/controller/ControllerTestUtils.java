package com.springuers.taxy4fun.controller;

import com.springuers.taxy4fun.CreateVehicleResponse;
import io.vavr.control.Try;

public class ControllerTestUtils {
    public static Vehicle newVehicle() {
        final Vehicle dto = new Vehicle();
        dto.setBrand("Mercedes Benz");
        dto.setPlate("JKL1234");
        dto.setDescription("Clase C");
        //dto.setPhoto("/media/" + UUID.randomUUID());
        return dto;
    }

    public static Try<CreateVehicleResponse> newCreateVehicleResponse() {
        return Try.success(new CreateVehicleResponse());
    }

}
