package com.example.integration_reporting.service;

import com.example.integration_reporting.model.Lead;
import com.example.integration_reporting.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CRMService {
    private final LeadRepository leadRepository;

    public CRMService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public List<Lead> fetchLeads() {
        Lead lead1 = new Lead();
        lead1.setId(UUID.randomUUID().toString());
        lead1.setName("John Doe");
        lead1.setEmail("john@example.com");
        lead1.setSource("CRM");

        Lead lead2 = new Lead();
        lead2.setId(UUID.randomUUID().toString());
        lead2.setName("Jane Smith");
        lead2.setEmail("jane@example.com");
        lead2.setSource("CRM");

        leadRepository.save(lead1);
        leadRepository.save(lead2);

        return leadRepository.findAll();
    }
}