package com.car.showroom.controller;

import com.car.showroom.models.ReportDto;
import com.car.showroom.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/revenue")
    public ResponseEntity<BigDecimal> getRevenue(@RequestParam(value = "fromDate")
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                             LocalDate fromDate,
                                                 @RequestParam(value = "toDate")
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                         LocalDate toDate) {
        return ResponseEntity.ok(reportService.getRevenue(fromDate, toDate));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReportDto>> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }
}
