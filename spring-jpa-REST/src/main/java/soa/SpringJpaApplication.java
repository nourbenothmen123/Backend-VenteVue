package soa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import soa.entities.Categorie;
import soa.entities.Produit;
import soa.repository.CategorieRepository;
import soa.repository.ProduitRepository;


@SpringBootApplication
public class SpringJpaApplication
{
    //déclaration des objets de type Repository
    //Déclaration d'un repository pour gérer les produits
    static ProduitRepository produitRepos ;
    //Déclaration d'un repository pour gérer les catégories
    static CategorieRepository categorieRepos;

    public static void main(String[] args)
    {
        System.out.println("---------Démarrage----------");
        //Commencer par réaliser les injections de dépendances pour les objets de type Repository
        // référencer le contexte
        ApplicationContext contexte = SpringApplication.run(SpringJpaApplication.class,args);

        // Récupérer une implémentation de l'interface "ProduitRepository" par injection de dépendance
        produitRepos =contexte.getBean(ProduitRepository.class);
        // Récupérer une implémentation de l'interface "CategorieRepository" par injection de dépendance
        categorieRepos =contexte.getBean(CategorieRepository.class);

        System.out.println("---------Insertion de deux catégories----------");
        // créer deux catégories (en mémoire)
        Categorie cat1 = new Categorie("AL", "Alimentaire");
        Categorie cat2 = new Categorie("PL", "Plastique");

        //Attacher les deux catégories à la BD (insertion)
        categorieRepos.save(cat1);
        categorieRepos.save(cat2);

        //objet pour formater les dates selon le pattern "yyyy-MM-dd"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = null;
        java.util.Date date2 = null;
        java.util.Date date3 = null;

        //trois objets de type date
        try {
            date1 = sdf.parse("2023-04-15");
            date2 = sdf.parse("2023-02-15");
            date3 = sdf.parse("2023-05-15");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Insérer 3 produits
        System.out.println("---------Insertion de trois produits----------");
        Produit p1 =new Produit("Yaourt", 0.400, 20, date1 , cat1);
        Produit p2 =new Produit("Chocolat", 2000.0, 5, date2, cat1);
        Produit p3 =new Produit("Panier", 1.200, 30, date3, cat2);

        produitRepos.save(p1);
        produitRepos.save(p2);
        produitRepos.save(p3);

        //Afficher la liste des produits
        afficherTousLesProduits();

        //Afficher la liste des produits d'une catégorie donnée
        afficherTousLesProduitsDeLaCategorie(1L);


        //Modifier la catégorie d'un produit  (en mémoire)
        System.out.println("---------Changer la catégorie du Yaourt à Plastique----------");
        p1.setCategorie(cat2);
        //Synchroniser avec la BD
        produitRepos.saveAndFlush(p1);
        //Afficher la liste des produits d'une catégorie donnée

        //afficherTousLesProduitsDeLaCategorie(1L);
        afficherTousLesProduitsDeLaCategorie(1L);

        //Supprimer une catégorie
        System.out.println("-----------Suppression de categorie Plastique----------");
        Categorie cs = categorieRepos.getOne(2L);
        if (cs!=null) categorieRepos.delete(cs);
        //Afficher la liste des produits
        afficherTousLesProduits();

        // Modifier une catégorie existante par l'ajout d'un nouveu produit
        System.out.println("-----------Ajouter un nouveau produit 'Pain' à la catégorie 'Alimenatire'----------");
        Produit p4 =new Produit("Pain", 230, 20, date1 );
        p4.setCategorie(cat1);
        cat1.getProduits().add(p4);
        categorieRepos.save(cat1);

        //Afficher la liste des produits
        afficherTousLesProduits();
        // Insérer une nouvelle  catégorie  avec l'ajout d'un nouveu produit
        System.out.println("-----------Ajouter un nouveau produit 'Stylo' à une nouvelle catégorie 'Bureautique'----------");
        Produit p5 =new Produit("Stylo", 0.400, 20, date1 );
        Categorie cat3 = new Categorie("S", "BUREATIQUE");
        p5.setCategorie(cat3);
        cat3.getProduits().add(p5);
        categorieRepos.save(cat3);
        //Afficher la liste des produits
        afficherTousLesProduits();
    }

    static void afficherTousLesProduits()
    {
        System.out.println("********************Début**********************");
        System.out.println("Afficher tous les produits...");
        System.out.println("***********************************************");

        List<Produit> lp = produitRepos.findAll();
        for (Produit p : lp)
        {
            System.out.println(p);
        }
        System.out.println("********************Fin************************");
    }

    static void afficherTousLesProduitsDeLaCategorie(Long id)
    {
        System.out.println("********************Début**********************");

        // récupérer l'entité "Catégorie" ayant l'id en paramètres
        Categorie cD = categorieRepos.getOne(id);

        if (cD !=null)
        {
            System.out.println("Afficher tous les produits de la catégorie ["+id+"]");
            System.out.println("***********************************************");
            Collection <Produit> lC = cD.getProduits();
            for (Produit p : lC)
            {
                System.out.println(p);
            }
        }
        else
        {
            System.out.println("catégorie ["+id+"] non existante...");
        }
        System.out.println("********************Fin************************");
    }
}
