package Controllers;

import Models.User;
import com.firebase.client.Firebase;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.event.ActionEvent;

import javax.naming.Name;
import java.awt.*;


public class LogIn {
    @FXML
    AnchorPane LogIn, Register, UserInfo;
    @FXML
    TextField FirstName, LastName, Username, Birthdate, Email, Number, Gender;
    @FXML
    TextArea Address, Conditions;
    @FXML
    PasswordField Password, ReenterPassword;
    @FXML
    public Button Next;
    int count = 0;

    public void RegisterAction(ActionEvent actionEvent){
        Reset();
        Write();
    }

    public void Next(ActionEvent actionEvent){
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1),Register);
        translateTransition.setByX(-380);
        translateTransition.play();
        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1),UserInfo);
        translateTransition2.setByX(-380);
        translateTransition2.play();
        Next.setDisable(true);
        count = 1;
    }

    public void Back(ActionEvent actionEvent){
        if(count == 0) {
            //this code basically moves the anchor panes lang, no need to set false
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), LogIn);
            translateTransition.setByX(-380);
            translateTransition.play();
            //just to pause
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1), Register);
            translateTransition2.setByX(380);
            translateTransition2.play();
            count = 0;
        }
        else{
            Reset();
        }
    }

    public void RegisterScreen(ActionEvent actionEvent) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1),LogIn);
        translateTransition.setByX(380);
        translateTransition.play();
        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1),Register);
        translateTransition2.setByX(-380);
        translateTransition2.play();
        Next.setDisable(false);
    }

    private void Reset(){
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), LogIn);
        translateTransition.setByX(-380);
        translateTransition.play();
        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1), Register);
        translateTransition2.setByX(760);
        translateTransition2.play();
        TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(1), UserInfo);
        translateTransition3.setByX(380);
        translateTransition3.play();
        count = 0;
    }
    private void Write(){
        Firebase firebase = new Firebase("https://lbycpd2-grp2-default-rtdb.firebaseio.com/");
        User model = new User();
        model.setUsername(Username.getText());
        model.setPassword(Password.getText());
        model.setFirstName(FirstName.getText());
        model.setLastName(LastName.getText());
        model.setReenterPass(ReenterPassword.getText());
        model.setBirthday(Birthdate.getText());
        model.setContactNumber(Number.getText());
        model.setEmail(Email.getText());
        model.setAddress(Address.getText());
//        model.setGender(Gender.getText());
//        model.setCondition(Conditions.getText());
        firebase.child("User").push().setValue(model);
    }
}

