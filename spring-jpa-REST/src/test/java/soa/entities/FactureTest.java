package soa.entities;

import org.junit.jupiter.api.Test;
import soa.entities.Facture;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactureTest {

    @Test
    void testGetId() {
        Long expectedId = 1L;
        Facture facture = new Facture();
        facture.setId(expectedId);

        Long actualId = facture.getId();

        assertEquals(expectedId, actualId);
    }

    @Test
    void testGetDateFacture() {
        Date expectedDate = null /* Initialize your expected date */;
        Facture facture = new Facture();
        facture.setDateFacture(expectedDate);

        Date actualDate = facture.getDateFacture();

        assertEquals(expectedDate, actualDate);
    }

    @Test
    void testGetStatus() {
        String expectedStatus = "réglé";
        Facture facture = new Facture();
        facture.setStatus(expectedStatus);

        String actualStatus = facture.getStatus();

        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    void testSetId() {
        Long expectedId = 2L;
        Facture facture = new Facture();
        facture.setId(expectedId);

        Long actualId = facture.getId();

        assertEquals(expectedId, actualId);
    }

    @Test
    void testSetDateFacture() {
        Date expectedDate = null /* Initialize your expected date */;
        Facture facture = new Facture();
        facture.setDateFacture(expectedDate);

        Date actualDate = facture.getDateFacture();

        assertEquals(expectedDate, actualDate);
    }

    @Test
    void testSetStatus() {
        String expectedStatus = "non réglé";
        Facture facture = new Facture();
        facture.setStatus(expectedStatus);

        String actualStatus = facture.getStatus();

        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    void testToString() {
        Long id = 1L;
        Date date = null /* Initialize your expected date */;
        String status = "réglé";
        Facture facture = new Facture(id, date, status);

        String expectedString = "Facture[id=1, dateFacture=" + date + ", status='réglé']";
        String actualString = facture.toString();

        assertEquals(expectedString, actualString);
    }
}
