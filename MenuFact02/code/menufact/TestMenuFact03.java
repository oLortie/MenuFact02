package menufact;

import Iterateur.Iterateur;
import ingredients.Fruit;
import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.IngredientInventaireLiquide;
import ingredients.IngredientInventaireSolideAdapter;
import ingredients.Laitier;
import inventaire.Inventaire;
import inventaire.exceptions.InventaireException;
import menufact.chef.Chef;
import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

public class TestMenuFact03 {
    public static void main(String[] args) {
        /////////////////////////////////////////////test adapter
        Ingredient jusDeFruit = new Fruit();
        jusDeFruit.setNom("jusDeFruit");
        jusDeFruit.setDescription("Jus de fruit");

        Ingredient banane = new Fruit();
        banane.setNom("banane");
        banane.setDescription("FruitJaune");

        IngredientInventaireLiquide inventaireJusDeFruit = new IngredientInventaireLiquide(jusDeFruit, 40);
        IngredientInventaire inventaireBanane = new IngredientInventaire(banane, 4);

        IngredientInventaireSolideAdapter adapter = new IngredientInventaireSolideAdapter(inventaireJusDeFruit);

        Inventaire.getInventaire().ajouterIngredient(adapter);
        Inventaire.getInventaire().ajouterIngredient(inventaireBanane);

        System.out.println(Inventaire.getInventaire().afficherInventaire());
        /////////////////////////////////////////////test adapter





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
