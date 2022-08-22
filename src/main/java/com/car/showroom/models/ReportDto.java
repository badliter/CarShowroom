package com.car.showroom.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {

    private LocalDate datePurchase;
    private BigDecimal cost;
    private String carModel;
    private Integer count;
    private String clientPhoneNumber;
    private String clientFio;
}
