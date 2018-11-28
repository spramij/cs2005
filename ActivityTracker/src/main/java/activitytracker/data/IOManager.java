package activitytracker.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import activitytracker.ClassProfile;

/**
 * Class to manage saving and loading of data
 */
public class IOManager {

    private File folder = Paths.get(".", "Data").toFile();
    private ObjectMapper mapper;

    /**
     * Create a new instance of DataManager
     * 
     * @param folder Absolute path to the folder where data will be stored
     */
    public IOManager() {
        mapper = new ObjectMapper();
        mapper.disable(MapperFeature.AUTO_DETECT_FIELDS, MapperFeature.AUTO_DETECT_GETTERS, MapperFeature.AUTO_DETECT_SETTERS);
    }

    /**
     * Gets the list of profiles available
     */
    public String[] getProfileList() {
        File[] files = folder.listFiles();
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
     * 
     * @param profile Profile instance that is to be saved to file
     */
    public void saveProfile(ClassProfile profile) {

        try {
            if (!folder.exists()) {
                folder.mkdir();
            }

            OutputStream outStream = new FileOutputStream(
                    Paths.get(folder.toString(), profile.getUserName() + ".profile").toFile());

            mapper.writeValue(outStream, profile);

            outStream.close();
        } catch (Exception e) {
            System.err.println("Error saving profile " + profile.getUserName() + " :" + e.getMessage());
        }
    }

    /**
     * Load Profile instance from JSON file
     * 
     * @param userName Username of the profile to load
     * @return Profile instance of the username provided
     */
    public ClassProfile loadProfile(String userName) {

        try {
            String profileJson = new String(Files.readAllBytes(Paths.get(folder.toString(), userName + ".profile")));

            return mapper.readValue(profileJson, ClassProfile.class);
        } catch (Exception e) {
            System.err.println("Encountered error " + userName + " profile json file: " + e.toString());
            return null;
        }
    }
}