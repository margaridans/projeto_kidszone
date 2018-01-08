package pt.ipp.estg.projeto_kidszone.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import pt.ipp.estg.projeto_kidszone.R;

public class JogoCompetitivoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogo_competitivo, container, false);


        final Button btnMat = (Button) view.findViewById(R.id.btnMat);
        final Button btnPt = (Button) view.findViewById(R.id.btnPt);
        final Button btnIng = (Button) view.findViewById(R.id.btnIngl);

        btnMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentComp, new JogoCompDificFragment());
                transaction.commit();

                btnIng.setVisibility(View.GONE);
                btnPt.setVisibility(View.GONE);
                btnMat.setVisibility(View.GONE);
            }
        });
        btnIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentComp, new JogoCompDificFragment());
                transaction.commit();

                btnIng.setVisibility(View.GONE);
                btnPt.setVisibility(View.GONE);
                btnMat.setVisibility(View.GONE);

            }
        });

        btnPt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentComp, new JogoCompDificFragment());
                transaction.commit();

                btnIng.setVisibility(View.GONE);
                btnPt.setVisibility(View.GONE);
                btnMat.setVisibility(View.GONE);
            }
        });


        return view;




    }

}
