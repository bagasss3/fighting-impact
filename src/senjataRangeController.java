import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class senjataRangeController {

    @FXML
    private Button senjataDaredevil;

    @FXML
    private Button senjataMariposa;

    @FXML
    private Button backRangeWeapon;

    @FXML
    void pilihDaredevil() throws IOException{
        AttWeapon BD = new AttWeapon();
        BD.setWeapon(2, 1);
        Parent start = FXMLLoader.load(getClass().getResource("showTime.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)senjataDaredevil.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void pilihMariposa() throws IOException{
        AttWeapon BD = new AttWeapon();
        BD.setWeapon(2, 2);
        Parent start = FXMLLoader.load(getClass().getResource("showTime.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)senjataMariposa.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void backToRangeChar() throws IOException{
        Parent start = FXMLLoader.load(getClass().getResource("pilihKarakterRange.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)backRangeWeapon.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

}
