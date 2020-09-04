package menufact.facture.Etats;

import menufact.facture.*;
import menufact.facture.exceptions.FactureException;

public interface EtatFacture {

    public abstract void ouvrir() throws FactureException;
    public abstract void fermer() throws FactureException;
    public abstract void payer() throws FactureException;
    public abstract FactureEtat getEtat();
}
