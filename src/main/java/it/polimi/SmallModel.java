package it.polimi;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SmallModel {

    private String timeStr = "??"; // e soliti set get..

    PropertyChangeListener listener;
    public void setListener(PropertyChangeListener listener) {
        this.listener = listener;
    }


    public void setTimeStr(String timeStr) {

        PropertyChangeEvent evt = new PropertyChangeEvent(
                this,
                "MODEL_CHANGED",
                this.timeStr,
                timeStr);

        this.timeStr = timeStr;
        this.listener.propertyChange(evt);
    }

}
