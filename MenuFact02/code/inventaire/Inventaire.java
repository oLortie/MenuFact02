package inventaire;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

public class Inventaire {
    private ArrayList<IngredientInventaire> lesIngredients;
    private static Inventaire instanceInventaire;

    private Inventaire()
    {
        lesIngredients = new ArrayList<IngredientInventaire>();
    }

    public void ajouterIngredient (IngredientInventaire ingredientInventaire)
    {
        lesIngredients.add(ingredientInventaire);
    }

    public void modifierQty(String nom, int ajoutQTY) throws IngredientException
    {
        for(IngredientInventaire ingredient : lesIngredients)
        {
            String nomIngredient = ingredient.getIngredient().getNom();

            if(nomIngredient == nom)
            {
                int qty = ingredient.getQuantite();

                ingredient.setQuantite(qty + ajoutQTY);

                break;
            }
        }
    }

    public static Inventaire getInventaire()
    {
        if(instanceInventaire == null)
        {
            instanceInventaire = new Inventaire();
        }
        else
        {
            System.out.println("L'inventaire existe déjà");
        }

        return instanceInventaire;
    }
}
