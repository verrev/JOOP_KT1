package com.verrev.code.radiostation;

import java.util.List;

/**
 * Created by Vootele Verrev on 15-Oct-15.
 */
public class RadioStationController {
    /*
        Static factory method, creates different radio stations by name.
     */
    public static RadioStation getRadioStation(String name, float frequency) {
        if (name.equals("ImprovedRadioStation")) return new ImprovedRadioStation("Improved radio station", frequency);
        else return new RadioStation("Radio station", frequency);
    }

    public static void setRadioStationsToEmergencyMode() {
        RadioStation.setIsInEmergencyMode(true);
    }

    public static void setRadioStationsToNormalMode() {
        RadioStation.setIsInEmergencyMode(false);
    }
}
