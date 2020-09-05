package inventaire.exceptions;

public class InventaireException extends Exception{

    public InventaireException(String message)
    {
        super("InventaireException: " + message);
    }
}
