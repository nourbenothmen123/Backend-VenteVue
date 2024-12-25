package soa.dao;

import soa.entities.DetailFacture;

import java.util.List;

public interface DetailFactureInterface {
    void ajouterDetailFacture(DetailFacture df1);

    List<DetailFacture> listeDetailsFactures();
}
