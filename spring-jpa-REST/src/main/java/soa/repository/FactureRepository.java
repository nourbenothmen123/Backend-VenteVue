package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import soa.entities.Facture;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    @Query("SELECT SUM(df.montant) FROM DetailFacture df WHERE MONTH(df.facture.dateFacture) = :month AND YEAR(df.facture.dateFacture) = :year")
    Double calculateCAByMonthAndYear(@Param("month") int month, @Param("year") int year);

    @Query("SELECT SUM(df.montant) FROM DetailFacture df WHERE YEAR(df.facture.dateFacture) = :year")
    Double calculateCAByYear(@Param("year") int year);
    //la méthode générera automatiquement une requête SQL du type SELECT * FROM Facture WHERE status = :status
    List<Facture> findByStatus(String status); // Trouver les factures par status (réglé/non réglé)


    /*@Query(value = "SELECT status, (COUNT(*) * 100 / (SELECT COUNT(*) FROM Facture)) AS percentage " +
            "FROM Facture GROUP BY status", nativeQuery = true)
    List<Facture> getPercentageGroupByStatus();*/

}
