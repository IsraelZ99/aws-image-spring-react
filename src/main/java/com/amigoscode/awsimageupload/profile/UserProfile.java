package com.amigoscode.awsimageupload.profile;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class UserProfile {

    private UUID userProfileId;
    private String username;
    private String userProfileImageLink; // S3 key

    public Optional<String> getUserProfileImageLink() {
        return Optional.ofNullable(userProfileImageLink);
    }

}
