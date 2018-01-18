package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.User;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.JogoTreino;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.MenuJogo;
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 18/01/2018.
 */

public class DefinicoesContaUser extends Activity implements View.OnClickListener {
    TextView txtNomeUserEd, txtEliminarConta;
    EditText edPass, edPassConf;
    Button btnPass;

    MyDbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.definicao_conta_user);


        MyDbHelper dbHelper = new MyDbHelper(this);
        SQLiteDatabase myDb = dbHelper.getWritableDatabase();


        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String nome = prefs.getString("username", "default");



        txtNomeUserEd = findViewById(R.id.nomeUsuarioEdit);
        txtNomeUserEd.setText(nome);

        btnPass = findViewById(R.id.btnAlterarPass);
        btnPass.setOnClickListener(this);

        edPass = findViewById(R.id.editTextPasswordConta);
        edPass.setVisibility(View.GONE);

        edPassConf = findViewById(R.id.editTextConfirmPasswordConta);
        edPassConf.setVisibility(View.GONE);

        txtEliminarConta = findViewById(R.id.cancelarConta);
        txtEliminarConta.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAlterarPass) {
            edPass = findViewById(R.id.editTextPasswordConta);
            edPass.setVisibility(View.VISIBLE);

            edPassConf = findViewById(R.id.editTextConfirmPasswordConta);
            edPassConf.setVisibility(View.VISIBLE);

        } else if (v.getId() == R.id.cancelarConta) {

            SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
            final String nome = prefs.getString("username", "default");

            onPause();
            AlertDialog.Builder alertaSair = new AlertDialog.Builder(DefinicoesContaUser.this);
            alertaSair.setTitle("Aviso");
            alertaSair.setMessage(nome+ ", tens a certeza que queres eliminar a tua conta?");
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

                    MyDbHelper dbHelper = new MyDbHelper(DefinicoesContaUser.this);

                    SQLiteDatabase myDb = dbHelper.getWritableDatabase();

                    User.deleteUser(myDb, nome);
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