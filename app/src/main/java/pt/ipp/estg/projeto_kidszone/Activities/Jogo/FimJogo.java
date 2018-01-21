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

public class FimJogo extends AppCompatActivity implements View.OnClickListener {
    TextView txtPontuacao;
    MyDbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_jogo);

        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);


        Button btnMenuPrincipal = (Button) findViewById(R.id.button_menuPrincipal);
        btnMenuPrincipal.setOnClickListener(this);

        SharedPreferences prefs= getSharedPreferences("login", MODE_PRIVATE);
        String nome= prefs.getString("username", "default");



        SharedPreferences prefs_pont = getSharedPreferences("pontuacao", MODE_PRIVATE);
        Integer pontuacao_nova = prefs_pont.getInt("pontuacao", 0);


        SharedPreferences prefs_ultimapont = getSharedPreferences("ultima_pont", MODE_PRIVATE);
        Integer ultima_pont = prefs_ultimapont.getInt("pontuacao", 0);


        txtPontuacao.setText("A sua pontuacao é de: " + pontuacao_nova);


        myDb = new MyDbHelper(this);
        if (nome != null) {
            Boolean res = myDb.inserirPontuacao(pontuacao_nova, nome);


            if (res == true) {

              if(pontuacao_nova>ultima_pont) {
                  onPause();
                  AlertDialog.Builder alertaSair = new AlertDialog.Builder(FimJogo.this);
                  alertaSair.setTitle("Boaaaaa! ");
                  alertaSair.setIcon(R.drawable.happy);
                  alertaSair.setMessage("Conseguiste superar a tua última pontuação!");
                  alertaSair.setCancelable(false);
                  alertaSair.setPositiveButton("Sair", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                          Intent intentTerminar = new Intent(FimJogo.this, MenuJogo.class);
                          startActivity(intentTerminar);
                          finish();
                      }
                  });
                  alertaSair.setNegativeButton("Voltar a jogar", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                          Intent intentJogar = new Intent(FimJogo.this, Jogo.class);
                          startActivity(intentJogar);
                      }
                  });

                  AlertDialog alertDialogo = alertaSair.create();
                  alertDialogo.show();
              } else  if(pontuacao_nova<ultima_pont) {
                  onPause();
                  AlertDialog.Builder alertaSair = new AlertDialog.Builder(FimJogo.this);
                  alertaSair.setTitle("Oh nãooooo! ");
                  alertaSair.setIcon(R.drawable.sad);
                  alertaSair.setMessage("não conseguiste superar a tua última pontuação!");
                  alertaSair.setCancelable(false);

                  alertaSair.setPositiveButton("Sair", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                          Intent intentTerminar = new Intent(FimJogo.this, MenuJogo.class);
                          startActivity(intentTerminar);
                          finish();
                      }
                  });

                  alertaSair.setNegativeButton("Voltar a jogar", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                          Intent intentJogar = new Intent(FimJogo.this, Jogo.class);
                          startActivity(intentJogar);
                      }
                  });

                  AlertDialog alertDialogo = alertaSair.create();
                  alertDialogo.show();
              } else  if(pontuacao_nova== ultima_pont) {
                  onPause();
                  AlertDialog.Builder alertaSair = new AlertDialog.Builder(FimJogo.this);
                  alertaSair.setTitle("Que pontaria! ");
                  alertaSair.setIcon(R.drawable.sad);
                  alertaSair.setMessage("conseguiste fazer a mesma pontuação da última vez!");
                  alertaSair.setCancelable(false);
                  alertaSair.setPositiveButton("Sair", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                          Intent intentTerminar = new Intent(FimJogo.this, MenuJogo.class);
                          startActivity(intentTerminar);
                          finish();
                      }
                  });
                  AlertDialog alertDialogo = alertaSair.create();
                  alertDialogo.show();
                  alertaSair.setNegativeButton("Voltar a jogar", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                          Intent intentJogar = new Intent(FimJogo.this, Jogo.class);
                          startActivity(intentJogar);
                      }
                  });


              }
            }
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_menuPrincipal) {
            Intent entrarMenu = new Intent(this, MainActivity.class);
            startActivity(entrarMenu);

        }
    }
}

