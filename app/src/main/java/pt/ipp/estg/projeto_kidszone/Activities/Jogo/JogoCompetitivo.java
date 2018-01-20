package pt.ipp.estg.projeto_kidszone.Activities.Jogo;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import pt.ipp.estg.projeto_kidszone.Fragments.JogoCompCategorias;
import pt.ipp.estg.projeto_kidszone.Fragments.JogoCompetitivoFragment;
import pt.ipp.estg.projeto_kidszone.R;

public class JogoCompetitivo extends AppCompatActivity implements JogoCompCategorias.fragmentsComunication {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_competitivo);

        FragmentManager manager = getSupportFragmentManager();
        JogoCompCategorias fragment_name = new JogoCompCategorias();
        manager.beginTransaction().replace(R.id.fragment_container, fragment_name, fragment_name.getTag()).commit();



    }


    @Override
    public void fragmentsComunication(String categoria) {

        JogoCompetitivoFragment segundoFragment = new JogoCompetitivoFragment();
        FragmentTransaction transacao = getSupportFragmentManager().beginTransaction();
        transacao.replace(R.id.fragment_container, segundoFragment);

        transacao.commit();
        segundoFragment.receberCategoria(categoria);


    }


}
