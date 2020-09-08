package ingredients;

/**
 * Cette classe permet de créer le type d'ingrédient suivant : légume
 */
public class Legume extends Ingredient{
    /**
     * Constructeur de la classe
     */
    public Legume(String nom, String description) {
        setTypeIngredient(TypeIngredient.LEGUME);
        setNom(nom);
        setDescription(description);
    }
}
