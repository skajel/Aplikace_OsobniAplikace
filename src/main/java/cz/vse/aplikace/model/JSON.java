package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class JSON {
    public static final String SAVE_FILE_NAME = "JSON.json";

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

    public static boolean compareUserInfo(JSONObject user, String defaultTerm, String type){
        String searchedTerm = (String) user.get(type);
        if (defaultTerm.equals(searchedTerm)){
            return true;
        }
        return false;
    }

    public static boolean findEmail(String email) {
        JSONArray userList = JSON.loadData();
        AtomicBoolean value = new AtomicBoolean(false);
        userList.forEach(currentUser -> {
            if (JSON.compareUserInfo((JSONObject) currentUser, email, MainController.EMAIL)) {
                value.set(true);
                return;
            }
        });
        return value.get();
    }

    public static JSONObject findUser(String email){
        JSONArray userList = JSON.loadData();
        AtomicReference<JSONObject> user = new AtomicReference<>(null);
        userList.forEach(currentUser -> {
            if (JSON.compareUserInfo((JSONObject) currentUser, email, MainController.EMAIL)) {
                user.set((JSONObject) currentUser);
                return;
            }
        });
        return user.get();
    }





}
