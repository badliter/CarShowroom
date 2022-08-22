package com.car.showroom.repository;

import com.car.showroom.entity.CarModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarModelRepository extends JpaRepository<CarModelEntity, UUID> {
}
