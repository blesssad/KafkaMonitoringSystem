package com.openschool.metricsconsumer.controller;

import com.openschool.metricsconsumer.entity.ExceptionDto;
import com.openschool.metricsconsumer.entity.MetricNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MetricNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handleException(MetricNotExistException e){
        return new ExceptionDto(e.getMessage());
    }
}
