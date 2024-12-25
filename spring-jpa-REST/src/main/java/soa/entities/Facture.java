package soa.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Facture
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    @Column(length = 50)
    private String status;

    public Facture(Date date1,String status) {
        this.dateFacture=date1;
        this.status=status;
    }
    public Facture() {
        super();

    }

    @Override
    public String toString() {
        return "Facture[" +
                "id=" + id +
                ", dateFacture=" + dateFacture +
                ", status='" + status + '\'' +
                ']';
    }

    public Facture(Long id, Date dateFacture, String status) {
        this.id = id;
        this.dateFacture = dateFacture;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

