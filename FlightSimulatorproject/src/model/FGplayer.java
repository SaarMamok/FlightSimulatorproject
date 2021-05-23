package model;

import properties.Settings;
import test.TimeSeries;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class FGplayer {
private  TimeSeries ts;
private Settings settings;

    public void setTs(TimeSeries ts) {
        this.ts = ts;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public void play(){

        Socket fg= null;
        try {
            fg = new Socket(settings.getIp(),settings.getPort());
            PrintWriter out=new PrintWriter(fg.getOutputStream());
            int sizeline=ts.getDataTable().get(0).valuesList.size();
            int sizecol=ts.getDataTable().size();
            for(int i=0;i<sizeline;i++){
                String line="";
                for(int j=0;j<sizecol;j++){
                    line+=ts.getDataTable().get(j).valuesList.get(i).toString();
                    line+=",";
                }
                out.println(line);
                out.flush();
                Thread.sleep(settings.getSleep());
            }
            out.close();
            fg.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }



    }



}
