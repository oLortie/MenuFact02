package ingredients;

/**
 * Cette classe fait partie du design pattern Adapter.
 * Elle permet de transformer un ingrédient inventaire liquide en le rendant solide à partir de sa masse volumique
 *
 */
public class IngredientInventaireLiquideAdapter extends IngredientInventaire{

    private IngredientInventaireLiquide ingredientLiquide;
    private double masseVolumique;

    public IngredientInventaireLiquideAdapter(IngredientInventaireLiquide IngredientLiquide, double masseVolumique) {
        super(IngredientLiquide.getIngredient(), IngredientLiquide.getQuantite());
        this.ingredientLiquide = IngredientLiquide;
        this.masseVolumique = masseVolumique;
    }

    /**
     * Obtenir la quantité tranformée en solide à partir de la masse volumique
     * @return la quantité
     */
    public int getQuantite() {
        return  (int) (this.ingredientLiquide.getQuantite() * masseVolumique);
    }

    /**
     * Obtenir l'ingrédient liquide
     * @return l'ingrédient liquide
     */
    public Ingredient getIngredienLiquide()
    {
        return ingredientLiquide.getIngredient();
    }
}
