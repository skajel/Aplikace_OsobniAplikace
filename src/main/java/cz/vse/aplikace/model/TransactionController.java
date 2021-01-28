package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.TransformationList;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Třída cz.vse.aplikace.model.TransactionController je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 *
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
    public TableView<JSONArray> tableView;
    public FXCollections table;

    private final SimpleStringProperty table_amount = new SimpleStringProperty("45");
    private final SimpleStringProperty table_category = new SimpleStringProperty("654");
    private final SimpleStringProperty table_date = new SimpleStringProperty("546");
    private final SimpleStringProperty table_description = new SimpleStringProperty("654");

    public TransactionController() {
        this("", "", "","");

    }

    public TransactionController(String table_amount, String table_category, String table_date,String table_description) {
        setTable_amount(table_amount);
        setTable_category(table_category);
        setTable_date(table_date);
        setTable_description(table_description);
    }

    public static void initialize() {
        getTransakce();
        TableColumn<JSONArray,String> amountCollumn = new TableColumn<>("Amount");
        amountCollumn.setPrefWidth(100);
        amountCollumn.setCellValueFactory(new PropertyValueFactory<>(MainController.AMOUNT));

        TableColumn<JSONArray,String> categoryCollumn = new TableColumn<>("Category");
        categoryCollumn.setPrefWidth(100);
        categoryCollumn.setCellValueFactory(new PropertyValueFactory<>(MainController.CATEGORY));

        TableColumn<JSONArray,String> dateCollumn = new TableColumn<>("Date");
        dateCollumn.setPrefWidth(100);
        dateCollumn.setCellValueFactory(new PropertyValueFactory<>(MainController.DATE));

        TableColumn<JSONArray,String> descriptionCollumn = new TableColumn<>("Description");
        descriptionCollumn.setPrefWidth(100);
        descriptionCollumn.setCellValueFactory(new PropertyValueFactory<>(MainController.DESCRIPTION));
    }




    public static ObservableList<JSONArray> getTransakce(){
        JSONObject user = JSON.getCurrentUser();
        JSONArray transactions  = (JSONArray) user.get(MainController.TRANSACTIONS);
        ObservableList<JSONArray> transakcepl = FXCollections.observableArrayList();
        transakcepl.add(transactions);
        return transakcepl;

    }

    public void update(ActionEvent actionEvent) {getTransakce();
    initialize();
    }


    public String getTable_amount() {
        return table_amount.get();
    }


    public void setTable_amount(String table_amount) {
        this.table_amount.set(table_amount);
    }

    public String getTable_category() {
        return table_category.get();
    }

    public void setTable_category(String table_category) {
        this.table_category.set(table_category);
    }

    public String getTable_date() {
        return table_date.get();
    }


    public void setTable_date(String table_date) {
        this.table_date.set(table_date);
    }

    public String getTable_description() {
        return table_description.get();
    }

    public void setTable_description(String table_description) {
        this.table_description.set(table_description);
    }






    /**
     * Metoda, která upravuje Button - Overview, provede změnu scény na OverviewScreen.fxml
     */
    public void loadOverview() {
        transaction_overview.setCursor(Cursor.HAND);
        Menu.loadOverview();}
    /**
     * Metoda, která upravuje Button - Account, provede změnu scény na SettingsScreen.fxml
     */
    public void loadAccount(){
        transaction_account.setCursor(Cursor.HAND);
        Menu.loadAccount();}
    /**
     * Metoda, která upravuje Button - Add, provede změnu scény na AddScreen.fxml
     */
    public void loadAdd(){
        transaction_add.setCursor(Cursor.HAND);
        Menu.loadAdd(); }
    /**
     * Metoda, která upravuje Button - Transaction, provede změnu scény na TransactionScreen.fxml
     */
    public void loadTransaction(){
        transaction_transaction.setCursor(Cursor.CLOSED_HAND);}


}
