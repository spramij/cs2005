package activitytracker;

import activitytracker.data.DataManager;

public final class Singleton {
    public static ClassProfile loadedProfile;
    public static DataManager dataManager = new DataManager("resources");
}