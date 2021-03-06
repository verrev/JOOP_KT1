package com.verrev.code.radiostation;

/**
 * Created by Vootele Verrev on 15-Oct-15.
 */
public class RadioStation {
    protected String name;
    protected float frequency;
    protected static boolean isInEmergencyMode = false;

    public RadioStation(String name, float frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public void seekNewFrequency() {
        if (frequency >= (float) 100 && frequency + 0.5f <= 999.9f) frequency += 0.5f;
        else if (frequency < (float) 100 && frequency - 0.7f >= 0.0f) frequency -= 0.7f;
    }

    public float getFrequency() {
        return frequency;
    }

    public boolean isInEmergencyMode() {
        return isInEmergencyMode;
    }

    public static void setIsInEmergencyMode(boolean isInEmergencyMode) {
        RadioStation.isInEmergencyMode = isInEmergencyMode;
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
