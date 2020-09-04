package menufact.facture.Etats;

import menufact.facture.*;
import menufact.facture.exceptions.FactureException;

public class EtatFacturePayee implements EtatFacture{

    private Facture facture;
    private FactureEtat etat;

    public EtatFacturePayee(Facture newFacture) {
        this.facture = newFacture;
        this.etat = FactureEtat.PAYEE;
    }

    @Override
    public void ouvrir() throws FactureException{
        throw new FactureException("Impossible d'ouvrir une facture payée!");
    }

    @Override
    public void fermer() throws FactureException{
        throw new FactureException("Impossible de femer une facture payée!");
    }

    @Override
    public void payer() {
        // ne rien faire, la facture est déjà payée
    }

    public String toString() {
        return etat.toString();
    }
}
