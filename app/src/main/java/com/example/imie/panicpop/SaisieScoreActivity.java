package com.example.imie.panicpop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Valérie on 22/08/14.
 */
public class SaisieScoreActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);
        findViewById(R.id.btnok).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Lire la valeur saisie dans l'edittext
        EditText editTextNom = (EditText) findViewById(R.id.edittext1);
        EditText editTextScore = (EditText) findViewById(R.id.edittext2);
        String nom = editTextNom.getText().toString();
        String score = editTextScore.getText().toString();
        //L'ajouter à la base
        BDD bdd = new BDD();
        bdd.open(this);
        if (bdd.createInfo(nom, score) > 0) finish();
    }
}
