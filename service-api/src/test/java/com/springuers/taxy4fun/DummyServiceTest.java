package com.springuers.taxy4fun;

import io.vavr.control.Try;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Failure;
import static io.vavr.Patterns.$Success;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DummyServiceTest {

    public static final long RESOURCE_ID = 1L;
    private final String EXCEPTION_MESSAGE = "service exception";
    private DummyService service;
    private VehicleService vehicleService;

    @Before
    public void setUp() {
        this.service = mock(DummyService.class);
        this.vehicleService = mock(VehicleService.class);
    }

    @Test
    public void testOperationOne() {
        when(this.service.operationOne(any(OperationOneInDto.class)))
                .thenReturn(newSuccessOutDto());

        Try<OperationOneOutDto> outDto = this.service.operationOne(newInDto());

        Assert.assertFalse(outDto.isFailure());
        Assert.assertEquals(Long.valueOf(RESOURCE_ID), outDto.get().getId());
    }

    @Test
    public void testOperationOneServiceException() {
        when(this.service.operationOne(any(OperationOneInDto.class)))
                .thenReturn(newFailureOutDto());

        Try<OperationOneOutDto> outDto = this.service.operationOne(newInDto());

        Assert.assertTrue(outDto.isFailure());
        Assert.assertEquals(ServiceException.class, outDto.getCause().getClass());
        Assert.assertEquals(EXCEPTION_MESSAGE, outDto.getCause().getMessage());
    }

    private Try<OperationOneOutDto> newFailureOutDto() {
        return Try.failure(new ServiceException(EXCEPTION_MESSAGE));
    }

    private OperationOneInDto newInDto() {
        final OperationOneInDto dto = new OperationOneInDto(RESOURCE_ID, "message");
        return dto;
    }

    private Try<OperationOneOutDto> newSuccessOutDto() {
        final OperationOneOutDto dto = new OperationOneOutDto(RESOURCE_ID);
        return Try.of(() -> dto);
    }


    @Test
    public void testTryOk() {
        when(this.service.operationOne(1)).thenReturn(Try.success("message"));
        when(this.service.operationTwo(anyString())).thenReturn(Try.success(2L));
        when(this.service.operationThree(anyLong())).thenReturn(Try.success(true));

        Try<Boolean> booleanTry = this.service.operationOne(1)
                .flatMap(s -> this.service.operationTwo(s))
                .flatMap(l -> this.service.operationThree(l));

        System.out.println("result: " + getResult(booleanTry));
    }

    @Test
    public void testTryKo() {
        when(this.service.operationOne(1)).thenReturn(Try.success("message"));
        when(this.service.operationTwo(anyString())).thenReturn(Try.failure(new RuntimeException("error")));
        when(this.service.operationThree(anyLong())).thenReturn(Try.success(true));

        Try<Boolean> booleanTry = this.service.operationOne(1)
                .flatMap(s -> this.service.operationTwo(s))
                .flatMap(l -> this.service.operationThree(l));

        System.out.println("result: " + getResult(booleanTry));
    }

    private String getResult(final Try<Boolean> booleanTry) {
        return Match(booleanTry).of(
                Case($Success($()), b -> b.toString()),
                Case($Failure($()), f -> f.getMessage())
        );
    }

}
