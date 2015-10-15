package com.verrev.code.radiostation;

/**
 * Created by Vootele Verrev on 15-Oct-15.
 */
public class RadioStation {
    protected String name;
    protected float frequency;
    protected boolean isInEmergencyMode;

    public RadioStation(String name, float frequency) {
        this.name = name;
        this.frequency = frequency;
        this.isInEmergencyMode = false;
    }

    public void seekNewFrequency() {
        if (frequency >= (float) 100) frequency += 0.5f;
        else frequency -= 0.7f;
    }

    public float getFrequency() {
        return frequency;
    }

    public boolean isInEmergencyMode() {
        return isInEmergencyMode;
    }

    public void setIsInEmergencyMode(boolean isInEmergencyMode) {
        this.isInEmergencyMode = isInEmergencyMode;
    }

    /*
        Allows us to 'print' an instance of this class conveniently.
     */
    @Override
    public String toString() {
        if (!isInEmergencyMode)
            return name + " with a frequency of " + frequency + ".";
        else
            return name + " with a frequency of " + frequency + "."
                    + " It is currently unable to play music due to an antenna problem.";
    }
}
