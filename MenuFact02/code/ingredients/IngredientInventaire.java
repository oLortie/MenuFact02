package ingredients;

import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

/**
 * Cette classe permet de définir un ingrédient avec une quantité pour pouvoir l'insérer dans l'inventaire
 */
public class IngredientInventaire {
    private Ingredient ingredient;
    private int quantite;

    /**
     * Constructeur de la classe
     * @param ingredient ingrédient
     * @param quantite quantité de l'ingrédient
     */
    public IngredientInventaire(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    /**
     * Cette méthode permet de savoir si un ingrédient se retrouve dans une liste
     * @param lesIngredients liste d'IngredientInventaire à vérifier
     * @return true si l'ingrédient est dans la liste et false sinon
     */
    public boolean isIn(ArrayList<IngredientInventaire> lesIngredients) {
        for (IngredientInventaire ingredient : lesIngredients) {
            if (this.ingredient.getNom() == ingredient.getIngredient().getNom()) {
                return true;
            }
        }
         return false;
    }

    /**
     * Obtenir la quantité
     * @return la quantité de l'ingrédient
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Changer la quantité de l'ingrédient
     * @param quantite la nouvelle quantité
     * @throws IngredientException si on tente de mettre une quantité négative
     */
    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    /**
     * Obtenir l'ingrédient
     * @return l'ingrédient
     */
    public Ingredient getIngredient()
    {
        return ingredient;
    }

    /**
     * Affichage de l'ingrédient
     * @return lers informations de l'ingrédient inventaire
     */
    @Override
    public String toString() {
        return  "Ingredient{ " +
                ingredient +
                ", quantite: " +
                getQuantite() +
                " }";
    }
}
