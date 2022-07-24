import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;
    public static void main(String[] args) {
        launch();
    }

	@Override
	public void start(Stage arg0) throws Exception {
        window = arg0;
        window.setResizable(false);
        Parent start = FXMLLoader.load(getClass().getResource("Start.fxml"));
        window.setTitle("Fighting Impact 0.2");
        window.setScene(new Scene(start, 800, 600));
        window.show();
	}    
}
