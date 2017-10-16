package Interfaz;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
	Image imgIconDVA = new Image(getClass().getResourceAsStream("/Image/IconDVA.png"));
	
	@Override
	public void start(Stage stage) throws Exception{
		Parent root =FXMLLoader.load(getClass().getResource("Interface.fxml"));
		stage.getIcons().add(new Image("/Image/IconDVA.png"));
		stage.setTitle("PluginDVA");
		stage.setScene(new Scene(root,1400,700) );
		stage.show();
		stage.centerOnScreen();
		stage.setOnCloseRequest(e -> Platform.exit());
	}
	
	public static void main(String[] args) {		
		launch(args);
	}
}
