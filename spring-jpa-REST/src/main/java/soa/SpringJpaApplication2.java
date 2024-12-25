package soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import soa.dao.DetailFactureInterface;
import soa.dao.FactureMetierInterface;
import soa.entities.Categorie;
import soa.entities.DetailFacture;
import soa.entities.Facture;
import soa.entities.Produit;
import soa.dao.ProduitMetierInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringJpaApplication2 {
    //déclaration des objets de type Repository
    //Déclaration d'un objet métier pour gérer les produits
    static ProduitMetierInterface produitMetier;
    static FactureMetierInterface factureMetier;
    static DetailFactureInterface detailMetier;

    public static void main(String[] args) {
        System.out.println("---------Injection de dépendances----------");
        //Commencer par réaliser les injections de dépendances pour les objets de type Repository
        // référencer le contexte
        ApplicationContext contexte = SpringApplication.run(SpringJpaApplication2.class, args);
        // Récupérer une implémentation de l'interface "ProduitRepository" par injection de dépendance
        produitMetier = contexte.getBean(ProduitMetierInterface.class);
        factureMetier=contexte.getBean(FactureMetierInterface.class);
        detailMetier = contexte.getBean(DetailFactureInterface.class);

        //objet pour formater les dates selon le pattern "yyyy-MM-dd"
        //objet pour formater les dates selon le pattern "yyyy-MM-dd"
        SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date datef1 =null;
        java.util.Date datef2 =null;
        java.util.Date datef3 =null;
        java.util.Date datef4 =null;
        java.util.Date datef5 =null;
        java.util.Date datef6 =null;
        java.util.Date datef7 =null;
        java.util.Date datef8 =null;
        java.util.Date datef9 =null;
        java.util.Date datef10 =null;
        java.util.Date datef11 =null;
        java.util.Date datef12 =null;
        java.util.Date datef13 =null;
        java.util.Date datef14 =null;
        java.util.Date datef15 =null;
        //trois objets de type date
        try
        {
            datef1 = sdff.parse("2023-09-31");
            datef2 = sdff.parse("2023-11-01");
            datef3 = sdff.parse("2023-06-02");
            datef4 = sdff.parse("2023-12-03");
            datef5 = sdff.parse("2023-12-04");
            datef6 = sdff.parse("2023-12-05");
            datef7 = sdff.parse("2022-06-01");
            datef8 = sdff.parse("2022-07-03");
            datef9 = sdff.parse("2022-07-04");
            datef10 = sdff.parse("2021-02-01");
            datef11 = sdff.parse("2021-03-01");
            datef12 = sdff.parse("2020-09-03");
            datef13 = sdff.parse("2020-08-04");
            datef14 = sdff.parse("2019-02-01");
            datef15 = sdff.parse("2019-03-01");

            System.out.println("-la date est est bien parsé");
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Insérer une facture
        System.out.println("-2-Insérer une facture ----------");
        Facture fac1 =new Facture( datef1 ,"réglé");
        factureMetier.ajouterFacture(fac1);
        Facture fac2 =new Facture( datef2 ,"réglé");
        factureMetier.ajouterFacture(fac2);
        Facture fac3 =new Facture( datef3 ,"réglé");
        factureMetier.ajouterFacture(fac3);
        Facture fac4 =new Facture( datef4 ,"réglé");
        factureMetier.ajouterFacture(fac4);
        Facture fac5 =new Facture( datef5 ,"non réglé");
        factureMetier.ajouterFacture(fac5);
        Facture fac6 =new Facture( datef6 ,"non réglé");
        factureMetier.ajouterFacture(fac6);
        Facture fac7 =new Facture( datef7 ,"réglé");
        factureMetier.ajouterFacture(fac7);
        Facture fac8 =new Facture( datef8 ,"réglé");
        factureMetier.ajouterFacture(fac8);
        Facture fac9 =new Facture( datef9 ,"non réglé");
        factureMetier.ajouterFacture(fac9);
        Facture fac10 =new Facture( datef10 ,"réglé");
        factureMetier.ajouterFacture(fac10);
        Facture fac11 =new Facture( datef11 ,"réglé");
        factureMetier.ajouterFacture(fac11);
        Facture fac12 =new Facture( datef12 ,"réglé");
        factureMetier.ajouterFacture(fac12);
        Facture fac13 =new Facture( datef13 ,"réglé");
        factureMetier.ajouterFacture(fac13);
        Facture fac14 =new Facture( datef14 ,"réglé");
        factureMetier.ajouterFacture(fac14);
        Facture fac15 =new Facture( datef15 ,"réglé");
        factureMetier.ajouterFacture(fac15);

        afficherTousLesFactures();

        System.out.println("-2-Insérer détail facture ----------");
        DetailFacture df1 =new DetailFacture(fac1,100,2000);
        detailMetier.ajouterDetailFacture(df1);
        DetailFacture df2 =new DetailFacture(fac2,150,2700);
        detailMetier.ajouterDetailFacture(df2);
        DetailFacture df3 =new DetailFacture(fac3,250,2800);
        detailMetier.ajouterDetailFacture(df3);
        DetailFacture df4 =new DetailFacture(fac4,50,10200);
        detailMetier.ajouterDetailFacture(df4);
        DetailFacture df5 =new DetailFacture(fac5,250,8000);
        detailMetier.ajouterDetailFacture(df5);
        DetailFacture df6 =new DetailFacture(fac6,40,1700);
        detailMetier.ajouterDetailFacture(df6);
        DetailFacture df7 =new DetailFacture(fac7,100,2000);
        detailMetier.ajouterDetailFacture(df7);
        DetailFacture df8 =new DetailFacture(fac8,40,1000);
        detailMetier.ajouterDetailFacture(df8);
        DetailFacture df9 =new DetailFacture(fac9,80,1700);
        detailMetier.ajouterDetailFacture(df9);
        DetailFacture df10 =new DetailFacture(fac10,400,8000);
        detailMetier.ajouterDetailFacture(df10);
        DetailFacture df11 =new DetailFacture(fac11,40,700);
        detailMetier.ajouterDetailFacture(df11);
        DetailFacture df12 =new DetailFacture(fac12,41,10000);
        detailMetier.ajouterDetailFacture(df12);
        DetailFacture df13 =new DetailFacture(fac13,60,7000);
        detailMetier.ajouterDetailFacture(df13);
        DetailFacture df14 =new DetailFacture(fac14,40,7000);
        detailMetier.ajouterDetailFacture(df14);
        DetailFacture df15 =new DetailFacture(fac15,40,7400);
        detailMetier.ajouterDetailFacture(df15);
        afficherTousLesDetailsFactures();




        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = null;
        java.util.Date date2 = null;
        java.util.Date date3 = null;
        java.util.Date date4 = null;
        java.util.Date dateFinPromotion = null;
        //trois objets de type date
        try
        {
            date1 = sdf.parse("2021-04-15");
            date2 = sdf.parse("2022-02-20");
            date3 = sdf.parse("2023-01-10");
            date4 = sdf.parse("2023-05-15");
            dateFinPromotion = sdf.parse("2023-01-01");
            System.out.println("-la date est est bien parsé");
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




        // Insérer un produit sans catégorie et sans stock
        System.out.println("-2-Insérer un produit 'Ordinateur' sans catégorie et sans stock ----------");
        Produit pOrdinateur =new Produit("Ordinateur", 2400, 1, date1 );
        produitMetier.ajouterProduit(pOrdinateur);
        afficherTousLesProduits();


        // Insérer un produit avec catégorie et sans stock
        System.out.println("-2-Insérer un produit 'Imprimate' avec la catégorie 'Informatique' et sans stock ----------");
        Produit pImprimante =new Produit("Imprimante", 500, 10, date2 );
        Categorie catInformatique = new Categorie("INF", "Informatique");
        produitMetier.ajouterProduit(pImprimante,catInformatique);
        afficherTousLesProduits();

        // Insérer un produit avec catégorie et sans stock
        System.out.println("-3-Insérer un produit 'Tablette' avec la catégorie 'Jouet' et sans stock ----------");
        Produit pTablette =new Produit("Tablette", 300, 3, date3 );
        Categorie catJouet = new Categorie("JOUET", "Jouets");
        produitMetier.ajouterProduit(pTablette,catJouet);
        afficherTousLesProduits();


        // Changer la catégorie du produit 'Tablette' à 'Informatique'
        System.out.println("-5-Changer la catégorie du produit 'Tablette' à 'Informatique'");
        boolean resultat =produitMetier.changerCategorieProduit(3L,1L);
        if (resultat)
            System.out.println("----Succès du changement de catégorie----'");
        else
            System.out.println("----Echec du changement de catégorie----'");
        afficherTousLesProduits();

        //Rendre tous les produits achetés avant '2023' en promotion
        System.out.println("-6-Rendre tous les produits achetés avant '2023' en promotion");
        produitMetier.rendreProduitsEnPromotionAvant(dateFinPromotion);
        afficherTousLesProduits();

    }

    private static void afficherTousLesDetailsFactures() {
        System.out.println("********************Début**********************");
        System.out.println("Afficher tous les details factures...");
        System.out.println("***********************************************");

        List<DetailFacture> ldf = detailMetier.listeDetailsFactures();
        for (DetailFacture df : ldf)
        {
            System.out.println(df);
        }
        System.out.println("********************Fin************************");
    }

    private static void afficherTousLesFactures() {
        System.out.println("********************Début**********************");
        System.out.println("Afficher tous les factures...");
        System.out.println("***********************************************");

        List<Facture> lfc = factureMetier.listeFactures();
        for (Facture f : lfc)
        {
            System.out.println(f);
        }
        System.out.println("********************Fin************************");
    }


    static void afficherTousLesProduits()
    {
        System.out.println("********************Début**********************");
        System.out.println("Afficher tous les produits...");
        System.out.println("***********************************************");

        List<Produit> lp = produitMetier.listeProduits();
        for (Produit p : lp)
        {
            System.out.println(p);
        }
        System.out.println("********************Fin************************");
    }



}
