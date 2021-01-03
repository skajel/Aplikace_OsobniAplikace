package cz.vse.aplikace.model;
import java.util.Date;

public class Loan {
    private double amount;
    private Date date;
    private int repayment;
    private int NumberOfRepayment;
    private Date DateOfSending;
    private String Description;
    Category category;


public Loan(double amount,Date date,int repayment,int NumberOfRepayment,Date DateOfSending,String Description){
    this.amount=amount;
    this.date=date;
    this.repayment=repayment;
    this.NumberOfRepayment=NumberOfRepayment;
    this.DateOfSending=DateOfSending;
    this.Description=Description;

}

public void addLoan(){

}

public void removeLoan(){

}

public void editLoan(){

}

public void setCategory (Category category) {
        this.category = category;
    }

public void setAmount(double amount){
    this.amount = amount;
}

public double getAmount(){
    return amount;
}

public void setDate(Date date){
    this.date=date;
}
public Date getDate(){
    return date;
}

public void setRepayment(int repayment){
    this.repayment=repayment;
}

public int getRepayment(){
    return repayment;
}

public void setNumberOfRepayment(int NumberOfRepayment){
    this.NumberOfRepayment=NumberOfRepayment;
}

public int getNumberOfRepayment(){
    return NumberOfRepayment;
}
public void setDateOfSending(Date DateOfSending){
    this.DateOfSending=DateOfSending;
}

public Date getDateOfSending(){
    return DateOfSending;
}
public void setDescription(String Description){
    this.Description=Description;
}

public String getDescription(){
    return Description;
}
}
