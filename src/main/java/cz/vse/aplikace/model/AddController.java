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
/**
 * Třída cz.vse.aplikace.model.AddController je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 *
 * Tato třída slouží jako controller pro AddScreen.fxml - která slouží k přidání transakce do JSON.json
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */


public class AddController {

    public Button add_overview;
    public Button add_transaction;
    public Button add_add;
    public Button add_account;
    public Button clearButton;
    public Button addTransactionAdd;
    public ComboBox<GainOrNot> add_gainComboBox;
    public ComboBox<Category> CategoryComboBox_GAIN;

    public TextField addTransactionSum;
    public DatePicker addTransactionDate;
    public TextField addTransactionDescription;

    public Label add_alert;
    public double sum;



    /**
     * Tato metoda inicializuje vložené úpravy a vyvolává vložené metody jako např. PromptText, itemy comboboxů a omezení textfieldů
     */
    public void initialize() {
        addTransactionSum.setPromptText("Enter numbers only                        ");
        addTransactionDescription.setPromptText("Short description");
        addTransactionDate.setEditable(false);
        CategoryComboBox_GAIN.setPromptText("Choose category");
        CategoryComboBox_GAIN.setItems(FXCollections.observableArrayList(Category.values()));
        add_gainComboBox.setItems(FXCollections.observableArrayList(GainOrNot.values()));
        addTransactionDate.setPromptText("Choose date");
        addTransactionAdd.setTooltip(new Tooltip("Add transaction to your list"));
        clearButton.setTooltip(new Tooltip("Clear all boxes"));
        CategoryComboBox_GAIN.setTooltip(new Tooltip("Choose category"));
        addTransactionSum.textProperty().addListener(new ChangeListener<String>() {
            /**
             * Metoda, která neumožní vložení jiných znaků než cifer do textfieldu
             * @Override přepíšee Value textfieldu
             */
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    addTransactionSum.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }


    /**
     * Metoda, která vloží hodnoty jednotlyvých objektů transakce do JSON.json a upravuje podmínky pro jednotlivé promměné
     */
    private void addTransactionToJSON() throws NoSuchAlgorithmException {
        if (addTransactionSum.getText().isEmpty()) {
            add_alert.setText("Sum is mandatory");
            return;
        }

        if (CategoryComboBox_GAIN.getSelectionModel().isEmpty()) {
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
                (CategoryComboBox_GAIN.getSelectionModel().getSelectedItem()).toString(),
                addDate, addTransactionDescription.getText());
        Menu.loadTransaction();
    }

    /**
     * Metoda, která vytváří proměnné v transaction a přiřadí je k aktuálnímu/přihlášenému uživateli
     */
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

    /**
     * Metoda, která upravuje Button - add a vyvolává metodu executeAdd
     */
    public void addTransaction() {
        addTransactionAdd.setCursor(Cursor.HAND);
        add_alert.setText("");
        executeAdd();
        //OverviewController.toGainOrSpanding();
    }

    /**
     * Metoda, která provede zápis transakce, vyvoláním metody addTransactionToJSON
     */
    public void executeAdd() {
        try {
            addTransactionToJSON();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda, která upravuje Button - Overview, provede změnu scény na OverviewScreen.fxml
     */
    public void loadOverview() {
        add_overview.setCursor(Cursor.HAND);
        Menu.loadOverview();
    }

    /**
     * Metoda, která upravuje Button - Account, provede změnu scény na SettingsScreen.fxml
     */
    public void loadAccount() {
        add_account.setCursor(Cursor.HAND);
        Menu.loadAccount();
    }

    /**
     * Metoda, která upravuje Button - Add, provede změnu scény na AddScreen.fxml
     */
    public void loadAdd() {
        add_add.setCursor(Cursor.CLOSED_HAND);
    }

    /**
     * Metoda, která upravuje Button - Transaction, provede změnu scény na TransactionScreen.fxml
     */
    public void loadTransaction() {
        add_transaction.setCursor(Cursor.HAND);
        Menu.loadTransaction();
    }

    /**
     * Metoda. která přidělí transakci ID
     */
    public UUID getRandomID() {
        return UUID.randomUUID();
    }

    /**
     * Metoda, která upravuje Button - Clear, vymaže vložené hodnoty v ComboBoxu a TextFieldu
     */
    public void clear() {
        clearButton.setCursor(Cursor.HAND);
        addTransactionSum.clear();
        addTransactionDescription.clear();
        addTransactionDate.setValue(null);
        CategoryComboBox_GAIN.setValue(null);
    }

    public void updateGainOrNot(ActionEvent actionEvent) {
        if ((add_gainComboBox.getSelectionModel().getSelectedItem()).toString() == "SPENDING"){
            CategoryComboBox_GAIN.setItems(FXCollections.observableArrayList(Category.RENT,Category.ENTERTAINMENT,Category.BUSINESS,Category.SPORT,Category.GROCERIES,Category.CHILDREN,Category.OTHER,Category.CHILDREN));
            }else {
            CategoryComboBox_GAIN.setItems(FXCollections.observableArrayList(Category.WAGE,Category.LOTTERY));
        }
    }
}


