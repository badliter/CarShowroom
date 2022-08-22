package com.car.showroom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientEntity {

    @Id
    private UUID id;
    private String fio;
    @JoinColumn(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<ReportEntity> reports;
}
