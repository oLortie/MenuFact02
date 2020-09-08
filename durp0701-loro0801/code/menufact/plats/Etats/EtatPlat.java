package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;

/**
 * Interface qui permet de créer des états pour les plats
 */
public interface EtatPlat {
    /**
     * Tenter de commander le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    public void commander() throws PlatException;

    /**
     * Tenter de preparer le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    public void preparer() throws PlatException;

    /**
     * Tenter de terminer le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    public void terminer() throws PlatException;

    /**
     * Tenter de servir le plat
     * @throws PlatException s'il est impossible de changer d'état
     */
    public void servir() throws PlatException;

    /**
     * Tenter de rendre le plat impossible à préparer
     * @throws PlatException s'il est impossible de changer d'état
     */
    public void rendreImpossible();

    /**
     * Affichage de l'état
     * @return l'état en String
     */
    public String toString();
}
