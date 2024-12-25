package soa.entities;

import org.junit.jupiter.api.Test;
import soa.entities.DetailFacture;
import soa.entities.Facture;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetailFactureTest {

    @Test
    void testGetIdDetail() {
        Long expectedId = 1L;
        DetailFacture detailFacture = new DetailFacture();
        detailFacture.setIdDetail(expectedId);

        Long actualId = detailFacture.getIdDetail();

        assertEquals(expectedId, actualId);
    }

    @Test
    void testGetFacture() {
        Facture expectedFacture = new Facture();
        DetailFacture detailFacture = new DetailFacture();
        detailFacture.setFacture(expectedFacture);

        Facture actualFacture = detailFacture.getFacture();

        assertEquals(expectedFacture, actualFacture);
    }

    @Test
    void testGetQuantite() {
        int expectedQuantite = 5;
        DetailFacture detailFacture = new DetailFacture();
        detailFacture.setQuantite(expectedQuantite);

        int actualQuantite = detailFacture.getQuantite();

        assertEquals(expectedQuantite, actualQuantite);
    }

    @Test
    void testGetMontant() {
        double expectedMontant = 100.0;
        DetailFacture detailFacture = new DetailFacture();
        detailFacture.setMontant(expectedMontant);

        double actualMontant = detailFacture.getMontant();

        assertEquals(expectedMontant, actualMontant);
    }

    @Test
    void testSetIdDetail() {
        Long expectedId = 2L;
        DetailFacture detailFacture = new DetailFacture();
        detailFacture.setIdDetail(expectedId);

        Long actualId = detailFacture.getIdDetail();

        assertEquals(expectedId, actualId);
    }

    @Test
    void testSetFacture() {
        Facture expectedFacture = new Facture();
        DetailFacture detailFacture = new DetailFacture();
        detailFacture.setFacture(expectedFacture);

        Facture actualFacture = detailFacture.getFacture();

        assertEquals(expectedFacture, actualFacture);
    }

    @Test
    void testSetQuantite() {
        int expectedQuantite = 10;
        DetailFacture detailFacture = new DetailFacture();
        detailFacture.setQuantite(expectedQuantite);

        int actualQuantite = detailFacture.getQuantite();

        assertEquals(expectedQuantite, actualQuantite);
    }

    @Test
    void testSetMontant() {
        double expectedMontant = 150.0;
        DetailFacture detailFacture = new DetailFacture();
        detailFacture.setMontant(expectedMontant);

        double actualMontant = detailFacture.getMontant();

        assertEquals(expectedMontant, actualMontant);
    }

    @Test
    void testToString() {
        Long id = 1L;
        Facture facture = new Facture();
        int quantite = 5;
        double montant = 100.0;
        DetailFacture detailFacture = new DetailFacture(facture, quantite, montant);
        detailFacture.setIdDetail(id);

        String expectedString = "DetailFacture[idDetail=1, facture=" + facture + ", quantite=5, montant=100.0]";
        String actualString = detailFacture.toString();

        assertEquals(expectedString, actualString);
    }
}
