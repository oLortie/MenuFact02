package menufact.facture.Etats;

import menufact.facture.*;
import menufact.facture.exceptions.FactureException;

/**
 * Interface pour les états d'une facture.
 * Fait partie du design pattern State.
 */
public interface EtatFacture {

    /**
     * Tenter d'ouvrir la facture à partir de cet état
     * @throws FactureException s'il est impossible d'ouvrir la facture
     */
    public void ouvrir() throws FactureException;

    /**
     * Tenter de fermer la facture
     * @throws FactureException s'il est impossible de fermer la facture
     */
    public void fermer() throws FactureException;

    /**
     * Tenter de payer la facture
     * @throws FactureException s'il est impossible de payer la facture
     */
    public void payer() throws FactureException;

    /**
     * Afficher la facture
     * @return les informations de la facture
     */
    public String toString();
}
