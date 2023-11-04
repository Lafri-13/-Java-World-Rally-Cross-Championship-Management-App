package com.example.cwpart2.cw2programming;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class LoadController {
    driversList dList = new driversList();
    //creating a new object of the class driversList and referencing that new object to dList.

    @FXML
    private Label loadedDetails;
    @FXML
    String line = null;
    @FXML
    String x;
    @FXML
    protected void onLoadControllerButtonClick(ActionEvent actionEvent) throws Exception {
        // .setText() is to print a message
        // getText() is to take an input
        // Reference : https://www.w3schools.com/java/java_files_read.asp
        try{
            FileReader drivers = new FileReader("src/main/java/com/example/cwpart2/cw2programming/driversDetails.txt");
            BufferedReader lineReader = new BufferedReader(drivers);
            StringBuilder newLine = new StringBuilder();
            while((line = lineReader.readLine())!=null){
                newLine.append(line).append("\n");
            }
            loadedDetails.setText(String.valueOf(newLine));
            lineReader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred");
        }

    }
    @FXML
    protected void onGoToUpdateButtonClick(ActionEvent actionEvent) throws Exception {
        updateNavigation(actionEvent);
        // calling the method to navigate back to menu on the button click
    }

    public void updateNavigation(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Update.fxml"));
        newStage.setScene(new Scene(root,640, 582));
        newStage.show();

        Stage previuosStage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previuosStage.close(); // closes the previous stage
    }
    @FXML
    protected void onLoadToMenuButtonClick(ActionEvent actionEvent) throws Exception {
        menuNavigation(actionEvent);
        // calling the method to navigate back to menu on the button click
    }

    public void menuNavigation(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        newStage.setScene(new Scene(root,640, 582));
        newStage.show();

        Stage previuosStage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previuosStage.close(); // closes the previous stage
    }
}
