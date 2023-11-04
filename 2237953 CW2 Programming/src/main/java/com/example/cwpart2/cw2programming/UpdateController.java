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


public class UpdateController {
    driversList dList = new driversList();
    //creating a new object of the class driversList and referencing that new object to dList.

    String existDriver;

    @FXML
    private TextField exist_name;
    @FXML
    private TextField update_name;
    @FXML
    private TextField update_age;
    @FXML
    private TextField update_team;
    @FXML
    private TextField update_car;

    @FXML
    private TextField update_points;

    @FXML
    private Label updateMessage;

    @FXML
    private Label driverDetailsText;
    @FXML
    protected void onFindControllerButtonClick(ActionEvent actionEvent) throws Exception {
        // .setText() is to print a message
        // getText() is to take an input
        if (exist_name.getText().isEmpty()) {
            updateMessage.setText("Please add a name To update");
            // Check and print a message if fields are not filled
        } else if (!(exist_name.getText().isEmpty())) { //! is not

            for (int check = 0; check < driversList.drivers_List.size(); check++) {
                if (exist_name.getText().equals(driversList.drivers_List.get(check).get(0))) {// checking that the deleting driver was there or not
                    updateMessage.setText("Driver found");
                    findDriversDetails();
                } else {
                    updateMessage.setText("Driver name not exist");
                    // Print the message in addMessage Label
                }
            }
        }
    }

        @FXML
        protected void onUpdateControllerButtonClick(ActionEvent actionEvent) throws Exception {
            if (update_name.getText().isEmpty() && update_age.getText().isEmpty() && update_team.getText().isEmpty() && update_car.getText().isEmpty() && update_points.getText().isEmpty()) {
                updateMessage.setText("First Find the driver");
                // Check and print a message if fields are not filled
            }
       if(!(update_age.getText().isEmpty() || update_points.getText().isEmpty())){ // ! is not
            try {
                int Age = Integer.parseInt(update_age.getText());
                int Points = Integer.parseInt(update_points.getText());
                //Integer.parseInt is to change the String value to integer.

                if ((Age < 18) || (Points < 0)) {
                    throw new Exception();
                    // check the age and points
                }
                if(existName(update_name.getText())){ //Calling Method existName() to check the driver name is already there or not
                    driverDetailsText.setText(existDriver);
                    // calling existDriver method in driverDetailsText Label to display exist driver
                    updateMessage.setText("Driver Name Already Exists");
                    // Print the message in addMessage Label
                }
                else {
                    updateDriversDetails();
                    // if there is no exist driver name addDriversDetails() method will be called
                }
            }
            catch (RuntimeException e){
                updateMessage.setText("Age and Points can be added only in Integer..");
                // Print the message in addMessage Label
            }
            catch (Exception f){
                updateMessage.setText("Points must be 0 or greater and Age must be 18 or greater");
                // Print the message in addMessage Label
            }
       }

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

    public void findDriversDetails() {

        for (int check = 0; check < driversList.drivers_List.size(); check++) {
            if (exist_name.getText().equals(driversList.drivers_List.get(check).get(0))) {// checking that the deleting driver was there or not
                update_name.setText((String) driversList.drivers_List.get(check).get(0));
                update_age.setText((String) driversList.drivers_List.get(check).get(1));
                update_team.setText((String) driversList.drivers_List.get(check).get(2));
                update_car.setText((String) driversList.drivers_List.get(check).get(3));
                update_points.setText((String) driversList.drivers_List.get(check).get(4));
                driversList.drivers_List.remove(check);

            }
        }
    }
    public void updateDriversDetails() {
        ArrayList<String> add_List = new ArrayList();
        add_List.add(update_name.getText());
        add_List.add(update_age.getText());
        add_List.add(update_team.getText());
        add_List.add(update_car.getText());
        add_List.add(update_points.getText()); // adding the detail to the add_list
        driversList.drivers_List.add(add_List); // adding the add_list to the drivers_list
        System.out.println(driversList.drivers_List);
        String details = update_name.getText() + " || " + update_age.getText() + " || " + update_team.getText() + " || " + update_car.getText() + " || " + update_points.getText();
        driverDetailsText.setText(details);
        updateMessage.setText("Added Successfully");
    }


    @FXML
    protected void onUpdateToMenuButtonClick(ActionEvent actionEvent) throws Exception {
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
