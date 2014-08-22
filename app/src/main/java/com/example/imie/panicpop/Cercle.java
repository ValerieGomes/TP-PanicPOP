package com.example.imie.panicpop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Valerie on 21/08/14.
 */
public class Cercle {
    int xc, yc, rayon;
    private Paint paint;

    public Cercle (int x, int y, int r) {
        xc = x;
        yc = y;
        rayon = r;
        paint = new Paint();
        //paint.setColor(Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        //paint.setColor(Color.MAGENTA);
        paint.setColor(Color.WHITE);
    }

    //Méthode pour dessiner un cercle dans le canvas
    public void draw (Canvas canvas) {
        canvas.drawCircle(xc, yc, rayon, paint);
    }

}
