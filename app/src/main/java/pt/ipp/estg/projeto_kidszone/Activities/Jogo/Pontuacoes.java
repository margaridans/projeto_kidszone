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
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.ActivityMainUser;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 20/01/2018.
 */

public class  Pontuacoes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacoes);

        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String nome = prefs.getString("username", null);

        MyDbHelper dbHelper = new MyDbHelper(this);

        TextView txtPontuacao = (TextView) findViewById(R.id.pontuacao_user);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

       /* int nr= Pontuacao.getPontuacaoByUser(db, nome).getPontuacao();
        Toast.makeText(this, nr, Toast.LENGTH_SHORT).show();*/

        SharedPreferences prefs_pontu = getSharedPreferences("pontuacao", MODE_PRIVATE);
        int pontuacao = prefs_pontu.getInt("pontuacao", 0);

        txtPontuacao.setText("A tua última pontuação foi: " + pontuacao);

        SharedPreferences.Editor editor = getSharedPreferences("ultima_pont", MODE_PRIVATE).edit();
        editor.putInt("pontuacao", pontuacao);

        editor.apply();



    }

}