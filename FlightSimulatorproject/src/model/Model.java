package model;

import properties.Settings;
import test.TimeSeries;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Observable;

public class Model extends Observable {
    private TimeSeries ts;
    private Settings prop;
    FGplayer fGplayer;
    public Model(){
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new FileInputStream(new File("setting.xml")));
            this.prop= (Settings) decoder.readObject();
            decoder.close();
            fGplayer=new FGplayer();
            fGplayer.setSettings(prop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public TimeSeries getTs() {
        return ts;
    }

    public FGplayer getfGplayer() {
        return fGplayer;
    }

    public void setTs(TimeSeries ts) {
        this.ts = ts;
    }
}
