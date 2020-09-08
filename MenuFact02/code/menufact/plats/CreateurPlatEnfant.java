package menufact.plats;

/**
 * Créateur de plats pour enfant.
 * Fait partie du design pattern factory.
 */
public class CreateurPlatEnfant extends CreateurPlatAuMenu{

    /**
     * Créer un plat pour enfant
     * @return le plat pour enfant
     */
    public PlatAuMenu creerPlat()
    {
        return new PlatEnfant();
    }
}
