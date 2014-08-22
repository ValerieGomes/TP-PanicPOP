package com.example.imie.panicpop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class PanicPopActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic_pop);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.panic_pop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.menu_affiche_score:
                // Affiche les scores
                Log.i("Score", "on va afficher les scores.");
                Intent intent = new Intent(this, AfficheScoreActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.menu_insere_score:
                // Insère un score
                Log.i("Score", "on va insérer un score.");
                Intent intent2 = new Intent(this, SaisieScoreActivity.class);
                startActivityForResult(intent2, 1);
                // Affiche les scores
                Log.i("Score", "on va afficher les scores.");
                Intent intent3 = new Intent(this, AfficheScoreActivity.class);
                startActivityForResult(intent3, 1) ;
                break;
            case R.id.menu_settings:
                //On ne fait rien pour l'instant
                break;
        }
        return true;
    }
}



