package com.openschool.metricsconsumer.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MetricNotExistException extends RuntimeException {
    public MetricNotExistException(String message) {
        super(message);
    }

    public MetricNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public MetricNotExistException(Throwable cause) {
        super(cause);
    }
}
