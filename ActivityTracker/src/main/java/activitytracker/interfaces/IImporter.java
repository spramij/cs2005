package activitytracker.interfaces;

import activitytracker.Data;
import activitytracker.Profile;

/**
 * IImporter
 */
public interface IImporter {

    void saveProfile(Profile profile);
    void saveRuns(String userName, Data[] data);
}