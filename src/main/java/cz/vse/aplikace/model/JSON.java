package cz.vse.aplikace.model;

import org.json.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class JSON {
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";




    public static void main(String[] args) throws FileNotFoundException {
        JSONArray users = new JSONArray();


        Map m = new LinkedHashMap<>();

        m. put("firstName", "Ondra");
        m. put("lastName", "Štěpán");
        m. put("userName", "ska");
        m. put("password", "123");
        m. put("email", "ondra@gmail.com");

        Map tran = new LinkedHashMap<>();

        tran.put("amount", "100");
        tran.put("date", "28.6.2020");
        tran.put("description", "přidána transakce");

        m.put("transactions", tran);
        users.put(m);


        try(FileWriter file = new FileWriter("JSON.json")){
            file.write(users.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println(users);


    }

    public String getRandomID(){

        return id;
    }

}
