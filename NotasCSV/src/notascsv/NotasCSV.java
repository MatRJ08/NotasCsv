package notascsv;

import java.io.File;
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
        });                                                              //http://tutorials.jenkov.com/javafx/filechooser.html
        
        VBox vBox = new VBox(btn);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

