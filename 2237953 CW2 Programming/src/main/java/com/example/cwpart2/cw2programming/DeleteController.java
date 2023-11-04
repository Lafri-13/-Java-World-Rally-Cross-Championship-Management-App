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
public class DeleteController {

    driversList dList = new driversList();
    //creating a new object of the class driversList and referencing that new object to dList.
    @FXML
    private Label deleteMessage;

    @FXML
    private TextField delete_driver;

    @FXML
    protected void onDeleteControllerButtonClick(ActionEvent actionEvent) throws Exception {
        // .setText() is to print a message
        // getText() is to take an input
        if (delete_driver.getText().isEmpty()) {
            deleteMessage.setText("Please fill the field and then Click Delete!");
            // Check and print a message if fields are not filled
        } else if (!(delete_driver.getText().isEmpty())) { //! is not

                for (int check = 0; check < driversList.drivers_List.size(); check++) {
                    if (!(delete_driver.getText().equals(driversList.drivers_List.get(check).get(0)))) {// checking that the deleting driver was there or not
                        deleteMessage.setText("Driver doesn't exist.");
                    }
                    else{
                        deleteDriversDetails(); // calling the delete method
                    }
            }
        }
     }

    public void deleteDriversDetails() {
        for (int check = 0; check < driversList.drivers_List.size(); check++) {
            if (delete_driver.getText().equals(driversList.drivers_List.get(check).get(0))) {// checking that the deleting driver was there or not
                driversList.drivers_List.remove(check); // removes from the list
                deleteMessage.setText("Driver deleted Successfully");
                // Print the message in deleteMessage Label
                System.out.println(driversList.drivers_List);

            }
        }
    }

    @FXML
    protected void onDeleteToMenuButtonClick(ActionEvent actionEvent) throws Exception {
        menuNavigation(actionEvent);
        // calling the method to navigate back to menu on the button click
    }

    @FXML
    public void menuNavigation(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        newStage.setScene(new Scene(root,640, 582));
        newStage.show();

        Stage previuosStage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previuosStage.close(); // closes the previous stage
    }
}
