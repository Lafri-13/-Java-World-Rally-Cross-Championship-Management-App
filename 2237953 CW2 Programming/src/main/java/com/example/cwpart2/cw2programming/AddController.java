package com.example.cwpart2.cw2programming;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ArrayList;


public class AddController {

    driversList dList = new driversList();
    //creating a new object of the class driversList and referencing that new object to dList.

    String existDriver;
    @FXML
    private TextField add_name;
    @FXML
    private TextField add_age;
    @FXML
    private TextField add_team;
    @FXML
    private TextField add_car;

    @FXML
    private TextField add_points;

    @FXML
    private Label addMessage;

    @FXML
    private Label driverDetailsText;

    @FXML
    protected void onAddControllerButtonClick(ActionEvent actionEvent) throws Exception {
        // .setText() is to print a message
        // getText() is to take an input
        if (add_name.getText().isEmpty() && add_age.getText().isEmpty() && add_team.getText().isEmpty() && add_car.getText().isEmpty() && add_points.getText().isEmpty()) {
            addMessage.setText("Please fill the fields and then Click ADD!");
            // Check and print a message if fields are not filled
        }
        else if (add_name.getText().isEmpty() || add_age.getText().isEmpty() || add_team.getText().isEmpty() || add_car.getText().isEmpty() || add_points.getText().isEmpty()) {
            addMessage.setText("Fill all fields without a blank field!");
            // check and print an error message at least one field is empty.
        }
        else if(!(add_age.getText().isEmpty() || add_points.getText().isEmpty())){ // ! is not
            try {
                int Age = Integer.parseInt(add_age.getText());
                int Points = Integer.parseInt(add_points.getText());
                //Integer.parseInt is to change the String value to integer.

                if ((Age < 18) || (Points < 0)) {
                    throw new Exception();
                    // check the age and points
                }
                if(existName(add_name.getText())){ //Calling Method existName() to check the driver name is already there or not
                    driverDetailsText.setText(existDriver);
                    // calling existDriver method in driverDetailsText Label to display exist driver
                    addMessage.setText("Driver Name Already Exists");
                    // Print the message in addMessage Label
                }
                else {
                    addDriversDetails();
                    // if there is no exist driver name addDriversDetails() method will be called
                }
            }
            catch (RuntimeException e){
                addMessage.setText("Age and Points can be added only in Integer..");
                // Print the message in addMessage Label
            }
            catch (Exception f){
                addMessage.setText("Points must be 0 or greater and Age must be 18 or greater");
                // Print the message in addMessage Label
            }
        }
    }

    public void addDriversDetails() {
        ArrayList<String> add_List = new ArrayList();
        add_List.add(add_name.getText());
        add_List.add(add_age.getText());
        add_List.add(add_team.getText());
        add_List.add(add_car.getText());
        add_List.add(add_points.getText()); // adding the detail to the add_list
        driversList.drivers_List.add(add_List); // adding the add_list to the drivers_list
        System.out.println(driversList.drivers_List);
        String details = add_name.getText() + " || " + add_age.getText() + " || " + add_team.getText() + " || " + add_car.getText() + " || " + add_points.getText();
        driverDetailsText.setText(details);
        addMessage.setText("Added Successfully");
    }

    public boolean existName(String existDriverName) {
        boolean findName = false; // initially assumes there is no driver with the same name
        for (int check = 0; check < driversList.drivers_List.size(); check++) {
            if (existDriverName.equals(driversList.drivers_List.get(check).get(0))) { //to check the name is already there or not
                existDriver = "Name in use : "+ driversList.drivers_List.get(check).get(0) + " || " + driversList.drivers_List.get(check).get(1) + " || " + driversList.drivers_List.get(check).get(2) + " || " + driversList.drivers_List.get(check).get(3) + " || " + driversList.drivers_List.get(check).get(4);
                findName = true; // after find the driver with the same name
            }
        }
        return findName; // if true returned this will print exist driver
    }

    @FXML
    protected void onAddToMenuButtonClick(ActionEvent actionEvent) throws Exception {
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
