package activitytracker;

import activitytracker.data.DataManager;

public final class Singleton {
    public static Profile loadedProfile;
    public static DataManager dataManager = new DataManager("resources");
}