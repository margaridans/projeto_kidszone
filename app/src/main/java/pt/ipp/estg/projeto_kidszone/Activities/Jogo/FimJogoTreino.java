package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.ActivityMainUser;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.Login;
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;

public class FimJogoTreino extends AppCompatActivity implements View.OnClickListener {
    TextView txtPontuacao;
    TextView mostrarTreinoTxt, mostrarCompTxt;
    Button mostrarTreinoBtn, mostrarCompBtn, btnPrincipal;


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

        txtPontuacao.setText("A sua pontuacao é de: " + pontuacao);

        if (pontuacao <= 20) {
            mostrarTreinoTxt.setVisibility(View.VISIBLE);
            mostrarTreinoBtn.setVisibility(View.VISIBLE);
            mostrarCompTxt.setVisibility(View.GONE);
            mostrarCompBtn.setVisibility(View.GONE);
        } else {
            mostrarCompTxt.setVisibility(View.VISIBLE);
            mostrarCompBtn.setVisibility(View.VISIBLE);
            mostrarTreinoTxt.setVisibility(View.GONE);
            mostrarTreinoBtn.setVisibility(View.GONE);

        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_menuPrincipal) {
            Intent entrar = new Intent(this, MainActivity.class);
            startActivity(entrar);

        } else if (v.getId() == R.id.mostrarTreinoBtn) {
            Intent entrarJogoTreino = new Intent(this, JogoTreino.class);
            startActivity(entrarJogoTreino);
        } else if (v.getId() == R.id.mostrarCompBtn) {
            Intent entrarJogoComp = new Intent(this, JogoCompetitivo.class);
            startActivity(entrarJogoComp);
        }

    }
}

