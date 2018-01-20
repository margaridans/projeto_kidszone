package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 18/01/2018.
 */

public class DefinicoesContaUser extends Activity implements View.OnClickListener {

    MyDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.definicao_conta_user);

        db = new MyDbHelper(this);

        TextView editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        TextView editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
        TextView editTextPassword = (EditText) findViewById(R.id.editTextPassword);


        Button btnEditar = findViewById(R.id.btnEdiDados);
        btnEditar.setOnClickListener(this);

        TextView btnCancelarConta = findViewById(R.id.cancelarConta);
        btnCancelarConta.setOnClickListener(this);


        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String nome = prefs.getString("username", "default");

        String pass = prefs.getString("password", "default");
        editTextPassword.setText(pass);
        editTextConfirmPassword.setText(pass);

        EditText txtUsername = findViewById(R.id.irBuscarNome);
        txtUsername.setText(nome);


    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnEdiDados) {
            TextView editTextPassword = (EditText) findViewById(R.id.editTextPassword);
            String password = editTextPassword.getText().toString();

            TextView editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
            String confirmPassword = editTextConfirmPassword.getText().toString();

            SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
            String nome = prefs.getString("username", "default");

            TextView editUsername = (EditText) findViewById(R.id.irBuscarNome);
            String nome_user = editUsername.getText().toString();


            if (password.equals("") || confirmPassword.equals("")) {
                Toast.makeText(DefinicoesContaUser.this, "Password inválida", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(DefinicoesContaUser.this, "As passwords não coincidem", Toast.LENGTH_SHORT).show();

            } else {
                Boolean res = db.editarUtilizador(nome_user, password);

                if (res == true) {

                    Toast.makeText(DefinicoesContaUser.this, "Dados editados com sucesso", Toast.LENGTH_SHORT).show();
                    Intent intentEditar = new Intent(DefinicoesContaUser.this, ActivityMainUser.class);
                    startActivity(intentEditar);
                    finish();

                } else {
                    Toast.makeText(DefinicoesContaUser.this, "Não é possível registar esse usuário, pois ele já existe", Toast.LENGTH_SHORT).show();

                }
            }
        }

        if (v.getId() == R.id.cancelarConta) {

            SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
            String nome = prefs.getString("username", "default");

            onPause();
            AlertDialog.Builder alertaSair = new AlertDialog.Builder(DefinicoesContaUser.this);
            alertaSair.setTitle("Aviso");
            alertaSair.setMessage(nome + ", tens a certeza que queres eliminar a tua conta?");
            alertaSair.setCancelable(false);
            alertaSair.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    onResume();
                }
            });
            alertaSair.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
                    String nome = prefs.getString("username", "default");

                    db.deleteUser(nome);

                    Toast.makeText(DefinicoesContaUser.this, "Conta eliminada com sucesso", Toast.LENGTH_SHORT).show();
                    Intent intentCancelarConta = new Intent(DefinicoesContaUser.this, MainActivity.class);
                    startActivity(intentCancelarConta);
                    finish();
                }

            });
            AlertDialog alertDialogo = alertaSair.create();
            alertDialogo.show();

        }
    }
}