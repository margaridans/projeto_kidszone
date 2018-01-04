package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pt.ipp.estg.projeto_kidszone.R;

public class FimJogoTreino extends AppCompatActivity {
    TextView txtPontuacao, txtCompetitivo, txtNovoTreino;
    Button btnNovoTreino;
    Button btnComp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_jogo);

        Intent intentFimJogo = getIntent();
        Integer pontuacao = intentFimJogo.getIntExtra("pontuacao", 0);

        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);

        btnNovoTreino = (Button) findViewById(R.id.btnNovoTreino);
        btnComp = (Button) findViewById(R.id.btnCompetitivo);

        //>20

        txtPontuacao.setText("A sua pontuacao é de: " + pontuacao);

        if (pontuacao <= 20) {
            clickBtnMostar1();
        }
    }


    public void clickBtnMostar1(View view) {
        txtCompetitivo.setVisibility(View.VISIBLE);
        txtNovoTreino.setText("Ainda não está preparado para competir. Que tal um novo jogo treino?");

        btnNovoTreino.setVisibility(View.VISIBLE);
    }

    public void clickBtnNaoMostar1(View esc) {
        btnNovoTreino.setVisibility(View.INVISIBLE);
    }

    public void clickBtnMostar2(View view) {
        btnNovoTreino.setVisibility(View.VISIBLE);
    }

    public void clickBtnNaoMostar2(View esc) {
        btnNovoTreino.setVisibility(View.INVISIBLE);
    }
}
