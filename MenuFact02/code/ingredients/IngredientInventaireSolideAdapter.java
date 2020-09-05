package ingredients;

public class IngredientInventaireSolideAdapter extends IngredientInventaire{

    private IngredientInventaireLiquide ingredientLiquide;
    private final static int RAPPORT_SOLIDE_LIQUIDE = 2; // rapport fait gramme/litre: 2 -> 1 litre = 2 grammes

    public IngredientInventaireSolideAdapter(IngredientInventaireLiquide IngredientLiquide) {
        super(IngredientLiquide.getIngredient(), IngredientLiquide.getQuantite());
        this.ingredientLiquide = IngredientLiquide;
    }

    public int getQuantite() {
        return this.ingredientLiquide.getQuantite() * RAPPORT_SOLIDE_LIQUIDE;
    }

    public Ingredient getIngredienLiquide()
    {
        return ingredientLiquide.getIngredient();
    }
}
