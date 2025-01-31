package com.example.informesgabrielaworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase Main: contiene los métodos necesarios para lanzar la aplicación de JavaFX. Extiende de {@link Application}
 *
 * @author Gabriela Jiménez Morcillo
 * @version 1.0
 */
public class Main extends Application {
    /**
     * El método start: contiene los parámetros necesarios para conifgurar la ventana de la aplicaición
     * Carga el archivo XML, las dimensiones de la ventana y le da un título a la ventana
     *
     * @param stage es el parámetro que representa la ventana principal de la aplicación
     * @throws IOException se lanza la excepción si ocurre algún error al cargar el archivo XML
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("informe-vista.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 549, 395);
        InformeController controller = fxmlLoader.getController();
        stage.setTitle("Generar Informes");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * El método main: lanza la aplicación JavaFX.
     * @param args Argumentos
     */
    public static void main(String[] args) {
        launch();
    }
}