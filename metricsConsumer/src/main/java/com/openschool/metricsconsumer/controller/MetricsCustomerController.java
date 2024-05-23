package com.openschool.metricsconsumer.controller;

import com.openschool.metricsconsumer.entity.MetricEntity;
import com.openschool.metricsconsumer.service.MetricsEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/get")
public class MetricsCustomerController {
    private final MetricsEntityService metricsService;

    @GetMapping("/metrics/{id}")
    public ResponseEntity<MetricEntity> getById(@PathVariable int id) {
        MetricEntity metric = metricsService.getMetricById(id);

        return ResponseEntity.ok(metric);
    }

    @GetMapping("/metrics")
    public ResponseEntity<List<MetricEntity>> getAllMetrics() {
        List<MetricEntity> metrics = metricsService.getAllMetrics();

        return ResponseEntity.ok(metrics);
    }
}
