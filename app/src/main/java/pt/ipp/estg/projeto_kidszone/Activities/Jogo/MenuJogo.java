package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.AsyncTaskLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import pt.ipp.estg.projeto_kidszone.MinhaTask;
import pt.ipp.estg.projeto_kidszone.R;

public class MenuJogo extends AppCompatActivity implements View.OnClickListener {
    private static Button treino;
    private static Button competitivo;
    private static TextView txtComp;
    private static TextView txtTreino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jogo);

        treino = (Button) findViewById(R.id.treino);
        treino.setOnClickListener(this);

        txtTreino = (TextView) findViewById(R.id.txtTreino);

        competitivo = (Button) findViewById(R.id.competitivo);
        competitivo.setOnClickListener(this);

        txtComp = (TextView) findViewById(R.id.txtComp);

        ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
        TextView texto = (TextView) findViewById(R.id.texto);

        new MinhaTask(MenuJogo.this, progress, texto).execute();

    }

    public static void mostrarBotoes() {
        treino.setVisibility(View.VISIBLE);
        competitivo.setVisibility(View.VISIBLE);
        txtComp.setVisibility(View.VISIBLE);
        txtTreino.setVisibility(View.VISIBLE);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.treino) {

            Intent intentTreino = new Intent(this, JogoTreino.class);
            startActivity(intentTreino);
        } else if (view.getId() == R.id.competitivo) {

            Intent intentCompetitivo = new Intent(this, JogoCompetitivo.class);
            startActivity(intentCompetitivo);
        }
    }

}


