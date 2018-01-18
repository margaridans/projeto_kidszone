package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
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
import com.facebook.share.Share;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.User;
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
                User user = new User();
                if (username.equals("")) {
                    Toast.makeText(Login.this, "Username inválido", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(Login.this, "Password inválido", Toast.LENGTH_SHORT).show();
                } else {
                    String res = db.validarUtilizador(username, password);

                    if (res.equals("OK")) {
                        SharedPreferences.Editor editor = getSharedPreferences("login", MODE_PRIVATE).edit();
                        editor.putString("username", username);

                        editor.apply();

                        Intent intentEntrar = new Intent(Login.this, ActivityMainUser.class);
                        intentEntrar.putExtra("login", "normal");
                        startActivity(intentEntrar);

                    } else {
                        Toast.makeText(Login.this, "Username não registado", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


        try

        {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "pt.ipp.estg.projeto_kidszone",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (
                PackageManager.NameNotFoundException e)

        {

        } catch (
                NoSuchAlgorithmException e)

        {

        }


        //Login com Facebook
        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton)

                findViewById(R.id.loginButton);
        loginButton.setReadPermissions("email");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>()

        {
            @Override
            public void onSuccess(LoginResult loginResult) {
                goMainScreen();
            }

            @SuppressLint("ResourceType")
            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Login cancelado", Toast.LENGTH_SHORT).show();
            }

            @SuppressLint("ResourceType")
            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), R.id.error_login, Toast.LENGTH_SHORT).show();
            }
        });

    }


    //Login com Facebook
    private void goMainScreen() {
        Intent intent = new Intent(this, ActivityMainUser.class);
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