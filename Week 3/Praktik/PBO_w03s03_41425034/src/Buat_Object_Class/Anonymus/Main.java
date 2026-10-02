/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buat_Object_Class.Anonymus;

/**
 *
 * @author ASUS
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) { launch(args); }
    //Method start tidak boleh static karena method static tidak dapat di override
    @Override public void start(Stage stage) {
        Button button = new Button("Click Me");
        button.setOnAction(
            event
            -> System.out.println(
                "Button clicked!")); //anonymus object melalui lambda
        
        StackPane root = new StackPane (button);
        stage.setScene(new Scene(root, 300, 200));
        stage.show();
    }
}
