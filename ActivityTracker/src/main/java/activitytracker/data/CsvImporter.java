package activitytracker.data;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import activitytracker.Data;
import activitytracker.interfaces.IImporter;

public class CsvImporter implements IImporter {
    private Path folderPath;
    private CsvSchema dataSchema = CsvSchema.builder().addColumn("name").addColumn("distance").addColumn("duration")
            .build();
    private CsvMapper mapper;

    public CsvImporter(String relativeFolder) {
        this.folderPath = Paths.get(".", relativeFolder);
        mapper = new CsvMapper();
    }

    /**
     * Load run data from CSV file
     * @param userName Username of the User who is loading his/her runs
     * @return An array of Data instances from the imported run data
     */
    public Data[] loadRuns(String userName) {
        Data[] data;

        try {
            String dataString = new String(Files.readAllBytes(Paths.get(folderPath.toString(), userName.toLowerCase() + "_runs.csv")));

            data = mapper.readerFor(Data[].class).with(dataSchema).readValue(dataString);
        } catch (Exception e) {
            System.err.println("Encountered error parsing csv file: " + e.toString());
            data = null;
        }

        return data;
    }
}