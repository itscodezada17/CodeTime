package com.example.codetime;

public class Pojo {
    private String name;
    private String url;
    private String start_time;
    private String end_time;
    private String duration;
    private String site;
    private String in_24_hours;
    private String status;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getDuration() {
        return duration;
    }

    public String getSite() {
        return site;
    }

    public String getIn_24_hours() {
        return in_24_hours;
    }

    public String getStatus() {
        return status;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setIn_24_hours(String in_24_hours) {
        this.in_24_hours = in_24_hours;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}