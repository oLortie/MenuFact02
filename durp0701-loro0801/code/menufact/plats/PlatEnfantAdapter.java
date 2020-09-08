package menufact.plats;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import menufact.plats.Exceptions.PlatException;

import java.util.ArrayList;

/**
 * Cette classe permet d'adapter un plat pour enfant avec la bonne proportion.
 * Elle fait partie du design pattern adapter.
 */
public class PlatEnfantAdapter extends PlatAuMenu{
    private PlatEnfant plat;

    /**
     * Constructeur de l'adapteur.
     * Il modifie la liste d'ingrédients pour qu'ils respectent la proportion
     * @param plat
     * @throws IngredientException
     */
    public PlatEnfantAdapter(PlatEnfant plat) throws PlatException {
        super(plat.getCode(), plat.getDescription(), plat.getPrix());
        this.plat = plat;

        IterateurPlatAuMenu iterateur = (IterateurPlatAuMenu) plat.creerIterateur();

        while (!iterateur.isFinished()) {
            IngredientInventaire nouvelIngredient = (IngredientInventaire) iterateur.next();
            try {
                nouvelIngredient.setQuantite((int) (nouvelIngredient.getQuantite() * plat.getProportion()));
            } catch (IngredientException e) {
                throw new PlatException(e.getMessage());
            }

            ajouterIngredient(nouvelIngredient);
        }
    }

}
