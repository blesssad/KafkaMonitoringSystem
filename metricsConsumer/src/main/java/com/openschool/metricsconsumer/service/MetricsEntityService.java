package com.openschool.metricsconsumer.service;

import com.openschool.entity.Metric;
import com.openschool.metricsconsumer.entity.MetricEntity;
import com.openschool.metricsconsumer.entity.MetricNotExistException;
import com.openschool.metricsconsumer.repository.MetricsProducerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetricsEntityService {
    private final MetricsProducerRepository metricsProducerRepository;

    public MetricEntity getMetricById(int id){
        MetricEntity metricEntity = metricsProducerRepository.findById(id);

        if (metricEntity == null){
            log.info("Metric with id {} doesn't exist!", id);
            throw new MetricNotExistException("Metric with this id doesn't exist!");
        }
        else{
            log.info("Metric fetched successfully: {}", metricEntity);
            return metricEntity;
        }
    }

    public List<MetricEntity> getAllMetrics(){
        List<MetricEntity> metrics = metricsProducerRepository.findAll();
        log.info("Get all metrics, total count: {}", metrics.size());

        return metrics;
    }

    public void saveMetrics(List<Metric> metrics){
        metrics.forEach(metric -> {
            MetricEntity metricEntity = metricsProducerRepository.findByName(metric.getName());

            String name = metric.getName();
            String type = metric.getType();
            String description = metric.getDescription();
            double value = metric.getValue();
            long timestamp = metric.getTimestamp();

            if(metricEntity == null){
                metricsProducerRepository.save(new MetricEntity(name, type, description, value, timestamp));
            }
            else{
                metricEntity.setName(name);
                metricEntity.setType(type);
                metricEntity.setDescription(description);
                metricEntity.setValue(value);
                metricEntity.setTimestamp(timestamp);

                metricsProducerRepository.save(metricEntity);
                log.info("Metric saved successfully: {}", name);
            }
        });
    }
}
