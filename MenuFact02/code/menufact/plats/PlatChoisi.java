package menufact.plats;

import menufact.plats.Etats.EtatPlat;
import menufact.plats.Etats.EtatPlatCommande;
import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private EtatPlat etat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etat = new EtatPlatCommande(this);
    }

    public void commander() throws PlatException {
        etat.commander();
        System.out.println("Le plat est commandé...");
    }

    public void preparer() throws PlatException {
        etat.preparer();
        System.out.println("Preparation du plat...");
    }

    public void terminer() throws PlatException {
        etat.terminer();
        System.out.println("Le plat est terminé...");
    }

    public void servir() throws PlatException {
        etat.servir();
        System.out.println("Le plat est servi...");
    }

    public void rendreImpossible(){
        etat.rendreImpossible();
        System.out.println("Le plat est impossible à commander..");
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

    public EtatPlat getEtat() {
        return etat;
    }

    public void setEtat(EtatPlat newEtat) {
        this.etat = newEtat;
    }
}
