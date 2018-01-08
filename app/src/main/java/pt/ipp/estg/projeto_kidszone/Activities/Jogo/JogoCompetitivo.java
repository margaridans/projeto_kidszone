package pt.ipp.estg.projeto_kidszone.Activities.Jogo;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import pt.ipp.estg.projeto_kidszone.Fragments.JogoCompDificFragment;
import pt.ipp.estg.projeto_kidszone.Fragments.JogoCompetitivoFragment;
import pt.ipp.estg.projeto_kidszone.R;

public class JogoCompetitivo extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_competitivo);

    }
}