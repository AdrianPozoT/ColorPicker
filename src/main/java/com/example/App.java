package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 600);

        root.setPadding(new Insets(20, 20, 20, 20));

        root.setCenter(createVBox());

        primaryStage.setTitle("COLOR PICKER");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    
    public VBox createVBox (){
        
        VBox vbox = new VBox();
        vbox.setPrefSize(50, 70);
        vbox.setSpacing(10);

        Button btnSeleccion = new Button("Guardar");
        btnSeleccion.setPrefSize(70, 30);
        
        DatePicker datePicker = CreateDatePicker();
        ColorPicker colorPicker = CreateColorPicker();


        vbox.getChildren().add(CreateLabel("Selecciona una Fecha: "));
        vbox.getChildren().add(datePicker);
        vbox.getChildren().add(CreateLabel("Selecciona un Color: "));
        vbox.getChildren().add(colorPicker);
        vbox.getChildren().add(btnSeleccion);

        btnSeleccion.setOnAction(e->{
            LocalDate selectDate = datePicker.getValue();
            if (selectDate != null){
                String dateString = selectDate.toString();
                System.out.println("La fecha seleccionada es: " + dateString);
            } else {
                System.out.println("La fecha es nula");
            }


            Color selectColor = colorPicker.getValue();
            if (selectColor != null){
                String coloString = "#" + selectColor.toString().substring(2, 8);
                System.out.println("El color seleccionado es: " + coloString);
            } else {
                System.out.println("El color es nulo");
            }

        }); 


        //vbox.setStyle(style);



        return vbox;
    }    
    

    public Label CreateLabel (String texto){
        Label lblFecha = new Label(texto);
        lblFecha.setFont(Font.font("Time New Roman", 15));
        String style = "-fx-font-weigth: bold; -fx-font-style: italic";
        lblFecha.setStyle(style);

        return lblFecha;
    }    

    public DatePicker CreateDatePicker (){
        DatePicker dtFecha = new DatePicker();
        dtFecha.setPrefSize(100, 80);
        String style = "-fx-background-color: FF0000FF";
        dtFecha.setStyle(style);
        
        return dtFecha;
    }    

    public ColorPicker CreateColorPicker (){
        ColorPicker clColor = new ColorPicker();
        clColor.setPrefSize(100, 100);

        return clColor;
    }    



}