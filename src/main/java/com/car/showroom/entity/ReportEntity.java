package com.car.showroom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "reports")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportEntity {
    @Id
    private UUID id;

    private LocalDate datePurchase;
    private Integer count;
    private BigDecimal cost;

    @JoinColumn(name = "model_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CarModelEntity carModel;

    @JoinColumn(name = "client_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientEntity client;
}
