package ActivityTracker.src.main.java.activitytracker;
// package activitytracker;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Importer {
    private String folderPath;
    private ObjectMapper oMapper;

    /**
     * Create a new instance of Importer
     * @param folderPath Absolute path to the folder where resources are kept
     */
    public Importer(String folderPath) {
        this.folderPath = folderPath;
        oMapper = new ObjectMapper();
    }

    /**
     * Loads profiles from json file in resource folder
     * @return An array of Profile instances loaded from json file
     */
    public Profile[] loadProfiles() {
        Profile[] profiles;
        try {
            profiles = oMapper.readValue(new String(Files.readAllBytes(Paths.get(folderPath, "profiles.json"))),
                    Profile[].class);
        } catch (Exception e) {
            profiles = null;
        }
        return profiles;
    }

    /**
     * Loads run data from json file in resource folder
     * @return An array of Data instances loaded from json file
     */
    public Data[] loadData() {
        Data[] data;
        try {
            data = oMapper.readValue(new String(Files.readAllBytes(Paths.get(folderPath, "runs.json"))), Data[].class);
        } catch (Exception e) {
            data = null;
        }
        return data;
    }
}