package cz.vse.aplikace.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

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





}
