package menufact.facture;

import menufact.Client;
import menufact.chef.Observable;
import menufact.chef.Observateur;
import menufact.facture.Etats.*;
import menufact.facture.exceptions.FactureException;
import menufact.plats.Exceptions.PlatException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact.
 * Cette classe fait partie du design pattern Observer.
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture implements Observable {
    private Date date;
    private String description;
    private EtatFacture etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private int courant;
    private Client client;
    private ArrayList<Observateur> observateurs;

    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     * attacher un observateur pour envoyer des notifications
     * @param observateur observateur à attacher
     */
    @Override
    public void attacher(Observateur observateur) {
        observateurs.add(observateur);
    }

    /**
     * détacher un observateur pour arrêter de lui envoyer des notifications
     * @param observateur observateur à détacher
     */
    @Override
    public void detacher(Observateur observateur) {
        observateurs.remove(observateurs.indexOf(observateur));
    }

    /**
     * Notifier tous les observateurs qu'un plat doit être préparé
     * @param plat
     * @throws PlatException
     */
    @Override
    public void notifier(PlatChoisi plat) throws PlatException {
        for (Observateur observateur : observateurs) {
            observateur.preparerPlatComplet(plat);
        }
    }

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client) throws FactureException
    {
        if (etat.toString() == FactureEtat.OUVERTE.toString()) {
            this.client = client;
        }
        else
        {
            throw new FactureException("Impossible d'associer un client à une facture fermée!");
        }
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
         for (PlatChoisi p : platchoisi) {
             if (p.getEtat().toString() != "IMPOSSIBLE") {
                 soustotal += p.getQuantite() * p.getPlat().getPrix();
             }
         }

        return soustotal;
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps(){
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }

    /**
     * Permet de chager l'état de la facture à PAYEE
     */
    public void payer() throws FactureException
    {
        etat.payer();
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer() throws FactureException
    {
        etat.fermer();
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
        etat.ouvrir();
    }

    /**
     *
     * @return l'état de la facture
     */
    public EtatFacture getEtat()
    {
        return etat;
    }

    public void setEtat(EtatFacture newEtat) {
        this.etat = newEtat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        etat = new EtatFactureOuverte(this);
        courant = -1;
        this.description = description;
        this.observateurs = new ArrayList<Observateur>();
    }

    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException {
        if (etat.toString() == "OUVERTE") {
            platchoisi.add(p);
            notifier(p);
        }
        else
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return "Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat.toString() +
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture()
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                          "Date:" + date + "\n" +
                          "Description: " + description + "\n" +
                          "Client:" + client.getNom() + "\n" +
                          "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : platchoisi)
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + tps() + "\n";
        factureGenere += "          TVQ:               " + tvq() + "\n";
        factureGenere += "          Le total est de:   " + total() + "\n";

        return factureGenere;
    }
}
