package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatChoisi;

/**
 * État servi d'un plat
 */
public class EtatPlatServi implements EtatPlat{

    private EtatPlatsEnum etat;
    private PlatChoisi plat;

    public EtatPlatServi(PlatChoisi newPlat) {
        this.plat = newPlat;
        this.etat = EtatPlatsEnum.SERVI;
    }

    /**
     * Tenter de commander le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void commander() throws PlatException{
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
    public void terminer() throws PlatException{
        throw new PlatException("Impossible de terminer un plat servi!");
    }

    /**
     * Tenter de servir le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void servir() {
        // ne rien faire, le plat est deja dans l'état servi
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
