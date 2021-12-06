package com.example.monitorlizard;

//Template for meal items created by user.
public class MealItem {

    private String itemName;
    private String itemQuantity;
    private String itemUnits;

    public MealItem(String itemName, String itemUnits, String itemQuantity) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemUnits = itemUnits;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemUnits() {
        return itemUnits;
    }

    public void setItemUnits(String itemUnits) {
        this.itemUnits = itemUnits;
    }
}
