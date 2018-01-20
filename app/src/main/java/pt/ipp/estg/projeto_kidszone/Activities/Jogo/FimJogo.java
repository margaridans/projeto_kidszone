package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

        Intent intentFimJogo = getIntent();
        Integer pontuacao = intentFimJogo.getIntExtra("pontuacao", 0);

        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);

        txtPontuacao.setText("A sua pontuacao é de: " + pontuacao);

        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String nome = prefs.getString("username", null);

        myDb = new MyDbHelper(this);
        if (nome != null) {
          myDb.inserirPontuacao(nome, pontuacao);

        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_menuPrincipal) {
            Intent entrarMenu = new Intent(this, MainActivity.class);
            startActivity(entrarMenu);

        } else if (v.getId() == R.id.btnPontuacao) {
            Intent entrarPontuacao = new Intent(this, Pontuacoes.class);
            startActivity(entrarPontuacao);
        }

    }
}

