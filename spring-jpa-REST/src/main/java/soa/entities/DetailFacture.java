package soa.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class DetailFacture
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetail;

    @ManyToOne
    @JoinColumn(name = "idFacture")
    private Facture facture;

    private int quantite;
    private double montant;


    public Long getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(Long idDetail) {
        this.idDetail = idDetail;
    }

    public DetailFacture() {
        super();
    }

    public DetailFacture(Facture facture, int quantite, double montant) {
        this.facture = facture;
        this.quantite = quantite;
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "DetailFacture[" +
                "idDetail=" + idDetail +
                ", facture=" + facture +
                ", quantite=" + quantite +
                ", montant=" + montant +
                ']';
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}

