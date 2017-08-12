package com.springuers.taxy4fun;

import io.vavr.control.Try;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DummyServiceTest {

    private final String EXCEPTION_MESSAGE = "service exception";
    private DummyService service;

    @Before
    public void setUp() {
        this.service = mock(DummyService.class);
    }

    @Test
    public void testOperationOne() {
        when(this.service.operationOne(any(OperationOneInDto.class)))
                .thenReturn(newSuccessOutDto());

        Try<OperationOneOutDto> outDto = this.service.operationOne(newInDto());

        Assert.assertFalse(outDto.isFailure());
        Assert.assertEquals(Long.valueOf(1L), outDto.get().getId());
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
        final OperationOneInDto dto = new OperationOneInDto(1L, "message");
        return dto;
    }

    private Try<OperationOneOutDto> newSuccessOutDto() {
        final OperationOneOutDto dto = new OperationOneOutDto(1L);
        return Try.of(() -> dto);
    }


}
