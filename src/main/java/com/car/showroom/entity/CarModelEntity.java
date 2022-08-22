package com.car.showroom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "car_models")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarModelEntity {
    @Id
    private UUID id;
    private String name;

    @OneToMany(mappedBy = "carModel", fetch = FetchType.LAZY)
    private Set<ReportEntity> reports;
}
