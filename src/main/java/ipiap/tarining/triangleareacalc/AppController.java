package ipiap.tarining.triangleareacalc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {

    private ObservableList<String> figures = FXCollections.observableArrayList("Rectangle","Triangle","Trapezia");

    private FigEnum selectedFigure = FigEnum.Triangle;

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
    protected void onCalcButtonClick() {
        calcFigure();
    }



    @FXML
    protected void initialize(){
    figChoice.setItems(figures);
    figChoice.setValue("Triangle");
    figChoice.setOnAction(actionEvent -> figChoiceOnClicAction());

    }
    @FXML
    protected void setVisibility(){
//        cSideInp.setText("");
//        selectedFigure = f
        switch (selectedFigure){
            case Triangle:
                aSideInp.setVisible(true);
                bSideInp.setVisible(true);
                cSideInp.setVisible(true);
                dSideInp.setVisible(false);
                break;
            case Rectangle:
                aSideInp.setVisible(true);
                bSideInp.setVisible(true);
                cSideInp.setVisible(false);
                dSideInp.setVisible(false);
                break;

            case Trapezia:
                aSideInp.setVisible(true);
                bSideInp.setVisible(true);
                cSideInp.setVisible(true);
                dSideInp.setVisible(true);
                break;
        }


        }
    @FXML
    protected void figChoiceOnClicAction(){
        switch (figChoice.getValue()){
            case "Triangle":
                selectedFigure = FigEnum.Triangle;
                break;
            case "Rectangle":
                selectedFigure = FigEnum.Rectangle;
                break;
            case "Trapezia":
                selectedFigure = FigEnum.Trapezia;
                break;
        }
        setVisibility();
    }

    @FXML
    protected void calcFigure(){
        double area =0;
        try {
            switch (selectedFigure) {
                case Triangle:
                    Triangle ti = new Triangle(Double.parseDouble(aSideInp.getText()),
                            Double.parseDouble(bSideInp.getText()),
                            Double.parseDouble(cSideInp.getText()));
                    if (ti.a < 0 || ti.b < 0 || ti.c < 0)
                        throw new NonNaturalValue();
                    area=ti.area;
                    break;
                case Rectangle:
                    Rectangle r = new Rectangle(Double.parseDouble(aSideInp.getText()),
                            Double.parseDouble(bSideInp.getText()));
                    if (r.a<0||r.b<0)
                        throw new NonNaturalValue();
                    area=r.area;
                    break;
                case Trapezia:
                    Trapezium ta = new Trapezium(Double.parseDouble(aSideInp.getText()),
                            Double.parseDouble(bSideInp.getText()),
                            Double.parseDouble(cSideInp.getText()),
                            Double.parseDouble(dSideInp.getText()));
                    if (ta.a<0||ta.b<0||ta.c<0||ta.d<0)
                        throw new NonNaturalValue();
                    area=ta.area;
                    break;
            }
            resultField.setText(String.valueOf(area));
        }catch (NumberFormatException | NullPointerException e){
            resultField.setText("Unrecognised values");
        } catch (NonNaturalValue | IncorrectFigException e) {
            resultField.setText(e.getMessage());
        }

    }

}