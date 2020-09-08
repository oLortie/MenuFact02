package ingredients;

/**
 * Cette classe permet de créer le type d'ingrédient suivant : produit laitier
 */
public class Laitier extends Ingredient{
    /**
     * Constructeur de la classe
     */
    public Laitier() {
        setTypeIngredient(TypeIngredient.LAITIER);
    }
}
