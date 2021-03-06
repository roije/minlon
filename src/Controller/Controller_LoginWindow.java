package Controller;

import Database.DB_LoginHandler;
import View.CurrentStage;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by roije on 23/05/2016.
 */
public class Controller_LoginWindow implements Initializable
{

    private DB_LoginHandler loginHandler = new DB_LoginHandler();

    @FXML
    ImageView loginError;

    @FXML
    Button createAccountBtn;

    @FXML
    Button signInBtn;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    HBox userNameBox;

    final BooleanProperty firstTime = new SimpleBooleanProperty(true); // Variable to store the focus on stage load


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        loginError.setVisible(false);

        //Remove focus from first textfield when window opens
        usernameField.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
            if(newValue && firstTime.get()){
                userNameBox.requestFocus(); // Delegate the focus to container
                firstTime.setValue(false); // Variable value changed for future references
            }
        });
    }

    public void changeToNewAccountWindow() throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLNewAccountPage_Window.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        CurrentStage.getCurrentStage().close();
        CurrentStage.setCurrentStage(stage);
        CurrentStage.showCurrentStage();
    }

    public void loginAction()
    {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (password.isEmpty() || password.isEmpty())
        {
            loginError.setVisible(true);
        }
        else if (loginHandler.userExists(username, password))
        {
            //Set current session user blabla
            //change to next window
            changeToFrontPage();
            loginHandler.updateLoginCount(username);
        }
        else
        {
            loginError.setVisible(true);
        }
    }

    public void clearError()
    {
        loginError.setVisible(false);
    }

    public void changeToFrontPage()
    {
        Stage stage = new Stage();
        Parent root = null;
        try
        {
            root = FXMLLoader.load(getClass().getResource("/View/FXMLFrontPage_Window.fxml"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);

        CurrentStage.getCurrentStage().close();
        CurrentStage.setCurrentStage(stage);
        CurrentStage.showCurrentStage();
    }
}
