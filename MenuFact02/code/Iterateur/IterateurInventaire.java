package Iterateur;

public class IterateurInventaire implements Iterateur {

    private int currentPosition;

    public IterateurInventaire()
    {
        currentPosition = 0;
    }

    public int next()
    {
        return currentPosition++;
    }

    public boolean isFinished()
    {
        return false;
    }
}
