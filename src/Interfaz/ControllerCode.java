package Interfaz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

public class ControllerCode {
	
	//@FXML private JTextArea textA_Code;	
	JTextArea textA_Code;	
	
	
	public void selectFile(ActionEvent event){
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		String filename = f.getAbsolutePath();
		
		
		try {
			FileReader reader = new FileReader (filename);
			BufferedReader br = new BufferedReader(reader);
			textA_Code.read(br,null);
			br.close();
			textA_Code.requestFocus();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	@FXML
	public void analyzeCode(ActionEvent event){	 // RUN
		
		
	}
	
	@FXML
	public void sendCodetoInterfacez(File ft){
			
		}
	
	/*
	@FXML
	public void analyzeCode(ActionEvent event){	 // RUN
		
		
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
	//@FXML
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
						System.out.println(line);
						n_Line++;
						//textA_CodeFort.insertText(n_Line,line);	
						
						//textA_CodeFort.setText(line);
						
						//textA_CodeFort.appendText(line);
						//textA_CodeFort.appendText("\n");
					}
				}catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			System.out.println("___________________________________");
			System.out.println("Lines: "+n_Line);			
		}catch (Exception e) {
			System.out.println("No lee el txt que quiero");
		}
		
		}
		*/
	
}
