package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatChoisi;

public class EtatPlatImpossible implements EtatPlat{

    private EtatPlatsEnum etat;
    private PlatChoisi plat;

    public EtatPlatImpossible(PlatChoisi newPlat) {
        this.plat = newPlat;
        this.etat = EtatPlatsEnum.IMPOSSIBLE;
    }

    @Override
    public void commander() {
        plat.setEtat(new EtatPlatCommande(plat));
    }

    @Override
    public void preparer() throws PlatException{
        throw new PlatException("Impossible de preparer un plat dans l'état impossible à préparer!");
    }

    @Override
    public void terminer() throws PlatException{
        throw new PlatException("Impossible de terminer un plat dans l'état impossible à préparer!");
    }

    @Override
    public void servir() throws PlatException{
        throw new PlatException("Impossible de servir un plat dans l'état impossible à préparer!");
    }

    @Override
    public void rendreImpossible() {
        // ne rien faire, le plat est déjà impossible à préparer
    }

    public String toString() {
        return etat.toString();
    }
}
