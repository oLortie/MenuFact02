package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

/**
 * État en préparation
 */
public class EtatPlatPreparation implements EtatPlat{

    private EtatPlatsEnum etat;
    private PlatChoisi plat;

    public EtatPlatPreparation(PlatChoisi newPlat) {
        this.plat = newPlat;
        this.etat = EtatPlatsEnum.PREPARATION;
    }

    /**
     * Tenter de commander le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void commander() throws PlatException {
        throw new PlatException("Impossible de commander un plat en preparation!");
    }

    /**
     * Tenter de preparer le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void preparer() {
        // ne rien faire, le plat est deja en preparation
    }

    /**
     * Tenter de terminer le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void terminer() {
        plat.setEtat(new EtatPlatTermine(plat));
    }

    /**
     * Tenter de servir le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void servir() throws PlatException{
        throw new PlatException("Impossible de commander un plat en preparation!");
    }

    /**
     * Tenter de rendre le plat impossible à préparer
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void rendreImpossible() {
        plat.setEtat(new EtatPlatImpossible(plat));
    }

    /**
     * Affichage de l'état
     * @return l'état en String
     */
    public String toString() {
        return etat.toString();
    }
}
