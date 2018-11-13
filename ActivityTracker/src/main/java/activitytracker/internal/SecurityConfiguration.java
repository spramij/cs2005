package ActivityTracker.src.main.java.activitytracker.internal;

import ActivityTracker.src.main.java.activitytracker.Profile;


import java.util.List;

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