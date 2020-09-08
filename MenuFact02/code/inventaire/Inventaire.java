package inventaire;

import Iterateur.Containeur;
import Iterateur.Iterateur;
import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import inventaire.exceptions.InventaireException;

import java.util.ArrayList;

/**
 * Cette classe permet de garder l'inventaire du restaurant en mémoire.
 * Elle contient le design pattern Singleton, puisqu'il y a seulement un inventaire dans le restaurant.
 */
public class Inventaire implements Containeur {
    private ArrayList<IngredientInventaire> lesIngredients;
    private static Inventaire instanceInventaire;

    /**
     * Constructeur par défaut
     * Privé pour respecter le design pattern Singleton
     */
    private Inventaire()
    {
        lesIngredients = new ArrayList<IngredientInventaire>();
    }

    /**
     * Ajouter un ingrédient à l'inventaire
     * @param ingredientInventaire ingrédient à ajouter
     */
    public void ajouterIngredient (IngredientInventaire ingredientInventaire)
    {
        lesIngredients.add(ingredientInventaire);
    }

    /**
     * Modifier la quantité d'un ingrédient existant en lui ajoutant une quantité
     * @param nom nom de l'ingrédient à ajouter
     * @param ajoutQTY la quantité à ajouter
     * @throws IngredientException si la nouvelle quantité devient négative
     */
    public void modifierQty(String nom, int ajoutQTY) throws IngredientException
    {
        for(IngredientInventaire ingredient : lesIngredients)
        {
            String nomIngredient = ingredient.getIngredient().getNom();

            if(nomIngredient.equals(nom))
            {
                int qty = ingredient.getQuantite();

                ingredient.setQuantite(qty + ajoutQTY);

                break;
            }
        }
    }

    /**
     * retourner l'instance unique de l'inventaire
     * @return l'instance
     */
    public static Inventaire getInventaire() {
        if(instanceInventaire == null)
        {
            instanceInventaire = new Inventaire();
        }
        /*else
        {
            System.out.println("L'inventaire existe déjà");
            //throw new InventaireException("L'inventaire existe déjà");
        }*/

        return instanceInventaire;
    }

    /**
     * Affichage de l'inventaire
     * @return informations de l'inventaire
     */
    public String afficherInventaire()
    {
        return  "Inventaire: " +
                lesIngredients;
    }

    /**
     * Obtenir la liste des ingrédients de l'inventaire
     * @return la liste d'ingrédients
     */
    public ArrayList<IngredientInventaire> getIngredients() {
        return lesIngredients;
    }

    /**
     * Créer un itérateur pour itérer à travers les ingrédients de l'inventaire
     * @return iterateur
     */
    public Iterateur creerIterateur()
    {
        IterateurInventaire result = new IterateurInventaire();
        return result;
    }

    /**
     * Cette classe contient l'itérateur pour naviguer à travers les éléments de l'inventaire.à
     * Cette classe fait partie du design pattern Iterator
     */
    public class IterateurInventaire implements Iterateur {

        private int currentPosition;

        /**
         * Constructeur par défaut
         */
        public IterateurInventaire()
        {
            currentPosition = 0;
        }

        /**
         * Obtenir le prochain objet dans la liste
         * @return
         */
        public Object next()
        {
            if (!isFinished()) {
                return lesIngredients.get(currentPosition++);
            }
            else
                return null;
        }

        /**
         * Vérifier s'il reste des objets dans la liste
         * @return true si la liste est terminée, false sinon
         */
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
