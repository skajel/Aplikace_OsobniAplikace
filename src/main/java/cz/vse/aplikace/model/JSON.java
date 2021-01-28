package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Třída cz.vse.aplikace.model.JSON je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 *
 * Tato třída slouží k práci s JSON.json pomocí několika metod a obsahuje pomocné funkce pro controllery.
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */

public class JSON {
    public static final String SAVE_FILE_NAME = "JSON.json";
    private static JSONObject currentUser;

    /**
     * Metoda, která určí aktuálního/přihlášeného uživatele
     */
    public static void setCurrentUser(JSONObject user){
        currentUser = user;
    }

    /**
     * Metoda, která vrací aktuálního uživatele
     */
    public static JSONObject getCurrentUser(){
        return currentUser;
    }

    /**
     * Metoda, která načítá data z JSON souboru
     */
    public static JSONArray loadData() {
        try {
            FileReader reader = new FileReader(SAVE_FILE_NAME);
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;
            reader.close();
            return userList;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Metoda, která ukládá data do JSON souboru
     */
    public static void saveData(JSONArray userList){
        try {
            FileWriter writer = new FileWriter(SAVE_FILE_NAME);
            writer.write(userList.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda, která porovnává JSONObjecty se požadovanými hodnotami
     */
    public static boolean compareUserInfo(JSONObject user, String defaultTerm, String type){
        String searchedTerm = (String) user.get(type);
        return defaultTerm.equals(searchedTerm);
    }

    /**
     * Metoda, která vrací unikátní email aktuálního/přihlášeného uživatele
     */
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

    /**
     * Metoda, která vrací uživatelské jméno aktuálního/přihlášeného uživatele
     */
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

    /**
     * Metoda, která slouží k změněn uživatelského jmnéna aktuálního uživatele a zapsání této změny do souboru JSON.json
     */
    public static void changeStateInUser(String str, String type){
        JSONObject currentUser = JSON.getCurrentUser();
        currentUser.replace(type, str);
        JSON.setCurrentUser(currentUser);
        JSONArray userList = JSON.loadData();
        JSONObject currentUserInJSON = JSON.findUser((String) JSON.getCurrentUser().get(MainController.EMAIL));
        userList.remove(currentUserInJSON);
        userList.add(currentUser);
        JSON.saveData(userList);
    }

    public static void addTransactionToUser(JSONObject tran){
        JSONObject currentUser = JSON.getCurrentUser();
        JSONArray transactions = (JSONArray) currentUser.get(MainController.TRANSACTIONS);
        transactions.add(tran);
        currentUser.replace(MainController.TRANSACTIONS, transactions);
        JSON.setCurrentUser(currentUser);
    }





}
