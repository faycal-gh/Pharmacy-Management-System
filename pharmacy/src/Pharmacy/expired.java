package Pharmacy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 0day
 */
public class expired {

    String name, quantity, nlot, price, expdate;

    public expired(String name, String quantity, String nlot, String price, String expdate) {
        this.name = name;
        this.quantity = quantity;
        this.nlot = nlot;
        this.price = price;
        this.expdate = expdate;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getNlot() {
        return nlot;
    }

    public String getPrice() {
        return price;
    }

    public String getExpdate() {
        return expdate;
    }
    
    
}
