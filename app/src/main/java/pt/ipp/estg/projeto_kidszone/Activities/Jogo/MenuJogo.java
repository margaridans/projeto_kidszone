package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.AsyncTaskLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import pt.ipp.estg.projeto_kidszone.R;

public class MenuJogo extends AppCompatActivity implements View.OnClickListener {
    ProgressBar prgs;
    ProgressTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jogo);

        Button treino = (Button) findViewById(R.id.treino);
        treino.setOnClickListener(this);

        Button competitivo = (Button) findViewById(R.id.competitivo);
        competitivo.setOnClickListener(this);


        prgs = (ProgressBar) findViewById(R.id.progress_bar);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.treino) {
            showProgress();
            Intent intentTreino = new Intent(this, JogoTreino.class);
            startActivity(intentTreino);
        } else if (view.getId() == R.id.competitivo) {

                Intent intentCompetitivo = new Intent(this, JogoCompetitivo.class);
                startActivity(intentCompetitivo);
        }
    }

    private class ProgressTask extends AsyncTask<Integer, Integer, Void> {

        protected void onPreExecute() {
            super.onPreExecute();
            prgs.setMax(100); // set maximum progress to 100.
        }

        protected void onCancelled() {
            prgs.setMax(0); // stop the progress
        }

        protected Void doInBackground(Integer... params) {
            int start = params[0];
            for (int i = start; i <= 100; i += 5) {
                try {
                    boolean cancelled = isCancelled();
                    if (!cancelled) {
                        publishProgress(i);
                        Log.v("Progress", "increment " + i);
                        onProgressUpdate(i);
                        SystemClock.sleep(1000);
                    }
                } catch (Exception e) {
                    Log.e("Error", e.toString());
                }
            }
            return null;
        }
        protected void onProgressUpdate(Integer... values) {

            // increment progress bar by progress value
            //////////////////////setProgress(10);
            //////////////////////prgs.setProgress(prgs.getProgress() + 5); // the bar does not fill 100%
            prgs.setProgress(5);
            Log.v("Progress","Once");
        }
        protected void onPostExecute(Void result) {
            // async task finished
            Log.v("Progress", "Finished");
        }
    }


        private void showProgress() {
            task = new ProgressTask();
            task.execute(150);
        }


    }


