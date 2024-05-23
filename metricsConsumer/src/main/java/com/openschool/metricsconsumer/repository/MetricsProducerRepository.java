package com.openschool.metricsconsumer.repository;

import com.openschool.metricsconsumer.entity.MetricEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetricsProducerRepository extends JpaRepository<MetricEntity, Integer> {
    MetricEntity findById(int id);
    MetricEntity findByName(String name);
    boolean existsByName(String name);


}
