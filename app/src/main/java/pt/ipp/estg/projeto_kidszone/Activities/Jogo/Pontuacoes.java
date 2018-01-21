package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.Pontuacao;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 20/01/2018.
 */

public class Pontuacoes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacoes);

        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String nome = prefs.getString("username", null);
        MyDbHelper dbHelper = new MyDbHelper(this);

        TextView txtPontuacao = (TextView) findViewById(R.id.pontuacao_user);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Integer nm = Pontuacao.getPontuacaoByUser(db, nome).getPontuacao();
        Toast.makeText(this, nm.toString(), Toast.LENGTH_SHORT).show();

        if(nm==null) {
            onPause();
            AlertDialog.Builder alertaSair = new AlertDialog.Builder(Pontuacoes.this);
            alertaSair.setTitle("Aviso");
            alertaSair.setMessage("Não tens pontuações para mostrar.");
            alertaSair.setCancelable(false);
            alertaSair.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  onResume();
                }
            });
            alertaSair.setPositiveButton("Jogar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intentJogar = new Intent(Pontuacoes.this, MenuJogo.class);
                    startActivity(intentJogar);
                    finish();
                }
            });
            AlertDialog alertDialogo = alertaSair.create();
            alertDialogo.show();
        }

    }


}