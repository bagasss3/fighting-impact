import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class pilihRoleController {

    @FXML
    private Button meleeButton;

    @FXML
    private Button rangeButton;

    @FXML
    private Button backRole;

    @FXML
    void pilihMelee() throws IOException{
        Parent start = FXMLLoader.load(getClass().getResource("pilihKarakterMelee.fxml"));
        Scene pilih = new Scene(start);
        Stage stage = (Stage)meleeButton.getScene().getWindow();
        stage.setResizable(false);
        
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void pilihRange() throws IOException{
        Parent start = FXMLLoader.load(getClass().getResource("pilihKarakterRange.fxml"));
        Scene pilih = new Scene(start);
        Stage stage = (Stage)rangeButton.getScene().getWindow();
        stage.setResizable(false);
        
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void backToStart() throws IOException{
        Parent start = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)backRole.getScene().getWindow();
        stage.setResizable(false);
        
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

}
