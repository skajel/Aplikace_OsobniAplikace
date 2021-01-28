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

    public Button add_overview;
    public Button add_transaction;
    public Button add_add;
    public Button add_account;
    public ComboBox<Category> CategoryComboBox;
    public ComboBox<GainOrNot> add_gainComboBox;
    public TextField addTransactionSum;
    public DatePicker addTransactionDate;
    public TextField addTransactionDescription;
    public Button addTransactionAdd;
    public Label add_alert;
    public double sum;
    public Button clearButton;



    public void initialize() {
        addTransactionSum.setPromptText("Enter numbers only                        ");
        addTransactionDescription.setPromptText("Short description");
        addTransactionDate.setEditable(false);
        CategoryComboBox.setPromptText("Choose category");
        CategoryComboBox.setItems(FXCollections.observableArrayList(Category.values()));
        add_gainComboBox.setItems(FXCollections.observableArrayList(GainOrNot.values()));
        addTransactionDate.setPromptText("Choose date");
        addTransactionAdd.setTooltip(new Tooltip("Add transaction to your list"));
        clearButton.setTooltip(new Tooltip("Clear all boxes"));
        CategoryComboBox.setTooltip(new Tooltip("Choose category"));
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
            add_alert.setText("Sum is mandatory");
            return;
        }

        if (CategoryComboBox.getSelectionModel().isEmpty()) {
            add_alert.setText("Category is mandatory");
            return;
        }

        if (add_gainComboBox.getSelectionModel().isEmpty()) {
            add_alert.setText("Choose gain or spending");
            return;
        }

        if (addTransactionDate.getValue() == null) {
            add_alert.setText("Date is mandatory");
            return;
        }

        if (addTransactionDescription.getText().isEmpty()) {
            add_alert.setText("Description is mandatory");
            return;
        }
        Date addDate = new Date(addTransactionDate.getValue().toEpochDay());
        addTransaction((String) JSON.getCurrentUser().get(MainController.EMAIL),
                sum = Integer.parseInt(addTransactionSum.getText()),
                (add_gainComboBox.getSelectionModel().getSelectedItem()).toString(),
                (CategoryComboBox.getSelectionModel().getSelectedItem()).toString(),
                addDate, addTransactionDescription.getText());
        Menu.loadTransaction();
    }

    public void addTransaction(String email, double amount,String gainOrNot, String category, Date date, String description) {
        JSONObject transaction = new JSONObject();
        transaction.put(MainController.AMOUNT, amount);
        transaction.put(MainController.GAINOTNOT,gainOrNot);
        transaction.put(MainController.CATEGORY, category);
        transaction.put(MainController.DATE, date.toString());
        transaction.put(MainController.DESCRIPTION, description);
        transaction.put(MainController.ID, getRandomID().toString());

        JSONArray userList = JSON.loadData();
        assert userList != null;
        userList.forEach(currentUser -> {
            if (JSON.compareUserInfo((JSONObject) currentUser, email, MainController.EMAIL)) {
                JSONArray trans = (JSONArray) ((JSONObject) currentUser).get(MainController.TRANSACTIONS);
                trans.add(transaction);
            }
        });
        JSON.saveData(userList);
    }

    public void addTransaction(ActionEvent actionEvent) {
        addTransactionAdd.setCursor(Cursor.HAND);
        add_alert.setText("");
        executeAdd();
        //OverviewController.toGainOrSpanding();
    }

    public void executeAdd() {
        try {
            addTransactionToJSON();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void loadOverview() {
        add_overview.setCursor(Cursor.HAND);
        Menu.loadOverview();
    }

    public void loadAccount() {
        add_account.setCursor(Cursor.HAND);
        Menu.loadAccount();
    }

    public void loadAdd() {
        add_add.setCursor(Cursor.CLOSED_HAND);
    }

    public void loadTransaction() {
        add_transaction.setCursor(Cursor.HAND);
        Menu.loadTransaction();
    }

    public UUID getRandomID() {
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

