package menufact.plats;

/**
 * Créateur de plats au menu.
 * Fait partie du design pattern factory.
 */
public class CreateurPlatAuMenu {

    /**
     * Créer un plat au menu
     * @return
     */
    public PlatAuMenu creerPlat()
    {
        return new PlatAuMenu();
    }
}
