package menufact.facture.Etats;

import menufact.facture.*;
import menufact.facture.exceptions.FactureException;

public interface EtatFacture {

    public void ouvrir() throws FactureException;
    public void fermer() throws FactureException;
    public void payer() throws FactureException;
    public String toString();
}
