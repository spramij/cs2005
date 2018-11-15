package activitytracker;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * Class to manage saving and loading of data
 */
public class DataManager {

    private String folderPath;
    private CsvSchema profileSchema;    // This needs to be defined based on profile data structure
    private CsvSchema dataSchema = CsvSchema.builder().addColumn("name").addColumn("distance").addColumn("duration")
            .build();
    private CsvMapper mapper;

    /**
     * Create a new instance of DataManager
     */
    public DataManager() {
        folderPath = Paths.get(".").toString();
    }

    /**
     * Create a new instance of DataManager
     * @param folderPath Absolute path to the folder where data will be stored
     */
    public DataManager(String folderPath) {
        this.folderPath = folderPath;
        mapper = new CsvMapper();
        dataSchema = CsvSchema.builder().addColumn("name").addColumn("distance").addColumn("duration").build();
    }

    /**
     * Save profile as CSV
     * @param profile Profile instance that is to be saved to file
     */
    public void saveProfile(Profile profile) {
        try {
            OutputStream outStream = new FileOutputStream(Paths.get(folderPath, profile.getName() + ".csv").toFile());

            mapper.writerFor(Profile.class).with(profileSchema).writeValue(outStream, profile);

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
            String profileCsv = new String(Files.readAllBytes(Paths.get(folderPath, userName + ".csv")));
            
            profile = mapper.readerFor(Profile.class).with(profileSchema).readValue(profileCsv);
        } catch (Exception e) {
            System.err.println("Encountered error " + userName + " profile csv file: " + e.toString());
            profile = null;
        }

        return profile;
    }

    /**
     * Save array of Data to CSV file
     * @param userName Username of the user who owns the run data
     * @param data Array of data to save
     */
    public void saveRuns(String userName, Data[] data) {
        try {
            OutputStream outStream = new FileOutputStream(Paths.get(folderPath, userName.toLowerCase() + "_runs.csv").toFile());

            mapper.writerFor(Data[].class).with(dataSchema).writeValue(outStream, data);

            outStream.close();
        } catch (Exception e) {
            System.err.println("Error formatting data to csv: " + e.getMessage());
        }
    }

    /**
     * Load run data from CSV file
     * @param userName Username of the User who is loading his/her runs
     * @return An array of Data instances from the imported run data
     */
    public Data[] loadRuns(String userName) {
        Data[] data;

        try {
            String dataString = new String(Files.readAllBytes(Paths.get(folderPath, userName.toLowerCase() + "_runs.csv")));

            data = mapper.readerFor(Data[].class).with(dataSchema).readValue(dataString);
        } catch (Exception e) {
            System.err.println("Encountered error parsing csv file: " + e.toString());
            data = null;
        }

        return data;
    }
}