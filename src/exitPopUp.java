import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class exitPopUp {

    static boolean yesno;

    public static boolean display(){

        Stage windows = new Stage();  
        windows.setResizable(false);
        windows.initModality(Modality.APPLICATION_MODAL);
        windows.setTitle("Exit");
        windows.setWidth(220);

        Label label = new Label();
        label.setText("Are You Sure ?");

        Button button1 = new Button("Yes");
        button1.setOnAction(e -> {
            yesno = true;
            windows.close();
        });

        Button button2 = new Button("Nope");
        button2.setOnAction(e -> {
            yesno = false;
            windows.close();
        });

        VBox layp = new VBox(20);
        layp.getChildren().add(label);
        layp.setAlignment(Pos.CENTER);

        HBox layh = new HBox(10);
        layh.getChildren().addAll(button1, button2);;
        layh.setAlignment(Pos.CENTER);

        layp.getChildren().add(layh);
        Scene scene = new Scene(layp);
        windows.setScene(scene);
        windows.showAndWait();

        return yesno;
    }
}
