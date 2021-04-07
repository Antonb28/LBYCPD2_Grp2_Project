package Controllers;

import com.firebase.client.Firebase;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.event.ActionEvent;


public class LogIn {
    @FXML
    AnchorPane LogIn, Register;

    void LogInScreen(){
        //this code basically moves the anchorpane lang, no need to set false
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1),LogIn);
        translateTransition.setByX(-600);
        translateTransition.play();
        //just to pause
        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1),Register);
        translateTransition2.setByX(427);
        translateTransition2.play();
    }

    public void Register(ActionEvent actionEvent){
        //for this part put the pop up box?? to confirm if all info is correct
        LogInScreen();
    }

    public void RegisterScreen(ActionEvent actionEvent) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1),LogIn);
        translateTransition.setByX(600);
        translateTransition.play();
        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1),Register);
        translateTransition2.setByX(-427);
        translateTransition2.play();
    }
}

