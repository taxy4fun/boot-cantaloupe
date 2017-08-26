package com.springuers.taxy4fun.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springuers.taxy4fun.CreateVehicleResponse;
import io.vavr.control.Try;

import java.io.IOException;

public class TestUtils {
    public static String convertObjectToJsonString(final Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(object);
    }

    public static Try<CreateVehicleResponse> newCreateVehicleResponse() {

        return Try.of(() -> new CreateVehicleResponse());
    }
}
