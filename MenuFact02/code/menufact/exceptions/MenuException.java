package menufact.exceptions;

/**
 * Exception en lien avec le menu
 */
public class MenuException extends Exception{

    public MenuException(String message){
        super("MenuException: " + message);
    }
}

