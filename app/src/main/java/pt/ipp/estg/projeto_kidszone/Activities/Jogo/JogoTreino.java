package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.Dificuldade;
import projeto_kidszone.database_library.Model.Pergunta;
import pt.ipp.estg.projeto_kidszone.Model.Perguntas_Jogo;
import pt.ipp.estg.projeto_kidszone.R;


public class JogoTreino extends AppCompatActivity implements View.OnClickListener {
    private Perguntas_Jogo jogo;
    private int pontuacao = 0, pontuacao_ind=0;
    private Dificuldade dificuldade;
    private TextView txtPergunta;
    private TextView txtPontuacao, txtPontuacao_ind;
    private Button btn, btn1, btn2, btn3, btn4, btnTerminar;
    private Pergunta pergunta;
    private int id_lista = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        ArrayList<Pergunta> listaPerguntas = new ArrayList<>();
        jogo = new Perguntas_Jogo(this, -1);

        txtPergunta = (TextView) findViewById(R.id.txtPergunta);
        btn1 = (Button) findViewById(R.id.resposta1);
        btn2 = (Button) findViewById(R.id.resposta2);
        btn3 = (Button) findViewById(R.id.resposta3);
        btn4 = (Button) findViewById(R.id.resposta4);
        txtPontuacao = (TextView) findViewById(R.id.pontuacao);
        btnTerminar = (Button) findViewById(R.id.terminar_treino);


        MyDbHelper dbHelper = new MyDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Pergunta.getPerguntas(db, listaPerguntas);
        pergunta = listaPerguntas.get(id_lista);

        Button terminarTreino = (Button) findViewById(R.id.terminar_treino);
        terminarTreino.setOnClickListener((View.OnClickListener) this);


        setPerguntaToView();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn1.getText().toString());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn2.getText().toString());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn3.getText().toString());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn4.getText().toString());
            }
        });


    }

    private void verificaResposta(String resposta) {
        if (jogo.respostaCerta(resposta)) {
            if(pergunta.getId_dificuldade()==1) {
                pontuacao += 2;
            }
            if(pergunta.getId_dificuldade()==2) {
                pontuacao += 5;
            }
            if(pergunta.getId_dificuldade()==3) {
                pontuacao += 8;
            }

            txtPontuacao.setText("Pontos: " + pontuacao);
            setPerguntaToView();

        } else {
            setPerguntaToView();
        }
    }

    private void setPerguntaToView() {

        pergunta = jogo.getNextPergunta();

        txtPergunta.setText(pergunta.getPergunta_name());
        btn1.setText(pergunta.getResposta1());
        btn2.setText(pergunta.getResposta2());
        btn3.setText(pergunta.getResposta3());
        btn4.setText(pergunta.getResposta4());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.terminar_treino) {
            Intent intentTerminar = new Intent(this, MenuJogo.class);
            startActivity(intentTerminar);
        }
    }
}

