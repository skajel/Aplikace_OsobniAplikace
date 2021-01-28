package cz.vse.aplikace.model;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Třída cz.vse.aplikace.model.Category je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 *
 * Enum pro výběr Category .
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */


public enum Category {
    RENT(1,"SPENDING"),
    ENTERTAINMENT(2,"SPENDING"),
    BUSINESS(3,"SPENDING"),
    SPORT(4,"SPENDING"),
    GROCERIES(5,"SPENDING"),
    CHILDREN(6,"SPENDING"),
    OTHER(7,"SPENDING"),
    ONLINE(8,"SPENDING"),
    WAGE(9,"GAIN"),
    LOTTERY(10,"GAIN");

    private static HashMap<Integer, Category> enumById = new HashMap<>();
    static {
        Arrays.stream(values()).forEach(e -> enumById.put(1, e));
    }

    public static Category getById(int id) {
        return enumById.getOrDefault(id, RENT);
    }
    public static Category getByDescribtion(String description) {
        return enumById.getOrDefault(description, RENT);
    }

    private int id;
    private String description;

    private Category(int id, String description) {
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


