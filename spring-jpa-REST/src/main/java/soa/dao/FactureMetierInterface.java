package soa.dao;

import soa.entities.Facture;
import soa.entities.Produit;

import java.util.List;

//FactureService
public interface FactureMetierInterface {
    Double calculateCAByMonthAndYear(int month, int year);

    Double calculateCAByYear(int year);
    List<Facture> findFacturesByStatus(String status);
    void ajouterFacture(Facture f);


    List<Facture> listeFactures();
}
