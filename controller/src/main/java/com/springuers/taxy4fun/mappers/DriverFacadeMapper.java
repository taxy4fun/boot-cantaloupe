package com.springuers.taxy4fun.mappers;

import com.springuers.taxy4fun.dtos.Driver;
import com.springuers.taxy4fun.dtos.DriverCreateRequest;

/**
 * Created by manuelmola on 31/08/17.
 */
public class DriverFacadeMapper {


    public Driver createRequestToDriver(final DriverCreateRequest driverCreateRequest) {
        Driver driver = new Driver("");
        return driver;
    }
}
