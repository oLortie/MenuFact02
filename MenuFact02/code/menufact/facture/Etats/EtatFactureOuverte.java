package menufact.facture.Etats;

import menufact.facture.*;
import menufact.facture.exceptions.FactureException;


/**
 * État ouvert de la facture.
 * Fait partie du design pattern State.
 */
public class EtatFactureOuverte implements EtatFacture{

    private Facture facture;
    private FactureEtat etat;

    /**
     * Constructeur par défaut de l'état.
     * @param newFacture la facture associée
     */
    public EtatFactureOuverte(Facture newFacture) {
        this.facture = newFacture;
        this.etat = FactureEtat.OUVERTE;
    }

    /**
     * Tenter d'ouvrir la facture à partir de cet état
     * @throws FactureException s'il est impossible d'ouvrir la facture
     */
    @Override
    public void ouvrir() {
        // ne rien faire, la facture est déjà ouverte
    }

    /**
     * Tenter de fermer la facture
     * @throws FactureException s'il est impossible de fermer la facture
     */
    @Override
    public void fermer() {
        facture.setEtat(new EtatFactureFermee(facture));
    }

    /**
     * Tenter de payer la facture
     * @throws FactureException s'il est impossible de payer la facture
     */
    @Override
    public void payer() {
        facture.setEtat(new EtatFacturePayee(facture));
    }

    /**
     * Afficher la facture
     * @return les informations de la facture
     */
    public String toString() {
        return etat.toString();
    }
}
