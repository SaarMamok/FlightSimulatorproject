package viewmodel;


import javafx.beans.property.*;
import model.Model;
import test.TimeSeries;

import java.util.Observable;
import java.util.Observer;

public class ViewModel implements Observer {
  private TimeSeries ts;
  private  Model model;
  public IntegerProperty timestep;
  public DoubleProperty aileron;
  public DoubleProperty elevators;
  public DoubleProperty rudder;
  public DoubleProperty throttle;
  public Model getModel() {
    return model;
  }

  public int getTimestep() {
    return timestep.get();
  }

  public IntegerProperty timestepProperty() {
    return timestep;
  }

  public ViewModel(Model m){
    this.model=m;
    m.addObserver(this);
    timestep=new SimpleIntegerProperty();
    aileron=new SimpleDoubleProperty();
    elevators=new SimpleDoubleProperty();
    rudder=new SimpleDoubleProperty();
    throttle=new SimpleDoubleProperty();

    }
    public DoubleProperty getAileron(){
    return this.aileron;
    }
  public DoubleProperty getElevators(){
    return this.elevators;
  }
  public DoubleProperty getRudder(){
    return this.rudder;
  }
  public DoubleProperty getThrottle(){
    return this.throttle;
  }

  public void setTs(TimeSeries ts) {
    this.ts = ts;
    this.model.setTs(ts);
    this.model.getfGplayer().setTs(ts);

  }

  @Override
    public void update(Observable o, Object arg) {

    }
}
