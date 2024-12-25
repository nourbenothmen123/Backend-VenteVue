package soa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Facture;
import soa.repository.FactureRepository;

import java.util.List;
@Service
public class FactureMetierImpl implements FactureMetierInterface{
    private final FactureRepository factureRepository;

    public FactureMetierImpl(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }
    @Override
    public Double calculateCAByMonthAndYear(int month, int year) {
        return factureRepository.calculateCAByMonthAndYear(month, year);
    }

    @Override
    public Double calculateCAByYear(int year) {
        return factureRepository.calculateCAByYear(year);
    }

    @Override
    public List<Facture> findFacturesByStatus(String status) {
        return factureRepository.findByStatus(status);
    }

    @Override
    public void ajouterFacture(Facture f) {
        factureRepository.save(f);
    }

    @Override
    public List<Facture> listeFactures() {
        return factureRepository.findAll();
    }

}
