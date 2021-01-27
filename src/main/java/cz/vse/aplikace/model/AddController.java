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

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

public class AddController {

    public Button overviewB;
    public Button transactionB;
    public Button addB;
    public Button accountB;
    public ComboBox<Category> CategoryComboBox;
    public TextField addTransactionSum;
    public DatePicker addTransactionDate;
    public TextField addTransactionDescription;
    public Button addTransactionAdd;
    public Label register_alert;
    public double sum;

    public void initialize() {
        addTransactionSum.setPromptText("Enter numbers only");
        addTransactionDescription.setPromptText("Short description");
        CategoryComboBox.setPromptText("Choose category");
        CategoryComboBox.setItems(FXCollections.observableArrayList(Category.values()));
        addTransactionDate.setPromptText("Choose date");
        addTransactionSum.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    addTransactionSum.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }


    private void addTransactionToJSON() throws NoSuchAlgorithmException {
        if (addTransactionSum.getText().isEmpty()) {
            register_alert.setText("Sum is mandatory");
            return;
        }

        if (CategoryComboBox.getItems().size() == 0) {
            register_alert.setText("Username is mandatory");
            return;
        }

        if (addTransactionDate.getValue() == null) {
            register_alert.setText("Date is mandatory");
            return;
        }

        if (addTransactionDescription.getText().isEmpty()) {
            register_alert.setText("Description is mandatory");
            return;
        }

        Date addDate = new Date(addTransactionDate.getValue().toEpochDay());
        addTransaction("burm10@gmail.com", sum = Integer.parseInt(addTransactionSum.getText()), CategoryComboBox.toString(), addDate, addTransactionDescription.getText());
        Menu.loadTransaction();
    }

    public void addTransaction(String email, double amount, String category, Date date, String description) {
        JSONObject transaction = new JSONObject();
        transaction.put(MainController.AMOUNT, amount);
        transaction.put(MainController.CATEGORY, category);
        transaction.put(MainController.DATE, date.toString());
        transaction.put(MainController.DESCRIPTION, description);
        transaction.put(MainController.ID, getRandomID().toString());
        JSONArray userList = JSON.loadData();
        assert userList != null;
        userList.forEach(currentUser -> {
            if (JSON.compareUserInfo((JSONObject) currentUser, email,MainController.EMAIL)) {
                JSONArray trans = (JSONArray) ((JSONObject) currentUser).get(MainController.TRANSACTIONS);
                trans.add(transaction);
            }
        });
        JSON.saveData(userList);
    }


    public void addTransaction(ActionEvent actionEvent) {
        addTransactionAdd.setCursor(Cursor.HAND);
        executeAdd();
    }

    public void executeAdd() {
        try {
            addTransactionToJSON();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void loadOverview() {
        overviewB.setCursor(Cursor.HAND);
        Menu.loadOverview();
    }

    public void loadAccount() {
        accountB.setCursor(Cursor.HAND);
        Menu.loadAccount();
    }

    public void loadAdd() {
        addB.setCursor(Cursor.CLOSED_HAND);
    }

    public void loadTransaction() {
        transactionB.setCursor(Cursor.HAND);
        Menu.loadTransaction();
    }

    public UUID getRandomID() {
        return UUID.randomUUID();
    }

}

