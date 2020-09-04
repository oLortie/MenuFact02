package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatChoisi;

public class EtatPlatCommande implements EtatPlat{

    private EtatPlatsEnum etat;
    private PlatChoisi plat;

    public EtatPlatCommande(PlatChoisi newPlat) {
        this.plat = newPlat;
        this.etat = EtatPlatsEnum.COMMANDE;
    }

    @Override
    public void commander() {
        // ne rien faire, plat déja commandé
    }

    @Override
    public void preparer() {
        plat.setEtat(new EtatPlatPreparation(plat));
    }

    @Override
    public void terminer() throws PlatException {
        throw new PlatException("Impossible de terminer un plat qui est à l'état commandé!");
    }

    @Override
    public void servir() throws PlatException{
        throw new PlatException("Impossible de servir un plat qui est à l'état commandé!");
    }

    @Override
    public void rendreImpossible() {
        plat.setEtat(new EtatPlatImpossible(plat));
    }

    public String toString() {
        return etat.toString();
    }
}
