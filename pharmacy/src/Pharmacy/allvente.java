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
public class allvente {
    String nofacture, montant;
    
    public allvente(String nofacture, String montant){
        this.nofacture = nofacture;
        this.montant = montant;
        
    }

    public String getNofacture() {
        return nofacture;
    }

    public String getMontant() {
        return montant;
    }
   
    
}
