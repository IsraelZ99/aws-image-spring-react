package com.amigoscode.awsimageupload.profile;

import com.amigoscode.awsimageupload.datastore.FakeUserProfileDataStore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserProfileDataAccesService {

    @Autowired
    private final FakeUserProfileDataStore fakeUserProfileDataStore;

    List<UserProfile> getUserProfiles(){
        return fakeUserProfileDataStore.getUserProfiles();
    }

}
