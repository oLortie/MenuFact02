package menufact.plats;

/**
 * Cette classe permet de créer un plat pour enfant qui aura une proportion d'un plat au menu normal
 */
public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    /**
     * Constructeur par défaut
     */
    public PlatEnfant() {
    }

    /**
     * Constructeur de la classe
     * @param code code du plat
     * @param description description du plat
     * @param prix prix du plat
     * @param proportion proportion du plat normal
     */
    public PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }

    /**
     * Obtenir la propotion du plat normal
     * @return la proportion
     */
    public double getProportion() {
        return proportion;
    }

    /**
     * Affichage du plat pour enfant
     * @return les informations du plat pour enfant
     */
    @Override
    public String toString() {
        return  "\n" + "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
