package com.dartmouth.kd.devents;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by kathrynflattum on 2/25/18.
 */

public class CampusEvent {

    private Long mId;
    private String mTitle;
    private String mLocation;
    private String mDescription;
    private Calendar mDate;
    private String mStart;
    private String mEnd;


    public CampusEvent(){
        this.mTitle = "";
        this.mLocation = "";
        this.mDescription = "";
        this.mDate = Calendar.getInstance();;
        this.mStart = "";
        this.mEnd = "";


    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long id) {
        this.mId = id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String title) {
        this.mTitle = title;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String location) {
        this.mLocation = location;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String description) {
        this.mDescription = description;
    }

    public Calendar getmDate() {
        return mDate;
    }

    public void setmDate(int year, int monthOfYear, int dayOfMonth) {
        mDate.set(year, monthOfYear, dayOfMonth);
    }

    public long getmDateTimeInMillis() {
        return mDate.getTimeInMillis();
    }

    public void setmDateTime(Calendar dateTime) {
        this.mDate = dateTime;

    }

    public void setmDateTime(long timestamp) {
        this.mDate.setTimeInMillis(timestamp);

    }

    public String getmStart() {
        return mStart;
    }

    public void setmStart(String start) {
        this.mStart = start;
    }

    public String getmEnd() {
        return mEnd;
    }

    public void setmEnd(String end) {
        this.mEnd = end;
    }
}