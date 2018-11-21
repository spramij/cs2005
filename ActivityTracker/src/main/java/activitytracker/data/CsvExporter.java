package activitytracker.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import activitytracker.Data;
import activitytracker.Profile;
import activitytracker.interfaces.IExporter;

public class CsvExporter implements IExporter {

    private Path folderPath;
    private CsvMapper mapper;
    
    private CsvSchema dataSchema;

    public CsvExporter(String relativePath) {
        this.folderPath = Paths.get(".", relativePath);
        mapper = new CsvMapper();
        dataSchema = CsvSchema.builder().build();
    }

    @Override
    public void saveRuns(Profile profile) {
        try {
            OutputStream outStream = new FileOutputStream(Paths.get(folderPath.toString(), profile.getName().toLowerCase() + "_runs.csv").toFile());

            mapper.writerFor(Data[].class).with(dataSchema).writeValue(outStream, profile.getRunData());
        } catch (Exception e) {
            System.err.println("Error formatting data to csv: " + e.getMessage());
        }
	}

}