package menufact.plats;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

public class PlatEnfantAdapter extends PlatEnfant{
    private PlatEnfant plat;
    boolean adapted;

    public PlatEnfantAdapter(PlatEnfant plat) {
        this.plat = plat;
        this.adapted = false;
    }

    public void  adapt() throws IngredientException {


        if (!adapted) {

            for (IngredientInventaire ingredient : plat.getIngredients()) {
                ingredient.setQuantite((int) (ingredient.getQuantite() * plat.getProportion()));
            }
        }

        adapted = true;
    }
}
