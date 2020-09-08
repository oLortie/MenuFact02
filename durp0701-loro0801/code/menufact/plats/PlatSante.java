package menufact.plats;

import menufact.plats.PlatAuMenu;

/**
 * Cette classe permet de créer un plat santé qui possède plusieurs valeurs nutritives
 */
public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    /**
     * Constructeur de la classe PlatSanté
     * @param code code du plat
     * @param description description du plat
     * @param prix prix du plat
     * @param kcal nombre de kcal dans le plat
     * @param chol cholestérol dans le plat
     * @param gras nombre de gras dans le plat
     */
    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        super(code, description, prix);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    /**
     * Constructeur par défaut
     */
    public PlatSante() {
    }

    /**
     * Affichage du plat santé
     * @return les informations du plat en String
     */
    @Override
    public String toString() {
        return  "\n" + "PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    /**
     * Obtenir le nombre de kcal dans le plat
     * @return nombre de kcal
     */
    public double getKcal() {
        return kcal;
    }

    /**
     * Obtenir le cholestérol du plat
     * @return le cholestérol
     */
    public double getChol() {
        return chol;
    }

    /**
     * Obtenir le gras du plat
     * @return le gras
     */
    public double getGras() {
        return gras;
    }
}
