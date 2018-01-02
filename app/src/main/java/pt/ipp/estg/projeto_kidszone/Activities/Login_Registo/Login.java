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
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;


public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText et_username, et_password;

    MyDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        db = new MyDbHelper(this);

        et_username = (EditText) findViewById(R.id.editTextUser);
        et_password = (EditText) findViewById(R.id.editTextPass);

        TextView btn_Registar = (TextView) findViewById(R.id.btnRegistar);
        btn_Registar.setOnClickListener(this);

        final Button btn_Entrar = (Button) findViewById(R.id.btnEntrar);
        btn_Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(Login.this, "Username inválido", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(Login.this, "Password inválido", Toast.LENGTH_SHORT).show();
                } else {
                    String res = db.validarUtilizador(username, password);

                    if (res.equals("OK")) {
                        Toast.makeText(Login.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intentEntrar = new Intent(Login.this, ActivityMainUser.class);
                        startActivity(intentEntrar);
                    } else {
                        Toast.makeText(Login.this, "Username não registado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegistar) {
            Intent intentRegisto = new Intent(this, Registo.class);
            startActivity(intentRegisto);
        } else if (v.getId() == R.id.btnEntrar) {
            Intent intentEntrar = new Intent(this, ActivityMainUser.class);
            startActivity(intentEntrar);
        }
    }


}