package menufact.plats;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import menufact.plats.Etats.EtatPlat;
import menufact.plats.Etats.EtatPlatCommande;

import java.util.ArrayList;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private ArrayList<IngredientInventaire> lesIngredients;



    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.lesIngredients = new ArrayList<IngredientInventaire>();
    }

    public void ajouterIngredient(IngredientInventaire ingredient) {
        lesIngredients.add(ingredient);
    }

    public void ajouterQty(String nom, int qty) throws IngredientException {
        for (IngredientInventaire ingredient : lesIngredients) {
            if (ingredient.getIngredient().getNom() == nom) {
                ingredient.setQuantite(ingredient.getQuantite() + qty);
            }
        }
    }

    public ArrayList<IngredientInventaire> getIngredients() {
        return lesIngredients;
    }

    public PlatAuMenu() {
        this.lesIngredients = new ArrayList<IngredientInventaire>();
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
