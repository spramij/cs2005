package activitytracker.data;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import activitytracker.ClassData;

public final class CsvImporter {

    public static ClassData[] Import(File file) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));

            String[] lines = jsonString.split("\n");

            List<ClassData> dataSet = new ArrayList<ClassData>();

            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

            for (String line : lines) {
                String[] fields = line.split(",");

                // For invalid csv format
                if (fields.length != 4) {
                    System.err.println("Invalid CSV file provided at " + file.getAbsolutePath());
                    return null;
                }

                dataSet.add(new ClassData(Integer.valueOf(fields[0]), Integer.valueOf(fields[1]),
                        Float.valueOf(fields[2]), dateFormatter.parse(fields[3])));
            }

            return dataSet.toArray(new ClassData[dataSet.size()]);

        } catch (Exception ex) {
            System.err.println(ex.toString());
            return null;
        }
    }

}