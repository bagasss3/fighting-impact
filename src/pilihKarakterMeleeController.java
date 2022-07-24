import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class pilihKarakterMeleeController {

    Chara t1 = new Chara();

    @FXML
    private Button joeButton;

    @FXML
    private Button bidenButton;

    @FXML
    private Button backMeleeChar;

    @FXML
    void pilihBiden() throws IOException{
        t1.setCharaName(1, 2);
        Parent start = FXMLLoader.load(getClass().getResource("SenjataMelee.fxml"));
        Scene pilih = new Scene(start);
        Stage stage = (Stage)bidenButton.getScene().getWindow();
        stage.setResizable(false);
        
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void pilihJoe() throws IOException{
        t1.setCharaName(1, 1);
        Parent start = FXMLLoader.load(getClass().getResource("SenjataMelee.fxml"));
        Scene pilih = new Scene(start);
        Stage stage = (Stage)joeButton.getScene().getWindow();
        stage.setResizable(false);
        
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void backToRole() throws IOException{
        Parent start = FXMLLoader.load(getClass().getResource("pilihRole.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)backMeleeChar.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

}
