package menufact;

import com.sun.source.tree.TryTree;
import ingredients.*;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import inventaire.exceptions.InventaireException;
import menufact.chef.Chef;
import menufact.facture.exceptions.FactureException;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEnfant;
import menufact.plats.PlatSante;

public class TestMenuFact02 {

    public static void main(String[] args) {
        ////////////// Déclaration des variables

        TestMenuFact02 t = new TestMenuFact02();

        PlatAuMenu p1 = new PlatAuMenu(0,"PlatAuMenu0",10);
        PlatAuMenu p2 = new PlatAuMenu(1,"PlatAuMenu1",20);
        PlatAuMenu p3 = new PlatAuMenu(2,"PlatAuMenu2",30);
        PlatAuMenu p4 = new PlatAuMenu(3,"PlatAuMenu3",40);
        PlatAuMenu p5 = new PlatAuMenu(4,"PlatAuMenu4",50);

        PlatSante ps1 = new PlatSante(10,"PlatSante0",10,11,11,11);
        PlatSante ps2 = new PlatSante(11,"PlatSante1",20,11,11,11);
        PlatSante ps3 = new PlatSante(12,"PlatSante2",30,11,11,11);
        PlatSante ps4 = new PlatSante(13,"PlatSante3",40,11,11,11);
        PlatSante ps5 = new PlatSante(14,"PlatSante4",50,11,11,11);

        PlatEnfant pe1 = new PlatEnfant( 100, "PlatEnfant0", 10, 0.5);
        PlatEnfant pe2 = new PlatEnfant( 200, "PlatEnfant1", 20, 0.5);
        PlatEnfant pe3 = new PlatEnfant( 300, "PlatEnfant2", 30, 0.5);
        PlatEnfant pe4 = new PlatEnfant( 400, "PlatEnfant3", 40, 2);
        PlatEnfant pe5 = new PlatEnfant( 500, "PlatEnfant4", 50, 2);

        Menu m1 = new Menu("Menu 1 - Plat au Menu");
        Menu m2 = new Menu("Menu 2 - Plat Sante");
        Menu m3 = new Menu("Menu 3 - Plat Enfant");

        Ingredient ingr1 = new Laitier("Yaourt", "Yaourt a la vanille");
        Ingredient ingr2 = new Laitier("Lait", "Lait de vache");
        Ingredient ingr3 = new Legume("Concombre", "Concombre vert");
        Ingredient ingr4 = new Legume("JusDeConcombre", "Jus de concombre");
        Ingredient ingr5 = new Viande("Merguez", "La meilleur qui soit!");
        Ingredient ingr6 = new Viande("JusDeMerguez", "Jus de merguez");
        Ingredient ingr7 = new Fruit("Mangue", "Mangue tropicale");
        Ingredient ingr8 = new Fruit("JusDeMangue", "Jus de mangue");
        Ingredient ingr9 = new Epice("Poivre", "Poivre en gros grain");
        Ingredient ingr10 = new Epice("SauceCurry", "Sauce au curry rouge");
        Ingredient ingr11 = new Epice("IngredientQuiPlante", "Ingredient qui lance une exception");

        IngredientInventaire ingrInv1 = new IngredientInventaire(ingr1, 6);
        IngredientInventaire ingrInv3 = new IngredientInventaire(ingr3, 2);
        IngredientInventaire ingrInv5 = new IngredientInventaire(ingr5, 20);
        IngredientInventaire ingrInv7 = new IngredientInventaire(ingr7, 8);
        IngredientInventaire ingrInv9 = new IngredientInventaire(ingr9, 100);

        IngredientInventaireLiquide ingrInv2 = new IngredientInventaireLiquide(ingr2, 2);
        IngredientInventaireLiquide ingrInv4 = new IngredientInventaireLiquide(ingr4, 1);
        IngredientInventaireLiquide ingrInv6 = new IngredientInventaireLiquide(ingr6, 4);
        IngredientInventaireLiquide ingrInv8 = new IngredientInventaireLiquide(ingr8, 10);
        IngredientInventaireLiquide ingrInv10 = new IngredientInventaireLiquide(ingr10, 5);

        IngredientInventaireLiquideAdapter adapter1 = new IngredientInventaireLiquideAdapter(ingrInv2, 1);
        IngredientInventaireLiquideAdapter adapter2 = new IngredientInventaireLiquideAdapter(ingrInv4, 2);
        IngredientInventaireLiquideAdapter adapter3 = new IngredientInventaireLiquideAdapter(ingrInv6, 3);
        IngredientInventaireLiquideAdapter adapter4 = new IngredientInventaireLiquideAdapter(ingrInv8, 0.5);
        IngredientInventaireLiquideAdapter adapter5 = new IngredientInventaireLiquideAdapter(ingrInv10, 4);

        IngredientInventaire ingrInv100 = new IngredientInventaire(ingr5, 5);
        IngredientInventaireLiquide ingrInv101 = new IngredientInventaireLiquide(ingr8, 1);
        IngredientInventaire ingrInv102 = new IngredientInventaire(ingr11, 1);

        IngredientInventaireLiquideAdapter adapter6 = new IngredientInventaireLiquideAdapter(ingrInv101, 1);

        PlatChoisi pc1 = new PlatChoisi(p2, 5);
        PlatChoisi pc2 = new PlatChoisi(ps3, 1);
        PlatChoisi pc3 = new PlatChoisi(pe4, 5);
        PlatChoisi pc4 = new PlatChoisi(p1, 1);

        Facture f1 = new Facture("Ma facture");

        Chef chef = new Chef();

        Client c1 = new Client(1,"Mr Client","1234567890");



        ////////////// Partie de tests

        t.test1_AjouterPlatsAuMenus(m1, m2, m3, p1, p2, p3, p4, p5, ps1, ps2, ps3, ps4, ps5, pe1, pe2, pe3, pe4, pe5);

        t.test2_AfficherLesMenus(m1, m2, m3);

        t.test3_AjouterIngredientInventaire(ingrInv1, ingrInv3, ingrInv5, ingrInv7, ingrInv9, adapter1, adapter2, adapter3, adapter4, adapter5);

        t.test4_AfficherIngredientInventaire();

        t.test5_AttachementDuChef(chef, f1);

        t.test6_AjoutDuClientFacture(c1, f1);

        t.test7_AjoutDesIngredientsAuxPlats(p2, ps3, pe4, ingrInv100, adapter6, ingrInv102);

        t.test8_AjoutDesPlatDuClient(f1, pc1, pc2, pc3);

        t.test9_ChangementEtatPlatCommandes(pc4);

        t.test10_GenererFacture(f1);

        t.test11_VerificationInventaire();

        System.out.println("FIN DE TOUS LES TESTS...");
    }

