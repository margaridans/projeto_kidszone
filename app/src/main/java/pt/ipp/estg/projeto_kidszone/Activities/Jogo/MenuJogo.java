package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pt.ipp.estg.projeto_kidszone.R;

public class MenuJogo extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jogo);

        Button treino = (Button) findViewById(R.id.treino);
        treino.setOnClickListener(this);

        Button competitivo = (Button) findViewById(R.id.competitivo);
        competitivo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.treino) {
            Intent intentTreino = new Intent(this, JogoTreino.class);
            startActivity(intentTreino);
        } else if (view.getId() == R.id.competitivo) {
            Intent intentCompetitivo = new Intent(this, JogoCompetitivo.class);
            startActivity(intentCompetitivo);
        }
    }
}
