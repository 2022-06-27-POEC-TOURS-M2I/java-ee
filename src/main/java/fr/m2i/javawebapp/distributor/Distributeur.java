package fr.m2i.javawebapp.distributor;

import java.util.ArrayList;
import java.util.List;

public class Distributeur {

    private static Distributeur instance;

    private int credit;
    private List<Produit> stock;

    public static Distributeur getInstance() {

        if (instance == null) {
            instance = new Distributeur();
        }

        return instance;
    }

    private Distributeur() {
        credit = 0;
        stock = new ArrayList();
        remplirLeStock();
    }
    
    public void remplirLeStock() {
        stock.add(new Produit(1, "café", 1, 5));
        stock.add(new Produit(2, "soda", 2, 5));
        stock.add(new Produit(3, "barre céréales", 3, 5));
    }

    public void insererArgent(int montant) {
        credit += montant;
    }

    public boolean stockSuffisant(int idProduit) {
        Produit produit = getProduit(idProduit);
        return produit != null && produit.getQuantite() >= 1;
    }

    public boolean creditSuffisant(int idProduit) {
        Produit produit = getProduit(idProduit);
        return produit != null && credit >= produit.getPrix();
    }

    public void commanderProduit(int idProduit){

        if(stockSuffisant(idProduit) && creditSuffisant(idProduit)) {
            Produit produit = getProduit(idProduit);

            produit.setQuantite(produit.getQuantite() - 1);
            credit -= produit.getPrix(); 
        }
    }
    
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List<Produit> getStock() {
        return stock;
    }

    public void setStock(List<Produit> stock) {
        this.stock = stock;
    }
    
    public Produit getProduit(int id) {
        for (Produit produit: stock) {
           if (produit.getId() == id){
               return produit;
           }
        }
        return null;
    }
    
}