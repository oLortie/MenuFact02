package menufact.plats;

import Iterateur.Containeur;
import Iterateur.Iterateur;
import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.plats.Etats.EtatPlat;
import menufact.plats.Etats.EtatPlatCommande;

import java.util.ArrayList;

/**
 * Cette classe permet de créer un plat au menu
 */
public class PlatAuMenu implements Containeur {
    private int code;
    private String description;
    private double prix;
    private ArrayList<IngredientInventaire> lesIngredients;


    /**
     * Constructeur de la classe
     * @param code code du plat
     * @param description description du plat
     * @param prix prix du plat
     */
    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.lesIngredients = new ArrayList<IngredientInventaire>();
    }

    /**
     * Ajouter un ingrédient au plat
     * @param ingredient ingrédient à ajouter
     */
    public void ajouterIngredient(IngredientInventaire ingredient) {
        lesIngredients.add(ingredient);
    }

    /**
     * Obtenir la liste des ingrédients du plat
     * @return
     * @throws IngredientException
     */
    public ArrayList<IngredientInventaire> getIngredients() {
        return lesIngredients;
    }

    /**
     * Constructeur par défaut
     */
    public PlatAuMenu() {
        this.lesIngredients = new ArrayList<IngredientInventaire>();
    }

    /**
     * Affichage du plat au menu
     * @return
     */
    @Override
    public String toString() {
        return  "\n" + "PlatAuMenu{" +
                "code=" + code +
                ", description='" + description +
                ", prix=" + prix +
                ", ingredient=" + lesIngredients +
                "}";
    }

    /**
     * Obtenir le code du plat au menu
     * @return le code
     */
    public int getCode() {
        return code;
    }

    /**
     * Changer le code du plat
     * @param code le nouveau code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Obtenir la description du plat
     * @return la description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changer la description du plat
     * @param description la nouvelle description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtenir le prix du plat
     * @return le prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Changer le prix du plat
     * @param prix le nouveau prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Créer un itérateur pour itérer à travers les ingrédients du plat
     * @return l'itérateur
     */
    @Override
    public Iterateur creerIterateur()
    {
        IterateurPlatAuMenu result = new IterateurPlatAuMenu();
        return result;
    }

    /**
     * Classe itérateur qui permet d'itérer à travers les ingrédients du plat
     * Cette classe fait partie du design pattern Iterator.
     */
    public class IterateurPlatAuMenu implements Iterateur {

        private int currentPosition;

        /**
         * Constructeur par défaut
         */
        public IterateurPlatAuMenu() {
            currentPosition = 0;
        }

        /**
         * Obtenir le prochain ingrédient de la liste
         * @return le prochain ingrédient
         */
        public Object next() {
            if (!isFinished()) {
                return lesIngredients.get(currentPosition++);
            } else
                return null;
        }

        /**
         * Vérifier s'il reste un élément dans la liste pour itérer
         * @return true si la liste est terminée, false sinon
         */
        public boolean isFinished() {
            if (this.currentPosition < lesIngredients.size()) {
                return false;
            } else {
                return true;
            }
        }
    }
}
