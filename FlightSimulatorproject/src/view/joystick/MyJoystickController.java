package view.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class MyJoystickController {
    @FXML
    Slider throttle;
    @FXML
    Slider rudder;

    public DoubleProperty aileron,elevators;

    public MyJoystickController() {
        aileron=new SimpleDoubleProperty();
        elevators=new SimpleDoubleProperty();
    }
}
