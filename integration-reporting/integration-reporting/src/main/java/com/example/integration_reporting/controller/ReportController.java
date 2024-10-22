package com.example.integration_reporting.controller;

import com.example.integration_reporting.service.ReportService;
import com.example.integration_reporting.model.Campaign;
import com.example.integration_reporting.repository.CampaignRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;
    private final CampaignRepository campaignRepository;

    public ReportController(ReportService reportService, CampaignRepository campaignRepository) {
        this.reportService = reportService;
        this.campaignRepository = campaignRepository;
    }

    @GetMapping("/csv")
    public ResponseEntity<byte[]> generateCsvReport() throws IOException {
        List<Campaign> campaigns = campaignRepository.findAll();
        byte[] csvData = reportService.generateCsvReport(campaigns);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=campaigns.csv");

        return new ResponseEntity<>(csvData, headers, HttpStatus.OK);
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generatePdfReport() throws Exception {
        List<Campaign> campaigns = campaignRepository.findAll();
        byte[] pdfData = reportService.generatePdfReport(campaigns);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=campaigns.pdf");

        return new ResponseEntity<>(pdfData, headers, HttpStatus.OK);
    }
}

