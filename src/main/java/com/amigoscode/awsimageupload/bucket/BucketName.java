package com.amigoscode.awsimageupload.bucket;

import lombok.Getter;

@Getter
public enum BucketName {
    PROFILE_IMAGE("demo-image-upload-springboot");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
