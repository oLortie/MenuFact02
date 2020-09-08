package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatChoisi;

/**
 * État d'un plat commandé
 */
public class EtatPlatCommande implements EtatPlat{

    private EtatPlatsEnum etat;
    private PlatChoisi plat;

    /**
     * Constructeur de l'état
     * @param newPlat plat associé
     */
    public EtatPlatCommande(PlatChoisi newPlat) {
        this.plat = newPlat;
        this.etat = EtatPlatsEnum.COMMANDE;
    }

    /**
     * Tenter de commander le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void commander() {
        // ne rien faire, plat déja commandé
    }

    /**
     * Tenter de preparer le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void preparer() {
        plat.setEtat(new EtatPlatPreparation(plat));
    }

    /**
     * Tenter de terminer le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void terminer() throws PlatException {
        throw new PlatException("Impossible de terminer un plat qui est à l'état commandé!");
    }

    /**
     * Tenter de servir le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    @Override
    public void servir() throws PlatException{
        throw new PlatException("Impossible de servir un plat qui est à l'état commandé!");
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
