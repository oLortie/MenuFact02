package menufact.chef;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

/**
 * Interface d'observateur pour le design pattern Observer.
 */
public interface Observateur {
    void preparerPlatComplet(PlatChoisi plat) throws PlatException;
}
