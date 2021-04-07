package Controllers;

import Models.User;
import com.firebase.client.Firebase;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.event.ActionEvent;

import javax.naming.Name;
import java.awt.*;


public class LogIn {
    @FXML
    AnchorPane LogIn, Register;
    @FXML
    TextField FirstName, LastName, Username, Birthdate, Email, Number;
    @FXML
    TextArea Address;
    @FXML
    PasswordField Password, ReenterPassword;

    private void LogInScreen(){
        //this code basically moves the anchorpane lang, no need to set false
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1),LogIn);
        translateTransition.setByX(-600);
        translateTransition.play();
        //just to pause
        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1),Register);
        translateTransition2.setByX(427);
        translateTransition2.play();
    }

    public void RegisterAction(ActionEvent actionEvent){
        Firebase firebase = new Firebase("https://lbycpd2-grp2-default-rtdb.firebaseio.com/");
        User register = new User();
        register.setUsername(Username.getText());
        register.setPassword(Password.getText());
        register.setFirstName(FirstName.getText());
        register.setLastName(LastName.getText());
        register.setReenterPass(ReenterPassword.getText());
        register.setBirthday(Birthdate.getText());
        register.setContactNumber(Number.getText());
        register.setEmail(Email.getText());
        register.setAddress(Address.getText());
        firebase.child("User").push().setValue(register);
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

