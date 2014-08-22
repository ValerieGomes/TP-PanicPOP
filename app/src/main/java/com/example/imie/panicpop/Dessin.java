package com.example.imie.panicpop;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Valerie on 21/08/14.
 */

public class Dessin extends View implements OnTouchListener {

    LinkedList<Cercle> cercles;

    private Dessin dessin = this;
    private Handler handler;
    private int nbPoints = 0;

    public Dessin(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
        handler = new Handler();
        // Création et insertion d'un cercle dans la liste
        Cercle cercle = new Cercle(100, 100, 30);
        EnsembleCercles.getInstance().liste.add(cercle);
        runAddCercles.run();
    }

    @Override
    public void onDraw(Canvas canvas) {
        // On dessine les cercles de la liste
        for (Cercle cercle : EnsembleCercles.getInstance().liste) {
            cercle.draw(canvas);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //On récupère la position x et y du pouce
        int x = (int) event.getX();
        int y = (int) event.getY();

        //Suivant l'évènement (toucher)
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // toucher en x,y
                //cercles.add(new Cercle(x, y, 1));
                Log.i ("nb élément dans la liste ", String.valueOf(EnsembleCercles.getInstance().liste.size()));
                Cercle cercleASupprimer = null;
                for (Cercle cercle : EnsembleCercles.getInstance().liste) {
                    if ((x < cercle.posx + cercle.rayon) &&
                            x > cercle.posx - cercle.rayon &&
                            y < cercle.posy + cercle.rayon &&
                            y > cercle.posy - cercle.rayon) {
                        cercleASupprimer = cercle;
                    }
                }
                if (cercleASupprimer != null) {
                    EnsembleCercles.getInstance().liste.remove(cercleASupprimer);
                    nbPoints++;
                    Log.i ("nb points", String.valueOf(nbPoints));
                }
        }
        //On va signaler à la vue que son contenu n'est plus à jour, elle va donc rappeler
        //automatiquement onDraw dès que possible.
        this.invalidate();
        return true;
    }

    public Runnable runAddCercles = new Runnable(){
        private Random random = new Random();

        @Override
        public void run() {
            // On ne prendra que 10 cercles à la fois
            if ( EnsembleCercles.getInstance().liste.size() <= 10){
                int x = random.nextInt(300);
                int y = random.nextInt(300) + 30;
                int rayon = random.nextInt(40);
                Cercle cercle = new Cercle(x, y, (rayon < 25 ? 25 : rayon));
                EnsembleCercles.getInstance().liste.add(cercle);
            }
            //if (comptePoints <= 20) {
            int delai = random.nextInt (1000);
            //Log.i("delai",String.valueOf(delai));
            handler.postDelayed (runAddCercles, (delai > 250 ? delai : 250));
            //}
            dessin.invalidate();
        }
    };

}



