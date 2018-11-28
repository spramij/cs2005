package activitytracker;

import activitytracker.data.IOManager;

public final class Singleton {
    public static ClassProfile loadedProfile;
    public static IOManager dataManager = new IOManager();
}