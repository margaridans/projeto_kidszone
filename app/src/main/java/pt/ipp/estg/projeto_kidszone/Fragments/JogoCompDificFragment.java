package pt.ipp.estg.projeto_kidszone.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pt.ipp.estg.projeto_kidszone.Activities.Jogo.JogoCompetitivo;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.JogoTreino;
import pt.ipp.estg.projeto_kidszone.R;

public class JogoCompDificFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogo_comp_dific, container, false);
        return view;

    }
}