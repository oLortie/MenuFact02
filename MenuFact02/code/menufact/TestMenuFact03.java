package menufact;

import ingredients.Fruit;
import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.Laitier;
import inventaire.Inventaire;
import menufact.chef.Chef;
import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

public class TestMenuFact03 {
    public static void main(String[] args) {

        Chef chef = new Chef();

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

        PlatChoisi platChoisi = new PlatChoisi(plat1, 1);

        try {
            chef.preparerPlatComplet(platChoisi);
        } catch (PlatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(platChoisi.getEtat().toString());
    }
}
