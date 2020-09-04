package menufact.facture.Etats;

import menufact.facture.*;
import menufact.facture.exceptions.FactureException;

public class EtatFactureFermee implements EtatFacture{

    private Facture facture;
    private FactureEtat etat;

    public EtatFactureFermee(Facture newFacture) {
        this.facture = newFacture;
        this.etat = FactureEtat.FERMEE;
    }

    @Override
    public void ouvrir() {
        facture.setEtat(new EtatFactureOuverte(facture));
    }

    @Override
    public void fermer() {
        // ne rien faire, la facture est déjà fermée
    }

    @Override
    public void payer() throws FactureException {
        // impossible de payer une facture fermée, il faut lancer une exception
        throw new FactureException("Impossible de payer une facture fermée!");
    }

    public FactureEtat getEtat() {
        return etat;
    }
}
