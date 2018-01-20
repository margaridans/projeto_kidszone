package pt.ipp.estg.projeto_kidszone.NotifiAndProgBar;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import pt.ipp.estg.projeto_kidszone.Activities.Jogo.JogoTreino;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.MenuJogo;

/**
 * Created by Bernardino on 19/01/2018.
 */

public class MinhaTask extends AsyncTask<Object, Object, String> {
private Button btnCom ;
    private ProgressBar progressBar;
    private TextView texto;
    private int total = 0;
    private static int PROGRESSO = 25;

    public MinhaTask(Context context, ProgressBar progressBar, TextView texto) {
        this.progressBar = progressBar;
        this.texto = texto;
    }

    @Override
    protected void onPreExecute() {
        texto.setText("0%");
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Object... params) {
        try {

            Thread.sleep(1000);

            for (int i=0; i<4; i++) {
                publishProgress();
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Object... values) {
        total += PROGRESSO;
        progressBar.incrementProgressBy(PROGRESSO);
        texto.setText(total + "%");
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        JogoTreino.mostrarInv();
    }
}