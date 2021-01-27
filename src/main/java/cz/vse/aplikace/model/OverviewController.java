package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
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
    public int gain;
    public int spending;

    public int initialize() {

        public Integer toGainOrStanding(){
            JSONObject user LoginController.getCurrentUser();
            JSONArray transactions  = (JSONArray) user.get(MainController.TRANSACTIONS);
            transactions.get(MainController.GAINOTNOT.toString());
            if
        }

        public int Ballance(){
            int n1 = gain;
            int n2 = spending;
            return gain - spending;



        }
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
