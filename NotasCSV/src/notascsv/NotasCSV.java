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
    class Estudiante{
        private String nombre;
        private String correo;
        private int tel;
        private String nickname;
        private char tipoEstudiante;
        private int promExamenes;
        private int promQuices;
        private int promTareas;
        private int proyecto1;
        private int proyecto2;
        private int proyecto3;
        public Estudiante(String newNombre, String newCorreo, int newTel, String newNickname, char newTipo, int newPromE, int newPromQ, int newPromT, int newProyecto1, int newProyecto2, int newProyecto3){
            nombre = newNombre;
            correo = newCorreo;
            tel = newTel;
            nickname = newNickname;
            tipoEstudiante = newTipo;
            promExamenes = newPromE;
            promQuices = newPromQ;
            promTareas = newPromT;
            proyecto1 = newProyecto1;
            proyecto2 = newProyecto2;
            proyecto3 = newProyecto3;
        }
        
        public String getNombre(){
            return nombre;
        }
        public String getCorreo(){
            return correo;
        }
        public int getTel(){
            return tel;
        }
        public String getNickname(){
            return nickname;
        }
        public char getTipoEstudiante(){
            return tipoEstudiante;
        }
        public int getPromExamenes(){
            return promExamenes;
        }
        public int getPromQuices(){
            return promQuices;
        }
        public int getPromTareas(){
            return promTareas;
        }
        public int getProyecto1(){
            return proyecto1;
        }
        public int getProyecto2(){
            return proyecto2;            
        }
        public int getProyecto3(){
            return proyecto3;            
        }
    
    }
    
    
    
    class EstudianteTipoA{
        private int notaPromedioEQT;
        Estudiante estudiante;
        public EstudianteTipoA(String newNombre, String newCorreo, int newTel, String newNickname, int newPromE, int newPromQ, int newPromT, int newProyecto1, int newProyecto2, int newProyecto3){
            estudiante = new Estudiante(newNombre, newCorreo, newTel, newNickname, 'A', newPromE, newPromQ, newPromT, newProyecto1, newProyecto2, newProyecto3);
            notaPromedioEQT = (newPromE + newPromQ + newPromT)/3;
        }
        
        public int getNotaPromedioEQT(){
            return notaPromedioEQT;
        }
        
    }
    
    
    
    class EstudianteTipoB{
        private int notaPromedioProyectos;
        Estudiante estudiante;
        public EstudianteTipoB(String newNombre, String newCorreo, int newTel, String newNickname, int newPromE, int newPromQ, int newPromT, int newProyecto1, int newProyecto2, int newProyecto3){
            estudiante = new Estudiante(newNombre, newCorreo, newTel, newNickname, 'B', newPromE, newPromQ, newPromT, newProyecto1, newProyecto2, newProyecto3);
            notaPromedioProyectos = (newProyecto1 + newProyecto2 + newProyecto3)/3;
        }
        
        public int getNotaPromedioProyectos(){
            return notaPromedioProyectos;
        }
        
        
    }
    
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

