package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.Activities.Dicas.DicasActivity;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.MenuJogo;
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




        Button btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

        Button btnJogar = (Button) findViewById(R.id.btnJogar);
        btnJogar.setOnClickListener(this);

        Button btnDicas = (Button) findViewById(R.id.btnDicas);
        btnDicas.setOnClickListener(this);

        final TextView txtNameUser = (TextView) findViewById(R.id.txtNameUser);


        db = new MyDbHelper(this);

        et_username = (EditText) findViewById(R.id.editTextUser);
        et_password = (EditText) findViewById(R.id.editTextPass);

        TextView btn_Registar = (TextView) findViewById(R.id.btnRegistar);

        Intent intentEntrar = getIntent();
        String username = intentEntrar.getStringExtra("username");

        Toast.makeText(this, "Bem vindo " + username, Toast.LENGTH_SHORT).show();

        TextView txtUsername = (TextView) findViewById(R.id.txtNameUser);
        txtUsername.setText(username);



        //Login com Facebook
        Intent login = getIntent();
        String loginS = null;
        if(login.getStringExtra("login")!=null){
            loginS = login.getStringExtra("login").toString();
        }
        if(AccessToken.getCurrentAccessToken()==null && loginS==null){
            goLoginScreen();
        }
    }

    //Login com Facebook
    private void goLoginScreen() {
        Intent intent=new Intent(this,Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogout) {
            Toast.makeText(this, "Terminou a sua sessão", Toast.LENGTH_LONG).show();
            Intent intentLogout = new Intent(this, MainActivity.class);
            SharedPreferences st = getSharedPreferences("login",MODE_PRIVATE);
            SharedPreferences.Editor ed = st.edit();
            ed.remove("username");
            ed.apply();
            startActivity(intentLogout);
        } else if (v.getId() == R.id.btnDicas) {
            Intent intentDicas = new Intent(this, DicasActivity.class);
            startActivity(intentDicas);
        } else if (v.getId() == R.id.btnJogar) {
            Intent intentJogar = new Intent(this, MenuJogo.class);
            startActivity(intentJogar);
        }
    }

}

