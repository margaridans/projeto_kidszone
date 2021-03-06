package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.Dificuldade;
import projeto_kidszone.database_library.Model.Pergunta;
import pt.ipp.estg.projeto_kidszone.NotifiAndProgBar.MinhaTask;
import pt.ipp.estg.projeto_kidszone.Model.Perguntas_Jogo;
import pt.ipp.estg.projeto_kidszone.R;


public class Jogo extends AppCompatActivity implements View.OnClickListener {
    private int pontuacao = 0;
    private Perguntas_Jogo jogo;
    private Dificuldade dificuldade;
    private static TextView txtPergunta;
    private static TextView txtPontuacao;
    private static Button btn, btn1, btn2, btn3, btn4, btnTerminar;
    private static Pergunta pergunta;
    private int id_lista = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        ArrayList<Pergunta> listaPerguntas = new ArrayList<>();
        jogo = new Perguntas_Jogo(this, -1);

        txtPergunta = (TextView) findViewById(R.id.txtPergunta);
        btn1 = (Button) findViewById(R.id.resposta1);
        btn2 = (Button) findViewById(R.id.resposta2);
        btn3 = (Button) findViewById(R.id.resposta3);
        btn4 = (Button) findViewById(R.id.resposta4);
        txtPontuacao = (TextView) findViewById(R.id.pontuacao);

        MyDbHelper dbHelper = new MyDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Pergunta.getPerguntas(db, listaPerguntas);
        pergunta = listaPerguntas.get(id_lista);

        btnTerminar = (Button) findViewById(R.id.terminar_treino);
        btnTerminar.setOnClickListener((View.OnClickListener) this);

        SharedPreferences.Editor edit = getSharedPreferences("pontuacao", MODE_PRIVATE).edit();
        edit.remove("pontuacao");
        edit.apply();


        setPerguntaToView();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn1.getText().toString());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn2.getText().toString());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn3.getText().toString());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn4.getText().toString());
            }
        });

        ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
        TextView texto = (TextView) findViewById(R.id.texto);

        new MinhaTask(Jogo.this, progress, texto).execute();

    }


    public static void mostrarInv() {
        txtPergunta.setVisibility(View.VISIBLE);
        txtPontuacao.setVisibility(View.VISIBLE);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btnTerminar.setVisibility(View.VISIBLE);
    }


    private void verificaResposta(String resposta) {
        if (jogo.respostaCerta(resposta)) {
            if (pergunta.getId_dificuldade() == 1) {
                pontuacao += 2;
            }
            if (pergunta.getId_dificuldade() == 2) {
                pontuacao += 5;
            }
            if (pergunta.getId_dificuldade() == 3) {
                pontuacao += 8;
            }

            txtPontuacao.setText("Pontos: " + pontuacao);

            setPerguntaToView();

        } else {
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(300);
            setPerguntaToView();
        }
    }

    String bigText = "A qualquer momento podem surgir novas questões na tua aplicação";

    @Override
    public void onBackPressed() {

    }

    private void setPerguntaToView() {

        onBackPressed();
        pergunta = jogo.getNextPergunta();
        if (pergunta != null) {
            txtPergunta.setText(pergunta.getPergunta_name());
            btn1.setText(pergunta.getResposta1());
            btn2.setText(pergunta.getResposta2());
            btn3.setText(pergunta.getResposta3());
            btn4.setText(pergunta.getResposta4());
        } else {

            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

            builder.setContentTitle("Fica atento!");
            builder.setContentText("A qualquer momento podem surgir novas questões na tua aplicação");
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(bigText));

            builder.setSmallIcon(R.drawable.logo);
            Notification n = builder.build();
            builder.setAutoCancel(true);
            n.vibrate = new long[]{150, 300, 150, 300};
            nm.notify(R.drawable.logo, n);
            finish();
            SharedPreferences.Editor editor = getSharedPreferences("pontuacao", MODE_PRIVATE).edit();
            editor.putInt("pontuacao", pontuacao);

            editor.apply();

            Intent intentFimJogo = new Intent(this, FimJogo.class);
            startActivity(intentFimJogo);

        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.terminar_treino) {
            onPause();
            AlertDialog.Builder alertaSair = new AlertDialog.Builder(Jogo.this);
            alertaSair.setTitle("Aviso");
            alertaSair.setMessage("Tens a certeza que queres sair?");
            alertaSair.setCancelable(false);
            alertaSair.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    onResume();
                }
            });
            alertaSair.setPositiveButton("Sair", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intentTerminar = new Intent(Jogo.this, MenuJogo.class);
                    startActivity(intentTerminar);
                    finish();
                }
            });
            AlertDialog alertDialogo = alertaSair.create();
            alertDialogo.show();


        }

    }


}

