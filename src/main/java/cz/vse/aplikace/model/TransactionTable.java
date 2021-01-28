package cz.vse.aplikace.model;


import javafx.beans.property.SimpleStringProperty;


public class TransactionTable {
    private final SimpleStringProperty table_amount = new SimpleStringProperty("");
    private final SimpleStringProperty table_category = new SimpleStringProperty("");
    private final SimpleStringProperty table_date = new SimpleStringProperty("");
    private final SimpleStringProperty table_description = new SimpleStringProperty("");

    public TransactionTable() {

    }

    public TransactionTable(String table_amount, String table_category, String table_date,String table_description) {
        setTable_amount(table_amount);
        setTable_category(table_category);
        setTable_date(table_date);
        setTable_description(table_description);
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
}
