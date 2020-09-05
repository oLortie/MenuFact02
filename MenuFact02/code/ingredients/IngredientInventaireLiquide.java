package ingredients;

import ingredients.exceptions.IngredientException;

public class IngredientInventaireLiquide {

    private Ingredient ingredient;
    private int quantite;

    public IngredientInventaireLiquide(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws IngredientException {

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    public Ingredient getIngredient()
    {
        return ingredient;
    }
}
