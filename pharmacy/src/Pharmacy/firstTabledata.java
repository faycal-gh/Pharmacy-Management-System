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
public class firstTabledata {
    public String nom,quantity,nlot,prix,expdate,montant;
    public int ID;
    public firstTabledata(int ID, String nom, String nlot, String expdate, String quantity, String prix, String montant){
        this.ID = ID;
        this.nom = nom;
        this.nlot = nlot;
        this.expdate = expdate;
        this.quantity = quantity;
        this.prix = prix;
        this.montant = montant;   
    }       

    public int getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getNlot() {
        return nlot;
    }

    public String getPrix() {
        return prix;
    }

    public String getExpdate() {
        return expdate;
    }

    public String getMontant() {
        return montant;
    }
    
}
