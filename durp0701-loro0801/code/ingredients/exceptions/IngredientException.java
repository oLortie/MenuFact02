package ingredients.exceptions;

/**
 * Exception pour les ingrédients
 */
public class IngredientException extends Exception{
    public IngredientException(String message){
        super("IngredientException: " + message);
    }
}
