package ingredients;

/**
 * Cette classe permet de créer le type d'ingrédient suivant : viande
 */
public class Viande extends Ingredient{
    /**
     * Constructeur de la classe
     */
    public Viande(String nom, String description) {
        setTypeIngredient(TypeIngredient.VIANDE);
        setNom(nom);
        setDescription(description);
    }
}
