package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pt.ipp.estg.projeto_kidszone.NotifiAndProgBar.NotificationService;
import pt.ipp.estg.projeto_kidszone.R;

public class MenuJogo extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jogo);


        Button btnPont = (Button) findViewById(R.id.btnPontuacao);
        btnPont.setOnClickListener(this);

        Button btnJogo = (Button) findViewById(R.id.btnJogo);
        btnJogo.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnJogo) {
            Intent intentJogar = new Intent(this, Jogo.class);
            startActivity(intentJogar);

        } else if (view.getId() == R.id.btnPontuacao) {


            SharedPreferences prefs= getSharedPreferences("login", MODE_PRIVATE);
            String nome= prefs.getString("username", null);

            if (nome == null) {
                Toast.makeText(this, "Para veres as pontuações tens que fazer login", Toast.LENGTH_SHORT).show();
            } else {
                if (nome != null) {
                    Intent intentPontuacao = new Intent(this, Pontuacoes.class);
                    startActivity(intentPontuacao);
                }
            }


        }
    }

}


