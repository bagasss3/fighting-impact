import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class pilihKarakterRangeController {

    @FXML
    private Button zydaneButton;

    @FXML
    private Button bagasButton;

    @FXML
    private Button backRangeChar;

    @FXML
    void pilihBagas() throws IOException{
        Chara t1 = new Chara();
        t1.setCharaName(2, 2);
        Parent start = FXMLLoader.load(getClass().getResource("senjataRange.fxml"));
        Scene pilih = new Scene(start);
        Stage stage = (Stage)bagasButton.getScene().getWindow();
        stage.setResizable(false);
        
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void pilihZydane() throws IOException{
        Chara t1 = new Chara();
        t1.setCharaName(2, 1);
        Parent start = FXMLLoader.load(getClass().getResource("senjataRange.fxml"));
        Scene pilih = new Scene(start);
        Stage stage = (Stage)zydaneButton.getScene().getWindow();
        stage.setResizable(false);
        
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void backToRole() throws IOException{
        Parent start = FXMLLoader.load(getClass().getResource("pilihRole.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)backRangeChar.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

}
