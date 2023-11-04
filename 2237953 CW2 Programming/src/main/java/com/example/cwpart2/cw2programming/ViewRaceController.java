package com.example.cwpart2.cw2programming;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ViewRaceController {
    driversList dList = new driversList();
    //creating a new object of the class driversList and referencing that new object to dList.

    @FXML
    private ScrollPane viewRaces;
    @FXML
    private Label loadedDetails ;
    @FXML
    String line = null;
    @FXML
    String x;
    @FXML
    protected void onViewControllerButtonClick(ActionEvent actionEvent) throws Exception {
        // .setText() is to print a message
        // getText() is to take an input
        // Reference : https://www.w3schools.com/java/java_files_read.asp
        ScrollPane scroll = new ScrollPane(); // To create a scroll bar
        try{
            FileReader races = new FileReader("src/main/java/com/example/cwpart2/cw2programming/viewRace.txt");
            // To read all the contents inside the file
            BufferedReader lineReader = new BufferedReader(races);
            // To read the contents line by line inside the file
            StringBuilder newLine = new StringBuilder();
            // to Append each line of the content read by the Buffered reader
            while((line = lineReader.readLine())!=null){
                newLine.append(line).append("\n"); // appending part
            }
            loadedDetails.setText(String.valueOf(newLine));
            viewRaces.setContent(loadedDetails);
            viewRaces.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            viewRaces.setFitToHeight(true);
            viewRaces.setFitToWidth(true);
            lineReader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred");
        }
    }
    @FXML
    protected void onViewRaceToMenuButtonClick(ActionEvent actionEvent) throws Exception {
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
