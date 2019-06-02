package com.strikalov.serverhw;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YearPogo {

    @SerializedName("time_of_year")
    @Expose
    private String timeOfYear;

    @SerializedName("year")
    @Expose
    private String year;

    public String getTimeOfYear() {
        return timeOfYear;
    }

    public void setTimeOfYear(String timeOfYear) {
        this.timeOfYear = timeOfYear;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "YearPogo{" +
                "timeOfYear='" + timeOfYear + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
