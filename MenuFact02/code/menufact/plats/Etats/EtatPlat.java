package menufact.plats.Etats;

import menufact.plats.Exceptions.PlatException;

public interface EtatPlat {
    public void commander() throws PlatException;
    public void preparer() throws PlatException;
    public void terminer() throws PlatException;
    public void servir() throws PlatException;
    public void rendreImpossible() throws PlatException;
    public String toString();
}
