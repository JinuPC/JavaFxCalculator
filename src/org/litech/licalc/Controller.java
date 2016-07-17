package org.litech.licalc;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.litech.licalc.Main;

public class Controller {
    private double xOffset;
    private double yOffset;
    private CalcModel calc = new CalcModel();
    private boolean initialState = true;
    private String operator = "";
    private String firstNumber = "0";
    private String secondNumber = "0";
    //getting PrimaryStage
    Stage primaryStage = Main.pStage;

    @FXML
    private TextField outputBox;
    /*
     * Method for getting current Window Position
     */
    public void mouseClickedaction(MouseEvent event) {
        xOffset = primaryStage.getX() - event.getScreenX();
        yOffset = primaryStage.getY() - event.getScreenY();
    }
    /*
     * Method for moving window to new Location while dragging
     */
    public void mouseDraggedaction(MouseEvent event) {
        primaryStage.setX(event.getScreenX() + xOffset);
        primaryStage.setY(event.getScreenY() + yOffset);
    }

    /*
     * Method for closing the program
     */
    public void closeProgram() {
        Platform.exit();
    }

    /*
     * Method for change button color while mouse over
     */
    public void animateButton(MouseEvent event) {
        Button currentButton =(Button)event.getSource();
        currentButton.setStyle("-fx-background-color:grey");
    }

    /*
     * Method for reset button color while mouse out
     */
    public void ResetButtonAnimation(MouseEvent event) {
        Button currentButton =(Button)event.getSource();
        currentButton.setStyle("-fx-background-color:white");
    }

    /*
     * Method for Processing the Number
     */
    @FXML
    public void performNumber(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if(initialState) {
            outputBox.setText(value);
            if(value.equals("0"))
                initialState = true;
            else
                initialState = false;
            return;
        }
        outputBox.setText(outputBox.getText() + value);
    }

    /*
     * Method for Processing the operations
     */
    public void performControl(ActionEvent event) {
        String control = ((Button)event.getSource()).getText();
        if(control.equals("R")) {
            initialState = true;
            outputBox.setText("0");
            firstNumber = "0";
            secondNumber = "0";
            operator = "";
            return;
        }
        if(control.equals("=")){
            if(operator.isEmpty() || initialState)
            {
                return;
            }
            else
            {
                secondNumber = outputBox.getText();
                long output = calc.doTask(firstNumber,secondNumber,operator);
                outputBox.setText("" + output);
                initialState = true;
            }
        }
        else {
            operator = control;
            firstNumber = outputBox.getText();
            initialState = true;
        }

    }
}