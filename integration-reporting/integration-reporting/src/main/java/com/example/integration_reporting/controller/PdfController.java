package com.example.integration_reporting.controller;

import com.example.integration_reporting.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/generate-report")
    @ResponseBody
    public void generateReport(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=report.pdf");
        byte[] report = pdfService.generateReport();
        response.getOutputStream().write(report);
        response.getOutputStream().flush();
    }
}
