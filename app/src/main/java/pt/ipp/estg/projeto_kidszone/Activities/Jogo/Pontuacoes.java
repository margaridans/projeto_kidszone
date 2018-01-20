package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
    }


}