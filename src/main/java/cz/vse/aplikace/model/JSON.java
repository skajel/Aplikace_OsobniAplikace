package cz.vse.aplikace.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Date;
import java.util.UUID;

public class JSON {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";

    private static final String AMOUNT = "amount";
    private static final String DATE = "date";
    private static final String DESCRIPTION = "description";
    private static final String ID = "id";

    private static final String TRANSACTIONS = "transactions";

    private static final String SAVE_FILE_NAME = "JSON.json";

    public static JSONArray loadData() {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(SAVE_FILE_NAME);
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;
            reader.close();
            return userList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveData(JSONArray userList){
        try {
            FileWriter writer = new FileWriter(SAVE_FILE_NAME);
            writer.write(userList.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(String username, String password, String email) {
        JSONObject user = new JSONObject();
        user.put(USERNAME, username);
        user.put(PASSWORD, password);
        user.put(EMAIL, email);
        user.put(TRANSACTIONS, "");

        JSONArray userList = loadData();
        userList.add(user);
        saveData(userList);

    }

    public void addTransaction(String username, double amount, Date date, String description){
        JSONObject transaction = new JSONObject();
        transaction.put(AMOUNT, amount);
        transaction.put(DATE, date);
        transaction.put(DESCRIPTION, description);
        transaction.put(ID, getRandomID().toString());


        JSONArray userList = loadData();
        userList.forEach(currentUser -> {
            if (compareUser((JSONObject) currentUser, username)){
                JSONArray trans = (JSONArray) ((JSONObject) currentUser).get(TRANSACTIONS);
                trans.add(transaction);
                return;
            }});
        saveData(userList);

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





}
