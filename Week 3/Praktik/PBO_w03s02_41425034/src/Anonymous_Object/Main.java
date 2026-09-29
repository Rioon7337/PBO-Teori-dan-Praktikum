/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Anonymous_Object;

/*
Nama  : Johannes Rein Gerardo Lumban Tobing
NIM   : 41425034
Prodi : D4 TRPL
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) { launch(args); }
    @Override public static void start(Stage stage) {
        Button button = new Button("Click Me");
        button.setOnAction(
            event
            -> System.out.println(
                "Button clicked!")); //anonymus object melalui lambda
        
        StackPane root = new StackPane (button);
        stage.setSccene(new Scene(root, 300, 200));
        stage.show();
    }
}
