// package ActivityTracker.src.main.java.activitytracker;
package activitytracker;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Exporter {
    private String folderPath;
    private ObjectMapper oMapper;

    /**
     * Creates a new instance of Exporter
     * @param folderPath Absolute path to the folder where resources are kept
     */
    public Exporter(String folderPath) {
        this.folderPath = folderPath;
        oMapper = new ObjectMapper();
    }

    /**
     * Saves profile data as json
     * @param profiles Array of profiles to save
     */
    public void saveProfiles(Profile[] profiles) {
        try {
            OutputStream outStream = new FileOutputStream(Paths.get(folderPath, "profiles.json").toFile());
            oMapper.writeValue(outStream, profiles);
        } catch (Exception e) {
            System.out.println("Error saving profiles");
        }
    }

    /**
     * Saves run data as json
     * @param data Array of data to save
     */
    public void saveRunData(Data[] data) {
        try {
            OutputStream outputStream = new FileOutputStream(Paths.get(folderPath, "runs.json").toFile());
            oMapper.writeValue(outputStream, data);
        } catch (Exception e) {
            System.out.println("Error saving run data");
        }
    }
}