package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

public class EtatPlatPreparation implements EtatPlat{

    private EtatPlatsEnum etat;
    private PlatChoisi plat;

    public EtatPlatPreparation(PlatChoisi newPlat) {
        this.plat = newPlat;
        this.etat = EtatPlatsEnum.PREPARATION;
    }

    @Override
    public void commander() throws PlatException {
        throw new PlatException("Impossible de commander un plat en preparation!");
    }

    @Override
    public void preparer() {
        // ne rien faire, le plat est deja en preparation
    }

    @Override
    public void terminer() {
        plat.setEtat(new EtatPlatTermine(plat));
    }

    @Override
    public void servir() throws PlatException{
        throw new PlatException("Impossible de commander un plat en preparation!");
    }

    @Override
    public void rendreImpossible() throws PlatException{
        throw new PlatException("Les ingrédients auraient du être vérifiés avant la préparation!");
    }

    public String toString() {
        return etat.toString();
    }
}
