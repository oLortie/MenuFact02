package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatChoisi;

/**
 * État impossible à préparer
 */
public class EtatPlatImpossible implements EtatPlat{

    private EtatPlatsEnum etat;
    private PlatChoisi plat;

    /**
     * Constructeur de l'état
     * @param newPlat plat associé
     */
    public EtatPlatImpossible(PlatChoisi newPlat) {
        this.plat = newPlat;
        this.etat = EtatPlatsEnum.IMPOSSIBLE;
    }

    /**
     * Tenter de commander le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void commander() {
        plat.setEtat(new EtatPlatCommande(plat));
    }

    /**
     * Tenter de preparer le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void preparer() throws PlatException{
        throw new PlatException("Impossible de preparer un plat dans l'état impossible à préparer!");
    }

    /**
     * Tenter de terminer le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void terminer() throws PlatException{
        throw new PlatException("Impossible de terminer un plat dans l'état impossible à préparer!");
    }

    /**
     * Tenter de servir le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void servir() throws PlatException{
        throw new PlatException("Impossible de servir un plat dans l'état impossible à préparer!");
    }

    /**
     * Tenter de rendre le plat impossible à préparer
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void rendreImpossible() {
        // ne rien faire, le plat est déjà impossible à préparer
    }

    /**
     * Affichage de l'état
     * @return l'état en String
     */
    public String toString() {
        return etat.toString();
    }
}
