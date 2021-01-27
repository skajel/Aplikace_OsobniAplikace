package cz.vse.aplikace.model;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class TransactionController {


    public Button transaction_account;
    public Button transaction_add;
    public Button transaction_transaction;
    public Button transaction_overview;

    public void loadOverview() {
        transaction_overview.setCursor(Cursor.HAND);
        Menu.loadOverview();}
    public void loadAccount(){
        transaction_account.setCursor(Cursor.HAND);
        Menu.loadAccount();}
    public void loadAdd(){
        transaction_add.setCursor(Cursor.HAND);
        Menu.loadAdd(); }
    public void loadTransaction(){
        transaction_transaction.setCursor(Cursor.CLOSED_HAND);}
}
