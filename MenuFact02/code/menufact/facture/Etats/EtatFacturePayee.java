package menufact.facture.Etats;

import menufact.facture.*;
import menufact.facture.exceptions.FactureException;

/**
 * État payé de la facture.
 * Fait partie du design pattern State.
 */
public class EtatFacturePayee implements EtatFacture{

    private Facture facture;
    private FactureEtat etat;

    /**
     * Constructeur par défaut de l'état.
     * @param newFacture la facture associée
     */
    public EtatFacturePayee(Facture newFacture) {
        this.facture = newFacture;
        this.etat = FactureEtat.PAYEE;
    }

    /**
     * Tenter d'ouvrir la facture à partir de cet état
     * @throws FactureException s'il est impossible d'ouvrir la facture
     */
    @Override
    public void ouvrir() throws FactureException{
        throw new FactureException("Impossible d'ouvrir une facture payée!");
    }

    /**
     * Tenter de fermer la facture
     * @throws FactureException s'il est impossible de fermer la facture
     */
    @Override
    public void fermer() throws FactureException{
        throw new FactureException("Impossible de femer une facture payée!");
    }

    /**
     * Tenter de payer la facture
     * @throws FactureException s'il est impossible de payer la facture
     */
    @Override
    public void payer() {
        // ne rien faire, la facture est déjà payée
    }

    /**
     * Afficher la facture
     * @return les informations de la facture
     */
    public String toString() {
        return etat.toString();
    }
}
