package view.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;


import java.io.IOException;

public class MyJoystick extends Pane {

    public DoubleProperty aileron,elevators,rudder,throttle;
    public MyJoystick(){
        super();

        try {
            FXMLLoader fxl=new FXMLLoader();
            Parent root = fxl.load(getClass().getResource("MyJoystick.fxml").openStream());
            MyJoystickController myJoystickController=fxl.getController();

            aileron=myJoystickController.aileron;
            elevators=myJoystickController.elevators;
            rudder=myJoystickController.rudder.valueProperty();
            throttle=myJoystickController.throttle.valueProperty();

            this.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
