package ipiap.tarining.triangleareacalc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {

    private ObservableList<String> figures = FXCollections.observableArrayList("Triangle","Trapezium");

    @FXML
    private TextField aSideInp;

    @FXML
    private TextField bSideInp;

    @FXML
    private TextField cSideInp;

    @FXML
    private TextField dSideInp;

    @FXML
    private ChoiceBox<String> figChoice;

    @FXML
    private Button calculate;

    @FXML
    private Label resultField;



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
                    Double.parseDouble(cSideInp.getText()),
                    Double.parseDouble(dSideInp.getText()));
            if (t.a<0||t.b<0||t.c<0)
                throw new NonNaturalValue();
            resultField.setText(String.valueOf(t.area));
        }catch (NumberFormatException | NullPointerException e){
            resultField.setText("Unrecognised values");
        }catch (IncorrectFigException | NonNaturalValue e){
            resultField.setText(e.getMessage());
        }

    }

    @FXML
    protected void initialize(){
    figChoice.setItems(figures);
    figChoice.setValue("Triangle");
    figChoice.setOnAction(actionEvent -> setVisibility());

    }
    @FXML
    protected void setVisibility(){
//        cSideInp.setText("");
        switch (figChoice.getValue()){
            case "Triangle":    dSideInp.setVisible(false);
            break;
            case "Trapezium":   dSideInp.setVisible(true);
            break;
        }

        }
    @FXML
    protected void calcTriangle(){
        try {
            Triangle t = new Triangle(Double.parseDouble(aSideInp.getText()),
                    Double.parseDouble(bSideInp.getText()),
                    Double.parseDouble(cSideInp.getText()));
            if (t.a<0||t.b<0||t.c<0)
                throw new NonNaturalValue();
            resultField.setText(String.valueOf(t.area));
        }catch (NumberFormatException | NullPointerException e){
            resultField.setText("Unrecognised values");
        } catch (NonNaturalValue | IncorrectFigException e) {
            resultField.setText(e.getMessage());
        }
    }
}