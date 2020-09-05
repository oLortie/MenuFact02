package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatChoisi;

public class EtatPlatTermine implements EtatPlat{

    private EtatPlatsEnum etat;
    private PlatChoisi plat;

    public EtatPlatTermine(PlatChoisi newPlat) {
        this.plat = newPlat;
        this.etat = EtatPlatsEnum.TERMINE;
    }

    @Override
    public void commander() throws PlatException {
        throw new PlatException("Impossible de commander un plat servi!");
    }

    @Override
    public void preparer() throws PlatException {
        throw new PlatException("Impossible de preparer un plat servi!");
    }

    @Override
    public void terminer() {
        // ne rien faire, le plat est deja dans cet etat
    }

    @Override
    public void servir() {
        plat.setEtat(new EtatPlatServi(plat));
    }

    @Override
    public void rendreImpossible() {
        plat.setEtat(new EtatPlatImpossible(plat));
    }

    public String toString() {
        return etat.toString();
    }
}
