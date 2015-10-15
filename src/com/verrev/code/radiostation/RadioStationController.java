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
        if (name.equals("ImprovedRadioStation")) return new ImprovedRadioStation("Improved radio station ", frequency);
        else return new RadioStation("Radio station", frequency);
    }

    public static void setRadioStationsToEmergencyMode(List<RadioStation> stations) {
        for (RadioStation r : stations) r.setIsInEmergencyMode(true);
    }

    public static void setRadioStationsToNormalMode(List<RadioStation> stations) {
        for (RadioStation r : stations) r.setIsInEmergencyMode(false);
    }
}
