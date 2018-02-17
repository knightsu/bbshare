package com.restbox.datatype;

import java.io.Serializable;

public enum ItemType implements Serializable{
    PHYSICAL("real stuff"),
    VERTUAL("account");

    private String itemType;

    ItemType(String itemType) {
        this.itemType=itemType;
    }

    public String getItemType() {
        return itemType;
    }

    public static ItemType getItemType(String itemType) {
        for(ItemType itemType1 : ItemType.values()) {
            if(itemType1.getItemType().equals(itemType)) {
                return itemType1;
            }
        }
        return VERTUAL;
    }
}
