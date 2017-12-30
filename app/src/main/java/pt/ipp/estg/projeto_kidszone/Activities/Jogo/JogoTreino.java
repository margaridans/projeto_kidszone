package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.Dificuldade;
import projeto_kidszone.database_library.Model.Pergunta;
import pt.ipp.estg.projeto_kidszone.Model.Perguntas_Jogo;
import pt.ipp.estg.projeto_kidszone.R;


public class JogoTreino extends AppCompatActivity implements View.OnClickListener {
    private Perguntas_Jogo jogo;
    private int pontuacao = 0;
    private Dificuldade dificuldade;
    private TextView txtPergunta;
    private TextView txtPontuacao;
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
                verificaResposta(btn1.getText().toString(), dificuldade, btn1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn2.getText().toString(), dificuldade, btn2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn3.getText().toString(), dificuldade, btn3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn4.getText().toString(), dificuldade, btn4);
            }
        });


    }

    private void verificaResposta(String resposta, Dificuldade dificuldade, Button btn) {
        if (jogo.respostaCerta(resposta)) {
            //Toast.makeText(this, "Ganhou", Toast.LENGTH_LONG).show();
            pontuacao += pergunta.getId_dificuldade();
            txtPontuacao.setText("Pontos: " + pontuacao);
            btn.setBackgroundResource(R.drawable.selector_button_certa);
            setPerguntaToView();

        } else {
            btn.setBackgroundResource(R.drawable.selector_button_errada);
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

