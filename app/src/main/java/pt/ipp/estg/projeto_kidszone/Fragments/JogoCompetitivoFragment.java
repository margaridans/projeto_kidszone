package pt.ipp.estg.projeto_kidszone.Fragments;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.Pergunta;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.FimJogoTreino;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.JogoTreino;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.ActivityMainUser;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.DefinicoesContaUser;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.Login;
import pt.ipp.estg.projeto_kidszone.Model.Perguntas_Jogo;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 13/01/2018.
 */

public class JogoCompetitivoFragment extends Fragment {
    private String tipo;
    TextView txt1, txtPergunta, txtPontuacao;
    Button btn1, btn2, btn3, btn4, btnTerminar;
    private ArrayList<Pergunta> perguntasJogo;
    private Pergunta pergunta;
    private Perguntas_Jogo jogo;
private JogoTreino jogo_treino;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogo_competitivo, container, false);


        if (tipo == "Inglês") {
            Intent intentEntrar = new Intent(getContext(), DefinicoesContaUser.class);
            intentEntrar.putExtra("preferido", "Inglês");
        }

        if (tipo == "Matemática") {

        }
        if (tipo == "Português") {

        }

        return view;
    }





    public void receberCategoria(String categoria) {
        this.tipo = categoria;

    }
}