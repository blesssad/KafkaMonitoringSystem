package com.openschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metric {
    private String name;
    private String type;
    private String description;
    private Double value;
    private Long timestamp;
}
