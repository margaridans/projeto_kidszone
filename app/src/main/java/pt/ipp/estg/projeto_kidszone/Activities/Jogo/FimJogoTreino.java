package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pt.ipp.estg.projeto_kidszone.R;

public class FimJogoTreino extends AppCompatActivity {
    TextView txtPontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_jogo);

        Intent intentFimJogo = getIntent();
        Integer pontuacao = intentFimJogo.getIntExtra("pontuacao", 0);

        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);

        //<20 ainda n esta preparado para competir -> que tal umn novo jogo treino
        //>20

        txtPontuacao.setText("A sua pontuacao é de: " + pontuacao);


    }
}
