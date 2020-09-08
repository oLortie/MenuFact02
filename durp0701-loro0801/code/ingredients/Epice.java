package ingredients;

/**
 * Cette classe permet de créer le type d'ingrédient suivant : fruit
 */
public class Epice extends Ingredient{
    /**
     * Constructeur par défaut
     */
    public Epice(String nom, String description) {
        setTypeIngredient(TypeIngredient.EPICE);
        setNom(nom);
        setDescription(description);
    }
}
