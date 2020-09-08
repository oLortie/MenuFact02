package menufact.plats;

/**
 * Créateur de plat santé.
 * Cette classe faait partie du design pattern factory.
 */
public class CreateurPlatSante extends CreateurPlatAuMenu{

    /**
     * Créer un plat santé
     * @return le plat santé
     */
    public PlatAuMenu creerPlat()
    {
        return new PlatSante();
    }
}
