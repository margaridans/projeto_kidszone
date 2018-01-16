package pt.ipp.estg.projeto_kidszone.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.Pergunta;
import pt.ipp.estg.projeto_kidszone.Model.Perguntas_Jogo;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 13/01/2018.
 */

public class JogoCompetitivoFragment extends Fragment {
    private String tipo;
    TextView txt1, txtPergunta, txtPontuacao;
    Button btn1, btn2, btn3, btn4, btnTerminar;
    Pergunta pergunta;




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


        if (tipo == "Inglês") {
            txtPergunta.setText(Pergunta.getPerguntaByIdCatg(db,1));

        }
        if (tipo == "Matemática") {
            txtPergunta.setText(Pergunta.getPerguntaByIdCatg(db,3));

        }
        if (tipo == "Português") {
            txtPergunta.setText(Pergunta.getPerguntaByIdCatg(db,2));

        }

        return view;
    }


    public void receberCategoria(String categoria) {
        this.tipo = categoria;

    }
}