package com.example.integration_reporting.repository;

import com.example.integration_reporting.model.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampaignRepository extends MongoRepository<Campaign, String> {

}
