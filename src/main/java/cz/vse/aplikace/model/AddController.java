package cz.vse.aplikace.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Date;
import java.util.UUID;

public class AddController {
    public static final String AMOUNT = "amount";
    public static final String DATE = "date";
    public static final String DESCRIPTION = "description";
    public static final String ID = "id";


    public void addTransaction(String email, double amount, Date date, String description){
        JSONObject transaction = new JSONObject();
        transaction.put(AMOUNT, amount);
        transaction.put(DATE, date);
        transaction.put(DESCRIPTION, description);
        transaction.put(ID, getRandomID().toString());


        JSONArray userList = JSON.loadData();
        userList.forEach(currentUser -> {
            if (JSON.compareUserInfo((JSONObject) currentUser, email, RegisterController.EMAIL)){
                JSONArray trans = (JSONArray) ((JSONObject) currentUser).get(RegisterController.TRANSACTIONS);
                trans.add(transaction);
                return;
            }});
        JSON.saveData(userList);

    }

    public UUID getRandomID(){
        return UUID.randomUUID();
    }

}