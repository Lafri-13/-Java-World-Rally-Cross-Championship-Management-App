package com.example.cwpart2.cw2programming;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StandingTableController implements Initializable {

    @FXML
    private TableColumn<driverClass, String> car;

    @FXML
    private TableColumn<driverClass, String> name;

    @FXML
    private TableColumn<driverClass, Integer> points;

    @FXML
    private TableColumn<driverClass, Integer> position;

    @FXML
    private TableView<driverClass> table;

    @FXML
    private TableColumn<driverClass, String> team;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        name.setCellValueFactory(new PropertyValueFactory<driverClass, String>("name"));
        position.setCellValueFactory(new PropertyValueFactory<driverClass, Integer>("position"));
        team.setCellValueFactory(new PropertyValueFactory<driverClass, String>("team"));
        car.setCellValueFactory(new PropertyValueFactory<driverClass, String>("car"));
        points.setCellValueFactory(new PropertyValueFactory<driverClass, Integer>("points"));

        ObservableList<driverClass> list = FXCollections.observableArrayList();

        for (int i=0; i<driversList.drivers_List.size(); i++){
            list.addAll( new driverClass((String) driversList.drivers_List.get(i).get(0), i+1, (String) driversList.drivers_List.get(i).get(2), (String) driversList.drivers_List.get(i).get(3), Integer.parseInt((String) driversList.drivers_List.get(i).get(4))));
        }


        table.setItems(list);

    }

    @FXML
    protected void onTableToMenuButtonClick(ActionEvent actionEvent) throws Exception {
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

