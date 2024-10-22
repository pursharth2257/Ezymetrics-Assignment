package com.example.integration_reporting.repository;

import com.example.integration_reporting.model.Lead;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeadRepository extends MongoRepository<Lead, String> {
}