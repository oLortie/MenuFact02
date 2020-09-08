package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatChoisi;

/**
 * État terminé d'un plat
 */
public class EtatPlatTermine implements EtatPlat{

    private EtatPlatsEnum etat;
    private PlatChoisi plat;

    public EtatPlatTermine(PlatChoisi newPlat) {
        this.plat = newPlat;
        this.etat = EtatPlatsEnum.TERMINE;
    }

    /**
     * Tenter de commander le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void commander() throws PlatException {
        throw new PlatException("Impossible de commander un plat servi!");
    }

    /**
     * Tenter de preparer le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void preparer() throws PlatException {
        throw new PlatException("Impossible de preparer un plat servi!");
    }

    /**
     * Tenter de terminer le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void terminer() {
        // ne rien faire, le plat est deja dans cet etat
    }

    /**
     * Tenter de servir le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void servir() {
        plat.setEtat(new EtatPlatServi(plat));
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
