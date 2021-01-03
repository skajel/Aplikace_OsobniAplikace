package cz.vse.aplikace.model;
import java.util.Date;

public class Transaction {
    Category category;
    private double amount;
    private Date date;
    private String description;

public Transaction(double amount,Date date,String description){
    this.amount=amount;
    this.date=date;
    this.description=description;
}

public void makeTransaction(){

}

public void addTransaction(){

}

public void removeTransaction(){

}

public void editTransaction(){

}

public void setCategory (Category category) {
        this.category = category;
    }

public double getAmount(){
    return amount;
}

public void setAmount (double amount){
    this.amount=amount;
}

public void setDate(Date date){
    this.date=date;
}

public Date getDate(){
    return date;
}

public void setDescription(String description){
    this.description=description;
}

public String getDescription(){
    return description;
}


}
