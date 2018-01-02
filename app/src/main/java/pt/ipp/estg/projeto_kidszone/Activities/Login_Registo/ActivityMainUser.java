package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.DicasActivity;
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

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogout) {
            Toast.makeText(this, "Terminou a sua sessão", Toast.LENGTH_LONG).show();
            Intent intentLogout = new Intent(this, MainActivity.class);
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

