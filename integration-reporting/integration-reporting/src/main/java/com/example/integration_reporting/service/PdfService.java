package com.example.integration_reporting.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public byte[] generateReport() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(new Paragraph("Hello, this is a test PDF report!"));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
            return new byte[0];
        }

        return outputStream.toByteArray();
    }
}