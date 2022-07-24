import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class senjataMeleeController{

    @FXML
    private Button senjataSukuna;

    @FXML
    private Button senjataDaimyo;

    @FXML
    private Button backMeleeWeapon;

    @FXML
    void pilihDaimyo() throws IOException{
        AttWeapon BD = new AttWeapon();
        BD.setWeapon(1, 2);
        Parent start = FXMLLoader.load(getClass().getResource("showTime.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)senjataDaimyo.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void pilihSukuna() throws IOException{
        AttWeapon BD = new AttWeapon();
        BD.setWeapon(1, 1);
        Parent start = FXMLLoader.load(getClass().getResource("showTime.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)senjataSukuna.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void backToMeleeChar() throws IOException{
        Parent start = FXMLLoader.load(getClass().getResource("pilihKarakterMelee.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)backMeleeWeapon.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }
}
