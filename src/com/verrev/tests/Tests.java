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
        List<Float> freqs = new ArrayList<>();
        for (RadioStation r : stations) freqs.add(r.getFrequency());
        for (RadioStation r : stations) r.seekNewFrequency();
        for (int i = 0; i < stations.size(); ++i) {
            float prevFreq = freqs.get(i);
            if (prevFreq > 0 && prevFreq < 999.9f) {
                if (prevFreq < 100)
                    Assert.assertTrue(stations.get(i).getFrequency() < prevFreq);
                else
                    Assert.assertTrue(stations.get(i).getFrequency() > prevFreq);
            }
        }
    }

    @Test
    public void testCombinedActionsOnStringRepresentation() {
        for (RadioStation r : stations) Assert.assertFalse(r.toString()
                .contains("It is currently unable to play music due to an antenna problem."));
        RadioStationController.setRadioStationsToEmergencyMode();
        for (RadioStation r : stations) Assert.assertTrue(r.toString()
                .contains("It is currently unable to play music due to an antenna problem."));
        RadioStationController.setRadioStationsToNormalMode();
        for (RadioStation r : stations) Assert.assertFalse(r.toString()
                .contains("It is currently unable to play music due to an antenna problem."));
    }

    @Test
    public void testEmergencyMode() {
        RadioStationController.setRadioStationsToEmergencyMode();
        for (RadioStation r : stations) Assert.assertTrue(r.isInEmergencyMode());
        RadioStationController.setRadioStationsToNormalMode();
        for (RadioStation r : stations) Assert.assertFalse(r.isInEmergencyMode());
    }
}
