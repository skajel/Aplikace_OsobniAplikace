package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Date;
import java.util.UUID;

/**
 * Třída cz.vse.aplikace.model.AddController je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 * <p>
 * Tato třída slouží jako controller pro AddScreen.fxml - která slouží k přidání transakce do JSON.json
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */


public class AddController {

    public Button add_overview;
    public Button add_add;
    public Button add_account;
    public Button clearButton;
    public Button addTransactionAdd;
    public ComboBox<GainOrNot> add_gainComboBox;
    public ComboBox<Category> CategoryComboBox_GAIN;
    public ComboBox<Category> CategoryComboBox_SPENDING;

    public TextField addTransactionSum;
    public DatePicker addTransactionDate;
    public TextField addTransactionDescription;

    public Label add_alert;
    public double sum;
    public static String category;


    /**
     * Tato metoda inicializuje vložené úpravy a vyvolává vložené metody jako např. PromptText, itemy comboboxů a omezení textfieldů
     */
    public void initialize() {
        addTransactionDate.setEditable(false);

        CategoryComboBox_GAIN.setItems(FXCollections.observableArrayList(Category.RENT, Category.ENTERTAINMENT, Category.BUSINESS, Category.SPORT, Category.GROCERIES, Category.CHILDREN, Category.OTHER, Category.CHILDREN));
        CategoryComboBox_SPENDING.setItems(FXCollections.observableArrayList(Category.WAGE, Category.LOTTERY));


        CategoryComboBox_GAIN.setVisible(false);
        CategoryComboBox_SPENDING.setVisible(false);


        add_gainComboBox.setItems(FXCollections.observableArrayList(GainOrNot.values()));
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
    private void addTransactionToJSON() {
        if (addTransactionSum.getText().isEmpty()) {
            add_alert.setText("Sum is mandatory.");
            return;
        }

        if ((CategoryComboBox_SPENDING.getSelectionModel().isEmpty())&&(CategoryComboBox_GAIN.getSelectionModel().isEmpty())) {
           add_alert.setText("Category is mandatory.");
           return;
        }

        if (add_gainComboBox.getSelectionModel().isEmpty()) {
            add_alert.setText("Choose gain or spending.");
            return;
        }

        if (addTransactionDate.getValue() == null) {
            add_alert.setText("Date is mandatory.");
            return;
        }

        if (addTransactionDescription.getText().isEmpty()) {
            add_alert.setText("Description is mandatory.");
            return;
        }
        if ((add_gainComboBox.getSelectionModel().getSelectedItem()).toString() == "SPENDING") {
            category = (CategoryComboBox_GAIN.getSelectionModel().getSelectedItem()).toString();
        } else {
            category = (CategoryComboBox_SPENDING.getSelectionModel().getSelectedItem()).toString();
        }

        Date addDate = new Date(addTransactionDate.getValue().toEpochDay());
        addTransaction((String) JSON.getCurrentUser().get(MainController.EMAIL),
                sum = Integer.parseInt(addTransactionSum.getText()),
                (add_gainComboBox.getSelectionModel().getSelectedItem()).toString(),
                category,
                addDate, addTransactionDescription.getText());

        Menu.loadOverview();
    }

    /**
     * Metoda, která vytváří proměnné v transaction a přiřadí je k aktuálnímu/přihlášenému uživateli
     */
    public void addTransaction(String email, double amount, String gainOrNot, String category, Date date, String description) {
        JSONObject transaction = new JSONObject();
        transaction.put(MainController.AMOUNT, amount);
        transaction.put(MainController.GAINOTNOT, gainOrNot);
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
        JSON.addTransactionToUser(transaction);
        JSON.saveData(userList);
    }

    /**
     * Metoda, která upravuje Button - add a vyvolává metodu executeAdd
     */
    public void addTransaction() {
        add_alert.setText("");
        executeAdd();
    }

    /**
     * Metoda, která provede zápis transakce, vyvoláním metody addTransactionToJSON
     */
    public void executeAdd() {
        addTransactionToJSON();
    }

    /**
     * Metoda, která upravuje Button - Overview, provede změnu scény na OverviewScreen.fxml
     */
    public void loadOverview() {
        Menu.loadOverview();
    }

    /**
     * Metoda, která upravuje Button - Account, provede změnu scény na SettingsScreen.fxml
     */
    public void loadAccount() {
        Menu.loadAccount();
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
        addTransactionSum.clear();
        addTransactionDescription.clear();
        addTransactionDate.setValue(null);
        CategoryComboBox_GAIN.setValue(null);
        CategoryComboBox_SPENDING.setValue(null);
    }

    /**
     * Metoda rozhoduje jestli se jedná o GAIN or SPANDING a podle toho zobrazuje kategorie
     */
    public void updateGainOrNot(ActionEvent actionEvent) {
        if ((add_gainComboBox.getSelectionModel().getSelectedItem()).toString() == "SPENDING") {
            CategoryComboBox_SPENDING.setVisible(false);
            CategoryComboBox_GAIN.setVisible(true);
        } else {
            CategoryComboBox_SPENDING.setVisible(true);
            CategoryComboBox_GAIN.setVisible(false);
        }
    }
}


