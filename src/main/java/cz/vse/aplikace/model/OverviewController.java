package cz.vse.aplikace.model;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class OverviewController {

    public Button overview;
    public Button transaction;
    public Button add;
    public Button account;


    public void loadOverview() {
        overview.setCursor(Cursor.CLOSED_HAND);}
    public void loadAccount(){
        account.setCursor(Cursor.HAND);
        Menu.loadAccount();}
    public void loadAdd(){
        add.setCursor(Cursor.HAND);
        Menu.loadAdd(); }
    public void loadTransaction(){
        transaction.setCursor(Cursor.HAND);
        Menu.loadTransaction();}

}
