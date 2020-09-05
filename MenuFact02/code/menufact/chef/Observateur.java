package menufact.chef;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

public interface Observateur {
    void preparerPlatComplet(PlatChoisi plat) throws PlatException;
}
