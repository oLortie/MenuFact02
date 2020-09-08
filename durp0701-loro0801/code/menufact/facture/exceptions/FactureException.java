package menufact.facture.exceptions;

/**
 * Exception liée à une facture
 */
public class FactureException extends Exception{

    public FactureException(String message){
        super("FactureException: " + message);
   }
}
