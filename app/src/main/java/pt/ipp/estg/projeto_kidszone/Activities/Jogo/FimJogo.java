package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.ActivityMainUser;
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;

public class FimJogo extends AppCompatActivity  {
    TextView txtPontuacao;
    MyDbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_jogo);

        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);


        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String nome = prefs.getString("username", "default");


        SharedPreferences prefs_pont = getSharedPreferences("pontuacao", MODE_PRIVATE);
        Integer pontuacao_nova = prefs_pont.getInt("pontuacao", 0);


/*        SharedPreferences prefs_ultimapont = getSharedPreferences("ultima_pont", MODE_PRIVATE);
        Integer ultima_pont = prefs_ultimapont.getInt("pontuacao", 0);*/


        myDb = new MyDbHelper(this);
        if (nome != null) {
            Boolean res = myDb.inserirPontuacao(pontuacao_nova, nome);


            if (res == true) {

               /* if (pontuacao_nova > ultima_pont) {
                    onPause();
                    AlertDialog.Builder alertaPont = new AlertDialog.Builder(FimJogo.this);
                    alertaPont.setTitle("Boaaaaa! ");
                    alertaPont.setIcon(R.drawable.happy);
                    alertaPont.setMessage("A tua pontuação foi de " + pontuacao_nova + ". Conseguiste superar a tua última pontuação.");
                    alertaPont.setCancelable(false);
                    alertaPont.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intentMenu = new Intent(FimJogo.this, MenuJogo.class);
                            startActivity(intentMenu);
                        }
                    });
                    alertaPont.setPositiveButton("Voltar a jogar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent intentJogar = new Intent(FimJogo.this, Jogo.class);
                            startActivity(intentJogar);
                        }
                    });

                    AlertDialog alertDialogo = alertaPont.create();
                    alertDialogo.show();
                } else if (pontuacao_nova < ultima_pont) {
                    onPause();
                    AlertDialog.Builder alertaPont = new AlertDialog.Builder(FimJogo.this);
                    alertaPont.setTitle("Oh nãooooo! ");
                    alertaPont.setIcon(R.drawable.sad);
                    alertaPont.setMessage("A tua pontuação foi de " + pontuacao_nova + ". Não conseguiste superar a tua última pontuação!");
                    alertaPont.setCancelable(false);

                    alertaPont.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intentMenu = new Intent(FimJogo.this, MenuJogo.class);
                            startActivity(intentMenu);
                        }
                    });


                    alertaPont.setPositiveButton("Voltar a jogar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent intentJogar = new Intent(FimJogo.this, Jogo.class);
                            startActivity(intentJogar);
                        }
                    });

                    AlertDialog alertDialogo = alertaPont.create();
                    alertDialogo.show();
                } else if (pontuacao_nova == ultima_pont) {
                    onPause();
                    AlertDialog.Builder alertaPont = new AlertDialog.Builder(FimJogo.this);
                    alertaPont.setTitle("Que pontaria! ");
                    alertaPont.setIcon(R.drawable.sad);
                    alertaPont.setMessage("A tua pontuação foi de " + pontuacao_nova + ". Conseguiste fazer a mesma pontuação da última vez!");
                    alertaPont.setCancelable(false);
                    alertaPont.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intentMenu = new Intent(FimJogo.this, MenuJogo.class);
                            startActivity(intentMenu);
                        }
                    });
                    AlertDialog alertDialogo = alertaPont.create();
                    alertDialogo.show();
                    alertaPont.setPositiveButton("Voltar a jogar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent intentJogar = new Intent(FimJogo.this, Jogo.class);
                            startActivity(intentJogar);
                        }
                    });


                }*/

                onPause();
                AlertDialog.Builder alertaPont = new AlertDialog.Builder(FimJogo.this);
                alertaPont.setTitle("Boaaaaa! ");
                alertaPont.setIcon(R.drawable.happy);
                alertaPont.setMessage("A tua pontuação foi de " + pontuacao_nova + ". Continua a jogar para te conseguires superar.");
                alertaPont.setCancelable(false);
                alertaPont.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intentMenu = new Intent(FimJogo.this, MenuJogo.class);
                        startActivity(intentMenu);
                        finish();
                    }
                });
                alertaPont.setPositiveButton("Voltar a jogar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intentJogar = new Intent(FimJogo.this, Jogo.class);
                        startActivity(intentJogar);
                    }
                });

                AlertDialog alertDialogo = alertaPont.create();
                alertDialogo.show();
            }
        }

    }
}



