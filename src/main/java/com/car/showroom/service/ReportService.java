package com.car.showroom.service;

import com.car.showroom.models.ReportDto;
import com.car.showroom.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public BigDecimal getRevenue(LocalDate fromDate, LocalDate toDate) {
        return reportRepository.getRevenueFromDateToDate(fromDate, toDate);
    }

    public List<ReportDto> getAllReports() {
        return reportRepository.findAll().stream()
                .map(entity -> ReportDto.builder()
                        .datePurchase(entity.getDatePurchase())
                        .clientPhoneNumber(entity.getClient().getPhoneNumber())
                        .clientFio(entity.getClient().getFio())
                        .carModel(entity.getCarModel().getName())
                        .cost(entity.getCost())
                        .count(entity.getCount())
                        .build())
                .sorted(getComparatorReportDto())
                .collect(Collectors.toList());
    }

    private Comparator<ReportDto> getComparatorReportDto() {
        return (r1, r2) -> {
            if (r1.getDatePurchase().isAfter(r2.getDatePurchase())) {
                return 1;
            } else if (r1.getDatePurchase().isBefore(r2.getDatePurchase())) {
                return -1;
            } else if (r1.getClientFio().compareTo(r2.getClientFio()) != 0) {
                return r1.getClientFio().compareTo(r2.getClientFio());
            }

            return r1.getCost().compareTo(r2.getCost());
        };
    }
}
