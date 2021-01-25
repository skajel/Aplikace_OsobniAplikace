package cz.vse.aplikace.model;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Date;
import java.util.UUID;

public class AddController{
    public static final String AMOUNT = "amount";
    public static final String DATE = "date";
    public static final String DESCRIPTION = "description";
    public static final String ID = "id";
    public Button overview;
    public Button transaction;
    public Button add;
    public Button account;
    public ComboBox CategoryComboBox;
    public TextField addTransactionSum;
    public DatePicker addTransactionDate;
    public TextField addTransactionDescription;
    public Button addTransactionAdd;

    public void initialize(){
        addTransactionSum.setPromptText("Enter numbers only");
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



    public void addTransaction(String email, double amount, Date date, String description){



        JSONObject transaction = new JSONObject();
        transaction.put(AMOUNT, amount);
        transaction.put(DATE, date);
        transaction.put(DESCRIPTION, description);
        transaction.put(ID, getRandomID().toString());


        JSONArray userList = JSON.loadData();
        userList.forEach(currentUser -> {
            if (JSON.compareUserInfo((JSONObject) currentUser, email, RegisterController.EMAIL)){
                JSONArray trans = (JSONArray) ((JSONObject) currentUser).get(RegisterController.TRANSACTIONS);
                trans.add(transaction);
                return;
            }});
        JSON.saveData(userList);

    }

    public UUID getRandomID(){
        return UUID.randomUUID();
    }





}

