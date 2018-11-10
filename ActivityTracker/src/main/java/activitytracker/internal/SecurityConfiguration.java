package activitytracker.internal;

import java.util.List;
import activitytracker.Profile;

// class to hold security configuration of user
public class SecurityConfiguration {

    // profiles to share personal information with
    private List<Profile> profilesToShareWith;

    // enum to hold how a user might want to share their information
    public enum ShareOptions {
        withEveryOne, withSome, withNoOne,
    }
    
    private ShareOptions shareOption;

    public SecurityConfiguration() {
        shareOption = ShareOptions.withNoOne;
    }
}