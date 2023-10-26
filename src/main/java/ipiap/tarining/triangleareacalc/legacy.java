package ipiap.tarining.triangleareacalc;

import javafx.fxml.FXML;
/*
public class legacy {
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

    @FXML
    private void calcTrapezia() {
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
    private void calcRectangle() {
        try {
            Rectangle r = new Rectangle(Double.parseDouble(aSideInp.getText()),
                    Double.parseDouble(bSideInp.getText()));
            if (r.a<0||r.b<0)
                throw new NonNaturalValue();
            resultField.setText(String.valueOf(r.area));
        }catch (NumberFormatException | NullPointerException e){
            resultField.setText("Unrecognised values");
        }catch (NonNaturalValue e){
            resultField.setText(e.getMessage());
        }

    }


//        switch (figChoice.getValue()) {
//            case "Triangle":
//                calcTriangle();
//                break;
//            case "Rectangle":
//                calcRectangle();
//                break;
//            case "Trapezium":
//                calcTrapezia();
//                break;
//        }


}


 */