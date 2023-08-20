package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginFormController {
    public AnchorPane root;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public Button btnLogin;
    public Label lblUserNameHint;
    public Label lblPasswordHint;
    public Label lblStatus;

    public void initialize(){

        btnLogin.setDefaultButton(true);

        /*
        To display a control => setVisible(true)
        To hide a control => setVisible(false)
         */

        lblUserNameHint.setVisible(false);
        lblPasswordHint.setVisible(false);
        lblStatus.setText("-");

        txtUserName.setOnAction( e -> {



        });
    }

    public void btnLoginOnAction(ActionEvent e) {

        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        lblUserNameHint.setVisible(true);
        if(userName.isBlank()){
            lblUserNameHint.setText("Username can't be empty");
        } else if (containsDigit(userName)) {
            lblUserNameHint.setText("Username can't contains any digits");
        } else if (!userName.equals("admin")){
            lblUserNameHint.setText("Username doesn't exist");
        } else {
            lblUserNameHint.setVisible(false);
        }

        lblPasswordHint.setVisible(true);
        if(password.isBlank()){
            lblPasswordHint.setText("Password can't be empty");
        } else if (!isVaidPasswordFormat(password)) {
            lblPasswordHint.setText("Invalid password format");
        } else if (!password.equals("Dep11")) {
            lblPasswordHint.setText("Password mismatch error");
        } else {
            lblPasswordHint.setVisible(false);
        }

        if(userName.equals("admin") && password.equals("Dep11")){
            lblStatus.setText("Authenticated!");
        } else {
            lblStatus.setText("Access Denied!");
        }
    }
    public static boolean containsDigit(String input){
        for (int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))) return true;
        }
        return false;
    }

    public static boolean isVaidPasswordFormat(String password){
        boolean upperCaseLetter = false;
        boolean lowerCaseLetter = false;
        boolean digits = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(upperCaseLetter && lowerCaseLetter && digits) break;
            if(Character.isUpperCase(c)) upperCaseLetter = true;
            if(Character.isLowerCase(c)) lowerCaseLetter = true;
            if (Character.isDigit(c)) digits = true;
        }
        return upperCaseLetter && lowerCaseLetter && digits && password.length() >=4;
    }
}
