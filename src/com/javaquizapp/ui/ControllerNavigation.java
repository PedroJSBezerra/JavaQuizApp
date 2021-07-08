package com.javaquizapp.ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ControllerNavigation {
    @FXML
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void navigation(ActionEvent event) throws IOException{
        
        String dados = ((Button)event.getSource()).getId();
            
        switch(dados){ 
            default:
            case "buttonStart":
                showScreen(event,"PageStart.fxml");
                break;
            case "buttonRestart":
            case "buttonRegister":
                showScreen(event,"PageRegister.fxml");
                break;

            case "buttonGameStart":
                playerRegister(event);
                showScreen(event,"PageGame.fxml");
                break;
            case "buttonRank":
                showScreen(event,"PageRank.fxml");
                break;
            case "buttonCredits":
                showScreen(event,"PageCredits.fxml");
                break;
            case "buttonLogout":
                exitScreen(event);
            break;
        }
    }
    private void showScreen(ActionEvent event,String dados) throws IOException{
        root = FXMLLoader.load(getClass().getResource(dados));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void exitScreen(ActionEvent event) throws IOException{   
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Seus dados não foram salvos!");
        alert.setContentText("Deseja sair agora?");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            System.out.println("You successfully logged out!");
            stage.close();
        }
    }

    private void playerRegister(ActionEvent event) {
        String name = "Alicia";
        String category = "news";
        System.out.println("O nome do jogador é: "+name+"\n"+"A categoria escolhida foi:"+category);
    }
}
