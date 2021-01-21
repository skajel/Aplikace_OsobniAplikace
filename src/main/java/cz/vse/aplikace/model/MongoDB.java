package cz.vse.aplikace.model;

import com.mongodb.*;


public class MongoDB{
    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection users;


    public static void main(String[]args){
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB("MongoDB");
        users = database.getCollection("users");
    }



}
