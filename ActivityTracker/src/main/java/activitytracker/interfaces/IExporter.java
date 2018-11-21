package activitytracker.interfaces;

import activitytracker.Data;
import activitytracker.Profile;

/**
 * IExporter
 */
public interface IExporter {

    void saveRuns(Profile profile);
}