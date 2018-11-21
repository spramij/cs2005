package activitytracker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class to manage saving and loading of data
 */
public class DataManager {

    private String folderPath;
    private ObjectMapper mapper;

    /**
     * Create a new instance of DataManager
     * @param folderPath Absolute path to the folder where data will be stored
     */
    public DataManager(String relativePath) {
        folderPath = Paths.get(".", relativePath).toString();
        mapper = new ObjectMapper();
    }

    /**
     * Gets the list of profiles available
     */
    public String[] getProfileList() {
        File[] files = new File("fullPath").listFiles();
        ArrayList<String> profileNames = new ArrayList<String>();
        for (File file : files) {
            String fileName = file.toString();

            if (fileName.endsWith(".profile")) {
                profileNames.add(fileName);
            }
        }
        return profileNames.toArray(new String[profileNames.size()]);
    }

    /**
     * Save profile as CSV
     * @param profile Profile instance that is to be saved to file
     */
    public void saveProfile(Profile profile) {
        try {
            OutputStream outStream = new FileOutputStream(Paths.get(folderPath, profile.getName() + ".profile").toFile());

            mapper.writeValue(outStream, profile);

            outStream.close();
        } catch (Exception e) {
            System.err.println("Error saving profile " + profile.getName() + " :" + e.getMessage());
        }
    }

    /**
     * Load Profile instance from CSV file
     * @param userName Username of the profile to load
     * @return Profile instance of the username provided
     */
    public Profile loadProfile(String userName) {
        Profile profile;

        try {
            String profileJson = new String(Files.readAllBytes(Paths.get(folderPath, userName + ".proifle")));

            profile = mapper.readValue(profileJson, Profile.class);
        } catch (Exception e) {
            System.err.println("Encountered error " + userName + " profile csv file: " + e.toString());
            profile = null;
        }

        return profile;
    }
}