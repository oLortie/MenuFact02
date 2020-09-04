package menufact.facture.Etats;

import menufact.facture.*;

public class EtatFactureOuverte implements EtatFacture{

    private Facture facture;
    private FactureEtat etat;

    public EtatFactureOuverte(Facture newFacture) {
        this.facture = newFacture;
        this.etat = FactureEtat.OUVERTE;
    }

    @Override
    public void ouvrir() {
        // ne rien faire, la facture est déjà ouverte
    }

    @Override
    public void fermer() {
        facture.setEtat(new EtatFactureFermee(facture));
    }

    @Override
    public void payer() {
        facture.setEtat(new EtatFacturePayee(facture));
    }

    public String toString() {
        return etat.toString();
    }
}
