package com.car.showroom.repository;

import com.car.showroom.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, UUID> {

    @Query(" select sum(r.cost) "
            + "from ReportEntity r "
            + "where r.datePurchase >= :fromDate and r.datePurchase <= :toDate ")
    BigDecimal getRevenueFromDateToDate(@Param("fromDate") LocalDate fromDate,
                                        @Param("toDate") LocalDate toDate);
}
