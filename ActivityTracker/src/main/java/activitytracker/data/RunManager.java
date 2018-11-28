package activitytracker.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

import activitytracker.ClassData;

public class RunManager {

    private List<ClassData> runDatas;

    /**
     * Create a new empty instance of Run Manager
     */
    public RunManager() {
        runDatas = new ArrayList<ClassData>();
    }

    /**
     * Create a new instance of Run Manager
     * @param runDatas Array of Data to populate this Run Manager
     */
    public RunManager(ClassData[] runDatas) {
        this.runDatas = new ArrayList<ClassData>();

        for (ClassData data : runDatas) {
            this.runDatas.add(data);
        }
    }

    @JsonGetter("run_data")
    /**
     * @return All the Run data available
     */
    public ClassData[] getRunDatas() {
        return runDatas.toArray(new ClassData[runDatas.size()]);
    }

    /**
     * @param from Lower limit to the date-based filter
     * @param to   Higher limti to the date-base filter
     * @return All the run data within given date frame
     */
    public ClassData[] getRunDatas(Date from, Date to) {
        return null;
    }

    @JsonSetter(value = "run_data", nulls = Nulls.SKIP)
    public void setRunDatas(ClassData[] dataSet) {
        if (dataSet == null)
            runDatas = new ArrayList<ClassData>();
        else {
            runDatas.clear();
            for (ClassData data : dataSet) {
                runDatas.add(data);
            }
        }
    }
}