package menufact.chef;

import Iterateur.Iterateur;
import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import inventaire.exceptions.InventaireException;
import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * Cette classe permet de créer un chef qui pourra préparer des plats et gérer les ingrédients de l'inventaire.
 * Cette classe fait partie du design pattern observer.
 * Le chef est notifié lorsqu'un plat est ajouté à une facture.
 */
public class Chef implements Observateur{
    Inventaire inventaire;

    /**
     * Constructeur par défaut
     */
    public Chef() {
        // un seul inventaire, car Singleton
        inventaire = Inventaire.getInventaire();
    }

    /**
     * Cette méthode vérifie d'abord la disponibilité des ingrédients.
     * Elle préparer ensuite le plat en passant à travers tous ses états
     * @param plat le plat qu'on doit préparer
     * @throws PlatException S'il n'y a pas assez d'ingrédients pour préparer le plat
     */
    public void preparerPlatComplet(PlatChoisi plat) throws PlatException, IngredientException, InventaireException {
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
            throw new IngredientException(e.getMessage());
        } catch (InventaireException e) {
            plat.rendreImpossible();
            throw new InventaireException(e.getMessage());
        }

    }

    /**
     * Cette méthode vérifie, pour un plat choisi, s'il y a assez d'ingrédients en inventaire pour le préparer.
     * Elle utilise les méthodes de l'itérateur de l'inventaire et du plat.
     * @param plat plat pour lequel on doit vérifier la disponibilité des ingrédients
     * @throws PlatException si il n'y a pas assez d'ingrédients
     */
    public void verifierIngredients(PlatChoisi plat) throws PlatException, InventaireException {

        Iterateur iterateurIngredientsPlat = plat.getPlat().creerIterateur();
        Iterateur iterateurIngredientsInventaire = Inventaire.getInventaire().creerIterateur();

        while (!iterateurIngredientsPlat.isFinished())
        {
            IngredientInventaire ingredientDuPlat = (IngredientInventaire) iterateurIngredientsPlat.next();

            if (!ingredientDuPlat.isIn(Inventaire.getInventaire().getIngredients())) {
                throw new InventaireException("Un des ingrédients du plat n'est pas disponible en inventaire!");
            }

            iterateurIngredientsInventaire = Inventaire.getInventaire().creerIterateur();
            while(!iterateurIngredientsInventaire.isFinished())
            {
                IngredientInventaire ingredientDeInventaire = (IngredientInventaire) iterateurIngredientsInventaire.next();

                if ((ingredientDuPlat.getIngredient().getNom() == ingredientDeInventaire.getIngredient().getNom()) && ingredientDuPlat.getQuantite() * plat.getQuantite() > ingredientDeInventaire.getQuantite()) {
                    throw new PlatException("Impossible de créer le plat, il n'y a pas assez d'ingredients!");
                }
            }
        }
    }

    /**
     * Cette méthode doit être appelée après avoir vérifié la disponibilité des ingrédients.
     * Elle permet d'enlever les ingrédients nécessaires pour le plat de l'inventaire.
     * Elle utilise l'itérateur du plat et de l'inventaire.
     * @param plat le plat qu'il faut préparer
     * @throws IngredientException si on tente de mettre une quantité d'ingrédients négative
     */
    public void enleverIngredients(PlatChoisi plat) throws IngredientException {

        Iterateur iterateurIngredientsPlat = plat.getPlat().creerIterateur();
        Iterateur iterateurIngredientsInventaire = Inventaire.getInventaire().creerIterateur();

        while (!iterateurIngredientsPlat.isFinished())
        {
            IngredientInventaire ingredientDuPlat = (IngredientInventaire) iterateurIngredientsPlat.next();
            iterateurIngredientsInventaire = Inventaire.getInventaire().creerIterateur();
            while(!iterateurIngredientsInventaire.isFinished())
            {
                IngredientInventaire ingredientDeInventaire = (IngredientInventaire) iterateurIngredientsInventaire.next();

                if (ingredientDeInventaire.getIngredient().getNom() == ingredientDuPlat.getIngredient().getNom()) {
                    ingredientDeInventaire.setQuantite(ingredientDeInventaire.getQuantite()-ingredientDuPlat.getQuantite());
                }
            }
        }
    }
}
