package pt.ipp.estg.projeto_kidszone.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 13/01/2018.
 */

public class JogoCompetitivoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogo_competitivo, container, false);

        return view;

    }
}