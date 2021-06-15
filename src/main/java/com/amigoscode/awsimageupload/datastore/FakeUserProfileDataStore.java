package com.amigoscode.awsimageupload.datastore;

import com.amigoscode.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("86fc2b39-2994-40e3-a171-d4911b169bd6"), "israel",null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("f1a2cac2-03a0-4130-9425-ac965afdfaaf"), " monserrat",null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }

}
