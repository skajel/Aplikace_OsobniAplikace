package cz.vse.aplikace.model;

import java.util.Date;

public class OverallOverview {
    Date period;

    public OverallOverview(){

    }

    public TransactionOverview showOverview(){
        TransactionOverview overview = new TransactionOverview();
        return overview;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public void showOverallOverview(){}

    public void createGraph(){}

    public void editGraph(){}

    public void removeGraph(){}

}
