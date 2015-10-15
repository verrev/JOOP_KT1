package com.verrev.tests;

import com.verrev.code.radiostation.RadioStation;
import com.verrev.code.radiostation.RadioStationController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vootele Verrev on 15-Oct-15.
 */
public class Tests {
    private List<RadioStation> stations = new ArrayList<>();

    @Before
    public void setUp() {
        stations.add(RadioStationController.getRadioStation("ImprovedRadioStation", 105.4f));
        stations.add(RadioStationController.getRadioStation("RadioStation", 101.2f));
        stations.add(RadioStationController.getRadioStation("ImprovedRadioStation", 99.9f));
        stations.add(RadioStationController.getRadioStation("RadioStation", 100.0f));
        stations.add(RadioStationController.getRadioStation("ImprovedRadioStation", 110.6f));
        stations.add(RadioStationController.getRadioStation("RadioStation", 89.6f));
        stations.add(RadioStationController.getRadioStation("ImprovedRadioStation", 102.6f));
        stations.add(RadioStationController.getRadioStation("RadioStation", 111.1f));
    }

    @Test
    public void testSeeking() {
        for (RadioStation r : stations) System.out.println(r);
        System.out.println("");
        for (RadioStation r : stations) r.seekNewFrequency();
        for (RadioStation r : stations) System.out.println(r);
    }

    @Test
    public void testCombinedActions() {
        for (RadioStation r : stations) System.out.println(r);
        RadioStationController.setRadioStationsToEmergencyMode(stations);
        for (RadioStation r : stations) System.out.println(r);
        RadioStationController.setRadioStationsToNormalMode(stations);
    }

    @Test
    public void testEmergencyMode() {
        RadioStationController.setRadioStationsToEmergencyMode(stations);
        for (RadioStation r : stations) Assert.assertTrue(r.isInEmergencyMode());
        RadioStationController.setRadioStationsToNormalMode(stations);
        for (RadioStation r : stations) Assert.assertFalse(r.isInEmergencyMode());
    }
}
