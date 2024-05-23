package com.openschool.metricproducer.service;

import com.openschool.entity.Metric;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostMetricsService {
    @Value("${app.kafka.kafkaMessageTopic}")
    private String topicName;

    private final MeterRegistry meterRegistry;
    private final KafkaTemplate<String, List<Metric>> kafkaTemplate;

    public void sendMetrics() {
        kafkaTemplate.send(topicName, collectAllMetrics());
    }

    public List<Metric> collectAllMetrics() {
        List<Metric> metrics = new ArrayList<>();

        meterRegistry.getMeters().forEach(meter ->
                meter.measure().forEach(measurement -> {
                    String metricName = meter.getId().getName();
                    String metricDescription = meter.getId().getDescription();
                    String metricType = meter.getId().getType().name();
                    double value = measurement.getValue();

                    Metric metric = new Metric(metricName, metricType, metricDescription, value, System.currentTimeMillis());
                    log.info("Metric created successfully: {}", metricName);

                    metrics.add(metric);
                })
        );

        return metrics;
    }
}