    void test1_AjouterPlatsAuMenus(Menu m1, Menu m2, Menu m3,
                                   PlatAuMenu p1, PlatAuMenu p2,PlatAuMenu p3, PlatAuMenu p4,PlatAuMenu p5,
                                   PlatSante ps1, PlatSante ps2, PlatSante ps3, PlatSante ps4, PlatSante ps5,
                                   PlatEnfant pe1, PlatEnfant pe2, PlatEnfant pe3, PlatEnfant pe4, PlatEnfant pe5)
    {
        System.out.println("--------------------------------------" + "\n" +
                           "TEST1 - AJOUT DES PLATS AUX MENUS" + "\n" +
                           "--------------------------------------");
        m1.ajoute(p1);
        m1.ajoute(p2);
        m1.ajoute(p3);
        m1.ajoute(p4);
        m1.ajoute(p5);
        m2.ajoute(ps1);
        m2.ajoute(ps2);
        m2.ajoute(ps3);
        m2.ajoute(ps4);
        m2.ajoute(ps5);
        m3.ajoute(pe1);
        m3.ajoute(pe2);
        m3.ajoute(pe3);
        m3.ajoute(pe4);
        m3.ajoute(pe5);
    }

    void test2_AfficherLesMenus(Menu m1, Menu m2, Menu m3)
    {
        System.out.println("TEST2 - AFFICHAGE DES MENUS" + "\n\n" +
                           "Menu 1:" + "\n" +
                           m1 + "\n" +
                           "\n" + "Menu 2:" + "\n" +
                           m2 + "\n" +
                           "\n" + "Menu 3:" + "\n" +
                           m3 + "\n" +
                           "--------------------------------------");
    }

