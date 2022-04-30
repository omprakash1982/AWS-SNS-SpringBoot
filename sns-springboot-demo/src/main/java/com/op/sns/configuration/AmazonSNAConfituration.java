package com.op.sns.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AmazonSNAConfituration {
    @Primary
    @Bean
    public AmazonSNSClient amazonSNSClient(){
        return (AmazonSNSClient) AmazonSNSClientBuilder
        .standard()
        .withRegion(Regions.US_EAST_1)
        .withCredentials(
        new AWSStaticCredentialsProvider(
            new BasicAWSCredentials(
                "AKIAYENN7EPRRURKAS7B",
                "DzBfdCe0tXlxC33mL9j8TjaZiCnb6z594UetJyTj" 
            )
        
        )
        ).build();
    }
    }

