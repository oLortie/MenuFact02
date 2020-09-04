package menufact.chef;

public interface Observable {
    public void attacher(Observateur observateur);
    public void detacher(Observateur observateur);
    public void notifier();
}
