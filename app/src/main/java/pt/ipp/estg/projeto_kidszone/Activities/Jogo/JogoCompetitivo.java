package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pt.ipp.estg.projeto_kidszone.R;

public class JogoCompetitivo extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_competitivo);

        Button btnCategIngles = (Button) findViewById(R.id.btnCatgIngles);
        btnCategIngles.setOnClickListener(this);

        Button btnCategPt = (Button) findViewById(R.id.btnCatgPt);
        btnCategPt.setOnClickListener(this);

        Button btnCategMat = (Button) findViewById(R.id.btnCatgMat);
        btnCategMat.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnCatgIngles) {
           Intent intentDifIngl = new Intent (this, JogoCompetitivoDif.class);
           startActivity(intentDifIngl);

        }

        if(v.getId()== R.id.btnCatgMat) {
            Intent intentDifMat = new Intent (this, JogoCompetitivoDif.class);
            startActivity(intentDifMat);
        }

        if(v.getId()== R.id.btnCatgPt) {
            Intent intentDifPt = new Intent (this, JogoCompetitivoDif.class);
            startActivity(intentDifPt);
        }
    }
}
