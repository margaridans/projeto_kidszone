package pt.ipp.estg.projeto_kidszone.Fragments;


import android.app.Activity;
import android.content.Context;
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

public class JogoCompetitivoFragment extends Fragment  {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogo_competitivo, container, false);

        Button btnIngl= (Button) view.findViewById(R.id.btnIngl);
        Button btnPt= (Button) view.findViewById(R.id.btnPt);
        Button btnMat= (Button) view.findViewById(R.id.btnMat);

        btnIngl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   mListener.fragmentsComunication("Inglês");
            }
        });

        btnPt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.fragmentsComunication("Português");
            }
        });

        btnMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.fragmentsComunication("Matemática");
            }
        });

        return view;
    }
    public interface fragmentsComunication {
        void fragmentsComunication(String id_catg);
    }

    private fragmentsComunication mListener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (fragmentsComunication) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " deve implementar fragmentsComunication");
        }
    }


}
