package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;

public class FimJogo extends AppCompatActivity implements View.OnClickListener {
    TextView txtPontuacao;
    TextView mostrarTreinoTxt, mostrarCompTxt;
    Button mostrarTreinoBtn, mostrarCompBtn, btnPrincipal;
    ImageView imgViewSad, imgViewHappy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_jogo);

        Intent intentFimJogo = getIntent();
        Integer pontuacao = intentFimJogo.getIntExtra("pontuacao", 0);

        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);

        mostrarTreinoBtn = (Button) findViewById(R.id.mostrarTreinoBtn);
        mostrarTreinoBtn.setOnClickListener(this);

        mostrarTreinoTxt = (TextView) findViewById(R.id.mostrarTreinoTxt);

        mostrarCompBtn = (Button) findViewById(R.id.mostrarCompBtn);
        mostrarCompBtn.setOnClickListener(this);

        btnPrincipal = (Button) findViewById(R.id.button_menuPrincipal);
        btnPrincipal.setOnClickListener(this);

        mostrarCompTxt = (TextView) findViewById(R.id.mostrarCompTxt);

        imgViewSad = (ImageView) findViewById(R.id.imgSad);
        imgViewHappy = (ImageView) findViewById(R.id.imgHappy);

        txtPontuacao.setText("A sua pontuacao é de: " + pontuacao);

        if (pontuacao <= 20) {
            mostrarTreinoTxt.setVisibility(View.VISIBLE);
            imgViewSad.setVisibility(View.VISIBLE);
            mostrarTreinoBtn.setVisibility(View.VISIBLE);

            mostrarCompTxt.setVisibility(View.GONE);
            imgViewHappy.setVisibility(View.GONE);
            mostrarCompBtn.setVisibility(View.GONE);


        } else {
            mostrarCompTxt.setVisibility(View.VISIBLE);
            imgViewHappy.setVisibility(View.VISIBLE);
            mostrarCompBtn.setVisibility(View.VISIBLE);


            mostrarTreinoTxt.setVisibility(View.GONE);
            imgViewSad.setVisibility(View.GONE);
            mostrarTreinoBtn.setVisibility(View.GONE);


        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_menuPrincipal) {
            Intent entrar = new Intent(this, MainActivity.class);
            startActivity(entrar);

        } else if (v.getId() == R.id.mostrarTreinoBtn) {
            Intent entrarJogoTreino = new Intent(this, Jogo.class);
            startActivity(entrarJogoTreino);
        }

    }
}
