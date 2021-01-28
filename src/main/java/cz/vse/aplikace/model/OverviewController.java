package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class OverviewController {

    public Button overview_overview;
    public Button overview_transaction;
    public Button overview_add;
    public Button overview_account;

    public PieChart chart;
    public static TextArea total_gain;
    public static TextArea total_spending;
    public static TextArea current_balance;

    private static double gain;
    private static double spending;


    /**
     * Tato metoda inicializuje vložené úpravy a vyvolává vložené metody
     */
    public void initialize() {
        toGainOrSpanding();

    }


    /**
     * Metoda, která slouží ke sečtení výdajů a příjmů přihlášeného uživatele
     */
        public static void toGainOrSpanding(){

            JSONObject user = JSON.getCurrentUser();
            JSONArray transactions  = (JSONArray) user.get(MainController.TRANSACTIONS);
            transactions.forEach(transaction -> {
                String gainOrSpending = (String) ((JSONObject) transaction).get(MainController.GAINOTNOT);
                if (gainOrSpending.equals(GainOrNot.GAIN.toString())){
                    gain += ((double) ((JSONObject) transaction).get(MainController.AMOUNT));
                } else {
                    spending += ((double) ((JSONObject) transaction).get(MainController.AMOUNT));
                }

            });   total_gain.setText(String.valueOf(gain));
            total_spending.setText((String.valueOf(spending)));
            current_balance.setText((String.valueOf(Balance(gain, spending))));
        }

    /**
     * Metoda, která odečte výdaje od příjmů
     */
        public static double Balance(double gain, double spending){
            return gain-spending;
        }


    /**
     * Metoda, která upravuje Button - Overview, provede změnu scény na OverviewScreen.fxml
     */
    public void loadOverview() {
        overview_overview.setCursor(Cursor.CLOSED_HAND);}
    /**
     * Metoda, která upravuje Button - Account, provede změnu scény na SettingsScreen.fxml
     */
    public void loadAccount(){
        overview_account.setCursor(Cursor.HAND);
        Menu.loadAccount();}
    /**
     * Metoda, která upravuje Button - Add, provede změnu scény na AddScreen.fxml
     */
    public void loadAdd(){
        overview_add.setCursor(Cursor.HAND);
        Menu.loadAdd(); }
    /**
     * Metoda, která upravuje Button - Transaction, provede změnu scény na TransactionScreen.fxml
     */
    public void loadTransaction(){
        overview_transaction.setCursor(Cursor.HAND);
        Menu.loadTransaction();}

}
