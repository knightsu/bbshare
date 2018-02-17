package com.restbox.datatype;

import java.io.Serializable;

public enum Category implements Serializable{

    CLEAN("cleaning"),
    MEMBERSHIP("membership"),
    ROOM("room"),
    KITCHEN("kitchen appliance"),
    SPORT("sport other"),
    CLOTH("clothing"),
    FURNITURE("furniture"),
    BOOK("book"),
    DVD("dvd"),
    GAME("game account"),
    DECOR("decoration"),
    OTHER("other");

    private String category;

    Category(String category) {
        this.category=category;
    }

    public String getCategory() {
        return category;
    }

    public static Category getCategory(String category) {
        for(Category category1 : Category.values()) {
            if(category1.getCategory().equals(category)) {
                return category1;
            }
        }
        return OTHER;
    }
}
