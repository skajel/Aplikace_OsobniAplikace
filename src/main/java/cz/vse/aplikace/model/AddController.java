package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;

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
    public Label register_alert;
    public double sum;

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










    private void addTransactionToJSON() throws NoSuchAlgorithmException {
        if(addTransactionSum.getText().isEmpty()){
            register_alert.setText("Sum is mandatory");
            return;
        }

        if(CategoryComboBox.getItems().size() == 0){
            register_alert.setText("Username is mandatory");
            return;
        }

        if(addTransactionDate.getValue() == null){
            register_alert.setText("Date is mandatory");
            return;
        }

        if (addTransactionDescription.getText().isEmpty()){
            register_alert.setText("Description is mandatory");
            return;
        }

        Date addDate = new Date(addTransactionDate.getValue().toEpochDay());
        addTransaction(MainController.EMAIL,sum = Integer.parseInt(addTransactionSum.getText()),CategoryComboBox.toString(),addDate,addTransactionDescription.getText());
        Menu.loadTransaction();
    }

    public void addTransaction(String email, double amount,String category, Date date, String description){
        JSONObject transaction = new JSONObject();
        transaction.put(MainController.AMOUNT, amount);
        transaction.put(MainController.CATEGORY,category);
        transaction.put(MainController.DATE, date);
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








    public void add(MouseEvent mouseEvent) {
        addTransactionAdd.setCursor(Cursor.HAND);
        executeAdd();
    }

    public void executeAdd(){
        try {
            addTransactionToJSON();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
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


    public UUID getRandomID(){
        return UUID.randomUUID();
    }





}

