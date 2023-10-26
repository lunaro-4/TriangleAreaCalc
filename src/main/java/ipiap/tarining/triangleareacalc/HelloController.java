package ipiap.tarining.triangleareacalc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    private ObservableList<String> figures = FXCollections.observableArrayList("Triangle","Trapezium");

    @FXML
    private TextField aSideInp;

    @FXML
    private TextField bSideInp;

    @FXML
    private TextField cSideInp;

    @FXML
    private ChoiceBox<String> figChoice;

    @FXML
    private Button calculate;

    @FXML
    private Label resultField;



    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onCalcButtonClick(){
        if (figChoice.getValue().equals("Triangle"))
            calcTriangle();
        else if (figChoice.getValue().equals("Trapezium"))
            calcTrapezium();
    }

    @FXML
    private void calcTrapezium() {
        try {
            Trapezium t = new Trapezium(Double.parseDouble(aSideInp.getText()),
                    Double.parseDouble(bSideInp.getText()),
                    Double.parseDouble(cSideInp.getText()));
            resultField.setText(String.valueOf(t.area));
        }catch (Exception e){
            resultField.setText("Unrecognised values");
        }

    }

    @FXML
    protected void initialize(){
    figChoice.setItems(figures);
    figChoice.setValue("Triangle");
    figChoice.setOnAction(actionEvent -> setDisc());

    }
    @FXML
    protected void setDisc(){
        cSideInp.setText("");
        switch (figChoice.getValue()){
            case "Triangle": cSideInp.setPromptText("c side length");
            break;
            case "Trapezium":  cSideInp.setPromptText("trapezium height");
            break;
        }

        }
    @FXML
    protected void calcTriangle(){
        try {
            Triangle t = new Triangle(Double.parseDouble(aSideInp.getText()),
                    Double.parseDouble(bSideInp.getText()),
                    Double.parseDouble(cSideInp.getText()));
            resultField.setText(String.valueOf(t.area));
        }catch (Exception e){
            resultField.setText("Unrecognised values");
        }
    }
}