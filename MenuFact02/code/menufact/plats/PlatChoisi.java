package menufact.plats;

import menufact.plats.Etats.EtatPlat;
import menufact.plats.Etats.EtatPlatCommande;
import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;

/**
 * Cette classe permet de créer un plat qui est choisi par un client.
 */
public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private EtatPlat etat;

    /**
     * Constructeur du plat choisi
     * @param plat le plat au menu correspondant
     * @param quantite la quantité qui est commandée
     */
    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etat = new EtatPlatCommande(this);
    }

    /**
     * Tenter de changer l'état du plat à commandé
     * @throws PlatException s'il n'y a pas assez d'ingrédients pour le commander
     */
    public void commander() throws PlatException {
        etat.commander();
        System.out.println("Le plat est commandé...");
    }

    /**
     * Tenter de changer l'état du plat à en préparation
     * @throws PlatException s'il est impossible de changer à cet état
     */
    public void preparer() throws PlatException {
        etat.preparer();
        System.out.println("Preparation du plat...");
    }

    /**
     * Tenter de changer l'état du plat à terminé
     * @throws PlatException s'il est impossible de changer à cet état
     */
    public void terminer() throws PlatException {
        etat.terminer();
        System.out.println("Le plat est terminé...");
    }

    /**
     * Tenter de changer l'état du plat à servi
     * @throws PlatException s'il est impossible de changer à cet état
     */
    public void servir() throws PlatException {
        etat.servir();
        System.out.println("Le plat est servi...");
    }

    /**
     * Tenter de changer l'état du plat à impossible de préparer
     * @throws PlatException s'il est impossible de changer à cet état
     */
    public void rendreImpossible(){
        etat.rendreImpossible();
        System.out.println("Le plat est impossible à commander..");
    }

    /**
     * Affichage du plat choisi
     * @return les informations du plat choisi en String
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    /**
     * Obtenir la quantité du plat choisi
     * @return la quantité
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Changer la quantité du plat choisi
     * @param quantite nouvelle quantité
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Obtenir le plat associé
     * @return le plat
     */
    public PlatAuMenu getPlat() {
        return plat;
    }

    /**
     * Obtenir l'état du plat choisi
     * @return l'état du plat
     */
    public EtatPlat getEtat() {
        return etat;
    }

    /**
     * Changer l'état du plat choisi
     * @param newEtat nouvel état
     */
    public void setEtat(EtatPlat newEtat) {
        this.etat = newEtat;
    }

}
