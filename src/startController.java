import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class startController implements Initializable {
    private static int qwe = 1;
    Image bgs = new Image("/res/TEAM SINGA.jpg");

    @FXML
    private Button startButton;

    @FXML
    private Button closeButton;

    @FXML
    private Button easterEgg;

    @FXML
    private ImageView back;

    @FXML
    void easterEgg() {
        if(qwe == 10){
            back.setImage(bgs);
        }
        qwe++;
    }

    @FXML
    public void exitWindow() throws IOException{
        boolean exit = exitPopUp.display();
        if(exit == true){
            Stage stage = (Stage)closeButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void pilihKarakter() throws IOException {
        Parent start = FXMLLoader.load(getClass().getResource("pilihRole.fxml"));
        Scene pilih = new Scene(start);
        Stage stage = (Stage)startButton.getScene().getWindow();
        stage.setResizable(false);
        
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

}

