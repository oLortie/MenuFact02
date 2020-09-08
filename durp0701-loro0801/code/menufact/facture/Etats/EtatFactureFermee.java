package menufact.facture.Etats;

import menufact.facture.*;
import menufact.facture.exceptions.FactureException;

/**
 * État fermé de la facture.
 * Fait partie du design pattern State.
 */
public class EtatFactureFermee implements EtatFacture{

    private Facture facture;
    private FactureEtat etat;

    /**
     * Constructeur par défaut de l'état.
     * @param newFacture la facture associée
     */
    public EtatFactureFermee(Facture newFacture) {
        this.facture = newFacture;
        this.etat = FactureEtat.FERMEE;
    }

    /**
     * Tenter d'ouvrir la facture à partir de cet état
     * @throws FactureException s'il est impossible d'ouvrir la facture
     */
    @Override
    public void ouvrir() {
        facture.setEtat(new EtatFactureOuverte(facture));
    }

    /**
     * Tenter de fermer la facture
     * @throws FactureException s'il est impossible de fermer la facture
     */
    @Override
    public void fermer() {
        // ne rien faire, la facture est déjà fermée
    }

    /**
     * Tenter de payer la facture
     * @throws FactureException s'il est impossible de payer la facture
     */
    @Override
    public void payer() throws FactureException {
        // impossible de payer une facture fermée, il faut lancer une exception
        throw new FactureException("Impossible de payer une facture fermée!");
    }

    /**
     * Afficher la facture
     * @return les informations de la facture
     */
    public String toString() {
        return etat.toString();
    }
}
