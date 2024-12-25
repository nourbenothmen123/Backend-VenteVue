package soa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.DetailFacture;
import soa.repository.DetailFactureRepository;

import java.util.List;

@Service
public class DetailFactureMetierImpl implements DetailFactureInterface{
    //injecter automatiquement une instance de DetailFactureRepository dans la classe DetailFactureMetierImpl
    @Autowired
    private DetailFactureRepository detailRepository;
    @Override
    public void ajouterDetailFacture(DetailFacture df1) {
        detailRepository.save(df1);
    }

    @Override
    public List<DetailFacture> listeDetailsFactures() {
        return detailRepository.findAll();
    }
}
