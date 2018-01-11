package pt.ipp.estg.projeto_kidszone.Activities.Jogo;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import pt.ipp.estg.projeto_kidszone.Fragments.JogoCompDificFragment;
import pt.ipp.estg.projeto_kidszone.Fragments.JogoCompetitivoFragment;
import pt.ipp.estg.projeto_kidszone.R;

public class JogoCompetitivo extends AppCompatActivity implements JogoCompetitivoFragment.fragmentsComunication {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_competitivo);

        FragmentManager manager = getSupportFragmentManager();
        JogoCompetitivoFragment fragment_name = new JogoCompetitivoFragment();
        manager.beginTransaction().replace(R.id.fragment_container, fragment_name, fragment_name.getTag()).commit();

    }

    @Override
    public void fragmentsComunication(String categoria) {
        FragmentManager manager = getSupportFragmentManager();
        JogoCompDificFragment fragment_name = new JogoCompDificFragment();
        manager.beginTransaction().replace(R.id.fragment_container, fragment_name, fragment_name.getTag()).commit();
    }



}
