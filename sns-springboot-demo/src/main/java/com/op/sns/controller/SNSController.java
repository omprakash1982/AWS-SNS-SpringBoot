package com.op.sns.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SNSController {

    @Autowired
     private AmazonSNSClient amazonSNSClient;

     private String TOPIC_ARN="arn:aws:sns:us-east-1:559247467491:my-sns-topic";
    
     @GetMapping("/subscribe/{email}")
    public String subscribeToSNSTopic(@PathVariable("email") String email){

        SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC_ARN,"email", email);
        amazonSNSClient.subscribe(subscribeRequest);
               
        return "Check your Email for notification";
    }

    @GetMapping("/publish/{msg}")
    public String publishRequest(@PathVariable("msg") String msg){

        PublishRequest publishRequest =new PublishRequest(
            TOPIC_ARN,msg,"SNS Using SpringBoot"
        );

        amazonSNSClient.publish(publishRequest);

        return " Message has been pulblished, please check your email";
    }
}
