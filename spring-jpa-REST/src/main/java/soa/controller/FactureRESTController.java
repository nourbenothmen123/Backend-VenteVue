package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.dao.FactureMetierInterface;
import soa.entities.Facture;

import java.util.List;
@RequestMapping("/factures")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FactureRESTController {
    private final FactureMetierInterface FactureMetier;

    @Autowired
    public FactureRESTController(FactureMetierInterface factureMetier) {
        this.FactureMetier = factureMetier;
    }

    @GetMapping("/calculateCAByMonthAndYear")
    public Double calculateCAByMonthAndYear(int month, int year) {
        return FactureMetier.calculateCAByMonthAndYear(month, year);
    }

    @GetMapping("/calculateCAByYear")
    public Double calculateCAByYear(int year) {
        return FactureMetier.calculateCAByYear(year);
    }
    @GetMapping(value = "/status/{status}")
    public List<Facture> getFacturesByStatus(@PathVariable String status) {
        return FactureMetier.findFacturesByStatus(status);
    }

}
