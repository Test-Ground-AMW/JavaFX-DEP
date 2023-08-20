package lk.ijse.dep11;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainFormController {

    public ImageView imvDog;
    @FXML
    private Button btnValidate;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtNIC;

    public void initialize(){
        btnValidate.setOnMouseClicked( e -> {
            System.out.println("Click Kala...!");
        });

        txtNIC.setOnKeyPressed( e -> {
            System.out.println("Ebuwa....");
        });

        txtNIC.setOnKeyReleased( e -> {
            System.out.println("Isuwa");
        });

        root.setCursor(Cursor.NONE);
        root.setOnMouseMoved( e -> {
            imvDog.setLayoutX(e.getX() - imvDog.getFitWidth()/2);
            imvDog.setLayoutY(e.getY() - imvDog.getFitHeight()/2);
            System.out.printf("x = %.2f, y = %.2f \n",e.getX(),e.getY());
        });
    }

}
