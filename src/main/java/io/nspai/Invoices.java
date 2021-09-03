package io.nspai;

import java.util.Date;

public class Invoices {

    private Integer itemId;
    private String itemName;
    private Integer itemQuantity;
    private Double totalPrice;
    private Date itemSoldDate;

    public Invoices() {
    }

    public Invoices(Integer itemId, String itemName, Integer itemQuantity, Double totalPrice, Date itemSoldDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.totalPrice = totalPrice;
        this.itemSoldDate = itemSoldDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getItemSoldDate() {
        return itemSoldDate;
    }

    public void setItemSoldDate(Date itemSoldDate) {
        this.itemSoldDate = itemSoldDate;
    }
}
