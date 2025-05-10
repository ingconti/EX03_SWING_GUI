package it.polimi;


import java.beans.PropertyChangeListener;

public class SmallModel {

    private String timeStr = "??";

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    PropertyChangeListener listener;
    public void setListener(PropertyChangeListener listener) {
        this.listener = listener;
    }


}
