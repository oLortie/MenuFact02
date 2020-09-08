package menufact.chef;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

/**
 * Interface pour un observable du design pattern Observer.
 */
public interface Observable {
    public void attacher(Observateur observateur);
    public void detacher(Observateur observateur);
    public void notifier(PlatChoisi plat) throws PlatException;
}
