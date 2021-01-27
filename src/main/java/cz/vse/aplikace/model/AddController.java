package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Date;
import java.util.UUID;

public class AddController{

    public Button overview;
    public Button transaction;
    public Button add;
    public Button account;
    public ComboBox CategoryComboBox;
    public TextField addTransactionSum;
    public DatePicker addTransactionDate;
    public TextField addTransactionDescription;
    public Button addTransactionAdd;
    public Button clearButton;

    public void initialize(){
        addTransactionSum.setPromptText("Enter numbers only                        ");
        addTransactionDescription.setPromptText("Short description");
        CategoryComboBox.setPromptText("Choose category");
        CategoryComboBox.setItems(FXCollections.observableArrayList(Category.values()));
        addTransactionDate.setPromptText("Choose date");
        addTransactionSum.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")){
                    addTransactionSum.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }



    public void loadOverview() {
        overview.setCursor(Cursor.HAND);
        Menu.loadOverview();}
    public void loadAccount(){
        account.setCursor(Cursor.HAND);
        Menu.loadAccount();}
    public void loadAdd(){
        add.setCursor(Cursor.CLOSED_HAND); }
    public void loadTransaction(){
        transaction.setCursor(Cursor.HAND);
        Menu.loadTransaction();}



    public void addTransaction (String email, String amount, Date date, String description, Enum category){
        JSONObject transaction = new JSONObject();
        transaction.put(MainController.AMOUNT, amount);
        transaction.put(MainController.DATE, date);
        transaction.put(MainController.CATEGORY,category);
        transaction.put(MainController.DESCRIPTION, description);
        transaction.put(MainController.ID, getRandomID().toString());


        JSONArray userList = JSON.loadData();
        userList.forEach(currentUser -> {
            if (JSON.compareUserInfo((JSONObject) currentUser, email, MainController.EMAIL)){
                JSONArray trans = (JSONArray) ((JSONObject) currentUser).get(MainController.TRANSACTIONS);
                trans.add(transaction);
                return;
            }});
        JSON.saveData(userList);

    }

    public UUID getRandomID(){
        return UUID.randomUUID();
    }




    public void clear(ActionEvent event) {
        clearButton.setCursor(Cursor.HAND);
        addTransactionSum.clear();
        addTransactionDescription.clear();
        addTransactionDate.setValue(null);
        CategoryComboBox.setValue(null);
    }
}

