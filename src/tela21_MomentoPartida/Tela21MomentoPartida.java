package tela21_MomentoPartida;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tela21MomentoPartida extends Application{

    private static Stage stage; 

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/tela21_MomentoPartida/MomentoPartidaFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Tela21MomentoPartida.stage = stage;
    }   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}