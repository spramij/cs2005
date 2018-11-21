package activitytracker.interfaces;

import activitytracker.Data;

/**
 * IImporter
 */
public interface IImporter {
    Data[] loadRuns(String userName);
}