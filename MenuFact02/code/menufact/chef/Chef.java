package menufact.chef;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class Chef implements Observateur{
    Inventaire inventaire;

    public Chef() {
        inventaire = Inventaire.getInventaire();
    }

    /**
     * Cette méthode vérifie d'abord la disponibilité des ingrédients.
     * Elle préparer ensuite le plat en passant à travers tous ses états
     * @param plat le plat qu'on doit préparer
     * @throws PlatException S'il n'y a pas assez d'ingrédients pour préparer le plat
     */
    public void preparerPlatComplet(PlatChoisi plat) throws PlatException {
        try {
            verifierIngredients(plat);
            enleverIngredients(plat);
            plat.preparer();
            plat.terminer();
            plat.servir();
        } catch (PlatException e) {
            plat.rendreImpossible();
            throw new PlatException(e.getMessage());
        } catch (IngredientException e) {
            plat.rendreImpossible();
        }

    }

    /**
     *
     * @param plat plat pour lequel on doit vérifier la disponibilité des ingrédients
     * @throws PlatException si il n'y a pas assez d'ingrédients
     */
    public void verifierIngredients(PlatChoisi plat) throws PlatException {

        for (IngredientInventaire ingredientDuPlat : plat.getPlat().getIngredients()) {
            for (IngredientInventaire ingredientDeInventaire : inventaire.getIngredients()) {
                if ((ingredientDuPlat.getIngredient().getNom() == ingredientDeInventaire.getIngredient().getNom()) && ingredientDuPlat.getQuantite() * plat.getQuantite() > ingredientDeInventaire.getQuantite()) {
                    throw new PlatException("Impossible de créer le plat, il n'y a pas assez d'ingredients!");
                }
            }
        }
    }

    public void enleverIngredients(PlatChoisi plat) throws IngredientException {
        for (IngredientInventaire ingredientDuPlat : plat.getPlat().getIngredients()) {
            for (IngredientInventaire ingredientDeInventaire : inventaire.getIngredients()) {
                if (ingredientDeInventaire.getIngredient().getNom() == ingredientDuPlat.getIngredient().getNom()) {
                    ingredientDeInventaire.setQuantite(ingredientDeInventaire.getQuantite()-ingredientDuPlat.getQuantite());
                }
            }
        }
    }

    public Inventaire getInventaire() {
        return Inventaire.getInventaire();
    }


}
