package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.ipp.estg.projeto_kidszone.R;

public class JogoCompetitivoDif extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_competitivo_dif);

        Button btnFacil = (Button) findViewById(R.id.btnFacil);
        btnFacil.setOnClickListener(this);

        Button btnMedio = (Button) findViewById(R.id.btnMedio);
        btnMedio.setOnClickListener(this);

        Button btnDificil = (Button) findViewById(R.id.btnDificil);
        btnDificil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
