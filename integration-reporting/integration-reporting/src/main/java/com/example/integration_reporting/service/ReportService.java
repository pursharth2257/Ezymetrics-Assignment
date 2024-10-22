package com.example.integration_reporting.service;

import com.example.integration_reporting.model.Campaign;
import com.opencsv.CSVWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class ReportService {

    public byte[] generateCsvReport(List<Campaign> campaigns) throws IOException {
        StringWriter writer = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(writer);

        String[] header = { "ID", "Name", "Description", "Status" };
        csvWriter.writeNext(header);

        for (Campaign campaign : campaigns) {
            String[] data = { campaign.getId(), campaign.getName(), campaign.getDescription(), campaign.getStatus() };
            csvWriter.writeNext(data);
        }

        csvWriter.close();
        return writer.toString().getBytes();
    }

    public byte[] generatePdfReport(List<Campaign> campaigns) throws DocumentException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        for (Campaign campaign : campaigns) {
            document.add(new Paragraph("Campaign ID: " + campaign.getId()));
            document.add(new Paragraph("Name: " + campaign.getName()));
            document.add(new Paragraph("Description: " + campaign.getDescription()));
            document.add(new Paragraph("Status: " + campaign.getStatus()));
            document.add(new Paragraph("\n"));
        }

        document.close();
        return out.toByteArray();
    }
}
