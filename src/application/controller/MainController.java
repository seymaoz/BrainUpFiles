package application.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import application.Main;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainController extends Main{
	Main yes;
	@FXML private Button signup;
	@FXML private Button login;
	@FXML private TextField username;
	@FXML private PasswordField pass;
	
	@FXML protected void handleSignUp(ActionEvent event) throws Exception {
		Stage stage;
		Parent root;
		
		stage = (Stage) signup.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		
	}
	
}
