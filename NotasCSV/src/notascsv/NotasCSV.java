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
    
    /**Decalracion de la clase Estudiante
     *@author Mathiw Rojas
     * @version 15/8/19
     * Aqui se utiliza los conceptos de clase, encapsulamiento, atributos
     */
    public class Estudiante{
        //declaracion de los atributos privados
        private String carnet;
        private String nombre;
        private String correo;
        private String tel;
        private String nickname;
        private String tipoEstudiante;
        private float promExamenes;
        private float promQuices;
        private float promTareas;
        private int proyecto1;
        private int proyecto2;
        private int proyecto3;
        
        
        /** creacion del constructor
         * @param newCarnet 
         * @param newNombre
         * @param newCorreo
         * @param newTel
         * @param newNickname
         * @param newTipo
         * Los parametros antes de este comentario son datos personales del estudiante
         * @param newPromE
         * @param newPromQ
         * @param newPromT
         * @param newProyecto1
         * @param newProyecto2
         * @param newProyecto3
         * Los parametros antes de este comentario son notas del estudiante
         */
        public Estudiante(String newCarnet, String newNombre, String newCorreo, String newTel, String newNickname, String newTipo, int newPromE, int newPromQ, int newPromT, int newProyecto1, int newProyecto2, int newProyecto3){
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
        
        /**@return Retorna el carnet del estudiante  */
        public String getCarnet(){
            return carnet;
        }
        
        /**@return Retorna el nombre del estudiante  */
        public String getNombre(){
            return nombre;
        }
        
        /**@return Retorna el correo del estudiante  */
        public String getCorreo(){
            return correo;
        }
        
        /**@return Retorna el Telefono del estudiante  */
        public String getTel(){
            return tel;
        }
        
        /**@return Retorna el NickName del estudiante  */
        public String getNickname(){
            return nickname;
        }
        
        /**@return Retorna el tipo de estudiante al cual pertenece el estudiante  */
        public String getTipoEstudiante(){
            return tipoEstudiante;
        }
        
        /**@return Retorna el promedio de los examenes del estudiante  */
        public float getPromExamenes(){
            return promExamenes;
        }
        
        /**@return Retorna el promedio de los quices del estudiante  */
        public float getPromQuices(){
            return promQuices;
        }
        
        /**@return Retorna el promedio de las tareas del estudiante  */
        public float getPromTareas(){
            return promTareas;
        }
        
        /**@return Retorna la nota del primer proyecto del estudiante  */
        public int getProyecto1(){
            return proyecto1;
        }
        
        /**@return Retorna la nota del segundo proyecto del estudiante  */
        public int getProyecto2(){
            return proyecto2;            
        }
       
        /**@return Retorna la nota del tercer proyecto del estudiante  */
        public int getProyecto3(){
            return proyecto3;            
        }
        
        /**Metodo que calcula el promedio de 3 notas
         * @param nota1,@param nota2, @param nota 3 son parametros de notas obtenidas por el estudiante 
         * @return Retorna el promedio de las 3 notas recibidas
         Aqui se utiliza el concepto de sobrecarga*/
        public float CalculaPromedio(float nota1, float nota2, float nota3){
            return (nota1 + nota2 + nota3)/3;
        }
        
        /**Metodo que calcula la nota final del estudiante dependiendo de que tipo sea
         *@param prom es la nota del promedio que se le calculo a ese tipo de estudiante
         * @param tipo es el tipo de estudiante al que el estudiante pertenece
         * @return Retorna la nota final del estudiante
         * Aqui se utiliza el concepto de sobrecarga
         */
        public float CalculaPromedio(float prom, String tipo){
            if(tipo.equals("A")){
                return (float) (prom * 0.65 + ((proyecto1 + proyecto2 + proyecto3)/3) * 0.35);
            }else{
                return (float) (prom * 0.35 + ((promTareas + promQuices + promExamenes)/3) * 0.65);
            }
        }
    
    }
    
    
    /**Decalracion de la clase EstudianteTipoA
     *@author Mathiw Rojas
     * @version 15/8/19 
     */
    public class EstudianteTipoA{
        
        //declaracion de los atributos privados
        private float notaPromedioEQT;
        private Estudiante estudiante;
        private float notaFinal;
        
        public EstudianteTipoA(String newCarnet,String newNombre, String newCorreo, String newTel, String newNickname, int newPromE, int newPromQ, int newPromT, int newProyecto1, int newProyecto2, int newProyecto3){
            estudiante = new Estudiante(newCarnet,newNombre, newCorreo, newTel, newNickname, "A", newPromE, newPromQ, newPromT, newProyecto1, newProyecto2, newProyecto3);
            notaPromedioEQT= estudiante.CalculaPromedio(newPromT, newPromE, newPromQ);
            notaFinal = estudiante.CalculaPromedio(notaPromedioEQT, "A");
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
        
        public String getTipoEstudiante(){
            return estudiante.tipoEstudiante;
        }
        
        public float getPromExamenes(){
            return estudiante.promExamenes;
        }
        
        public float getPromQuices(){
            return estudiante.promQuices;
        }
        
        public float getPromTareas(){
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
    
        public float getNotaPromedioEQT(){
            return notaPromedioEQT;
        }
        public float getNotaFinal(){
            return notaFinal;
        }
        
    }
    
    
    
    public class EstudianteTipoB{
        
        private float notaPromedioProyectos;
        private float notaFinal;
        Estudiante estudiante;
        
        public EstudianteTipoB(String newCarnet, String newNombre, String newCorreo, String newTel, String newNickname, int newPromE, int newPromQ, int newPromT, int newProyecto1, int newProyecto2, int newProyecto3){
            estudiante = new Estudiante(newCarnet, newNombre, newCorreo, newTel, newNickname, "B", newPromE, newPromQ, newPromT, newProyecto1, newProyecto2, newProyecto3);
            notaPromedioProyectos = estudiante.CalculaPromedio(newProyecto1, newProyecto2, newProyecto3);
            notaFinal = estudiante.CalculaPromedio(notaPromedioProyectos, "B");
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
        
        public String getTipoEstudiante(){
            return estudiante.tipoEstudiante;
        }
        
        public float getPromExamenes(){
            return estudiante.promExamenes;
        }
        
        public float getPromQuices(){
            return estudiante.promQuices;
        }
        
        public float getPromTareas(){
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
        
        public float getNotaPromedioProyectos(){
            return notaPromedioProyectos;
        }
        
        public float getNotaFinal(){
            return notaFinal;
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
            TableColumn col,colEQT,colProyectos,colFinal;
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
            
            colFinal = new TableColumn("Nota Final");
            colFinal.setCellValueFactory(new PropertyValueFactory<>("notaFinal"));
            colFinal.prefWidthProperty().bind(tableEstudiantes.widthProperty().multiply(0.08));
            tableEstudiantes.getColumns().addAll(colProyectos,colEQT,colFinal);
            
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

