package com.example.cwpart2.cw2programming;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class MenuController {
    driversList dList = new driversList();
    //creating a new object of the class driversList and referencing that new object to dList.
    int day = 1;
    @FXML
    private Label menuMessage;

    @FXML
    protected void onAddButtonClick(ActionEvent actionEvent) throws Exception {
        menuMessage.setText("  ");
        addNavigation(actionEvent);
    }

    @FXML
    protected void onDeleteButtonClick(ActionEvent actionEvent) throws Exception {
        menuMessage.setText("  ");
        deleteNavigation(actionEvent);
    }

    @FXML
    protected void onUpdateButtonClick(ActionEvent actionEvent) throws Exception {
        menuMessage.setText("  ");
        updateNavigation(actionEvent);
    }

    @FXML
    protected void onTableButtonClick(ActionEvent actionEvent) throws Exception  {
        menuMessage.setText("  ");
        bubbleSort(driversList.drivers_List);
        System.out.println(driversList.drivers_List);
        standingTableNavigation(actionEvent);
    }

    @FXML
    protected void onRaceButtonClick() {
        try{
            FileWriter viewRace = new FileWriter("src/main/java/com/example/cwpart2/cw2programming/viewRace.txt", true);
            String[] locations = {"Nyirad", "Holjes", "Montalegre", "Barcelona", "Riga", "Norway"};
            viewRace.write("\n\n");
            viewRace.write("\t\tLocation : ");
            viewRace.write(locations[new Random().nextInt(6)]);
            viewRace.write(" \t\t\tRace on : 2023 MAY ");
            viewRace.write(String.valueOf(day));
            day++;
            Collections.shuffle(driversList.drivers_List);
            String gap = " ";
            String header = String.format("%-5s%s%-30s%s%-5s","Position",gap,"Name",gap,"Points");
            viewRace.write("\n");
            viewRace.write(header);
            viewRace.write("\n");
            viewRace.write("==========================================================");
            viewRace.write("\n");
            for (int position = 0; position<driversList.drivers_List.size();position++){
                if(position==0){
                    String position1 = String.format("%-5s%s%-30s%s%-5s",position+1,gap,driversList.drivers_List.get(position).get(0),gap,"10");
                    viewRace.write("\n");
                    viewRace.write(position1);
                    viewRace.write("\n");
                    int y = parseInt(driversList.drivers_List.get(position).get(4).toString());
                    int z = y + 10;
                    driversList.drivers_List.get(position).set(4,z);
                }
                else if(position==1){
                    String position2 = String.format("%-5s%s%-30s%s%-5s",position+1,gap,driversList.drivers_List.get(position).get(0),gap,"7");
                    viewRace.write("\n");
                    viewRace.write(position2);
                    viewRace.write("\n");
                    int y = parseInt(driversList.drivers_List.get(position).get(4).toString());
                    int z = y + 7;
                    driversList.drivers_List.get(position).set(4,z);
                }
                else if(position==2){
                    String position3 = String.format("%-5s%s%-30s%s%-5s",position+1,gap,driversList.drivers_List.get(position).get(0),gap,"5");
                    viewRace.write("\n");
                    viewRace.write(position3);
                    viewRace.write("\n");
                    int y = parseInt(driversList.drivers_List.get(position).get(4).toString());
                    int z = y + 5;
                    driversList.drivers_List.get(position).set(4,z);
                }
                else{
                    String positionX = String.format("%-5s%s%-30s%s%-5s",position+1,gap,driversList.drivers_List.get(position).get(0),gap,"0");
                    viewRace.write("\n");
                    viewRace.write(positionX);
                    viewRace.write("\n");
                    int y = parseInt(driversList.drivers_List.get(position).get(4).toString());
                    int z = y + 0;
                    driversList.drivers_List.get(position).set(4,z);
                }
            }
            System.out.println(driversList.drivers_List);
            viewRace.close();
        }catch(IOException e){
            System.out.println("An error occurred");
        }
        menuMessage.setText("Race Completed..");
    }

    @FXML
    protected void onViewRacesButtonClick(ActionEvent actionEvent) throws Exception{
        menuMessage.setText("  ");
        viewRaceNavigation(actionEvent);
    }

    @FXML
    protected void onSaveButtonClick() throws IOException {
        try {
            FileWriter drivers = new FileWriter("src/main/java/com/example/cwpart2/cw2programming/driversDetails.txt", true);
            // To write the file
            String gap = " ";
            String header = String.format("%-30s%s%-5s%s%-30s%s%-20s%s%-5s","Name",gap,"Age",gap,"Team",gap,"Car",gap,"Points");
            drivers.write(header);// Starts writing
            for (int i = 0; i<driversList.drivers_List.size(); i++){
                drivers.write("\n");
                String driver = String.format("%-30s%s%-5s%s%-30s%s%-20s%s%-5s",driversList.drivers_List.get(i).get(0),gap,driversList.drivers_List.get(i).get(1),gap,driversList.drivers_List.get(i).get(2),gap,driversList.drivers_List.get(i).get(3),gap,driversList.drivers_List.get(i).get(4));
                drivers.write(driver);
            }
            drivers.close(); // to close the file after working
        }catch(IOException e){
            System.out.println("An error occurred");
        }
        menuMessage.setText("Details Saved..");

    }

    @FXML
    protected void onLoadButtonClick(ActionEvent actionEvent) throws Exception{
        menuMessage.setText("  ");
        loadNavigation(actionEvent);
    }

    @FXML
    protected void onExitButtonClick() {
        menuMessage.setText("  ");
        System.exit(0);
    }

    private static void bubbleSort(ArrayList<ArrayList> drivers) {
        int x = drivers.size();
        for (int loop1 = 0; loop1 < x - 1; loop1++) {
            for (int loop2 = 0; loop2 < x - loop1 - 1; loop2++) {
                int y = parseInt((String) drivers.get(loop2).get(4));
                int z = parseInt((String) drivers.get(loop2+1).get(4));

                if (y< z) {
                    ArrayList<ArrayList> temp = drivers.get(loop2);
                    drivers.set(loop2, drivers.get(loop2 + 1));
                    drivers.set(loop2 + 1, temp);
                }
            }
        }
    }

    public void addNavigation(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Add.fxml"));
        newStage.setScene(new Scene(root,640, 582));
        newStage.show();

        Stage previuosStage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previuosStage.close();
    }

    public void deleteNavigation(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        newStage.setScene(new Scene(root,640, 582));
        newStage.show();

        Stage previuosStage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previuosStage.close();
    }

    public void updateNavigation(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Update.fxml"));
        newStage.setScene(new Scene(root,640, 582));
        newStage.show();

        Stage previuosStage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previuosStage.close();
    }

    public void loadNavigation(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Load.fxml"));
        newStage.setScene(new Scene(root,740, 682));
        newStage.show();

        Stage previuosStage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previuosStage.close();
    }

    public void standingTableNavigation(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("StandingTable.fxml"));
        newStage.setScene(new Scene(root,740, 682));
        newStage.show();

        Stage previuosStage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previuosStage.close();
    }

    public void viewRaceNavigation(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewRace.fxml"));
        newStage.setScene(new Scene(root,740, 682));
        newStage.show();

        Stage previuosStage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previuosStage.close();
    }
}