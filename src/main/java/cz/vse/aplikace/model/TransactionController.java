package cz.vse.aplikace.model;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class TransactionController {

    public Button overview;
    public Button transaction;
    public Button add;
    public Button account;


    public void loadOverview() {
        overview.setCursor(Cursor.HAND);
        Menu.loadOverview();}
    public void loadAccount(){
        account.setCursor(Cursor.HAND);
        Menu.loadAccount();}
    public void loadAdd(){
        add.setCursor(Cursor.HAND);
        Menu.loadAdd(); }
    public void loadTransaction(){
        transaction.setCursor(Cursor.CLOSED_HAND);}
}
