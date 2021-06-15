package com.amigoscode.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Bean //Instantiate this class to use in another classes
    public AmazonS3 s3(){ // Storage in the cloud
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIAQE5ILIXTZ7HPLCXZ",
                "f3cdqWakGQi1utG4eltjz66rJFhyRqlKRdw2Vlc1"
        );
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.SA_EAST_1)
                .build();
    }

}
