package com.benhlal.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnomalyCheckResponse {

    private Integer id;
    private String title;
    private String description;
    private String creator;
    private LocalDate creationDate;
}
