package com.example.integration_reporting.controller;

import com.example.integration_reporting.model.Lead;
import com.example.integration_reporting.model.Campaign;
import com.example.integration_reporting.service.CRMService;
import com.example.integration_reporting.service.MarketingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IntegrationController {

    private final CRMService crmService;
    private final MarketingService marketingService;

    public IntegrationController(CRMService crmService, MarketingService marketingService) {
        this.crmService = crmService;
        this.marketingService = marketingService;
    }

    @GetMapping("/fetchLeads")
    public List<Lead> fetchLeads() {
        return crmService.fetchLeads();
    }

    @GetMapping("/fetchCampaigns")
    public List<Campaign> fetchCampaigns() {
        return marketingService.fetchCampaigns();
    }
}