package com.example.integration_reporting.service;

import com.example.integration_reporting.model.Campaign;
import com.example.integration_reporting.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MarketingService {

    private final CampaignRepository campaignRepository;
    private final EmailService emailService;

    public MarketingService(CampaignRepository campaignRepository, EmailService emailService) {
        this.campaignRepository = campaignRepository;
        this.emailService = emailService;
    }

    public List<Campaign> fetchCampaigns() {
        // Sample campaigns
        Campaign campaign1 = new Campaign();
        campaign1.setId(UUID.randomUUID().toString());
        campaign1.setName("Spring Promotion");
        campaign1.setDescription("Marketing campaign for spring sales");
        campaign1.setStatus("Active");

        Campaign campaign2 = new Campaign();
        campaign2.setId(UUID.randomUUID().toString());
        campaign2.setName("Summer Promotion");
        campaign2.setDescription("Marketing campaign for summer sales");
        campaign2.setStatus("Inactive"); // Set one campaign to inactive

        campaignRepository.save(campaign1);
        campaignRepository.save(campaign2);


        checkCampaignStatus(campaign1);
        checkCampaignStatus(campaign2);

        return campaignRepository.findAll();
    }


    public void checkCampaignStatus(Campaign campaign) {
        if ("Inactive".equals(campaign.getStatus())) {
            emailService.sendAlertEmail(
                    "Campaign Inactive",
                    "The campaign " + campaign.getName() + " is now inactive.",
                    "admin@example.com"
            );
        }
    }
}
