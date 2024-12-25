package soa.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import soa.dao.DetailFactureMetierImpl;
import soa.entities.DetailFacture;
import soa.repository.DetailFactureRepository;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DetailFactureMetierImplTest {

    @Mock
    private DetailFactureRepository detailRepository;

    @InjectMocks
    private DetailFactureMetierImpl detailFactureMetier;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialisation des mocks
    }

    @Test
    void testAjouterDetailFacture() {
        DetailFacture df1 = new DetailFacture();

        detailFactureMetier.ajouterDetailFacture(df1);

        verify(detailRepository).save(df1);
    }

    @Test
    void testListeDetailsFactures() {
        DetailFacture detail1 = new DetailFacture();
        DetailFacture detail2 = new DetailFacture();

        when(detailRepository.findAll()).thenReturn(Arrays.asList(detail1, detail2));

        List<DetailFacture> actualDetails = detailFactureMetier.listeDetailsFactures();
        //verification
        assertEquals(2, actualDetails.size());
    }
}
