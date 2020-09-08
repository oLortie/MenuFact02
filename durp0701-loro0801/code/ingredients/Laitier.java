package ingredients;

/**
 * Cette classe permet de créer le type d'ingrédient suivant : produit laitier
 */
public class Laitier extends Ingredient{
    /**
     * Constructeur de la classe
     */
    public Laitier(String nom, String description) {
        setTypeIngredient(TypeIngredient.LAITIER);
        setNom(nom);
        setDescription(description);
    }
}
