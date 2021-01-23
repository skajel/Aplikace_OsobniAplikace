package cz.vse.aplikace.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JSON {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";

    private static final String AMOUNT = "amount";
    private static final String DATE = "date";
    private static final String DESCRIPTION = "description";
    private static final String ID = "id";

    private static final String TRANSACTIONS = "transactions";

    JSONArray users = new JSONArray();
    JSONArray transactions = new JSONArray();

    public void addUser(String username, byte[] password, String email){
        JSONObject user = new JSONObject();
        user.put(USERNAME, username);
        user.put(PASSWORD, password);
        user.put(EMAIL, email);

        getUsers().add(user);
    }

    public void addTransaction(String username, double amount, Date date, String description){
        JSONObject transaction = new JSONObject();
        transaction.put(AMOUNT, amount);
        transaction.put(DATE, date);
        transaction.put(DESCRIPTION, description);
        transaction.put(ID, getRandomID().toString());

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("JSON.json"));
            JSONArray userList = (JSONArray) obj;
            userList.forEach(currentUser -> {
                   if (compareUser((JSONObject) currentUser, username)){
                        ((JSONObject) currentUser).put(TRANSACTIONS, transactions);

            }});
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public UUID getRandomID(){
        return UUID.randomUUID();
    }

    public static boolean compareUser(JSONObject user, String defaultUser){
        String searchedUser = (String) user.get(USERNAME);
        if (defaultUser.equals(searchedUser)){
            return true;
        }
        return false;
    }

    public JSONArray getUsers() {
        return users;
    }

    public void setUsers(JSONArray users) {
        this.users = users;
    }

    public JSONArray getTransactions() {
        return transactions;
    }

    public void setTransactions(JSONArray transactions) {
        this.transactions = transactions;
    }
}
