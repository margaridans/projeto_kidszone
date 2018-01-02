package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    EditText et_username, et_password;

    MyDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Login com Facebook
        callbackManager = CallbackManager.Factory.create();

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
                        Intent intentEntrar = new Intent(Login.this, ActivityMainUser.class);
                        intentEntrar.putExtra("username", username);
                        startActivity(intentEntrar);
                    } else {
                        Toast.makeText(Login.this, "Username não registado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        //Login com Facebook
        loginButton = (LoginButton) findViewById(R.id.loginButton);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                goMainScreen();
            }

            @SuppressLint("ResourceType")
            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"Login cancelado", Toast.LENGTH_SHORT).show();
            }

            @SuppressLint("ResourceType")
            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(),R.id.error_login, Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Login com Facebook
    private void goMainScreen() {
        Intent intent=new Intent(this, ActivityMainUser.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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