package com.springuers.taxy4fun;

import io.vavr.control.Try;
import org.springframework.stereotype.Service;

/**
 * @author springuers
 */
@Service
public interface VehicleService {
    Boolean exists(ExistsVehicleRequest request);

    Try<CreateVehicleResponse> create(CreateVehicleRequest request);
}
