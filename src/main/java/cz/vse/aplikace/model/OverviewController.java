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
    public TextArea total_gain;
    public TextArea total_spending;
    public TextArea current_balance;

    private double gain;
    private double spending;


    public void initialize() {
        toGainOrSpanding();
        total_gain.setText(String.valueOf(gain));
        total_spending.setText((String.valueOf(spending)));
        current_balance.setText((String.valueOf(Balance(gain, spending))));
    }


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

        public double Balance(double gain, double spending){
            return gain-spending;
        }


    public void loadOverview() {
        overview_overview.setCursor(Cursor.CLOSED_HAND);}
    public void loadAccount(){
        overview_account.setCursor(Cursor.HAND);
        Menu.loadAccount();}
    public void loadAdd(){
        overview_add.setCursor(Cursor.HAND);
        Menu.loadAdd(); }
    public void loadTransaction(){
        overview_transaction.setCursor(Cursor.HAND);
        Menu.loadTransaction();}

}
