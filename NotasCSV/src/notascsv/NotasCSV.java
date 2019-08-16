package notascsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Rectangle2D;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Mathiw Rojas
 */

public class NotasCSV extends Application {
    
    public class Estudiante{
        private String carnet;
        private String nombre;
        private String correo;
        private String tel;
        private String nickname;
        private char tipoEstudiante;
        private int promExamenes;
        private int promQuices;
        private int promTareas;
        private int proyecto1;
        private int proyecto2;
        private int proyecto3;
        
        public Estudiante(String newCarnet, String newNombre, String newCorreo, String newTel, String newNickname, char newTipo, int newPromE, int newPromQ, int newPromT, int newProyecto1, int newProyecto2, int newProyecto3){
            carnet = newCarnet;
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
        
        public String getCarnet(){
            return carnet;
        }
        
        public String getNombre(){
            return nombre;
        }
        
        public String getCorreo(){
            return correo;
        }
        
        public String getTel(){
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
    
    
    
    public class EstudianteTipoA{
        private int notaPromedioEQT;
        private Estudiante estudiante;
        public EstudianteTipoA(String newCarnet,String newNombre, String newCorreo, String newTel, String newNickname, int newPromE, int newPromQ, int newPromT, int newProyecto1, int newProyecto2, int newProyecto3){
            estudiante = new Estudiante(newCarnet,newNombre, newCorreo, newTel, newNickname, 'A', newPromE, newPromQ, newPromT, newProyecto1, newProyecto2, newProyecto3);
            this.notaPromedioEQT = (newPromE + newPromQ + newPromT)/3;
        }
        
        public String getCarnet(){
            return estudiante.carnet;
        }
        
        public String getNombre(){
            return estudiante.nombre;
        }
        
        public String getCorreo(){
            return estudiante.correo;
        }
        
        public String getTel(){
            return estudiante.tel;
        }
        
        public String getNickname(){
            return estudiante.nickname;
        }
        
        public char getTipoEstudiante(){
            return estudiante.tipoEstudiante;
        }
        
        public int getPromExamenes(){
            return estudiante.promExamenes;
        }
        
        public int getPromQuices(){
            return estudiante.promQuices;
        }
        
        public int getPromTareas(){
            return estudiante.promTareas;
        }
        
        public int getProyecto1(){
            return estudiante.proyecto1;
        }
        
        public int getProyecto2(){
            return estudiante.proyecto2;            
        }
       
        public int getProyecto3(){
            return estudiante.proyecto3;            
        }
    
        public int getNotaPromedioEQT(){
            return notaPromedioEQT;
        }
        
    }
    
    
    
    public class EstudianteTipoB{
        
        private int notaPromedioProyectos;
        Estudiante estudiante;
        
        public EstudianteTipoB(String newCarnet, String newNombre, String newCorreo, String newTel, String newNickname, int newPromE, int newPromQ, int newPromT, int newProyecto1, int newProyecto2, int newProyecto3){
            estudiante = new Estudiante(newCarnet, newNombre, newCorreo, newTel, newNickname, 'B', newPromE, newPromQ, newPromT, newProyecto1, newProyecto2, newProyecto3);
            this.notaPromedioProyectos = (newProyecto1 + newProyecto2 + newProyecto3)/3;
        }
        
        
        public String getCarnet(){
            return estudiante.carnet;
        }
        
        public String getNombre(){
            return estudiante.nombre;
        }
        
        public String getCorreo(){
            return estudiante.correo;
        }
        
        public String getTel(){
            return estudiante.tel;
        }
        
        public String getNickname(){
            return estudiante.nickname;
        }
        
        public char getTipoEstudiante(){
            return estudiante.tipoEstudiante;
        }
        
        public int getPromExamenes(){
            return estudiante.promExamenes;
        }
        
        public int getPromQuices(){
            return estudiante.promQuices;
        }
        
        public int getPromTareas(){
            return estudiante.promTareas;
        }
        
        public int getProyecto1(){
            return estudiante.proyecto1;
        }
        
        public int getProyecto2(){
            return estudiante.proyecto2;            
        }
       
        public int getProyecto3(){
            return estudiante.proyecto3;            
        }
        
        public int getNotaPromedioProyectos(){
            return notaPromedioProyectos;
        }
        
        
    }
    
    
    TableView tableEstudiantes = new TableView();
    
    
    @Override
    public void start(Stage primaryStage) {        
        primaryStage.setTitle("Notas Estudiantes");
        Button btn = new Button("Seleccionar Archivo");
        FileChooser fileChooser = new FileChooser();
        btn.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);//Evento con File chooser tomado de 
            readCSV(selectedFile);
        });                                                              //http://tutorials.jenkov.com/javafx/filechooser.html
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableEstudiantes,btn);
        Scene scene = new Scene(vBox, 960, 600);
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
        
        
    private void readCSV(File selectedFile) {//Funcion read CSV tomada de:
                                            //http://java-buddy.blogspot.com/2016/06/read-csv-file-display-in-javafx.html
        String FieldDelimiter = ",";
 
        BufferedReader br;
 
        try {
            br = new BufferedReader(new FileReader(selectedFile));
 
            String line;
            
            Boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
                System.out.println(fields[0]);
                Agnadir_Field(fields,isHeader);
                isHeader = false;
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NotasCSV.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NotasCSV.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
 
    }
    
    
    
    public void Agnadir_Field(String[] field, Boolean isHeader){
        if(isHeader){
            TableColumn col,colEQT,colProyectos;
            String[] columnValues = new String[]{"carnet","nombre","correo","tel","nickname","tipoEstudiante","promExamenes","promQuices","promTareas","proyecto1","proyecto2","proyecto3"}; 
            
            for(int i=0; i < field.length ;i++){
                col = new TableColumn(field[i]);
                col.setCellValueFactory(new PropertyValueFactory<>(columnValues[i]));
                col.prefWidthProperty().bind(tableEstudiantes.widthProperty().multiply(0.08));
                tableEstudiantes.getColumns().add(col);
            }
            
            colProyectos = new TableColumn("Promedio Proyectos");
            colProyectos.setCellValueFactory(new PropertyValueFactory<>("notaPromedioProyectos"));
            colProyectos.prefWidthProperty().bind(tableEstudiantes.widthProperty().multiply(0.08));
            
            colEQT = new TableColumn("Promedio EQT");
            colEQT.setCellValueFactory(new PropertyValueFactory<>("notaPromedioEQT"));
            colEQT.prefWidthProperty().bind(tableEstudiantes.widthProperty().multiply(0.08));
            tableEstudiantes.getColumns().addAll(colProyectos,colEQT);
            
        }else{
            if("A".equals(field[5])){
                EstudianteTipoA nuevoEstudiante = new EstudianteTipoA(field[0],field[1],field[2],field[3],field[4],Integer.parseInt(field[6]),Integer.parseInt(field[7]),Integer.parseInt(field[8]),Integer.parseInt(field[9]),Integer.parseInt(field[10]),Integer.parseInt(field[11]));
                tableEstudiantes.getItems().add(nuevoEstudiante);
            }else{
                EstudianteTipoB nuevoEstudiante = new EstudianteTipoB(field[0],field[1],field[2],field[3],field[4],Integer.parseInt(field[6]),Integer.parseInt(field[7]),Integer.parseInt(field[8]),Integer.parseInt(field[9]),Integer.parseInt(field[10]),Integer.parseInt(field[11]));
                tableEstudiantes.getItems().add(nuevoEstudiante);
            }
        }
    }

    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

