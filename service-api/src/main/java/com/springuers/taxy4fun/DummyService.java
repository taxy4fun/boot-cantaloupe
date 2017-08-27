package com.springuers.taxy4fun;

import io.vavr.control.Try;
import org.springframework.stereotype.Service;

/**
 * @author springuers
 */
@Service
public interface DummyService {
    Try<OperationOneOutDto> operationOne(OperationOneInDto inDto);

    Try<CreateVehicleResponse> create(CreateVehicleRequest request);

    Try<String> operationOne(Integer i);

    Try<Long> operationTwo(String s);

    Try<Boolean> operationThree(Long l);

    Try<Void> operationFour(Integer i);

}
