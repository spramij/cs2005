package activitytracker.data;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
        List<ClassData> returnData = new ArrayList<ClassData>();

        for (ClassData data : this.runDatas) {
            Date date = data.getDate();

            if ((date.before(to) || date.equals(to)) && (date.after(from) || date.equals(from))) {
                returnData.add(data);
            }
        }

        return returnData.toArray(new ClassData[returnData.size()]);
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

    @JsonIgnore
    public Date getStartDate() {
        Date startDate = new Date();

        for (ClassData data : this.runDatas) {
            if (startDate.after(data.getDate()))
                startDate = data.getDate();
        }

        return startDate;
    }

    @JsonIgnore
    public void addRunDatas(ClassData[] dataSet) {
        for (ClassData data : dataSet) {
            this.runDatas.add(data);
        }
    }

    @JsonIgnore
    public Time getTotalTime() {
        int totalTime = 0;

        for (ClassData data : this.runDatas) {
            totalTime += data.getDuration();
        }
        int hours = (int) totalTime / 3600;
        double remainder = (double) totalTime - hours * 3600;
        int mins = (int) remainder / 60;

        return new Time(hours, mins, 0);
    }
}