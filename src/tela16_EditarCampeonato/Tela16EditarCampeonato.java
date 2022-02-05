package tela16_EditarCampeonato;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tela16EditarCampeonato extends Application{
    private static Stage stage; 

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/tela16_EditarCampeonato/EditarCampeonatoFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Tela16EditarCampeonato.stage = stage;
    }   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}