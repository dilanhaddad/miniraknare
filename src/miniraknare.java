import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class miniraknare extends Application {

    TextField inputField;
    ArrayList<Button> numpad;
    GridPane numpadLayout;
    HBox utilContainer;
    BorderPane mainLayout;
    VBox displayLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Kalkulatorn");

      initField();

      displayLayout.getChildren().add(inputField);

      mainLayout.setTop(displayLayout);
      mainLayout.setCenter(numpadLayout);
      mainLayout.setBottom(utilContainer);

        Scene scene = new Scene(mainLayout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initField(){
        inputField = new TextField();
        numpad = new ArrayList<Button>();
        numpadLayout = new GridPane();
        utilContainer = new HBox();
        displayLayout = new VBox();
        mainLayout = new BorderPane();
    }

    private void displayNunmpadButtons(){
        int buttonIndex = 0;
        for (int rowIndex = 0; rowIndex < 5; rowIndex++){
            for (int columnIndex = 0; columnIndex <3; columnIndex++){
                numpadLayout.add(numpad.get(buttonIndex), columnIndex, rowIndex);
                buttonIndex++;
                if (buttonIndex == numpad.size())
                    break;
            }
        }
    }

    private void populateNumpad (){
        char[] numpadKeys = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ',', '-', '+', '*'};

        for (char key : numpadKeys) {
            String keyText = key + "";
            Button tempButton = new Button(keyText);
            tempButton.setId(keyText);
            tempButton.setOnAction(event -> {
                inputField.textProperty().set(inputField.textProperty().get() + keyText);
            });
            numpad.add(tempButton);
        }

    }



}
