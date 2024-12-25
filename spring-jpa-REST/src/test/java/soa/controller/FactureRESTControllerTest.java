package soa.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import soa.controller.FactureRESTController;
import soa.dao.FactureMetierInterface;
import soa.entities.Facture;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class FactureRESTControllerTest {

    @Mock
    private FactureMetierInterface factureMetier;

    @InjectMocks
    private FactureRESTController factureRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCalculateCAByMonthAndYear() {
        int month = 10;
        int year = 2023;
        double expectedCA = 5000.0;

        when(factureMetier.calculateCAByMonthAndYear(month, year)).thenReturn(expectedCA);

        double actualCA = factureRestController.calculateCAByMonthAndYear(month, year);

        assertEquals(expectedCA, actualCA);
    }

    @Test
    void testCalculateCAByYear() {
        int year = 2023;
        double expectedCA = 25000.0;

        when(factureMetier.calculateCAByYear(year)).thenReturn(expectedCA);

        double actualCA = factureRestController.calculateCAByYear(year);

        assertEquals(expectedCA, actualCA);
    }

    @Test
    void testGetFacturesByStatus() {
        String status = "réglé";
        Facture facture1 = new Facture(/* initialize facture */);
        Facture facture2 = new Facture(/* initialize facture */);
        List<Facture> expectedFactures = Arrays.asList(facture1, facture2);

        when(factureMetier.findFacturesByStatus(status)).thenReturn(expectedFactures);

        List<Facture> actualFactures = factureRestController.getFacturesByStatus(status);

        assertEquals(expectedFactures, actualFactures);
    }
}
