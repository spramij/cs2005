package activitytracker.interfaces;

import activitytracker.Data;
import activitytracker.Profile;

/**
 * IExporter
 */
public interface IExporter {

    void saveRuns(String userName, Data[] data);
    void saveProfile(Profile profile);
}