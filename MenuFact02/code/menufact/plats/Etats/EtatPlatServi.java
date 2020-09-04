package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatChoisi;

public class EtatPlatServi implements EtatPlat{

    private EtatPlatsEnum etat;
    private PlatChoisi plat;

    public EtatPlatServi(PlatChoisi newPlat) {
        this.plat = newPlat;
        this.etat = EtatPlatsEnum.SERVI;
    }

    @Override
    public void commander() throws PlatException{
        throw new PlatException("Impossible de commander un plat servi!");
    }

    @Override
    public void preparer() throws PlatException {
        throw new PlatException("Impossible de preparer un plat servi!");
    }

    @Override
    public void terminer() throws PlatException{
        throw new PlatException("Impossible de terminer un plat servi!");
    }

    @Override
    public void servir() {
        // ne rien faire, le plat est deja dans l'état servi
    }

    @Override
    public void rendreImpossible() throws PlatException{
        throw new PlatException("Les ingrédients auraient du être vérifiés avant de servir!");
    }

    public String toString() {
        return etat.toString();
    }
}
