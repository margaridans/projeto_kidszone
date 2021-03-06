package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.facebook.share.Share;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.Activities.Dicas.DicasActivity;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.MenuJogo;
import pt.ipp.estg.projeto_kidszone.ListaLocais.LocaisActivity;
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by margarida on 30/12/2017.
 */

public class ActivityMainUser extends AppCompatActivity implements View.OnClickListener {
    EditText et_username, et_password;

    MyDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_user);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnJogar = (Button) findViewById(R.id.btnJogar);
        btnJogar.setOnClickListener(this);

        Button btnDicas = (Button) findViewById(R.id.btnDicas);
        btnDicas.setOnClickListener(this);

        Button btnLocais = (Button) findViewById(R.id.btnLocais);
        btnLocais.setOnClickListener(this);

        db = new MyDbHelper(this);

        et_username = (EditText) findViewById(R.id.editTextUser);
        et_password = (EditText) findViewById(R.id.editTextPass);


        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String nome = prefs.getString("username", "default");


        TextView txtUsername = (TextView) findViewById(R.id.nome_usuario);
        txtUsername.setText(nome);


        //Login com Facebook
        Intent login = getIntent();
        String loginS = null;
        if (login.getStringExtra("login") != null) {
            loginS = login.getStringExtra("login").toString();
        }
        if (AccessToken.getCurrentAccessToken() == null && loginS == null) {
            goLoginScreen();
        }
    }


    //Login com Facebook
    private void goLoginScreen() {
        Intent intent = new Intent(this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnDicas) {
            Intent intentDicas = new Intent(this, DicasActivity.class);
            startActivity(intentDicas);
        } else if (v.getId() == R.id.btnJogar) {
            Intent intentJogar = new Intent(this, MenuJogo.class);
            startActivity(intentJogar);
        } else if (v.getId() == R.id.btnLocais) {
            Intent intentLocais = new Intent(this, LocaisActivity.class);
            startActivity(intentLocais);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.def_conta:
                alterarConta();
                return true;
            case R.id.logout:
                terminarSessao();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void terminarSessao() {
        SharedPreferences.Editor edit = getSharedPreferences("login", MODE_PRIVATE).edit();

        edit.remove("username");

        edit.apply();

        Toast.makeText(this, "Terminaste Sessão", Toast.LENGTH_LONG).show();
        Intent intentLogout = new Intent(this, MainActivity.class);
        startActivity(intentLogout);
        onBackPressed();
        finish();

    }

    public void alterarConta() {
        Intent intentConta = new Intent(this, DefinicoesContaUser.class);
        startActivity(intentConta);


    }

    @Override
    public void onBackPressed() {

    }


}

