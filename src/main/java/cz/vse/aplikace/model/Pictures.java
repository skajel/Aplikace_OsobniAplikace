package cz.vse.aplikace.model;

import java.util.Arrays;
import java.util.HashMap;

public enum Pictures {
    PICTURE1(1,"picture1"),
    PICTURE2(2,"picture2"),
    PICTURE3(3,"picture3");

    private static HashMap<Integer, Pictures> enumById = new HashMap<>();
    static {
        Arrays.stream(values()).forEach(e -> enumById.put(e.getId(), e));
    }

    public static Pictures getById(int id) {
        return enumById.getOrDefault(id, PICTURE1);
    }

    private int id;
    private String description;

    private Pictures(int id, String description) {
        this.id = id;
        this.description= description;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
