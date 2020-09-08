package ingredients;

/**
 * Cette classe est la classe mère de tous les ingrédients. Elle ne peut pas être instanciée.
 *
 */
public abstract class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;

    /**
     * obtenir le nom de l'ingrédient
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Changer le nom de l'ingrédient
     * @param nom le nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * obtenir la description de l'ingredient
     * @return la description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changer la description de l'ingrédient
     * @param description la nouvelle description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtenir le type d'ingrédient
     * @return le type d'ingrédient
     */
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * Changer le type d'ingrédient
     * @param typeIngredient le nouveau type d'ingrédient
     */
    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    /**
     * Affichage des informations de l'ingrédient
     * @return les informations
     */
    @Override
    public String toString() {
        return  "nom: " +
                getNom() +
                ", description: " +
                getDescription();
    }
}
