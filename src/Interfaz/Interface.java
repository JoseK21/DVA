package Interfaz;

import java.awt.Canvas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.SimpleAttributeSet;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Interface implements Initializable {
	@FXML private TextArea textA_Code;	
	@FXML private TextArea  textA_CodeFort;
	@FXML private Canvas  canvas_FlowChartMain;
	@FXML private Canvas  canvas_FlowChartStepInto;
	@FXML private TextArea  textA_Variables;
	@FXML private TextArea  textA_Complexity;
	
	Image imgIconDVA = new Image(getClass().getResourceAsStream("/Image/IconDVA.png"));
	
	@FXML
	public void close(ActionEvent event){		
		try{
			Platform.exit();
			System.exit(0);
		}catch (Exception e){
			System.out.println("Error_Close");
		}
			
	}
	
	@FXML
	public void openInformation(ActionEvent event){			
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Information.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.WINDOW_MODAL);
			stage.centerOnScreen();
			stage.getIcons().add(new Image("/Image/IconDVA.PNG"));
			stage.setTitle("PluginDVA");
			stage.setScene(new Scene(root1));
			stage.show();			
		}catch (Exception e){
			System.out.println("Error_Window openInformation");
		}			
		}
	
	@FXML
	public void InsertCode(ActionEvent event){			
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Code.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();			
			stage.initModality(Modality.WINDOW_MODAL);
			stage.centerOnScreen();
			stage.getIcons().add(new Image("/Image/IconDVA.PNG"));
			stage.setTitle("PluginDVA");
			stage.setScene(new Scene(root1));
			stage.show();			
		}catch (Exception e){
			System.out.println("Error_Window InsertCode");
		}			
		}
	@FXML
	public void analyzeCode(ActionEvent event){	
		File crea_archivo;
		File crea_archivo1;
		((Node)event.getSource()).getScene().getWindow().hide();
		String text = textA_Code.getText() ;
		String ruta = "C:\\DVA\\";
		String nombre = "Code.txt"; // POR EL MOMENTO. LUEGO HAY QUE COLOCARLE EL NOMBRE DE LA CLASE__ Y TIENE QUE IR DEBAJO DEL IF(!text.is..
		
		if (!text.isEmpty()) {					
			String filetxt = ruta+nombre;
			crea_archivo = new File(filetxt);
			
			if (!crea_archivo.exists()) {
				try {
					crea_archivo.createNewFile();
					Alert alert = new Alert(AlertType.INFORMATION);					
	                alert.setTitle("Menssage");	               
	                alert.setHeaderText(null);
	                alert.setContentText("Analyzed code");
	                alert.showAndWait();
	                String [] lineas = text.split("\n");
	                for(int i=0;i<lineas.length; i++) {
	                	FileWriter writer = new FileWriter(crea_archivo,true);
	                    BufferedWriter bw = new BufferedWriter(writer);
	                    PrintWriter wr = new PrintWriter(bw);
	                   // System.out.println(lineas[i]);
	                    wr.write(lineas[i]);
	                    bw.newLine();
	                    wr.close();
	                    bw.close();
	                }
	                sendCodetoInterfacez(crea_archivo);
				
                
				} catch (IOException e) {
					System.out.println("Error_Window AnalyzeCode1");
				}
				
			}else{
				crea_archivo.delete();	
				
				String filetxt1 = ruta+nombre;
				
				crea_archivo1 = new File(ruta+nombre);
				try {
					crea_archivo1.createNewFile();
					Alert alert = new Alert(AlertType.INFORMATION);
	                alert.setTitle("Menssage");
	                alert.setHeaderText(null);
	                alert.setContentText("Analyzed code");
	                alert.showAndWait();
	                String [] lineas = text.split("\n");
	                
	                
	                
	                for(int i=0;i<lineas.length; i++) {
	                	FileWriter writer = new FileWriter(crea_archivo1,true);
	                    BufferedWriter bw = new BufferedWriter(writer);
	                    PrintWriter wr = new PrintWriter(bw);
	                    //System.out.println(lineas[i]);
	                    wr.write(lineas[i]);
	                    bw.newLine();
	                    wr.close();
	                    bw.close();
	                }
	                sendCodetoInterfacez(crea_archivo1);
				
                
			} catch (IOException e) {
				System.out.println("Error_Window AnalyzeCode2");
			}
		}
	
		}else {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Without code");
            alert.showAndWait();
		}
		
	}
	
	public void sendCodetoInterfacez(File ft){
		int n_Line = 0;
		try {
			FileReader writer = new FileReader(ft);
			
			BufferedReader inLine = new BufferedReader(writer);			
			String line="";
			System.out.println("\n-> Code \n___________________________________");
			while (line != null) {
				
				try {
					line = inLine.readLine();					
					if (line != null) {
						n_Line++;
						System.out.println(line);
						textA_CodeFort.appendText(line);
						textA_CodeFort.appendText("\n");
					}
				}catch (Exception e) {
					System.out.println("Error_Window sendCodetoInterfacez");
				}		
			}
			System.out.println("___________________________________");
			System.out.println("Lines: "+n_Line);			
		}catch (Exception e) {
			System.out.println("No lee el txt que quiero");
		}
		
	}
	@Override
	public void initialize(URL url, ResourceBundle rb){
			
	}
}

