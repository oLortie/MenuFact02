package inventaire;

import Iterateur.Containeur;
import Iterateur.Iterateur;
import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

public class Inventaire implements Containeur {
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


    public ArrayList<IngredientInventaire> getIngredients() {
        return lesIngredients;
    }

    public Iterateur creerIterateur()
    {
        IterateurInventaire result = new IterateurInventaire();
        return result;
    }

    public class IterateurInventaire implements Iterateur {

        private int currentPosition;

        public IterateurInventaire()
        {
            currentPosition = 0;
        }

        public Object next()
        {
            if (!isFinished()) {
                return lesIngredients.get(currentPosition++);
            }
            else
                return null;
        }

        public boolean isFinished()
        {
            if (this.currentPosition < lesIngredients.size()) {
                return false;
            }
            else {
                return true;
            }
        }
    }
}
