package com.example.imie.panicpop;

import java.util.LinkedList;

/**
 * Created by Valerie on 21/08/2014.
 */
public final class EnsembleCercles {

    // L'utilisation du mot clé volatile (utilisable qu'à partir de Java 5)
    // permet d'éviter le cas où "Singleton.instance" est non-nul,
    // mais pas encore "réellement" instancié.
    private static volatile EnsembleCercles instance = null;
    public LinkedList<Cercle> liste = null;

    // Constructeur de l'objet EnsembleCercles
    private EnsembleCercles() {
        // La présence d'un constructeur privé supprime le constructeur public par défaut.
        // De plus, seul le singleton peut s'instancier lui-même.
        super();
        liste =  new LinkedList<Cercle>();
    }

    //Méthode permettant de renvoyer l'instance de la classe EnsembleCercles
    public final static EnsembleCercles getInstance() {

        if (instance == null) {
            instance = new EnsembleCercles();
        }
        return instance;
    }

}

