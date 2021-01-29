package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class OverviewController {

    public Button overview_overview;
    public Button overview_transaction;
    public Button overview_add;
    public Button overview_account;

    public PieChart chart;
    public TextArea total_gain;
    public TextArea total_spending;
    public TextArea current_balance;

    private double gain;
    private double spending;


    /**
     * Tato metoda inicializuje vložené úpravy a vyvolává vložené metody
     */
    public void initialize() {
        total_gain.setEditable(false);
        total_spending.setEditable(false);
        current_balance.setEditable(false);

        resetTextAreas();
        toGainOrSpanding();
        makeGraph();

        total_gain.setText(String.valueOf(gain));
        total_spending.setText((String.valueOf(spending)));
        current_balance.setText((String.valueOf(Balance(gain, spending))));



    }

    public void resetTextAreas(){
        gain = 0;
        spending = 0;
    }

    /**
     * Metoda, která slouží ke sečtení výdajů a příjmů přihlášeného uživatele
     */
        public void toGainOrSpanding(){
            JSONObject user = JSON.getCurrentUser();
            JSONArray transactions  = (JSONArray) user.get(MainController.TRANSACTIONS);
            transactions.forEach(transaction -> {
                String gainOrSpending = (String) ((JSONObject) transaction).get(MainController.GAINOTNOT);
                if (gainOrSpending.equals(GainOrNot.GAIN.toString())){
                    gain += ((double) ((JSONObject) transaction).get(MainController.AMOUNT));
                } else {
                    spending += ((double) ((JSONObject) transaction).get(MainController.AMOUNT));
                }

            });
        }

    private void makeGraph() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("gain", gain),
                        new PieChart.Data("spending", spending));
        chart.setData(pieChartData);
    }

    /**
     * Metoda, která odečte výdaje od příjmů
     */
        public double Balance(double gain, double spending){
            return gain-spending;
        }


    /**
     * Metoda, která upravuje Button - Overview, provede změnu scény na OverviewScreen.fxml
     */
    public void loadOverview() { }
    /**
     * Metoda, která upravuje Button - Account, provede změnu scény na SettingsScreen.fxml
     */
    public void loadAccount(){
        Menu.loadAccount();}
    /**
     * Metoda, která upravuje Button - Add, provede změnu scény na AddScreen.fxml
     */
    public void loadAdd(){
        Menu.loadAdd(); }


}
