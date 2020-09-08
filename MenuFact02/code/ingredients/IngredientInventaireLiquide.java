package ingredients;

import ingredients.exceptions.IngredientException;

/**
 * Cette classe fait partie du design pattern adapter.
 * Elle permet de créer un ingrédient inventaire qui est liquide
 */
public class IngredientInventaireLiquide extends IngredientInventaire{
    /**
     * Constructeur de la classe
     *
     * @param ingredient ingrédient
     * @param quantite   quantité de l'ingrédient
     */
    public IngredientInventaireLiquide(Ingredient ingredient, int quantite) {
        super(ingredient, quantite);
    }

    /*private Ingredient ingredient;
    private int quantite;

    /**
     * Constructeur de la classe
     * @param ingredient l'ingrédient
     * @param quantite la quantité en ml
     */
    /*public IngredientInventaireLiquide(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    /**
     * Obtenir la quantité de l'ingrédient
     * @return la quantité en ml
     */
    /*public int getQuantite() {
        return quantite;
    }

    /**
     * Changer la quantité
     * @param quantite la nouvelle quantité
     * @throws IngredientException si la nouvelle quantité est négative
     */
    /*public void setQuantite(int quantite) throws IngredientException {

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    /**
     * Obtenir l'ingrédient
     * @return l'ingrédient
     */
    /*public Ingredient getIngredient()
    {
        return ingredient;
    }*/
}
