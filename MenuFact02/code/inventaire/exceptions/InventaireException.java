package inventaire.exceptions;

/**
 * Exception en lien avec l'inventaire
 */
public class InventaireException extends Exception{

    public InventaireException(String message)
    {
        super("InventaireException: " + message);
    }
}
