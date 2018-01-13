package pt.ipp.estg.projeto_kidszone.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.Pergunta;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.FimJogoCompetitivo;
import pt.ipp.estg.projeto_kidszone.Model.Perguntas_Jogo;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 13/01/2018.
 */

public class JogoCompetitivoFragment extends Fragment {
    private String tipo;
    TextView txt1, txtPergunta, txtPontuacao;
    Button btn1, btn2, btn3, btn4, btnTerminar;
    private Perguntas_Jogo jogo;
    private Pergunta pergunta;
    private int pontuacao = 0;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogo_competitivo, container, false);

        txt1 = view.findViewById(R.id.ctg_escolhida);
        txt1.setText("A tua categoria escolhida foi: " + tipo);

        txtPergunta = view.findViewById(R.id.txtPergunta);
        btn1 = view.findViewById(R.id.resposta1);
        btn2 = view.findViewById(R.id.resposta2);
        btn3 = view.findViewById(R.id.resposta3);
        btn4 = view.findViewById(R.id.resposta4);

        txtPontuacao = view.findViewById(R.id.pontuacao);

        MyDbHelper dbHelper = new MyDbHelper(getContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        btnTerminar = view.findViewById(R.id.terminar_comp);
        
        return view;

    }



    public void receberCategoria(String categoria) {
        this.tipo = categoria;

    }
}