    void test3_AjouterIngredientInventaire(IngredientInventaire ingr1, IngredientInventaire ingr3, IngredientInventaire ingr5, IngredientInventaire ingr7, IngredientInventaire ingr9,
                                           IngredientInventaireLiquideAdapter ingr2, IngredientInventaireLiquideAdapter ingr4, IngredientInventaireLiquideAdapter ingr6, IngredientInventaireLiquideAdapter ingr8, IngredientInventaireLiquideAdapter ingr10)
    {
        System.out.println("TEST3 - AJOUT DES INGREDIENTS DANS L INVENTAIRE" + "\n" +
                           "--------------------------------------");

        Inventaire.getInventaire().ajouterIngredient(ingr1);
        Inventaire.getInventaire().ajouterIngredient(ingr2);
        Inventaire.getInventaire().ajouterIngredient(ingr3);
        Inventaire.getInventaire().ajouterIngredient(ingr4);
        Inventaire.getInventaire().ajouterIngredient(ingr5);
        Inventaire.getInventaire().ajouterIngredient(ingr6);
        Inventaire.getInventaire().ajouterIngredient(ingr7);
        Inventaire.getInventaire().ajouterIngredient(ingr8);
        Inventaire.getInventaire().ajouterIngredient(ingr9);
        Inventaire.getInventaire().ajouterIngredient(ingr10);
    }

    void test4_AfficherIngredientInventaire()
    {
        System.out.println("TEST4 - AFFICHAGE DE L INVENTAIRE" + "\n\n" +
                           Inventaire.getInventaire().afficherInventaire() + "\n" +
                           "--------------------------------------");
    }

    void test5_AttachementDuChef(Chef chef, Facture f1)
    {
        System.out.println("TEST5 - ATTACHEMENT DU CHEF" + "\n" +
                "--------------------------------------");

        f1.attacher(chef);
    }

    void test6_AjoutDuClientFacture(Client c1, Facture f1) {
        System.out.println("TEST6 - AJOUT DU CLIENT A LA FACTURE" + "\n");

        try
        {
            f1.fermer();
            f1.associerClient(c1);
        }
        catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }

        try
        {
            f1.ouvrir();
            f1.associerClient(c1);
        }
        catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }

        System.out.println("--------------------------------------");
    }

    void test7_AjoutDesIngredientsAuxPlats(PlatAuMenu p2, PlatSante ps3, PlatEnfant pe4, IngredientInventaire ingr1, IngredientInventaire ingr2, IngredientInventaire ingr3)
    {
        System.out.println("TEST7 - AJOUT DES INGREDIENTS AUX PLATS" + "\n" +
                           "--------------------------------------");

        p2.ajouterIngredient(ingr1);
        ps3.ajouterIngredient(ingr2);
        pe4.ajouterIngredient(ingr3);
    }

    void test8_AjoutDesPlatDuClient(Facture f1, PlatChoisi pc1, PlatChoisi pc2, PlatChoisi pc3)
    {
        System.out.println("TEST8 - AJOUT DES PLATS A LA FACTURE" + "\n");

        try
        {
            f1.ajoutePlat(pc1);
        }
        catch (FactureException | PlatException | IngredientException | InventaireException fe)
        {
            System.out.println(fe.getMessage());
        }

        try
        {
            f1.ajoutePlat(pc2);
        }
        catch (FactureException | PlatException | InventaireException | IngredientException fe)
        {
            System.out.println(fe.getMessage());
        }

        try
        {
            f1.ajoutePlat(pc3);
        }
        catch (FactureException | PlatException | IngredientException | InventaireException fe)
        {
            System.out.println(fe.getMessage());
        }

        try
        {
            f1.fermer();
            f1.ajoutePlat(pc1);
        }
        catch (FactureException | PlatException | IngredientException | InventaireException fe)
        {
            System.out.println(fe.getMessage());
        }

        try
        {
            f1.payer();
        }
        catch(FactureException fe)
        {
            System.out.println(fe.getMessage());
        }

        try
        {
            f1.ouvrir();
        }
        catch(FactureException fe)
        {
            System.out.println(fe.getMessage());
        }

        System.out.println("--------------------------------------");
    }

    void test9_ChangementEtatPlatCommandes(PlatChoisi pc4)
    {
        System.out.println("TEST9 - CHANGEMENT DETAT DES PLAT COMMANDES" + "\n");

        try
        {
            pc4.servir();
        }
        catch (PlatException pe) {
            System.out.println(pe.getMessage());
        }

        System.out.println("--------------------------------------");
    }

    void test10_GenererFacture(Facture f1)
    {
        System.out.println("TEST10 - GENERER FACTURE" + "\n");

        System.out.println(f1.genererFacture());

        System.out.println("--------------------------------------");
    }

    void test11_VerificationInventaire()
    {
        System.out.println("TEST11 - VERIFICATION INVENTAIRE" + "\n\n" +
                           Inventaire.getInventaire().afficherInventaire() + "\n" +
                           "--------------------------------------");
    }
}
