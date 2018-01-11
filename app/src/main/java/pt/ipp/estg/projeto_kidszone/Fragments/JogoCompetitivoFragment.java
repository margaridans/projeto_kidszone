package pt.ipp.estg.projeto_kidszone.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import projeto_kidszone.database_library.Model.Categoria;
import projeto_kidszone.database_library.Model.Dificuldade;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.JogoCompetitivo;
import pt.ipp.estg.projeto_kidszone.R;

public class JogoCompetitivoFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogo_competitivo, container, false);


        return view;
    }
    public interface fragmentsComunication {
        void fragmentsComunication(String id_catg);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnIngl) {
            Intent it= new Intent(getContext(), JogoCompetitivo.class);
            startActivity(it);
        }

    }

}
