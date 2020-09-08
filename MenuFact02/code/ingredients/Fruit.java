package ingredients;

/**
 * Cette classe permet de créer le type d'ingrédient suivant : fruit
 */
public class Fruit extends Ingredient{
    /**
     * Constructeur par défaut
     */
    public Fruit(String nom, String description) {
        setTypeIngredient(TypeIngredient.FRUIT);
        setNom(nom);
        setDescription(description);
    }
}
