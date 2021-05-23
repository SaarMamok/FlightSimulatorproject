package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import test.TimeSeries;
import view.attlist.AttList;
import view.joystick.MyJoystick;
import viewmodel.ViewModel;

import java.io.File;
import java.util.Observable;

public class Windowcontroller extends Observable {


    @FXML
    ListView<String> listView=new ListView<>();
    @FXML
    MyJoystick myJoystick;
    @FXML
    AttList attributeslist;
    @FXML
    ImageView play;
    @FXML
    ImageView backwards;
    @FXML
    ImageView skipprev;
    @FXML
    ImageView pause;
    @FXML
    ImageView stop;
    @FXML
    ImageView fastforward;
    @FXML
    ImageView skipnext;


    private File chosen;
    ViewModel viewModel;



    public void init(ViewModel vm){

        this.viewModel=vm;

        this.viewModel.getAileron().bind(myJoystick.aileron);
        this.viewModel.getElevators().bind(myJoystick.elevators);
        this.viewModel.getRudder().bind(myJoystick.rudder);
        this.viewModel.getThrottle().bind(myJoystick.throttle);

        play.setImage(new Image(getClass().getResourceAsStream("./buttons/play.png")));
        backwards.setImage(new Image(getClass().getResourceAsStream("./buttons/fastbackwards.png")));
        skipprev.setImage(new Image(getClass().getResourceAsStream("./buttons/skiprev.png")));
        pause.setImage(new Image(getClass().getResourceAsStream("./buttons/pause.png")));
        stop.setImage(new Image(getClass().getResourceAsStream("./buttons/stop.png")));
        fastforward.setImage(new Image(getClass().getResourceAsStream("./buttons/fastforward.png")));
        skipnext.setImage(new Image(getClass().getResourceAsStream("./buttons/skipnext.png")));

    }

    public void Opencsv(){
        FileChooser fc =new FileChooser();
        fc.setTitle("Choose file");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Csv Files", "*.csv"));
        chosen=fc.showOpenDialog(null);
        if(chosen!=null) {
            System.out.println(chosen.getName());
        }
        this.viewModel.setTs(new TimeSeries(chosen.getAbsolutePath()));
    }

    public void playview(){
        this.viewModel.getModel().getfGplayer().play();
        //this.viewModel.getModel().getPlayer().play(viewModel.getModel().getProp(),viewModel.getModel().getTs());
    }

}
