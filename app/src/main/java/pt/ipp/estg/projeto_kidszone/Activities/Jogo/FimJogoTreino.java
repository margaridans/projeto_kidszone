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

public class FimJogoTreino extends AppCompatActivity implements View.OnClickListener{
    TextView txtPontuacao;
    TextView lyMostrarTreinoTxt, lyMostrarCompTxt;
    Button lyMostrarTreinoBtn,lyMostrarCompBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_jogo);

        Intent intentFimJogo = getIntent();
        Integer pontuacao = intentFimJogo.getIntExtra("pontuacao", 0);

        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);
        lyMostrarTreinoBtn = (Button) findViewById(R.id.lyMostrarTreinoBtn);
        lyMostrarTreinoTxt = (TextView) findViewById(R.id.lyMostrarTreinoTxt);
        lyMostrarCompBtn = (Button) findViewById(R.id.lyMostrarCompBtn);
        lyMostrarCompTxt = (TextView) findViewById(R.id.lyMostrarCompTxt);

        txtPontuacao.setText("A sua pontuacao é de: " + pontuacao);

        if (pontuacao <= 20) {
            lyMostrarTreinoTxt.setVisibility(View.VISIBLE);
            lyMostrarTreinoBtn.setVisibility(View.VISIBLE);
            lyMostrarCompTxt.setVisibility(View.GONE);
            lyMostrarCompBtn.setVisibility(View.GONE);
        } else {
            lyMostrarCompTxt.setVisibility(View.VISIBLE);
            lyMostrarCompBtn.setVisibility(View.VISIBLE);
            lyMostrarTreinoTxt.setVisibility(View.GONE);
            lyMostrarTreinoBtn.setVisibility(View.GONE);

        }
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.button_menuPrincipal) {

            /*SharedPreferences st = getSharedPreferences("login",MODE_PRIVATE);
            if(!st.contains("username")) {*/
                Intent entrarSemLogin = new Intent(this, MainActivity.class);
                startActivity(entrarSemLogin);
            }else{
                Intent entrarComLogin = new Intent(this, ActivityMainUser.class);
                startActivity(entrarComLogin);
            }
        }

    }

