package menufact;

import Iterateur.Iterateur;
import ingredients.Fruit;
import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.IngredientInventaireLiquide;
import ingredients.IngredientInventaireSolideAdapter;
import ingredients.Laitier;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import inventaire.exceptions.InventaireException;
import menufact.chef.Chef;
import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEnfant;
import menufact.plats.PlatEnfantAdapter;

public class TestMenuFact03 {
    public static void main(String[] args) {
        /////////////////////////////////////////////test adapter
        /*Ingredient jusDeFruit = new Fruit();
        jusDeFruit.setNom("jusDeFruit");
        jusDeFruit.setDescription("Jus de fruit");

        Ingredient banane = new Fruit();
        banane.setNom("banane");
        banane.setDescription("FruitJaune");

        IngredientInventaireLiquide inventaireJusDeFruit = new IngredientInventaireLiquide(jusDeFruit, 40);
        IngredientInventaire inventaireBanane = new IngredientInventaire(banane, 4);

        IngredientInventaireSolideAdapter adapter = new IngredientInventaireSolideAdapter(inventaireJusDeFruit, 1.5f);

        Inventaire.getInventaire().ajouterIngredient(adapter);
        Inventaire.getInventaire().ajouterIngredient(inventaireBanane);

        System.out.println(Inventaire.getInventaire().afficherInventaire());*/
        /////////////////////////////////////////////test adapter

        // test adapter plat enfant
        Chef chef = new Chef();

        PlatEnfant plat1 = new PlatEnfant(0, "Banana Split Enfant", 12, 0.5);
        Fruit banane = new Fruit();
        banane.setNom("banane");
        banane.setDescription("FruitJaune");
        Ingredient cremeGlacee = new Laitier();
        cremeGlacee.setNom("Crème glacée");
        cremeGlacee.setDescription("Coaticook");
        IngredientInventaire bananeInventaire = new IngredientInventaire(banane, 25);
        IngredientInventaire cremeGlaceeInventaire = new IngredientInventaire(cremeGlacee, 12);
        IngredientInventaire plat1BananeInventaire = new IngredientInventaire(banane, 50);
        IngredientInventaire plat1CremeGlaceeInventaire = new IngredientInventaire(cremeGlacee, 2);
        plat1.ajouterIngredient(plat1BananeInventaire);
        plat1.ajouterIngredient(plat1CremeGlaceeInventaire);

        Inventaire.getInventaire().ajouterIngredient(bananeInventaire);
        Inventaire.getInventaire().ajouterIngredient(cremeGlaceeInventaire);

        PlatEnfantAdapter adapter = new PlatEnfantAdapter(plat1);
        try {
            adapter.adapt();
        } catch (IngredientException e) {
            e.printStackTrace();
        }

        PlatChoisi platChoisi = new PlatChoisi(plat1, 1);


        try {
            chef.preparerPlatComplet(platChoisi);
        } catch (PlatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(platChoisi.getEtat().toString());





        /*Chef chef = new Chef();

        PlatAuMenu plat1 = new PlatAuMenu(0,"banana split",10);
        Ingredient banane = new Fruit();
        banane.setNom("banane");
        banane.setDescription("FruitJaune");
        Ingredient cremeGlacee = new Laitier();
        cremeGlacee.setNom("Crème glacée");
        cremeGlacee.setDescription("Coaticook");
        IngredientInventaire bananeInventaire = new IngredientInventaire(banane, 25);
        IngredientInventaire cremeGlaceeInventaire = new IngredientInventaire(cremeGlacee, 12);
        IngredientInventaire plat1BananeInventaire = new IngredientInventaire(banane, 1);
        IngredientInventaire plat1CremeGlaceeInventaire = new IngredientInventaire(cremeGlacee, 2);

        Inventaire.getInventaire().ajouterIngredient(bananeInventaire);
        Inventaire.getInventaire().ajouterIngredient(cremeGlaceeInventaire);

        plat1.ajouterIngredient(plat1BananeInventaire);
        plat1.ajouterIngredient(plat1CremeGlaceeInventaire);

        PlatChoisi platChoisi = new PlatChoisi(plat1, 6);

        try {
            chef.preparerPlatComplet(platChoisi);
        } catch (PlatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(platChoisi.getEtat().toString());*/

    }
}
