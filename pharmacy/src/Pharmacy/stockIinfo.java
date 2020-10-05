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
public class stockIinfo {
    public String nom,quantity,nlot,prix,expdate,montant;
    public stockIinfo(){
        
    }
    public stockIinfo(String nom, String quantity, String nlot, String prix, String expdate){
        this.nom = nom;
        this.quantity = quantity;
        this.nlot = nlot;
        this.prix = prix;
        this.expdate = expdate;
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
