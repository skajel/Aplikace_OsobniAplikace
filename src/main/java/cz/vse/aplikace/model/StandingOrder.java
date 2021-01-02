package cz.vse.aplikace.model;

import java.util.Date;

public class StandingOrder {
    private double amount;
    private Date date;
    private int repetitionPeriod;

    public StandingOrder(double amount,Date date,int repetitionPeriod){
        this.amount = amount;
        this.date = date;
        this.repetitionPeriod = repetitionPeriod;

    }

    public void addStandingOrder() {

    }

    public void removeStandingOrder() {

    }

    public void editStandingOrder() {

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRepetitionPeriod() {
        return repetitionPeriod;
    }

    public void setRepetitionPeriod(int repetitionPeriod) {
        this.repetitionPeriod = repetitionPeriod;
    }
}
