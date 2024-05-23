package com.openschool.metricproducer.conroller;

import com.openschool.entity.Metric;
import com.openschool.metricproducer.service.PostMetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/send")
public class MetricsProducerController {
    private final PostMetricsService metricsProducerService;

    @PostMapping("/metrics")
    public ResponseEntity<String> sendMetrics() {
        metricsProducerService.sendMetrics();
        return ResponseEntity.ok("Send metrics");
    }
}
