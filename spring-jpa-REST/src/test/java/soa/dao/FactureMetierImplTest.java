package soa.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import soa.dao.FactureMetierImpl;
import soa.dao.FactureMetierInterface;
import soa.entities.Facture;
import soa.repository.FactureRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FactureMetierImplTest {

    @Mock
    private FactureRepository factureRepository;

    private FactureMetierInterface factureMetier;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialisation des mocks
        factureMetier = new FactureMetierImpl(factureRepository);
    }

    @Test
    void testCalculateCAByMonthAndYear() {
        when(factureRepository.calculateCAByMonthAndYear(1, 2023)).thenReturn(1000.0);

        Double actualCA = factureMetier.calculateCAByMonthAndYear(1, 2023);

        assertEquals(1000.0, actualCA);
    }

    @Test
    void testCalculateCAByYear() {
        when(factureRepository.calculateCAByYear(2023)).thenReturn(5000.0);

        Double actualCA = factureMetier.calculateCAByYear(2023);

        assertEquals(5000.0, actualCA);
    }
    @Test
    void testFindFacturesByStatus() {
        factureMetier = new FactureMetierImpl(factureRepository);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = null;
        Date date2 = null;
        try {
            date1 = dateFormat.parse("2023-12-10");
            date2 = dateFormat.parse("2023-12-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Facture facture1 = new Facture(date1, "réglé");
        Facture facture2 = new Facture(date2, "réglé");

        when(factureRepository.save(facture1)).thenReturn(facture1);
        when(factureRepository.save(facture2)).thenReturn(facture2);

        when(factureRepository.findByStatus("réglé")).thenReturn(Arrays.asList(facture1, facture2));

        factureMetier.ajouterFacture(facture1);
        factureMetier.ajouterFacture(facture2);

        List<Facture> actualFactures = factureMetier.findFacturesByStatus("réglé");
        //verification de size expected et actual(ce qui trouve)
        assertEquals(2, actualFactures.size());
    }




}
