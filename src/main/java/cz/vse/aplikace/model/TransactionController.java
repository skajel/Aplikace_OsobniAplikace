package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Třída cz.vse.aplikace.model.TransactionController je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 * <p>
 * Tato třída slouží jako controller pro TransactionScreen.fxml - která slouží k vyhledávání a filtrování transakcní podle jednotlivých kritérií
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */

public class TransactionController {

    public Button transaction_account;
    public Button transaction_add;
    public Button transaction_transaction;
    public Button transaction_overview;
    public static VBox list;


    public void initialize() {
        System.out.println("Hello");
        iterateTransactions(getTransaction());
    }


    public JSONArray getTransaction() {
        JSONObject user = JSON.getCurrentUser();
        JSONArray transactions = (JSONArray) user.get(MainController.TRANSACTIONS);
        return transactions;
    }

    public void iterateTransactions(JSONArray transactions) {
            transactions.forEach(transaction -> {
            double amount = (double) ((JSONObject) transaction).get(MainController.AMOUNT);
            String category = (String) ((JSONObject) transaction).get(MainController.CATEGORY);
            String date = (String) ((JSONObject) transaction).get(MainController.DATE);
            String description = (String) ((JSONObject) transaction).get(MainController.DESCRIPTION);

            String str = (amount + ", " + category + ", " + date + ", " + description);
            Label label = new Label(str);
            list.getChildren().add(label);
            return;
        });}
        /**
         * Metoda, která upravuje Button - Overview, provede změnu scény na OverviewScreen.fxml
         */
        public void loadOverview () {
            transaction_overview.setCursor(Cursor.HAND);
            Menu.loadOverview();
        }

        /**
         * Metoda, která upravuje Button - Account, provede změnu scény na SettingsScreen.fxml
         */
        public void loadAccount () {
            transaction_account.setCursor(Cursor.HAND);
            Menu.loadAccount();
        }

        /**
         * Metoda, která upravuje Button - Add, provede změnu scény na AddScreen.fxml
         */
        public void loadAdd () {
            transaction_add.setCursor(Cursor.HAND);
            Menu.loadAdd();
        }

        /**
         * Metoda, která upravuje Button - Transaction, provede změnu scény na TransactionScreen.fxml
         */
        public void loadTransaction () {
            transaction_transaction.setCursor(Cursor.CLOSED_HAND);
        }


    }
