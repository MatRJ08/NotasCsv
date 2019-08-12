package notascsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Mathiw Rojas
 */
public class NotasCSV extends Application {
   
    @Override
    public void start(Stage primaryStage) {        
        primaryStage.setTitle("Notas Estudiantes");
        Button btn = new Button("Seleccionar Archivo");
        FileChooser fileChooser = new FileChooser();
        btn.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);//Evento con File chooser tomado de 
            readCSV(selectedFile);
        });                                                              //http://tutorials.jenkov.com/javafx/filechooser.html
        
        VBox vBox = new VBox(btn);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void readCSV(File selectedFile) {//Funcion read CSV tomada de:
                                            //http://java-buddy.blogspot.com/2016/06/read-csv-file-display-in-javafx.html
        String FieldDelimiter = ",";
 
        BufferedReader br;
 
        try {
            br = new BufferedReader(new FileReader(selectedFile));
 
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
                System.out.println(fields[0]);
               
 
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NotasCSV.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NotasCSV.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
 
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

