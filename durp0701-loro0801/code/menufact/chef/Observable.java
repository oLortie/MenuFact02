package menufact.chef;

import ingredients.exceptions.IngredientException;
import inventaire.exceptions.InventaireException;
import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

/**
 * Interface pour un observable du design pattern Observer.
 */
public interface Observable {
    public void attacher(Observateur observateur);
    public void detacher(Observateur observateur);
    public void notifier(PlatChoisi plat) throws PlatException, IngredientException, InventaireException;
}
